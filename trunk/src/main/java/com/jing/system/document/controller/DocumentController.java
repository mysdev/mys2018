package com.jing.system.document.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jing.config.web.Result;
import com.jing.config.web.exception.CustomException;
import com.jing.config.web.page.PageInfo;
import com.jing.config.web.page.PageRequestUtils;
import com.jing.system.document.entity.Document;
import com.jing.system.document.service.DocumentService;
import com.jing.system.document.util.DocumentUtils;
import com.jing.utils.BaseController;
import com.jing.utils.FileUtil;

/**
 * <br>
 * <b>功能：</b>附件 WEB接口<br>
 * <br>
 */
@Controller
@RequestMapping("/document")
public class DocumentController extends BaseController {
	private final String FileData = "Filedata";

	@Autowired
	private DocumentService documentService;

	/**
	 * @Description: 上传附件到临时目录
	 * @author EX-LIFENG001
	 * @date 2013-3-11下午03:44:48
	 * @return String
	 * @throws CustomException
	 * @throws IOException
	 */
	@RequestMapping(value = "/uploadMultiple", method = RequestMethod.POST)
	public @ResponseBody Result uploadMultipleFile(HttpServletRequest request, HttpServletResponse response)
			throws CustomException, IOException {
		Document document = new Document();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Iterator<String> fileNames = multipartRequest.getFileNames();
		List<Document> list = new ArrayList<Document>();
		while (fileNames.hasNext()) {
			String fn = (String) fileNames.next();
			MultipartFile file = multipartRequest.getFile(fn);
			String fileName = file.getOriginalFilename();
			if (fileName.indexOf(".") < 0 || fileName.indexOf(".exe") > 0 || fileName.indexOf(".bat") > 0) {
				logger.error("上传非法文件:" + fileName);
				throw new CustomException("非法文件[" + fileName + "]禁止上传!");
			}
			document.setActual(fileName.substring(0, fileName.lastIndexOf(".")));
			document.setSuffix(fileName.substring(fileName.lastIndexOf("."), fileName.length()));
			document.setSize(file.getSize());
			document.setUrl(DocumentUtils.getTempUrl(document.getSuffix()));
			FileUtil.writeMultipartFile(document.getUrl(), file);
			document.setState(DocumentUtils.DOC_TEMP);
			document = documentService.addDocument(document);
			list.add(document);
		}
		return Result.getDefaultSuccMsgResult(list);
	}

	/**
	 * @Description: 上传附件到临时目录
	 * @author EX-LIFENG001
	 * @date 2013-3-11下午03:44:48
	 * @return String
	 * @throws CustomException
	 * @throws IOException
	 */
	@RequestMapping(value = "/uploadMultiple2", method = RequestMethod.POST)
	public @ResponseBody Result uploadMultipleFile2(HttpServletRequest request, HttpServletResponse response)
			throws CustomException, IOException {
		Document document = new Document();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		List<Document> list = new ArrayList<Document>();
		List<MultipartFile> files = multipartRequest.getFiles(FileData);
		for (MultipartFile file : files) {
			String fileName = file.getOriginalFilename();
			if (fileName.indexOf(".") < 0 || fileName.indexOf(".exe") > 0 || fileName.indexOf(".bat") > 0) {
				logger.error("上传非法文件:" + fileName);
				throw new CustomException("非法文件[" + fileName + "]禁止上传!");
			}
			document.setActual(fileName.substring(0, fileName.lastIndexOf(".")));
			document.setSuffix(fileName.substring(fileName.lastIndexOf("."), fileName.length()));
			document.setSize(file.getSize());
			document.setUrl(DocumentUtils.getTempUrl(document.getSuffix()));
			FileUtil.writeMultipartFile(document.getUrl(), file);
			document.setState(DocumentUtils.DOC_TEMP);
			document = documentService.addDocument(document);
			list.add(document);
		}
		return Result.getDefaultSuccMsgResult(list);
	}

	/**
	 * @Description: 上传附件到临时目录
	 * @author EX-LIFENG001
	 * @date 2013-3-11下午03:44:48
	 * @return String
	 * @throws CustomException
	 * @throws IOException
	 */
	@RequestMapping(value = "/uploadTemp", method = RequestMethod.POST)
	public @ResponseBody Result uploadTemp(HttpServletRequest request, HttpServletResponse response)
			throws CustomException, IOException {
		Document document = new Document();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile(FileData);
		String fileName = file.getOriginalFilename();
		if (fileName.indexOf(".") < 0 || fileName.indexOf(".exe") > 0 || fileName.indexOf(".bat") > 0) {
			logger.error("上传非法文件:" + fileName);
			throw new CustomException("非法文件[" + fileName + "]禁止上传!");
		}
		document.setActual(fileName.substring(0, fileName.lastIndexOf(".")));
		document.setSuffix(fileName.substring(fileName.lastIndexOf("."), fileName.length()));
		document.setSize(file.getSize());
		document.setUrl(DocumentUtils.getTempUrl(document.getSuffix()));
		FileUtil.writeMultipartFile(document.getUrl(), file);
		document.setState(DocumentUtils.DOC_TEMP);
		return Result.getDefaultSuccMsgResult(documentService.addDocument(document));
	}

