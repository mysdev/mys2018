package com.jing.system.document.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.jing.attendance.service.impl.AttendanceDetailServiceImpl;
import com.jing.config.web.exception.CustomException;
import com.jing.config.web.page.PageInfo;
import com.jing.system.document.dao.DocumentDao;
import com.jing.system.document.entity.Document;
import com.jing.system.document.service.DocumentService;
import com.jing.system.document.util.DocumentUtils;
import com.jing.utils.FileUtil;
import com.jing.utils.PrimaryKey;

@Service("documentService")
public class DocumentServiceImpl implements DocumentService {
	private static final Logger logger = LoggerFactory.getLogger(AttendanceDetailServiceImpl.class);

	@Resource
	private DocumentDao documentDao;

	@Override
	@Async
	public void saveDocumentToData(String idstr, String resId) {
		if (idstr == null || "".equals(idstr)) {
			return;
		} else if (idstr.indexOf(",") < 0) {
			saveToData(idstr, resId);
		}
		String[] id = idstr.split(",");
		for (String string : id) {
			saveToData(string, resId);
		}
	}

	private void saveToData(String id, String resId) {
		Document doc = this.getDocumentById(id);
		if (doc == null) {
			logger.error("附件" + id + "不存在,来源:" + resId);
			//throw new CustomRuntimeException("附件" + id + "不存在,来源:" + resId);
			return;
		}
		if (doc.getState().intValue() == DocumentUtils.DOC_DATA) {
			return;
		}
		doc.setRes(resId);
		doc.setState(DocumentUtils.DOC_DATA);
		String url = DocumentUtils.getDataUrl(doc.getSuffix(), resId);
		try {
			FileUtil.move(doc.getUrl(), url);
			doc.setUrl(url);
			this.updateDocument(doc);
		} catch (Exception e) {
			logger.error("附件saveToData错误", e);
		}
	}

	/**
	 * 添加 附件
	 */
	@Override
	public Document addDocument(Document document) {
		document.setDid(PrimaryKey.getUUID());
		document.setUpTime(new Date());
		documentDao.addDocument(document);
		return document;
	}

	/**
	 * 修改 附件
	 */
	@Override
	public void updateDocument(Document document) {
		documentDao.updateDocument(document);
	}

	/**
	 * 根据ID删除记录
	 */
	@Override
	public void deleteDocumentById(String id) {
		documentDao.deleteDocumentById(id);
	}

	@Override
	public void deleteDocumentByRes(String res) {
		if(res == null || "".equals(res)){
			throw new CustomException("删除附件时，res不能为空。");
		}
		documentDao.deleteDocumentByRes(res);
	}

	/**
	 * 根据ID查询记录
	 */
	@Override
	public Document getDocumentById(String id) {
		return documentDao.getDocumentById(id);
	}

	/**
	 * 分页查询
	 */
	@Override
	public PageInfo findDocumentListPage(PageInfo page, Map<String, Object> param) {
		return page.setRows(documentDao.findDocumentListPage(page, param));
	}

	/**
	 * 根据属性查询附件
	 * 
	 * @param param
	 * @return
	 */
	@Override
	public List<Document> findDocumentList(Map<String, Object> param) {
		return documentDao.findDocumentList(param);
	}

	@Override
	public List<Document> findDocumentListByRes(String resId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("res", resId);
		return this.findDocumentList(param);
	}
}