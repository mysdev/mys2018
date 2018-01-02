package com.jing.utils.httpclient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jing.utils.JsonUtil;

public class HttpClientUtil {

	private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
	/**
	 * 请求资源或服务，自定义client对象，传入请求参数， 设置内容类型，并指定参数和返回数据的编码
	 * 
	 * @param httpMethod
	 *            请求方法
	 * @param url
	 *            资源地址
	 * @param parasMap
	 *            请求参数
	 * @param headers
	 *            请求头信息
	 * @param isRAW
	 *            参数以raw形式传送
	 * @param encoding
	 *            编码
	 * @return 返回处理结果
	 * @throws HttpProcessException
	 */
	public static HttpClientResult sendRequest(HttpClientMethod httpMethod, String url, Map<String, Object> parasMap,
			Map<String, String> headers, boolean isRAW, String encoding) {
		HttpClientUtil hcu = new HttpClientUtil();
		if(parasMap!=null && httpMethod.getCode()==HttpClientMethod.GET.getCode()){
			//GET请求拼装数据到URL
			if(url.indexOf("?")==-1){
				url +="?";
			}
			for(String key : parasMap.keySet()){
				Object kv = parasMap.get(key);
				if(kv instanceof String){
					url+=("&"+key+"="+(String)kv);
				}else if(kv instanceof Integer){
					url+=("&"+key+"="+(Integer)kv);
				}else{
					//其它情况
					//url+=("&"+key+"="+kv.toString());
				}
			}
			url= url.replace("?&", "?");
			
		}
		// 创建请求对象
		HttpRequestBase request = hcu.getRequest(url, httpMethod);
		// 设置header信息
		if (headers != null && headers.size() > 0) {
			for (String key : headers.keySet()) {
				request.setHeader(key, headers.get(key));
			}
		}
		if (parasMap == null) {
			parasMap = new HashMap<String, Object>();
		}
		parasMap.putAll(hcu.getParamsFromURL(url)); // 参数合并
		//url = hcu.removeParamsFromURL(url); // 净化请求地址 --特殊情况，不能净化参数
		logger.info("请求:"+url +"入参："+ JsonUtil.map2json(parasMap));
		// 判断是否支持设置entity(仅HttpPost、HttpPut、HttpPatch支持)
		if (HttpEntityEnclosingRequestBase.class.isAssignableFrom(request.getClass())) {
			try {
				if (isRAW) {
					StringEntity postingString = new StringEntity(JsonUtil.map2json(parasMap), encoding);// json字符串传递
					((HttpEntityEnclosingRequestBase) request).setEntity(postingString);// 设置参数到请求对象中
				} else {
					List<NameValuePair> nvps = new ArrayList<NameValuePair>();
					for (String key : parasMap.keySet()) {
						nvps.add(new BasicNameValuePair(key, (String) parasMap.get(key)));
					}
					// 设置参数到请求对象中
					((HttpEntityEnclosingRequestBase) request).setEntity(new UrlEncodedFormEntity(nvps, encoding));

				}
			} catch (UnsupportedEncodingException e) {
				return new HttpClientResult(500,
						"{\"code\":500,\"error\":\"set Entity ("+encoding+") error:" + e.getMessage() + "\"}");
			}
		}
		// 调用发送请求
		return hcu.execute(HttpClients.createDefault(), request, url, encoding);

	}
	
	public static HttpClientResult sendRequest(HttpClientMethod httpMethod, String url, String params,
			Map<String, String> headers, String encoding) {
		HttpClientUtil hcu = new HttpClientUtil();		
		// 创建请求对象
		HttpRequestBase request = hcu.getRequest(url, httpMethod);
		// 设置header信息
		if (headers != null && headers.size() > 0) {
			for (String key : headers.keySet()) {
				request.setHeader(key, headers.get(key));
			}
		}
		url = hcu.removeParamsFromURL(url); // 净化请求地址
		logger.info("请求:"+url +"入参："+ JsonUtil.object2json(params));
		// 判断是否支持设置entity(仅HttpPost、HttpPut、HttpPatch支持)
		if (HttpEntityEnclosingRequestBase.class.isAssignableFrom(request.getClass())) {			
			StringEntity postingString = new StringEntity(params, encoding);// json字符串传递
					((HttpEntityEnclosingRequestBase) request).setEntity(postingString);// 设置参数到请求对象中				
			
		}
		// 调用发送请求
		return hcu.execute(HttpClients.createDefault(), request, url, encoding);

	}

