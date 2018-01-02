package com.jing.utils;

import java.io.File;

/**
 * @ClassName: FileUtil
 * @Description: 文件操作有关函数
 * @author: Jinlong He
 * @date: 2017年11月15日 下午3:13:21
 */
public class FileUtil {
	
	public static String systemSeparator =  System.getProperty("file.separator");
	
//	public static void main(String[] arg){
//		System.out.println(getRealFile("/user/local", "aa.txt"));
//		System.out.println(getRealFile("/user/local/", "aa.txt"));
//		System.out.println(getRealFile("D:\\local", "aa.txt"));
//		System.out.println(getRealFile("D:\\local\\", "aa.txt"));
//		
//		System.out.println(FileUtil.deleteFileOrDirectory("D:\\Downloads"));
//		System.out.println(FileUtil.deleteFileOrDirectory("D:\\62.docx"));
//	}
	
	/** 
	* @Title: getRealFile 
	* @Description: 获取资源地址-自动处理路径符号与分隔符
	* @param path 路径
	* @param filename 文件名
	* @return  String    返回类型 
	* @throws 
	*/
	public static String getRealFile(String path, String filename){
		if(!path.endsWith("/") && !path.endsWith("\\")){
			return getRealFilePath(path+systemSeparator+filename);
		}else{
			return getRealFilePath(path+filename);
		}
	}
	
	/** 
	* @Title: getRealFilePath 
	* @Description: 当前文件系统路径
	* @param path
	* @return  String    返回类型 
	* @throws 
	*/
	public static String getRealFilePath(String path) {  
        return path.replace("/", systemSeparator).replace("\\", systemSeparator);
    }
	
	/** 
	* @Title: deleteFileOrDirectory 
	* @Description: 删除文件或文件目录 
	* @param fileName
	* @return  boolean    返回类型 
	* @throws 
	*/
	public static boolean deleteFileOrDirectory(String fileName){
		File file = new File(fileName);
        if (!file.exists()) {
            return false;
        } else {
            if (file.isFile())
                return deleteFile(fileName);
            else
                return deleteDirectory(fileName);
        }
	}
	
	/** 
	* @Title: deleteDirectory 
	* @Description: 删除目录，级联删除子目录及文件
	* @param dir
	* @return  boolean    返回类型 
	* @throws 
	*/
	private static boolean deleteDirectory(String dir) {
		 // 如果dir不以文件分隔符结尾，自动添加文件分隔符
        if (!dir.endsWith(File.separator))
            dir = dir + File.separator;
        File dirFile = new File(dir);
        // 如果dir对应的文件不存在，或者不是一个目录，则退出
        if ((!dirFile.exists()) || (!dirFile.isDirectory())) {
            return false;
        }
        boolean flag = true;
        // 删除文件夹中的所有文件包括子目录
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            // 删除子文件
            if (files[i].isFile()) {
                flag = FileUtil.deleteFile(files[i].getAbsolutePath());
                if (!flag)
                    break;
            }
            // 删除子目录
            else if (files[i].isDirectory()) {
                flag = FileUtil.deleteDirectory(files[i]
                        .getAbsolutePath());
                if (!flag)
                    break;
            }
        }
        if (!flag) {
            return false;
        }
        // 删除当前目录
        if (dirFile.delete()) {
            return true;
        } else {
            return false;
        }
	}

	/** 
	* @Title: deleteFile 
	* @Description: 删除文件
	* @param fileName
	* @return  boolean    返回类型 
	* @throws 
	*/
	private static boolean deleteFile(String fileName) {
		File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
	}


}
