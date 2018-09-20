package com.jing.codeing.entity;

import java.io.Serializable;

/**
 * 
 * <br>
 * <b>功能：</b>列<br>
 */
public class Columns implements Serializable {
	private static final long serialVersionUID = 1L;
	private final int fontSize=13;
	private Integer cid; //列名
	private int tid;// 表名
	private String columnName;// 字段名
	private String columnLabel;// 显示名
	private String columnComment;// 字段注释
	private String columnType;// 字段类型【varchar\int\colob\datetime】
	private String scale;// 规模
	private String precision;// 精度
	private String nullable;//是否不可以为空Y/N
	private boolean foreignKey = false;//是否外键
	private String filedName;//字段名
	private String filedType;//Java类型【String\Integer\Date】
	private Integer length;// 字段长度
	private Integer isSearch=1;// 是否查询条件
	private Integer isList=1;// 是否列表显示
	private Integer listSort;// 列表顺序
	private Integer listWidth;// 列表宽度
	private Integer isForm=1;// 是否表单显示
	private Integer formType=1;// 表单控件类型【0=hidden;1=text;2=radio;3=checkbox;4=select;5=date;6=textarea;7=number】
	private String groupCode;// 数据字典groupCode
	private String formClass="form-control";// 表单Class
	private String formValidate;// 表单校验
	private Integer fromWidth;// 控件宽度
	private Integer spacing;// 间隔宽度
	private Integer isNewLine=0;// 是否换行
	private String method;//方法名称
	
	public static void main(String[] args) {
		
		
		
	}
	
	public String getFiledName() {
		if(columnName != null) {
			String s[]  = columnName.split("_");
			StringBuffer sbf = new StringBuffer();
			for(int i=0;i<s.length;i++) {
				if(i>0) {
					sbf.append(s[i].substring(0, 1).toUpperCase() + s[i].substring(1, s[i].length()));
				}else {
					sbf.append(s[i]);
				}
			}
			return sbf.toString();
		}
		return filedName;
	}

	public String getMethod() {
		//columnName
		if(method==null){
			String maxChar = getFiledName().substring(0, 1).toUpperCase();
			method = maxChar + getFiledName().substring(1, getFiledName().length());
		}
		return method;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getColumnName() {
		return this.columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnLabel() {
		if(columnLabel==null){
			return columnComment;
		}
		return this.columnLabel;
	}

	public void setColumnLabel(String columnLabel) {
		this.columnLabel = columnLabel;
	}

	public String getColumnComment() {
		return this.columnComment;
	}

	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}

	public String getColumnType() {
		return this.columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	public Integer getLength() {
		return this.length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getIsSearch() {
		return this.isSearch;
	}

	public void setIsSearch(Integer isSearch) {
		this.isSearch = isSearch;
	}

	public Integer getIsList() {
		return this.isList;
	}

	public void setIsList(Integer isList) {
		this.isList = isList;
	}

	public Integer getListSort() {
		return this.listSort;
	}

	public void setListSort(Integer listSort) {
		this.listSort = listSort;
	}

	public Integer getListWidth() {
		if(listWidth==null && length != null && length.intValue()>0){
			listWidth =  length*fontSize;
		}else if(listWidth==null && (length ==null || length.intValue()==0)){
			listWidth = getColumnLabel().length()*fontSize;
		}
		if(listWidth>500){
			listWidth = 500;
		}
		return this.listWidth;
	}

	public void setListWidth(Integer listWidth) {
		this.listWidth = listWidth;
	}

	public Integer getIsForm() {
		if(isForm==null && "createdBy".equals(getColumnName())){
			return 0;
		}else if(isForm==null && "createdDate".equals(getColumnName())){
			return 0;
		}else if(isForm==null && "updatedBy".equals(getColumnName())){
			return 0;
		}else if(isForm==null && "updatedDate".equals(getColumnName())){
			return 0;
		}
		return this.isForm;
	}

	public void setIsForm(Integer isForm) {
		this.isForm = isForm;
	}

	//【0=hidden;1=text;2=radio;3=checkbox;4=select;5=date;6=textarea;7=number】
	public Integer getFormType() {
		if(formType==null && "String".equals(getFiledType())){
			return 1;
		}else if(formType==null && "Date".equals(getFiledType())){
			return 5;
		}else if(formType==null && "Integer".equals(getFiledType())){
			return 7;
		}
		return this.formType;
	}

	public void setFormType(Integer formType) {
		this.formType = formType;
	}

	public String getGroupCode() {
		return this.groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getFormClass() {
		return this.formClass;
	}

	public void setFormClass(String formClass) {
		this.formClass = formClass;
	}

	public String getFormValidate() {
		return this.formValidate;
	}

	public void setFormValidate(String formValidate) {
		this.formValidate = formValidate;
	}

	public Integer getFromWidth() {
		return this.fromWidth;
	}

	public void setFromWidth(Integer fromWidth) {
		this.fromWidth = fromWidth;
	}

	public Integer getSpacing() {
		return this.spacing;
	}

	public void setSpacing(Integer spacing) {
		this.spacing = spacing;
	}

	public Integer getIsNewLine() {
		return this.isNewLine;
	}

	public void setIsNewLine(Integer isNewLine) {
		this.isNewLine = isNewLine;
	}

	public String getFiledType() {
		return filedType;
	}

	public void setFiledType(String filedType) {
		this.filedType = filedType;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getPrecision() {
		return precision;
	}

	public void setPrecision(String precision) {
		this.precision = precision;
	}

	public String getNullable() {
		return nullable;
	}

	public void setNullable(String nullable) {
		this.nullable = nullable;
	}
	
	public boolean isForeignKey() {
		return foreignKey;
	}

	public void setForeignKey(boolean foreignKey) {
		this.foreignKey = foreignKey;
	}
	
	
	
	private String filedStr;//字段声明字符串
	private String getMethodStr;//get方法声明字符串
	private String setMethodStr;//set方法声明字符串

	public String getFiledStr() {
		if(filedStr==null){
			return "private " + this.getFiledType()+" " + this.getFiledName()+";" + "   // "+ this.getColumnLabel()+ (this.getColumnComment().equals(this.getColumnLabel())?"":":"+this.getColumnComment());
		}
		return filedStr;
	}

	public String getGetMethodStr() {
		if(getMethodStr==null){
			//首字母大写
			StringBuffer str = new StringBuffer();
			str.append("\r\t").append("public ").append(getFiledType() + " ").append("get" +getMethod() + "() {\r\t");
			str.append("    return this.").append(getFiledName()).append(";\r\t}");
			return str.toString();
			
		}
		return getMethodStr;
	}

	public String getSetMethodStr() {
		if(setMethodStr==null){
			//首字母大写
			StringBuffer str = new StringBuffer();
			str.append("\r\t").append("public ").append("void ").append("set" + getMethod() + "(").append(getFiledType() +" " + getFiledName()+ ")" ).append("{\r\t");
			str.append("this.").append(getFiledName() +" = "+ getFiledName()).append(";\r\t}");
			return str.toString();
		}
		return setMethodStr;
	}
	
}