	/**
	 * 请求资源或服务
	 * 
	 * @param client
	 *            client对象
	 * @param request
	 *            请求对象
	 * @param url
	 *            资源地址
	 * @param parasMap
	 *            请求参数
	 * @param encoding
	 *            编码
	 * @return 返回处理结果
	 * @throws HttpProcessException
	 */
	private HttpClientResult execute(HttpClient client, HttpRequestBase request, String url, String encoding) {
		HttpClientResult ret = new HttpClientResult();
		HttpResponse response = null;
		try {
			// 执行请求操作，并拿到结果（同步阻塞）
			response = client.execute(request);
			
			// 获取结果实体
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				// 按指定编码转换结果实体为String类型
				ret = new HttpClientResult(EntityUtils.toString(entity, encoding)); // 设置内容
			}
			ret.setCode(response.getStatusLine().getStatusCode()); // 设置状态
			EntityUtils.consume(entity);
		} catch (IOException e) {
			ret.setCode(500);
			ret.setBody("{\"code\":500,\"error\":\"execute http client error:" + e.getMessage() + "\"}");
		} finally {
			closeResponse(response);
		}
		logger.info("返回："+ret.getBody());
		return ret;
	}

	/**
	 * 关闭response
	 * 
	 * @param resp
	 *            HttpResponse对象
	 */
	private void closeResponse(HttpResponse resp) {
		if (resp == null) {
			return;
		}
		try {
			// 如果CloseableHttpResponse 是resp的父类，则支持关闭
			if (CloseableHttpResponse.class.isAssignableFrom(resp.getClass())) {
				((CloseableHttpResponse) resp).close();
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 根据请求方法名，获取request对象
	 * 
	 * @param url
	 *            资源地址
	 * @param method
	 *            请求方式
	 * @return
	 */
	private HttpRequestBase getRequest(String url, HttpClientMethod method) {
		HttpRequestBase request = null;
		switch (method.getCode()) {
		case 0:// HttpGet
			request = new HttpGet(url);
			break;
		case 1:// HttpPost
			request = new HttpPost(url);
			break;
		case 2:// HttpHead
			request = new HttpHead(url);
			break;
		case 3:// HttpPut
			request = new HttpPut(url);
			break;
		case 4:// HttpDelete
			request = new HttpDelete(url);
			break;
		case 5:// HttpTrace
			request = new HttpTrace(url);
			break;
		case 6:// HttpPatch
			request = new HttpPatch(url);
			break;
		case 7:// HttpOptions
			request = new HttpOptions(url);
			break;
		default:
			request = new HttpPost(url);
			break;
		}
		return request;
	}

	/**
	 * @Title: removeParamsFromURL
	 * @Description: 去掉路径中的参数
	 * @param url
	 * @return String 返回类型
	 */
	private String removeParamsFromURL(String url) {
		if (url != null && url.contains("?") && url.indexOf("?") < url.indexOf("=")) {
			return url.substring(0, url.indexOf("?"));
		}
		return url;
	}

	/**
	 * 获取路径中的参数
	 * 
	 * @param url
	 *            资源地址
	 * @return List<NameValuePair>
	 */
	private Map<String, String> getParamsFromURL(String url) {
		Map<String, String> ret = new HashMap<String, String>();
		if (url != null && url.contains("?") && url.indexOf("?") < url.indexOf("=")) {
			// 不空，包括?，?号在=前
			String param = url.substring(url.indexOf("?") + 1); // 参数
			if (param != null && param.length() > 0) {
				String[] p = param.split("&"); // 拆开
				for (int i = 0; i < p.length; i++) {
					if (p[i] == null || p[i].length() < 3 || !p[i].contains("=")) {
						continue;
					}
					String[] kv = p[i].split("=");
					if (kv[0] != null && kv[0].length() > 0 && kv[1] != null && kv[1].length() > 0) {
						ret.put(kv[0], kv[1]);
						// new BasicNameValuePair(kv[0], kv[1])
					}
				}
			}
		}
		return ret;
	}
}
