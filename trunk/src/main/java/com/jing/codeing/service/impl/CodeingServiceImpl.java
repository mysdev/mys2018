package com.jing.codeing.service.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.VelocityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.jing.codeing.entity.Columns;
import com.jing.codeing.entity.Tables;
import com.jing.codeing.service.CodeingService;
import com.jing.codeing.service.ColumnsService;
import com.jing.codeing.service.TablesService;
import com.jing.codeing.util.CommonPageParser;
import com.jing.config.web.exception.CustomException;

/**
 * 代码生成相关服务接口
 * 
 * @author LIFENG
 *
 */
@Service("codeingService")
public class CodeingServiceImpl implements CodeingService {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private TablesService tablesService;
	@Autowired
	private ColumnsService columnsService;

	@Override
	@Transactional
	public void addTables(String tid) throws CustomException {
		// 先查询是不是已经存在了
		Tables table = tablesService.getTablesById(tid);
		if (table != null) {
			throw new CustomException("表已录入");
		} else {
			table = this.readDbTable(tid);
			tablesService.addTables(table);
			for (Columns columns : table.getColumns()) {
				columns.setTid(Integer.parseInt(tid));
				columnsService.addColumns(columns);
			}
		}
	}

	@Override
	public Tables readDbTable(String tableName) {
		Tables tables = new Tables();
		try {
			DruidPooledConnection connection = (DruidPooledConnection) dataSource.getConnection();
			// 查询table 信息
			String sqlTables = "show table status where Name='"+tableName+"'";
			PreparedStatement tablesStmt = connection.prepareStatement(sqlTables);
			ResultSet trs = tablesStmt.executeQuery();
			if (trs.next()) {
				tables = new Tables();
				tables.setTableName(tableName);
				tables.setTableComment(trs.getString("Comment"));
			} else {
				throw new CustomException("表不存在:" + tableName);
			}
			trs.close();
			tablesStmt.close();

			// 查询列
			String SQLColumns = "select COLUMN_NAME,DATA_TYPE,column_comment ,NUMERIC_PRECISION,NUMERIC_SCALE,CHARACTER_MAXIMUM_LENGTH,IS_NULLABLE "
					+ "from information_schema.columns  where table_name='" + tableName + "' and TABLE_SCHEMA='mys'"
					+ "order by ORDINAL_POSITION asc";
//			System.err.println(SQLColumns);
			PreparedStatement columnsStmt = connection.prepareStatement(SQLColumns);
			ResultSet rs = columnsStmt.executeQuery();
			List<Columns> columns = new ArrayList<Columns>();
			while (rs.next()) {
				String name = rs.getString(1);// 列名
				String type = rs.getString(2);// 数据类型-db
				String comment = rs.getString(3);// 注释
				String precision = rs.getString(4);// 精度
				String scale = rs.getString(5);// 范围
				String charmaxLength = rs.getString(6) == null ? "" : rs.getString(6);// 字段长度
				String nullable = rs.getString(7);// 是否可以为空
				if (("YES".equals(nullable)) || ("yes".equals(nullable)) || ("y".equals(nullable))
						|| ("Y".equals(nullable))) {
					nullable = "Y";
				} else if (("NO".equals(nullable)) || ("N".equals(nullable)) || ("no".equals(nullable))
						|| ("n".equals(nullable))) {
					nullable = "N";
				}
				type = getType(type, precision, scale);
				Columns cd = new Columns();
				// 列名
				cd.setColumnName(name);
				// 数据类型-java
				cd.setFiledType(type);
				// 数据类型-db
				cd.setColumnType(rs.getString(2));
				// 注释
				cd.setColumnComment(comment);
				// 范围
				cd.setScale(scale);
				// 字段长度
				if (charmaxLength != null && !"".equals(charmaxLength)) {
					cd.setLength(Integer.parseInt(charmaxLength));
				} else {
					cd.setLength(0);
				}
				// 是否可以为空
				cd.setNullable(nullable);
				columns.add(cd);
			}
			tables.setColumns(columns);
			columnsStmt.close();
			rs.close();
		} catch (Exception e) {
			throw new CustomException("数据库操作失败" + e.getMessage());
		}

		return tables;
	}

