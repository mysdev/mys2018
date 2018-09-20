package ${packge}.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.faith.framework.core.exception.CustomException;
import com.faith.framework.core.web.BaseController;
import com.faith.framework.core.web.Result;
import com.faith.framework.core.web.page.PageInfo;
import com.faith.framework.core.web.page.PageRequestUtils;
import com.faith.framework.core.web.session.Config;
import com.faith.framework.core.web.session.SessionAttr;
import ${packge}.entity.${className};
import ${packge}.service.${className}Service;

/**
 * <br>
 * <b>功能：</b>${comment} WEB接口<br>
 * <br>
 */
@Controller
@RequestMapping("/${model}/${lowerName}")
public class ${className}Controller extends BaseController{

	@Autowired
	private ${className}Service ${lowerName}Service;
	
	/**
	 * 新增保存
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Result add(${className} ${lowerName},@SessionAttr(Config.USER_INFO) User user)throws CustomException  {
		${lowerName}.setCreatedBy(user.getUserId());
		${lowerName}.setCreatedDateNow();
		${lowerName}.setUpdatedBy(user.getUserId());
		${lowerName}.setUpdatedDateNow();
		${lowerName}Service.add${className}(${lowerName});
		return Result.getDefaultSuccMsgResult();
	}
	
	/**
	 * 修改保存
	 * 
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Result update(${className} ${lowerName},@SessionAttr(Config.USER_INFO) User user)throws CustomException{
		if(${lowerName}==null || ${lowerName}.get${primaryKey.method}()==null || "".equals(${lowerName}.get${primaryKey.method}())){
			throw new CustomException("缺失修改参数.");
		}
		${lowerName}.setUpdatedBy(user.getUserId());
		${lowerName}.setUpdatedDateNow();
		${lowerName}Service.update${className}(${lowerName});
		return Result.getDefaultSuccMsgResult();
	}

	
	/**
	 * 删除
	 * 
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result delete(@PathVariable("id") ${primaryKey.filedType} id)throws CustomException {
		if(id==null || "".equals(id)){
			throw new CustomException("缺失删除参数.");
		}
		${lowerName}Service.delete${className}ById(id);
		return Result.getDefaultSuccMsgResult();
	}
	
	/**
	 * ID查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
	public @ResponseBody Result get(@PathVariable("id") ${primaryKey.filedType} id)throws CustomException {
		if(id==null || "".equals(id)){
			throw new CustomException("缺失查询参数.");
		}
		return Result.getDefaultSuccMsgResult(${lowerName}Service.get${className}ById(id));
	}
	
	
	/**
	 * 分页查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public @ResponseBody PageInfo findPage(HttpServletRequest request)throws Exception {
		Map<String,Object> map=PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		return ${lowerName}Service.find${className}ListPage(PageRequestUtils.getPageBean(request), map);
	}
}