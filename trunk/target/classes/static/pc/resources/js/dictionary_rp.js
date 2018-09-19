/**
 * 获取字典组某个字典的值-用于grid显示
 * 
 * @param group
 * @param code
 * @returns
 */
function dictionary(group, code) {
    if (!code) {
	return "";
    }
    for (var i = 0; i < dictionaryObj.length; i++) {
	if (dictionaryObj[i].code == group) {
	    var array = dictionaryObj[i].dictionarys;
	    for (var j = 0; j < array.length; j++) {
		if (array[j].code == code) {
		    return array[j].value;
		}
	    }
	}
    }
    return "未知";
}

/**
 * 获取字典组某个字典的值-用于grid显示
 * 
 * @param group
 * @param code
 * @returns
 */
function dictionary_checkbox(group, code) {
    if (!code) {
	return "";
    }
    var array = [];
    for (var i = 0; i < dictionaryObj.length; i++) {
	if (dictionaryObj[i].code == group) {
	    array = dictionaryObj[i].dictionarys;
	}
    }
    if (code.length > 0 && code.indexOf(",") > 0) {
	var res = '';
	var codes = code.split(",");
	for (var j = 0; j < array.length; j++) {
	    for (var k = 0; k < codes.length; k++) {
		if (array[j].code == codes[k]) {
		    res = res + array[j].value + "，";
		}
	    }
	}
	if (res.length > 0) {
	    res = res.substring(0, res.length - 1)
	}
	return res;
    } else {
	for (var j = 0; j < array.length; j++) {
	    if (array[j].code == code) {
		return array[j].value;
	    }
	}
    }
    return "未知";
}

/**
 * 获取字典组所有字典数组-加“不限” -用于LG 的查询条件
 * 
 * @param group
 * @returns
 */
function dictionarySelect(group) {
    for (var i = 0; i < dictionaryObj.length; i++) {
	if (dictionaryObj[i].code == group) {
	    var array = dictionaryObj[i].dictionarys;
	    array.splice(0, 0, {
		code : '-1',
		value : '不限',
		upValue : null
	    });
	    return array;
	}
    }
    var list = new Array();
    list.splice(0, 0, {
	code : '-1',
	value : '不限'
    });
    return list;
}

/**
 * 获取字典组所有字典数组-用于LG表单
 * 
 * @param group
 * @returns
 */
function dictionarySelectFild(group) {
    var list = new Array();
    for (var i = 0; i < dictionaryObj.length; i++) {
	if (dictionaryObj[i].code == group) {
	    var array = dictionaryObj[i].dictionarys;
	    for (var int = 0; int < array.length; int++) {
		//if (array[int].flag == 1) {
		    list.push(array[int]);
		//}
	    }
	}
    }
    return list;
}

// find code in list,and return value
/**
 * 从字典数组中找对应code的值
 */
function dictionary2(youList, code) {
    if (youList == null || youList.length == 0 || code == null || code.length == 0) {
	return '';
    }
    for (var i = 0; i < youList.length; i++) {
	if (youList[i].code == code) {
	    return youList[i].value;
	}
    }
    return code;
}

/**
 * 获取"是/否"字典组-数组
 * 
 * @returns {Array}
 */
function dictionaryYN() {
    var rs = [];
    var tmp = new Object();
    tmp.code = '1';
    tmp.value = '是';
    rs.push(tmp);

    var tmp1 = new Object();
    tmp1.code = '0';
    tmp1.value = '否';
    rs.push(tmp1);
    return rs;
}

/**
 * 分析"是/否"字典的值
 * 
 * @param code
 * @returns {String}
 */
function dictionaryYN(code) {
    if (code == 1) {
	return "是";
    } else if (code == 0) {
	return "否";
    }
}

function dictionaryYN2() {
    return [ {
	code : '1',
	value : '是'
    }, {
	code : '0',
	value : '否'
    } ];
}

function dictionaryYN2cn(code) {
    if (code == '1') {
	return "是";
    } else if (code == '0') {
	return "否";
    }
}

/**
 * 获取字典组所有字典-字符串-【？？】
 * 
 * @param group
 * @returns {String}
 */