	public String getType(String dataType, String precision, String scale) {
		dataType = dataType.toLowerCase();
		if (dataType.contains("char") || dataType.contains("text"))
			dataType = "String";
		else if (dataType.contains("bit"))
			dataType = "Boolean";
		else if (dataType.contains("bigint"))
			dataType = "Long";
		else if (dataType.contains("int"))
			dataType = "Integer";
		else if (dataType.contains("float"))
			dataType = "java.lang.Float";
		else if (dataType.contains("double"))
			dataType = "Double";
		else if (dataType.contains("number")) {
			if ((StringUtils.isNotBlank(scale)) && (Integer.parseInt(scale) > 0))
				dataType = "java.math.BigDecimal";
			else if ((StringUtils.isNotBlank(precision)) && (Integer.parseInt(precision) > 6))
				dataType = "Long";
			else
				dataType = "Integer";
		} else if (dataType.contains("decimal"))
			dataType = "java.math.BigDecimal";
		else if (dataType.contains("date"))
			dataType = "Date";
		else if (dataType.contains("time"))
			dataType = "java.sql.Timestamp";
		else if (dataType.contains("datetime"))
			dataType = "java.util.Date";
		else if (dataType.contains("clob"))
			dataType = "String";
		else if (dataType.contains("text"))
			dataType = "String";
		else if (dataType.contains("longtext"))
			dataType = "String";
		else if (dataType.contains("blob"))
			dataType = "String";
		else {
			dataType = "java.lang.Object";
		}
		return dataType;
	}

	@Override
	public void generate(String tid) throws CustomException {
		// 获取代码生成跟目录

		// 获取表格对象
		Tables table = tablesService.getTablesById(tid);
		if (table == null) {
			throw new CustomException("表不存在.");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tid", tid);
		table.setColumns(columnsService.findColumnsByProperty(map));
		if (table.getColumns() == null) {
			throw new CustomException("空表（没有找到列）.");
		}
		String rootPath = this.getProjectPath();
		
		this.generate(table,rootPath);
	}

	private void generate(Tables table, String rootPath) {
		String className = table.getClassName();// 类名
		String lowerName = className.substring(0, 1).toLowerCase() + className.substring(1, className.length());// 类别名
		String packgePath = table.getPakageURL();
		
		rootPath = rootPath + packgePath.replace(".", "/");
		String[] pks = packgePath.split("\\.");
		
		//设置上下文
		VelocityContext context = new VelocityContext();
		context.put("comment", table.getTableComment());
		context.put("className", className);
		context.put("tableName", table.getTableName());
		context.put("lowerName", lowerName);
		context.put("packge", packgePath);
		context.put("columns", table.getColumns());
		context.put("model", pks[pks.length-1]);
		context.put("pkType", table.getColumns().get(0).getFiledType());
		Columns primaryKey =null;
		for (Columns col : table.getColumns()) {
			if(primaryKey==null){
				primaryKey =  col;
				context.put("primaryKey", primaryKey);
			}
			if(col.isForeignKey()){
				context.put("foreignKey", col);
			}
		}
		// entity
		String entityFilePath= rootPath + "/model/entity/";
		CommonPageParser.WriterPage(context, "EntityTemplate.ftl", entityFilePath, className+".java");
		// dao
		String daoFilePath= rootPath + "/model/dao/";
		String mapperFilePath= rootPath + "/model/mapper/";
		CommonPageParser.WriterPage(context, "DaoTemplate.ftl", daoFilePath, className+"Mapper.java");
		CommonPageParser.WriterPage(context, "MapperTemplate.ftl", mapperFilePath, className+"Mapper.xml");
		
		// service
		String serviceFilePath= rootPath + "/service/";
		String serviceImplFilePath= rootPath + "/service/impl/";
		CommonPageParser.WriterPage(context, "ServiceTemplate.ftl", serviceFilePath, className+"Service.java");
		CommonPageParser.WriterPage(context, "ServiceImplTemplate.ftl", serviceImplFilePath, className+"ServiceImpl.java");

		// controller
		String controllerFilePath= rootPath + "/controller/";
		CommonPageParser.WriterPage(context, "ControllerTemplate.ftl", controllerFilePath, className+"Controller.java");

		// easeyui
		String webpageFilePath= rootPath + "/webpage/easeyui/"+lowerName+"/";
		CommonPageParser.WriterPage(context, "PageListTemplate.ftl", webpageFilePath, lowerName+".html");
		CommonPageParser.WriterPage(context, "PageFormTemplate.ftl", webpageFilePath, lowerName+"_form.html");
		CommonPageParser.WriterPage(context, "PageDetailTemplate.ftl", webpageFilePath, lowerName+"_detail.html");
		
		//junitTest
		String junitTestFilePath= rootPath + "/test/";
		CommonPageParser.WriterPage(context, "TestTemplate.ftl", junitTestFilePath, "Test"+className+".java");
		
		//permission
		String permissionFilePath= rootPath + "/sql/";
		CommonPageParser.WriterPage(context, "PermissionTemplate.ftl", permissionFilePath, "qx_"+lowerName+".sql");
	}
	
	public String getProjectPath() {
		String path = System.getProperty("user.dir").replace("\\", "/") + "/target/codeing/";
		return path;
	}
}
