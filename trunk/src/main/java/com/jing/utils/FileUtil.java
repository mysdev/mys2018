package com.jing.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;

import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;

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
	
	/**
	 * @Description: 将文件从path1转移到path2 ,如果path2不存在就新建path2目录
	 * @author EX-LIFENG001
	 * @date 2013-3-11下午01:18:11
	 * @param path1
	 * @param path2
	 *            void
	 * @throws IOException
	 */
	public static void move(String path1, String path2) throws IOException {
		copy(path1, path2);
		deleteFile(path1);
	}
	
	/**
	 * @Description: 将文件从path1拷贝到path2 ,如果path2不存在就新建path2目录
	 * @author EX-LIFENG001
	 * @date 2013-3-11下午01:18:11
	 * @param path1
	 * @param path2
	 *            void
	 * @throws IOException
	 */
	public static void copy(String path1, String path2) throws IOException {
		if (path1.equals(path2)) {
			return;
		}

		FileUtil.mkdirs(path2);
		FileInputStream fileInputStream = new FileInputStream(path1);
		BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
		FileOutputStream fileOutputStream = new FileOutputStream(path2);
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
		IOUtils.copy(bufferedInputStream, bufferedOutputStream);
		bufferedInputStream.close();
		fileOutputStream.flush();
		fileInputStream.close();
		bufferedOutputStream.close();
		fileOutputStream.flush();
		fileOutputStream.close();
	}

	/**
	 * @Description: 创建目录（多层） ,如果最后一个层次中带有‘.’号则不会被创建。
	 * @author EX-LIFENG001
	 * @date 2013-3-12下午02:54:51
	 * @param path
	 *            void
	 */
	public static void mkdirs(String path) throws IOException {
		String[] tmp = path.split("/");
		if (tmp != null && tmp.length > 0) {
			if (tmp[tmp.length - 1].indexOf(".") > 0) {
				path = path.substring(0, path.lastIndexOf("/"));
			}
		}
		StringTokenizer st = new StringTokenizer(path, "/");
		StringBuffer pathBuf = new StringBuffer();
		pathBuf.append(st.nextToken()).append("/");
		while (st.hasMoreTokens()) {
			File inbox = new File(pathBuf.append(st.nextToken()).append("/").toString());
			if (!inbox.exists() && !inbox.mkdir())
				throw new IOException("make dir error!path = " + pathBuf.toString());
		}
	}
	
	/**
	 * @Description: 读取文件全部内容到字节数据
	 * @author EX-LIFENG001
	 * @date 2013-3-9下午04:42:33
	 * @param filePath
	 * @return
	 * @throws IOException
	 *             byte[]
	 */
	public static byte[] readFileToBytes(String filePath) throws IOException {
		FileInputStream fis = new FileInputStream(filePath);
		byte[] res = IOUtils.toByteArray(fis);
		fis.close();
		return res;
	}
	
	
	public static void writeMultipartFile(String filePath, MultipartFile file) throws IOException {
		InputStream stream = file.getInputStream();
		// 读入多个字节到字节数组中，byteread为一次读入的字节数
		FileUtil.mkdirs(filePath);
		FileOutputStream fs = new FileOutputStream(filePath, true);
		byte[] buffer = new byte[10240];
		int byteread = 0;
		while ((byteread = stream.read(buffer)) != -1) {
			fs.write(buffer, 0, byteread);
			fs.flush();
		}
		fs.close();
		stream.close();
	}

}