function getOptionStr(group) {
    var rs = "<li><a href='javascript:;' selectid='-1' onclick='getContion(\"" + group + "\", \"-1\", \"\")'>不限</a></li>";
    var ss = "<li><a href='javascript:;' selectid='-1' onclick='getContion(\"" + group + "\", \"-1\", \"\")'>不限</a>&nbsp;&nbsp;&nbsp;&nbsp;<input type='button' value='确定' class='input_subc'></li>"
    for (var i = 0; i < dictionaryObj.length; i++) {
	if (dictionaryObj[i].code == group) {
	    var array = dictionaryObj[i].dictionarys;
	    for (var j = 0; j < array.length; j++) {
		if ('health' == group || 'economy' == group || 'personnelProperty' == group || 'marriageStatus' == group || 'politicalStatus' == group || 'building_self_type' == group
			|| 'building_type' == group || 'building_use' == group || 'building_structure' == group) {
		    rs += "<li><table><tr><td><input type='checkbox' id='con" + group + "_" + array[j].code + "' onclick='add_contions(\"" + group + "\", \"" + array[j].code + "\", \""
			    + array[j].value + "\")'/></td><td style='font-size:12px;padding-top:4px;'>" + array[j].value + "</td></tr></table></li> ";
		} else if ('nation' == group) {
		    ss += "<div class='div_f div_nationw div_mt_t_t'><table><tr><td><input type='checkbox' id='con" + group + "_" + array[j].code + "' onclick='add_contions(\"" + group + "\", \""
			    + array[j].code + "\", \"" + array[j].value + "\")'/></td><td style='font-size:12px;padding-top:4px;'>" + array[j].value + "</td></tr></table></div> ";
		} else if ('education' == group) {
		    ss += "<div class='div_f div_educationW div_mt_t_t'><table><tr><td><input type='checkbox' id='con" + group + "_" + array[j].code + "' onclick='add_contions(\"" + group + "\", \""
			    + array[j].code + "\", \"" + array[j].value + "\")'/></td><td style='font-size:12px;padding-top:4px;'>" + array[j].value + "</td></tr></table></div> ";
		} else if ('population_business' == group) {
		    ss += "<div class='div_f div_popw div_mt_t_t'><table><tr><td><input type='checkbox' id='con" + group + "_" + array[j].code + "' onclick='add_contions(\"" + group + "\", \""
			    + array[j].code + "\", \"" + array[j].value + "\")'/></td><td style='font-size:12px;padding-top:4px;'>" + array[j].value + "</td></tr></table></div> ";
		} else {
		    rs += "<li><a href='javascript:;' selectid='" + array[j].code + "' onclick='getContion(\"" + group + "\", \"" + array[j].code + "\", \"" + array[j].value + "\")'>"
			    + array[j].value + "</a></li> ";
		}
	    }
	}
    }
    if ('nation' == group || 'education' == group || 'population_business' == group) {
	return ss;
    } else {
	return rs;
    }
}

/**
 * 获取字典组所有字典-字符串-【简单option格式】
 * 
 * @param group
 * @returns {String}
 */
function getOption(group) {
    var opts = '';
    for (var i = 0; i < dictionaryObj.length; i++) {
	if (dictionaryObj[i].code == group) {
	    var array = dictionaryObj[i].dictionarys;
	    for (var j = 0; j < array.length; j++) {
		if (array[j].flag == 1) {
		    opts += '<option value="' + array[j].code + '">' + array[j].value + '</option>';
		}
	    }
	    return opts;

	}
    }
}

/**
 * 获取字典组所有字典-字符串-【简单radio格式】
 * 
 * @param group
 * @param inputId
 * @param inputName
 * @returns {String}
 */
function getDictionaryRadio(group, inputId, inputName) {
    var opts = '';
    for (var i = 0; i < dictionaryObj.length; i++) {
	if (dictionaryObj[i].code == group) {
	    var array = dictionaryObj[i].dictionarys;
	    for (var j = 0; j < array.length; j++) {
		if (array[j].flag == 1) {
		    opts += '<input type="radio" id="' + inputId + '" name="' + inputName + '" value="' + array[j].code + '" />' + array[j].value + '';
		}
	    }
	    return opts;

	}
    }
}

/**
 * 获取字典组所有字典-字符串-【简单checkbox格式】
 * @param group
 * @param inputId
 * @param inputName
 * @returns {String}
 */
function getDictionaryCheckbox(group, inputId, inputName) {
    var opts = '';
    for (var i = 0; i < dictionaryObj.length; i++) {
	if (dictionaryObj[i].code == group) {
	    var array = dictionaryObj[i].dictionarys;
	    for (var j = 0; j < array.length; j++) {
		if (array[j].flag == 1) {
		    opts += '<input type="checkbox" id="' + inputId + '" name="' + inputName + '" value="' + array[j].code + '" />' + array[j].value + '';
		}
	    }
	    return opts;

	}
    }
}