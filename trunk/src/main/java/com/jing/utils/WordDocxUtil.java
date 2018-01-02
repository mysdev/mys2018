package com.jing.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

/**
 * @ClassName: WordDocxUtil
 * @Description: word文档操作工具类-现阶段初步定制抽离 
 * 后期改进方向-书签操作
 * @author: Jinlong He
 * @date: 2017年11月15日 上午9:10:28
 */
public class WordDocxUtil {
	

	/**
	 * @Title: getXWPFDocument 
	 * @Description: 获取文档对象 
	 * @param inputUrl 目标文件地址 
	 * @return XWPFDocument 返回类型 
	 */
	private static XWPFDocument getXWPFDocument(String inputUrl) {
		// 解析docx模板并获取document对象
		try {
			XWPFDocument document = new XWPFDocument(POIXMLDocument.openPackage(inputUrl));			
			return document;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void writeTemplateWord(String inputUrl, String outputUrl, Map<String, String> textParam,
			List<String[]> tableData) {
		// 解析docx模板并获取document对象
		XWPFDocument document = getXWPFDocument(inputUrl);
		
		if(textParam!=null && textParam.size()>0){
			changeTemplateText(document, textParam);  //文本值替换
		}
		
		if((tableData!=null && tableData.size()>0) || (textParam!=null && textParam.size()>0)){
			changeTemplateTable(document, textParam, tableData);  //表格内容处理
		}		
		
		//生成新的word
        File file = new File(outputUrl);
		try {
			FileOutputStream stream = new FileOutputStream(file);
			document.write(stream);
	        stream.close();
	        document.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
	}
	
	/** 
	* @Title: changeTemplateTable
	* @Description: 写入表格内容 
	* @param document 
	* @param textParam
	* @param tableData  void    返回类型 
	* @throws 
	*/
	public static void changeTemplateTable(XWPFDocument document, Map<String, String> textParam,
			List<String[]> tableData) {
		// 获取表格对象集合
		List<XWPFTable> tables = document.getTables();
		for (int i = 0; i < tables.size(); i++) {
			XWPFTable table = tables.get(i);			
			if (table.getRows().size() > 1 && textParam!=null && textParam.size()>0) {				
				// 替换只处理行数大于等于2的表格，且不循环表头				
				if (checkReplaceText(table.getText())) {
					// 判断表格是需要替换还是需要插入，判断逻辑有$为替换，表格无$为插入
					List<XWPFTableRow> rows = table.getRows();
					// 遍历表格,并替换模板
					replaceTable(rows, textParam);
				} 
			}else if(table.getRows().size() ==1 && tableData.size()>0){
				// 只有表头 写入行数据
				insertTable(table, tableData);
			}
		}
	}
	
	/**
     * 遍历表格
     * @param rows 表格行对象
     * @param textParam 需要替换的信息集合
     */
    public static void replaceTable(List<XWPFTableRow> rows ,Map<String, String> textParam){
        for (XWPFTableRow row : rows) {
            List<XWPFTableCell> cells = row.getTableCells();
            for (XWPFTableCell cell : cells) {
                //判断单元格是否需要替换
            	String cellText = cell.getText();
                if(checkReplaceText(cellText)){
//                	while (cell.getParagraphs().size()>0) {
//                		cell.removeParagraph(0);
//                    }
//                    XWPFParagraph p = document.createParagraph();//此法引起最后有个标签
//                    p.createRun().setText(replaceValue(cellText, textParam), 0);
//                    cell.setParagraph(p);
                	List<XWPFParagraph> paragraphs = cell.getParagraphs();
                    for (XWPFParagraph paragraph : paragraphs) {
                        List<XWPFRun> runs = paragraph.getRuns();
                        for (XWPFRun run : runs) {
                            run.setText(replaceValue(run.toString(), textParam),0);
                        }
                    }
                }
            }
        }
    }
    
    /**
     * 为表格插入数据，行数不够添加新行
     * @param table 需要插入数据的表格
     * @param tableData 插入数据集合
     */
    public static void insertTable(XWPFTable table, List<String[]> tableData){
    	if(tableData==null || tableData.size()==0){
    		return;
    	}
        //创建行,根据需要插入的数据添加新行
        for(int i = 0; i < tableData.size(); i++){
            XWPFTableRow row =table.createRow();
            List<XWPFTableCell> cells = row.getTableCells();
            for(int j = 0; j < cells.size(); j++){
            	if(j<tableData.get(i).length){
            		//保证数据不越界
            		XWPFTableCell cell = cells.get(j);
                	cell.setText(tableData.get(i)[j]);
                }
            }
        }
    }

	/** 
	* @Title: changeTemplateText 
	* @Description: 写入变量参数
	* @param document
	* @param textParam  void    返回类型 
	* @throws 
	*/
	public static void changeTemplateText(XWPFDocument document, Map<String, String> textParam){
		if(textParam==null || textParam.size()==0){
			return;
		}
        //获取段落集合
        List<XWPFParagraph> paragraphs = document.getParagraphs();
        for (XWPFParagraph paragraph : paragraphs) {
            //判断此段落时候需要进行替换
            String text = paragraph.getText();
            if(checkReplaceText(text)){            	
                List<XWPFRun> runs = paragraph.getRuns();
                int c = runs.size();
                for (int k=0; k<c; k++) {
                	paragraph.removeRun(0);   //移除所有      
                }                
                paragraph.createRun().setText(replaceValue(text, textParam), 0);
            }
        }
    }
	
	/** 
	* @Title: replaceValue 
	* @Description: 替换变量值
	* @param line 
	* @param textParam 
	* @return  String    返回类型 
	* @throws 
	*/
	private static String replaceValue(String line, Map<String, String> textParam) {	
		if(textParam==null || textParam.size()==0){
			return "";
		}
		for(String key : textParam.keySet()){
			if(line.indexOf("${"+key+"}")!=-1){
				line = line.replace("${"+key+"}", textParam.get(key));
			}
		}
		return line;
	}

	/** 
	* @Title: checkReplaceText 
	* @Description: 判断是否包括特殊符号${*}
	* @param lineContext 行文本
	* @return  boolean    返回类型 
	* @throws 
	*/
	private static boolean checkReplaceText(String lineContext){
		if(lineContext!=null && lineContext.length()>0){
			if(lineContext.indexOf("${")!=-1 && lineContext.indexOf("}")!=-1){
				return true;
			}
		}
		return false;
	}
	
//	public static void main(String[] arg) {
//		String inputUrl = "D:\\50.docx";
//		String outputUrl = "D:\\51.docx";		
//		Map<String, String> param = new HashMap<String, String>();
//		param.put("userName", "景隆");
//		param.put("userNote", "不是宗师，也是高手");
//		
//		List<String[]> tables = new ArrayList<String[]>();
//		for(int i=0; i<10; i++){
//			String[] s = new String[]{ "话题"+i, ""+(100*i), "不是高手，也是老司机"+i};
//			tables.add(s);
//		}
//		WordDocxUtil.writeTemplateWord(inputUrl, outputUrl, null, null);		
//	}

}
