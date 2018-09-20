package com.jing.codeing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jing.codeing.service.CodeingService;
import com.jing.config.web.Result;
import com.jing.config.web.exception.CustomException;
import com.jing.utils.BaseController;

/**
 * 
 * <br>
 * <b>功能：</b>TablesController<br>
 * <br>
 */
@Controller
@RequestMapping("/codeing")
public class CodeingController extends BaseController {

	@Autowired(required=false)
	private CodeingService codeingService;

	/**
	 * 生成代码
	 * @param tid
	 * @return
	 * @throws CustomException
	 */
	@RequestMapping(value="/generate",method=RequestMethod.POST)
	public @ResponseBody Result generate(@RequestParam("tid") String tid)throws CustomException  {
			codeingService.generate(tid);
			return Result.getDefaultSuccMsgResult();
	}
	
	@RequestMapping(value="/readdbTable",method=RequestMethod.POST)
	public @ResponseBody Result readdbTable(@RequestParam("tableName") String tableName)throws CustomException  {
		codeingService.readDbTable(tableName);
		return Result.getDefaultSuccMsgResult();
}

	
}
