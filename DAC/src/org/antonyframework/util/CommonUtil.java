package org.antonyframework.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * 通用工具类
 * 
 * @author Nanlei
 * 
 */
public final class CommonUtil {
	/**
	 * 获取当前时间戳
	 * 
	 * @return
	 */
	public static long getTimestamp() {
		return new java.util.Date().getTime();
	}

	/**
	 * 按字节切分字符串
	 */
	public static String substring(String str, int toCount, String suffix) {
		int reInt = 0;
		StringBuffer reStr = new StringBuffer();
		if (str == null)
			return "";
		char[] tempChar = str.toCharArray();
		for (int kk = 0; (kk < tempChar.length && toCount > reInt); kk++) {
			String s1 = String.valueOf(tempChar[kk]);
			byte[] b = s1.getBytes();
			reInt += b.length;
			if (toCount >= reInt) {
				reStr.append(tempChar[kk]);
			}
		}
		if (suffix != null && !"".equals(suffix)) {
			if (toCount == reInt || (toCount == reInt - 1))
				reStr.append(suffix);
		}
		return reStr.toString();
	}

	public static String getExtensionFromFileName(String fileName) {
		int pot = fileName.lastIndexOf(".");
		if (pot != -1) {
			return fileName.substring(pot + 1, fileName.length());
		} else {
			return "";
		}
	}
	public static File CommonFileUploadUtil(String uploadPath,String dirType,HttpServletRequest request,MultipartFile file){
		/*获取文件上传路径名称*/
		String fileNameLong = file.getOriginalFilename();
		//System.out.println("fileNameLong:" + fileNameLong);
		
		/*获取文件扩展名*/
		/*索引加1的效果是只取xxx.jpg的jpg*/
		String extensionName = fileNameLong.substring(fileNameLong.lastIndexOf(".") + 1);
		String newFileName = "";
		/* 获取文件上传存储的相当路径 */
		String realBaseDir = request.getSession().getServletContext()
				.getRealPath(uploadPath);
		System.out.println("%%%%%%%%%%%%%%%%%%%%"+file.getContentType());
		System.out.println(realBaseDir+"%%%%%%%%%%%%%%%%%%%%");
		File baseFile = new File(realBaseDir);
		if (!baseFile.exists()) {
			baseFile.mkdir();
		}

		//0:不建目录, 1:按天存入目录, 2:按月存入目录, 3:按扩展名存目录.建议使用按天存.
		String fileFolder = "";
		if (dirType.equalsIgnoreCase("1"))
			fileFolder = new SimpleDateFormat("yyyyMMdd").format(new Date());;
		if (dirType.equalsIgnoreCase("2"))
			fileFolder = new SimpleDateFormat("yyyyMM").format(new Date());
		
		/*文件存储的相对路径*/
		String saveDirPath = uploadPath +fileFolder + "/";
		//System.out.println("saveDirPath:" + saveDirPath);
		
		/*文件存储在容器中的绝对路径*/
		String saveFilePath = request.getSession().getServletContext().getRealPath("") + saveDirPath;
		//System.out.println("saveFilePath:" + saveFilePath);
		
		/*构建文件目录以及目录文件*/
		File fileDir = new File(saveFilePath);
		System.out.println(saveFilePath+"(((((((((9");
		if (!fileDir.exists()) {fileDir.mkdirs();}
		
		/*重命名文件*/
		String filename = UUID.randomUUID().toString();
		System.out.println(filename);
		File savefile = new File(saveFilePath + filename.substring(0, 7) + "." + extensionName);
		
		//这个地方根据项目的不一样，需要做一些特别的定制。
		newFileName = "/sun/" + saveDirPath + filename.substring(0, 7) + "." + extensionName;		
		//System.out.println("newFileName:" + newFileName);

		try {
			FileCopyUtils.copy(file.getBytes(), savefile);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return savefile;
	}
}
