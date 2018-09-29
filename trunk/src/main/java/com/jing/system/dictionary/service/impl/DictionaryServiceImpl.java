package com.jing.system.dictionary.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jing.config.web.page.PageInfo;
import com.jing.system.dictionary.dao.DictionaryDao;
import com.jing.system.dictionary.entity.Dictionary;
import com.jing.system.dictionary.entity.DictionaryGroup;
import com.jing.system.dictionary.service.DictionaryService;
import com.jing.system.dictionary.util.DictionaryMapper;
import com.jing.system.sysconfig.SysConfigMapper;

@Service("dictionaryService")
public class DictionaryServiceImpl implements DictionaryService {
	@Resource
	private DictionaryDao dictionaryDao;

	/*
	 * @Transactional
	 * 
	 * @Override public boolean addDictionaryGroup(DictionaryGroup dg) { if (dg ==
	 * null || dg.getCode() == null || dg.getDesc() == null) { return false; } if
	 * (dictionaryDao.getDictionaryGroupByCode(dg.getCode()) != null) { return
	 * false; } dictionaryDao.addDictionaryGroup(dg); return true; }
	 */

	@Transactional
	@Override
	public void addDictionary(String groupCode, Dictionary dictionary) {
		dictionary.setGroupCode(groupCode);
		dictionaryDao.addDictionary(dictionary);
		DictionaryMapper.setValue(dictionary);
	}

	@Transactional
	@Override
	public void deleteDictionary(Dictionary dictionary) {
		// dictionaryDao.deleteDictionary(dictionary);
		dictionary.setFlag(0);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("flag", 0);
		param.put("code", dictionary.getCode());
		param.put("groupCode", dictionary.getGroupCode());
		this.updateDictionary(param);
	}

	@Transactional
	@Override
	public void updateDictionary(Map<String, Object> param) {
		dictionaryDao.updateDictionary(param);
		Dictionary dictionary =  new Dictionary();
		dictionary.setCode(param.get("code").toString());
		dictionary.setValue(param.get("value").toString());
		dictionary.setFlag(Integer.parseInt(param.get("flag").toString()));
		dictionary.setSort(Integer.parseInt(param.get("sort").toString()));
		dictionary.setGroupCode((String)param.get("groupCode"));
		DictionaryMapper.setValue(dictionary);
	}

	@Override
	public DictionaryGroup findDictionaryGroup(String code) {
		DictionaryGroup group = dictionaryDao.getDictionaryGroupByCode(code);
		if (group != null) {
			group.setDictionarys(dictionaryDao.findDictionaryByGroupCode(code));
		}
		return group;
	}

	@Override
	public DictionaryGroup findDictionaryGroupNoCache(String code) {
		DictionaryGroup group = dictionaryDao.getDictionaryGroupByCode(code);
		if (group != null) {
			group.setDictionarys(dictionaryDao.findAllDictionaryByGroupCode(code));
		}
		return group;
	}

	@Override
	public List<DictionaryGroup> findAllDictionaryGroup() {
		return dictionaryDao.findAllDictionaryGroup();
	}

	@Override
	public List<DictionaryGroup> findAllDictionaryGroupNoCache() {
		return dictionaryDao.findDictionaryGroupSimple();
	}

	@Override
	public List<Dictionary> findDictionaryGroupByCode(String rootCode) {
		return dictionaryDao.findDictionaryGroupByCode(rootCode);
	}

	@Override
	public List<Dictionary> findDictionaryByGroupCode(String groupCode) {
		return dictionaryDao.findDictionaryByGroupCode(groupCode);
	}

