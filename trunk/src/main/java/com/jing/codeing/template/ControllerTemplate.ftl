package ${packge}.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jing.utils.BaseController;
import com.jing.config.web.Result;
import com.jing.config.web.exception.CustomException;
import com.jing.config.web.page.PageInfo;
import com.jing.config.web.page.PageRequestUtils;
import com.jing.system.login.session.Config;
import com.jing.system.login.session.SessionAttr;
import com.jing.system.user.entity.User;
import ${packge}.model.entity.${className};
import ${packge}.service.${className}Service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

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
	
	@ApiOperation(value = "新增${comment}", notes = "添加${comment}")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Result add(${className} ${lowerName},@SessionAttr(Config.USER_INFO) User user) {
		${lowerName}.setCreatedBy(user.getUserId());
		${lowerName}.setCreatedDateNow();
		${lowerName}.setUpdatedBy(user.getUserId());
		${lowerName}.setUpdatedDateNow();
		${lowerName}Service.add${className}(${lowerName});
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "修改${comment}", notes = "修改${comment}")
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

	@ApiOperation(value = "删除 根据ID删除${comment}", notes = "根据ID删除${comment}")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result delete(@PathVariable("id") ${primaryKey.filedType} id){
		if(id==null || "".equals(id)){
			throw new CustomException("缺失删除参数.");
		}
		${lowerName}Service.delete${className}ById(id);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "根据ID查询${comment}", notes = "根据ID查询${comment}")
	@RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
	public @ResponseBody Result get(@PathVariable("id") ${primaryKey.filedType} id){
		if(id==null || "".equals(id)){
			throw new CustomException("缺失查询参数.");
		}
		return Result.getDefaultSuccMsgResult(${lowerName}Service.get${className}ById(id));
	}
		
	@ApiOperation(value = "分页查询${comment}", notes = "分页查询${comment}")
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public @ResponseBody PageInfo findPage(HttpServletRequest request)throws Exception {
		Map<String,Object> map=PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		return ${lowerName}Service.find${className}ListPage(PageRequestUtils.getPageBean(request), map);
	}
}