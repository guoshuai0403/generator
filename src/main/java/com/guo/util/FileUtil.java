/**   **/
package com.guo.util;

import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * 文件生成、删除工具类
 *
 * @auth guoshuai
 * @since 2018年3月26日下午5:49:25
 */
public class FileUtil {
	
	/**
	 * 工具类构造方法私有化
	 */
	private FileUtil() {}

	/**
	 * 生成文件并向文件中写入相应的内容
	 *
	 * @auth guoshuai
	 * @since 2018年3月28日下午3:53:25
	 * @param filePath - 文件路径
	 * @param fileName - 文件名
	 * @param filecontent - 文件内容
	 * @return
	 */
    public static boolean createFile(String filePath, String fileName, String filecontent){
    	
        Boolean bool = false;
        String filenameTemp = filePath + File.separator +fileName;//文件路径+名称+文件类型
        File file = new File(filenameTemp);
        try {
        	
        	FileUtil.createFolder(new File(filePath));
        	
        	// 文件存在就删除掉，保证是最新的
        	if (file.exists()) {
        		
        		file.delete();
        	}
        	
        	// 创建最新的文件
        	file.createNewFile();
        	
        	bool = true;
            //创建文件成功后，写入内容到文件里
            writeFileContent(filenameTemp, filecontent);
            
            System.out.println("success create file,the file is "+filenameTemp);
        	
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return bool;
    }
    
    /**
     * 删除文件
     *
     * @auth guoshuai
     * @since 2018年3月28日下午3:54:48
     * @param filePath - 文件路径
     * @param fileName - 文件名称
     * @return
     */
    public static boolean delFile(String filePath, String fileName){
        Boolean bool = false;
        String filenameTemp = filePath + File.separator + fileName;
        File file  = new File(filenameTemp);
        try {
            if(file.exists()){
                file.delete();
                bool = true;
            }
        } catch (Exception e) {
        	
        	e.printStackTrace();
        }
        return bool;
    }
    
    //--------------私有方法-----------------------
    
    /**
     * 递归创建文件夹
     * @auth guoshuai
     * @since 2018年3月28日下午4:33:17
     * @param file
     */
    private static void createFolder(File file) {
		
    	if (file.exists()) {
    		
    		return;
    	}
    	
		if (!file.getParentFile().exists()) {
			
			File parentFile = file.getParentFile();
			
			createFolder(parentFile);
		}
		
		file.mkdir();
	}
    
    /**
     * 向文件中写入内容
     *
     * @auth guoshuai
     * @since 2018年3月28日下午3:54:15
     * @param filepath - 文件路径与名称全称
     * @param newstr - 写入的内容
     * @return
     * @throws IOException
     */
    private static boolean writeFileContent(String filepath, String newstr) throws IOException {
        Boolean bool = false;
        String filein = newstr+"\r\n";//新写入的行，换行
        String temp;
        
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            File file = new File(filepath);//文件路径(包括文件名称)
            //将文件读入输入流
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            StringBuffer buffer = new StringBuffer();
            
            //文件原有内容
            while ((temp =br.readLine())!=null) {
            	buffer.append(temp);
                // 行与行之间的分隔符 相当于“\n”
                buffer = buffer.append(System.getProperty("line.separator"));
            }
            buffer.append(filein);
            
//            fos = new FileOutputStream(file);
            pw = new PrintWriter(file, "utf-8");
            pw.write(buffer.toString().toCharArray());
            pw.flush();
            bool = true;
        } catch (Exception e) {
            LoggerFactory.getLogger(FileUtil.class).error(e.getMessage());
        }finally {
            //不要忘记关闭
            if (pw != null) {
                pw.close();
            }
            if (br != null) {
                br.close();
            }
            if (isr != null) {
                isr.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
        return bool;
    }
}
