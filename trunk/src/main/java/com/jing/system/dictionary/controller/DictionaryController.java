package com.jing.system.dictionary.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jing.config.web.Result;
import com.jing.config.web.exception.CustomException;
import com.jing.config.web.page.PageInfo;
import com.jing.config.web.page.PageRequestUtils;
import com.jing.system.dictionary.entity.Dictionary;
import com.jing.system.dictionary.entity.DictionaryGroup;
import com.jing.system.dictionary.service.DictionaryService;
import com.jing.system.dictionary.util.DictionaryMapper;
import com.jing.system.login.session.Config;
import com.jing.system.login.session.SessionAttr;
import com.jing.system.user.entity.User;
import com.jing.utils.BaseController;

/**
 * 数据字典
 * 
 * @author lifeng
 *
 */
@Controller
@RequestMapping("/sys/dictionary")
public class DictionaryController extends BaseController {

	@Autowired(required=false)
	private DictionaryService dictionaryService;

	@RequestMapping(value = "/group/save", method = RequestMethod.POST)
	public @ResponseBody Result addDG(@SessionAttr(Config.USER_INFO) User user, @RequestParam("code") String code,
			@RequestParam("desc") String desc) {
		try {
			dictionaryService.addDictionaryGroup(code, desc, user.getUsername());
			return Result.getDefaultSuccMsgResult();
		} catch (Exception e) {
			logger.error("新增数据字典组错误", e);
			return Result.getErroMsgResult(e.getMessage());
		}
	}

	@RequestMapping(value = "/group/update", method = RequestMethod.POST)
	public @ResponseBody Result updateDG(@SessionAttr(Config.USER_INFO) User user, @RequestParam("code") String code,
			@RequestParam("desc") String desc) {
		try {
			dictionaryService.modDictionaryGroup(code, desc, user.getUsername());
			return Result.getDefaultSuccMsgResult();
		} catch (Exception e) {
			logger.error("修改数据字典组错误", e);
			return Result.getErroMsgResult(e.getMessage());
		}
	}

