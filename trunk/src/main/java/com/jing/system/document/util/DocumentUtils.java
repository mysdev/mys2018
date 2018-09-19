package com.jing.system.document.util;

import java.util.ArrayList;
import java.util.List;

import com.jing.system.document.entity.Document;
import com.jing.system.sysconfig.SysConfigMapper;
import com.jing.utils.DateUtils;
import com.jing.utils.PrimaryKey;

/**
 * 附件上传工具类
 * 
 * @author LIFENG
 *
 */
public class DocumentUtils {

	public static final int DOC_TEMP = 1;
	public static final int DOC_DATA = 2;

	// 获得一个文件存储路径
	public static String getTempUrl(String suffix) {
		// 获取根目录
		String rootFolder = SysConfigMapper.getValue("document.upload.folder.temp");
		// 组合日期目录
		String date = DateUtils.getSystemDate("yyyy-MM-dd");
		// 获取一个uuid
		String uuid = PrimaryKey.getUUID();
		return rootFolder + "/" + date + "/" + uuid + suffix;
	}

	// 获得一个文件存储路径
	public static String getDataUrl(String suffix) {
		// 获取根目录
		String rootFolder = SysConfigMapper.getValue("document.upload.folder.data");
		// 组合日期目录
		String date = DateUtils.getSystemDate("yyyy-MM-dd");
		// 获取一个uuid
		String uuid = PrimaryKey.getUUID();
		return rootFolder + "/" + date + "/" + uuid + suffix;
	}

	// 获得一个文件存储路径
	public static String getDataUrl(String suffix, String resId) {
		// 获取根目录
		String rootFolder = SysConfigMapper.getValue("document.upload.folder.data");
		// 获取一个uuid
		String uuid = PrimaryKey.getUUID();
		return rootFolder + "/" + resId + "/" + uuid + suffix;
	}
	
	/**
	 * @Description: 把ID字符串分割后组装成为DOCUMENT对象
	 * @author EX-LIFENG001
	 * @date 2013-3-27下午04:07:25
	 * @param docid
	 * @return List<Document>
	 */
	public static List<Document> getDocements(String docid, int umId) {
		if (docid != null && docid.length() > 0) {
			List<Document> res = new ArrayList<Document>();
			String[] docids = docid.split(",");
			if (docids != null && docids.length > 0) {
				for (String id : docids) {
					Document doc = new Document();
					doc.setDid(id);
					doc.setUpdatedBy(umId);
					doc.setCreatedBy(umId);
					res.add(doc);
				}
			}
			return res;
		}
		return null;
	}

}