	/**
	 * @Description: 上传附件到正式目录
	 * @author EX-LIFENG001
	 * @date 2013-3-11下午03:44:48
	 * @return String
	 * @throws CustomException
	 * @throws IOException
	 */
	@RequestMapping(value = "/uploadData", method = RequestMethod.POST)
	public @ResponseBody Result uploadData(HttpServletRequest request, HttpServletResponse response)
			throws CustomException, IOException {
		Document document = new Document();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile(FileData);
		String fileName = file.getOriginalFilename();
		if (fileName.indexOf(".") < 0 || fileName.indexOf(".exe") > 0 || fileName.indexOf(".bat") > 0) {
			logger.error("上传非法文件:" + fileName);
			throw new CustomException("非法文件[" + fileName + "]禁止上传!");
		}
		document.setActual(fileName.substring(0, fileName.lastIndexOf(".")));
		document.setSuffix(fileName.substring(fileName.lastIndexOf("."), fileName.length()));
		document.setSize(file.getSize());
		document.setUrl(DocumentUtils.getDataUrl(document.getSuffix()));
		FileUtil.writeMultipartFile(document.getUrl(), file);
		document.setState(DocumentUtils.DOC_DATA);
		return Result.getDefaultSuccMsgResult(documentService.addDocument(document));
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result delete(@PathVariable("id") String id) throws CustomException {
		if (id == null || "".equals(id)) {
			throw new CustomException("缺失删除参数.");
		}
		documentService.deleteDocumentById(id);
		return Result.getDefaultSuccMsgResult();
	}

	/**
	 * ID查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
	public @ResponseBody Result get(@PathVariable("id") String id) throws CustomException {
		if (id == null || "".equals(id)) {
			throw new CustomException("缺失查询参数.");
		}
		return Result.getDefaultSuccMsgResult(documentService.getDocumentById(id));
	}

	/**
	 * 分页查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public @ResponseBody PageInfo findPage(HttpServletRequest request) throws Exception {
		Map<String, Object> map = PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		return documentService.findDocumentListPage(PageRequestUtils.getPageBean(request), map);
	}

	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public void show(@PathVariable("id") String id, HttpServletResponse res, HttpServletRequest request) throws IOException {
		String isImage = request.getParameter("isImage");
		OutputStream os = res.getOutputStream();
		Document doc = null;
		try {
			doc = documentService.getDocumentById(id);
			if (doc == null) {
				throw new CustomException("文档不存在！");
			}
			if ("true".equals(isImage) && (".jpg".equals(doc.getSuffix()) || ".png".equals(doc.getSuffix())
					|| ".jpeg".equals(doc.getSuffix()))) {
				res.reset();
			} else {
				res.reset();
				res.setHeader("Content-Disposition",
						"attachment; filename=" + URLEncoder.encode(doc.getActual() + doc.getSuffix(), "utf-8"));
				res.setContentType("application/octet-stream; charset=utf-8");
			}
			String filePath = doc.getUrl();
			os.write(FileUtil.readFileToBytes(filePath));
			os.close();
		} catch (Exception e) {
			logger.error("下载文档出错!", e);
		} finally {
			if (os != null) {
				os.close();
			}
		}
	}

	@RequestMapping(value = "/down/{id}", method = RequestMethod.GET)
	public void down(@PathVariable("id") String id, HttpServletResponse res, HttpServletRequest request) throws IOException {
		String isImage = request.getParameter("isImage");
		OutputStream os = res.getOutputStream();
		Document doc = null;
		try {
			doc = documentService.getDocumentById(id);
			if (doc == null) {
				throw new CustomException("文档不存在！");
			}
			if ("true".equals(isImage) && (".jpg".equals(doc.getSuffix()) || ".png".equals(doc.getSuffix())
					|| ".jpeg".equals(doc.getSuffix()))) {
				res.reset();
			} else {
				res.reset();
				res.setHeader("Content-Disposition",
						"attachment; filename=" + URLEncoder.encode(doc.getActual() + doc.getSuffix(), "utf-8"));
				res.setContentType("application/octet-stream; charset=utf-8");
			}
			String filePath = doc.getUrl();
			os.write(FileUtil.readFileToBytes(filePath));
			os.close();
			os.close();
		} catch (Exception e) {
			logger.error("下载文档出错!", e);
		} finally {
			if (os != null) {
				os.close();
			}
		}
	}
}