	@RequestMapping(value = "/group/delete/{code}", method = RequestMethod.GET)
	public @ResponseBody Result deleteDG(@SessionAttr(Config.USER_INFO) User user, @PathVariable("code") String code) {
		try {
			dictionaryService.deleteDictionaryGroup(code, user.getUserId());
			return Result.getDefaultSuccMsgResult();
		} catch (Exception e) {
			logger.error("删除数据字典组错误", e);
			return Result.getErroMsgResult(e.getMessage());
		}
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Result addDic(@SessionAttr(Config.USER_INFO) User user, HttpServletRequest request) {
		try {
			Dictionary Dic = request2Dic(request);
			Dic.setCreatedBy(user.getUserId());
			dictionaryService.addDictionary(Dic.getGroupCode(), Dic);
			return Result.getDefaultSuccMsgResult();
		} catch (Exception e) {
			logger.error("保存数据字典错误", e);
			return Result.getErroMsgResult(e.getMessage());
		}

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Result updateDic(@SessionAttr(Config.USER_INFO) User user, HttpServletRequest request) {
		try {
			Map<String, Object> map = PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
			dictionaryService.updateDictionary(map);
			return Result.getDefaultSuccMsgResult();
		} catch (Exception e) {
			logger.error("保存数据字典错误", e);
			return Result.getErroMsgResult(e.getMessage());
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody Result deleteDic(@SessionAttr(Config.USER_INFO) User user, HttpServletRequest request) {
		try {
			Dictionary Dic = request2Dic(request);
			Dic.setUpdatedBy(user.getUserId());
			dictionaryService.deleteDictionary(Dic);
			return Result.getDefaultSuccMsgResult();
		} catch (Exception e) {
			logger.error("deleteDic error!", e);
			return Result.getErroMsgResult(e.getMessage());
		}
	}

	/**
	 * @Title: request2Dic
	 * @Description:
	 * @param request
	 * @return
	 *
	 */
	private Dictionary request2Dic(HttpServletRequest request) {
		Dictionary dic = new Dictionary();
		if (request.getParameter("code") != null) {
			try {
				dic.setCode(request.getParameter("code"));
			} catch (Exception e) {

			}
		}
		if (request.getParameter("value") != null) {
			dic.setValue(request.getParameter("value"));
		}
		if (request.getParameter("groupCode") != null) {
			dic.setGroupCode(request.getParameter("groupCode"));
		}
		dic.setSort(9);
		if (request.getParameter("sort") != null) {
			try {
				dic.setSort(Integer.parseInt(request.getParameter("sort")));
			} catch (Exception e) {

			}
		}
		dic.setFlag(1);
		if (request.getParameter("flag") != null) {
			try {
				dic.setFlag(Integer.parseInt(request.getParameter("flag")));
			} catch (Exception e) {

			}
		}
		return dic;
	}

	/**
	 * 获取单个字典 /dictionary/sex
	 * 
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/index/{code}", method = RequestMethod.GET)
	public @ResponseBody Dictionary getDictionary(@PathVariable("code") String code) {
		try {
			return dictionaryService.getDictionaryById(code);
		} catch (Exception e) {
			logger.error("查询数据字典错误", e);
			return null;
		}
	}

	@RequestMapping(value = "/list/value", method = RequestMethod.POST)
	public @ResponseBody List<Dictionary> getDictionaryList(@RequestParam("code") String code,
			HttpServletRequest request) {
		try {
			DictionaryGroup group = dictionaryService.findDictionaryGroupNoCache(code);
			String keywords = request.getParameter("keywords");
			if (keywords != null && !"".equals(keywords) && group != null && group.getDictionarys() != null) {
				List<Dictionary> list = group.getDictionarys();
				List<Dictionary> list2 = new ArrayList<Dictionary>();
				if (list != null && list.size() > 0) {
					for (Dictionary dictionary : list) {
						if (dictionary.getValue().indexOf(keywords) >= 0) {
							list2.add(dictionary);
						}
					}
				}
				group.setDictionarys(list2);
			}
			return group.getDictionarys();
		} catch (Exception e) {
			logger.error("查询数据字典错误", e);
		}
		return null;
	}

	/**
	 * 获取多个字典 var param = {codes:['sex','politicalStatus','marriageStatus']};
	 * 
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/group/list", method = RequestMethod.POST)
	public @ResponseBody List<DictionaryGroup> getDictionaryList(@RequestParam(value = "codes[]") String[] codes) {
		try {
			if (codes != null && codes.length > 0 && !"".equals(codes[0])) {
				List<DictionaryGroup> dictionaryGroups = new ArrayList<DictionaryGroup>();
				for (String code : codes) {
					dictionaryGroups.add(dictionaryService.findDictionaryGroup(code));
				}
				return dictionaryGroups;
			} else {
				return dictionaryService.findAllDictionaryGroupNoCache();
			}
		} catch (Exception e) {
			logger.error("查询数据字典错误", e);
		}
		return null;
	}

	/*
	 * @RequestMapping(value = "/all", method = RequestMethod.GET)
	 * public @ResponseBody Map<String, List<Dictionary>> getAllDictionaryList() {
	 * try { // List<DictionaryGroup> dictionaryGroups = //
	 * dictionaryService.findAllDictionaryGroup(); return
	 * dictionaryService.findAllDictionary(); } catch (Exception e) {
	 * logger.error("查询数据字典错误", e); } return null; }
	 */

	/**
	 * 根据传进来的名字和code值查询，树列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list/tree", method = RequestMethod.GET)
	public @ResponseBody DictionaryGroup getDictionaryTree(HttpServletRequest request) {
		DictionaryGroup dictionaryTree = new DictionaryGroup();
		String rootName = request.getParameter("rootName");
		try {
			rootName = new String(rootName.getBytes("iso8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String rootCode = request.getParameter("rootCode");
		List<Dictionary> list = dictionaryService.findDictionaryGroupByCode(rootCode);
		dictionaryTree.setCode(rootCode);
		dictionaryTree.setDesc(rootName);
		dictionaryTree.setDictionarys(list);
		return dictionaryTree;
	}

	/**
	 * 查询出城市部件以及之下的数据字典
	 */
	/*
	 * @RequestMapping(value = "/thing/tree", method = RequestMethod.GET)
	 * public @ResponseBody DictionaryThing getThingDictionay() { DictionaryThing
	 * dictionaryThing = new DictionaryThing(); List<DictionaryGroup> groupList =
	 * new ArrayList<DictionaryGroup>(); List<Dictionary> list =
	 * dictionaryService.findDictionaryByGroupCode("500");// 城市部件的标识就是500
	 * dictionaryThing.setCode("500"); dictionaryThing.setName("城市部件"); for
	 * (Dictionary dictionary : list) { DictionaryGroup dictionaries =
	 * dictionaryService.findDictionaryGroup(dictionary.getCode() + "");
	 * groupList.add(dictionaries); } dictionaryThing.setDictionarys(groupList); ;
	 * return dictionaryThing; }
	 */

	/**
	 * 手机查询出所有的数据字典
	 * 
	 * @return
	 */
	@RequestMapping(value = "/mobile/all", method = RequestMethod.GET)
	public @ResponseBody List<Map<String, Object>> getAllDictionaryToMobile() {
		try {
			return DictionaryMapper.getJsonObj();
		} catch (Exception e) {
			logger.error("查询数据字典给手机错误", e);
		}
		return null;
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/refresh/file", method = RequestMethod.GET)
	public @ResponseBody Result refreshDictionaryFile() {
		try {
			dictionaryService.refreshDictionaryFile();
			return Result.getDefaultSuccMsgResult();
		} catch (Exception e) {
			logger.error("刷新数据字典缓存js文件错误", e);
			return Result.getErroMsgResult(e.getMessage());
		}
	}

	@RequestMapping(value = "/groupTree", method = RequestMethod.GET)
	public @ResponseBody Result groupTree(Dictionary dictionary) throws CustomException {
		return Result.getDefaultSuccMsgResult(dictionaryService.getDictionaryGroupList());
	}

	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public @ResponseBody PageInfo findPage(HttpServletRequest request) throws Exception {
		Map<String, Object> map = PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		return dictionaryService.findDictionaryListPage(PageRequestUtils.getPageBean(request), map);
	}

	@RequestMapping(value = "/deleteGroup/{id}", method = RequestMethod.GET)
	public @ResponseBody Result deleteGroup(@PathVariable("id") String id) throws CustomException {
		if (id.equals("")) {
			throw new CustomException("缺失删除参数.");
		}
		dictionaryService.deleteDictionaryGroupById(id);
		return Result.getDefaultSuccMsgResult();
	}
}