	/*
	 * (non-Javadoc) <p>Title: modDictionaryGroup</p> <p>Description: </p>
	 * 
	 * @param code
	 * 
	 * @param desc
	 * 
	 * @param updatedBy
	 * 
	 * @return
	 * 
	 * @see com.faith.framework.common.dictionary.service.DictionaryService#
	 * modDictionaryGroup(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void modDictionaryGroup(String code, String desc, String username) {
		dictionaryDao.modDictionaryGroup(code, desc, username);
	}

	/*
	 * (non-Javadoc) <p>Title: delDictionaryGroup</p> <p>Description: </p>
	 * 
	 * @param code
	 * 
	 * @param updatedBy
	 * 
	 * @return
	 * 
	 * @see com.faith.framework.common.dictionary.service.DictionaryService#
	 * delDictionaryGroup(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean delDictionaryGroup(String code, int updatedBy) {
		Dictionary dic = new Dictionary();
		dic.setGroupCode(code);
		dic.setUpdatedBy(updatedBy);
		dictionaryDao.deleteDictionaryByGroupCode(dic);
		return dictionaryDao.delDictionaryGroup(code);
	}

	/*
	 * (non-Javadoc) <p>Title: deleteDictionaryGroup</p> <p>Description: </p>
	 * 
	 * @param code
	 * 
	 * @param username
	 * 
	 * @return
	 * 
	 * @see com.faith.framework.common.dictionary.service.DictionaryService#
	 * deleteDictionaryGroup(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean deleteDictionaryGroup(String code, int username) {
		if (code != null && code.length() > 0) {
			Dictionary d = new Dictionary();
			d.setGroupCode(code);
			d.setUpdatedBy(username);
			dictionaryDao.deleteDictionaryByGroupCode(d);
			return dictionaryDao.delDictionaryGroup(code);
		}
		return false;
	}

	/*
	 * (non-Javadoc) <p>Title: addDictionaryGroup</p> <p>Description: </p>
	 * 
	 * @param eventGroup
	 * 
	 * @param string
	 * 
	 * @param string2
	 * 
	 * @see com.faith.framework.common.dictionary.service.DictionaryService#
	 * addDictionaryGroup(java.lang.String, java.lang.String, java.lang.String)
	 */
	/*
	 * @Override public void addDictionaryGroup(String code, String desc, int user)
	 * { DictionaryGroup dg = new DictionaryGroup(); dg.setCode(code);
	 * dg.setDesc(desc); dg.setCreatedBy(user);
	 * dictionaryDao.addDictionaryGroup(dg); }
	 */

	@SuppressWarnings("resource")
	@Override
	public void refreshDictionaryFile() throws IOException {
		String mapJakcson = DictionaryMapper.getJsonString();
		String data = "var dictionaryObj=" + mapJakcson;
		File file = new File(SysConfigMapper.getValue("dictionary.file"));
		PrintStream ps = new PrintStream(new FileOutputStream(file), false, "UTF-8");
		ps.println(data);// 往文件里写入字符串
	}

	@Override
	public String getValue(String group, String code) {
		if (code == null || "".equals(code)) {
			return "";
		}
		DictionaryGroup dg = this.findDictionaryGroup(group);
		List<Dictionary> list = dg.getDictionarys();
		for (Dictionary dictionary : list) {
			if (code.equals(dictionary.getCode())) {
				return dictionary.getValue();
			}
		}
		return "未知";
	}

	@Override
	public Dictionary Dictionary(String group, String code) {
		DictionaryGroup dg = this.findDictionaryGroup(group);
		List<Dictionary> list = dg.getDictionarys();
		for (Dictionary dictionary : list) {
			if (code.equals(dictionary.getCode())) {
				return dictionary;
			}
		}
		return null;
	}

	@Override
	public List<DictionaryGroup> getDictionaryGroupList() {
		return dictionaryDao.getDictionaryGroupList();
	}

	@Override
	public PageInfo findDictionaryListPage(PageInfo page, Map<String, Object> param) {
		return page.setRows(dictionaryDao.findDictionaryListPage(page, param));
	}

	@Override
	public Dictionary getDictionaryById(String code) {
		return dictionaryDao.getDictionaryById(code);
	}

	@Override
	public void deleteDictionaryGroupById(String code) {
		dictionaryDao.deleteDictionaryGroupById(code);

	}

	@Override
	public void addDictionaryGroup(String code, String desc, String username) {
		dictionaryDao.addDictionaryGroup(code, desc, username);
	}

}
