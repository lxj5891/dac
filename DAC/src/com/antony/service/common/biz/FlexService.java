package com.antony.service.common.biz;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.antonyframework.service.common.BaseService;

public class FlexService extends BaseService{

	private int len = 0;// 处理流
	private int mm = 0;// 重命名
	private static String systemDir;

	private static String baseDir = "/uploads/";// 上传文件存储目录
	private static String flexDir = "/COMBOIMG/";// 上传文件存储目录
	
	private static String quanDir = "/uploads/";// 上传文件存储目录
	
	private static String fileExt = "jpg,jpeg,bmp,gif,png";
	private static Long maxSize = 0l;

	// 0:不建目录 1:按天存入目录 2:按月存入目录 3:按扩展名存目录 建议使用按天存
	private static String dirType = "1";
	
	public void init(){
		
		try {
			ResourceBundle resourceBundle;
			resourceBundle = ResourceBundle.getBundle("/combo");
			baseDir = resourceBundle.getString("baseDir");
			fileExt = resourceBundle.getString("fileExt");
			maxSize = Long.valueOf(resourceBundle.getString("maxSize"));
			
			flexDir = resourceBundle.getString("flexDir");
			dirType = resourceBundle.getString("dirType");
			systemDir = resourceBundle.getString("systemDir");
			
			
			quanDir = resourceBundle.getString("quanDir");
			
			quanDir = "/uploads/quan/";
			
			
			flexDir = "/uploads/";
			log.info("flexServiceInit-->"+ "systemDir-->"+systemDir+" flexDir-->"+flexDir+"\tQuanDir"+quanDir);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String uploadFile(byte[] content, String fileName) throws Exception {
		log.info("antony start uploads 上传发布图片 "+new Date()+"fileName:"+fileName);
		String realBaseDir = systemDir+flexDir;
		File baseFile = new File(realBaseDir);
		if (!baseFile.exists()) {
			baseFile.mkdirs();
		}
		//生成目录名称
		String fileFolder = "";
		if (dirType.equalsIgnoreCase("1"))
			fileFolder = new SimpleDateFormat("yyyyMMdd")
					.format(new Date());
		if (dirType.equalsIgnoreCase("2"))
			fileFolder = new SimpleDateFormat("yyyyMM").format(new Date());

		
		String dirPath = systemDir+
				flexDir + fileFolder + "/";
		File DirFile = new File(dirPath);
		if (!DirFile.exists()) {
			DirFile.mkdirs();
		}
		
		String imgPath = dirPath+fileName;
		File file = new File(imgPath);
		log.info("\n\n antony loading uploads uploadFile "+new Date()+"imgPath:"+imgPath);
		FileOutputStream stream = new FileOutputStream(file);
		if (content != null)
			stream.write(content);
		
		
		log.info("\n\n antony loading uploads uploadFile "+new Date()+"SQLField:"+fileFolder + "/"+fileName);
		stream.close();
		return "/"+fileFolder + "/"+fileName;
		
	}
	
	public String uploadFileAct(byte[] content, String fileName) throws Exception {
		log.info("antony start uploads 上传活动图片"+new Date()+"fileName:"+fileName);
		String realBaseDir = systemDir+flexDir;
		File baseFile = new File(realBaseDir);
		if (!baseFile.exists()) {
			baseFile.mkdirs();
		}
		//生成目录名称
		String fileFolder = "";
		if (dirType.equalsIgnoreCase("1"))
			fileFolder = new SimpleDateFormat("yyyyMMdd")
					.format(new Date());
		if (dirType.equalsIgnoreCase("2"))
			fileFolder = new SimpleDateFormat("yyyyMM").format(new Date());

		
		String dirPath = systemDir+
				flexDir + fileFolder + "/";
		File DirFile = new File(dirPath);
		if (!DirFile.exists()) {
			DirFile.mkdirs();
		}
		
		String imgPath = dirPath+fileName;
		File file = new File(imgPath);
		log.info("\n\n antony loading uploads uploadFile "+new Date()+"imgPath:"+imgPath);
		FileOutputStream stream = new FileOutputStream(file);
		if (content != null)
			stream.write(content);
		
		
		log.info("\n\n antony loading uploads uploadFile "+new Date()+"SQLField:"+fileFolder + "/"+fileName);
		stream.close();
		return "/"+fileFolder + "/"+fileName;
	}
	
	public String uploadFileQuan(byte[] content, String fileName) throws Exception {
		log.info("antony start uploads 上传圈子图片 "+new Date()+"fileName:"+fileName);
		String realBaseDir = systemDir+flexDir;
		File baseFile = new File(realBaseDir);
		if (!baseFile.exists()) {
			baseFile.mkdirs();
		}
		//生成目录名称
		String fileFolder = "";
		if (dirType.equalsIgnoreCase("1"))
			fileFolder = new SimpleDateFormat("yyyyMMdd")
					.format(new Date());
		if (dirType.equalsIgnoreCase("2"))
			fileFolder = new SimpleDateFormat("yyyyMM").format(new Date());

		
		String dirPath = systemDir+
				flexDir + fileFolder + "/";
		File DirFile = new File(dirPath);
		if (!DirFile.exists()) {
			DirFile.mkdirs();
		}
		
		String imgPath = dirPath+fileName;
		File file = new File(imgPath);
		log.info("\n\n antony loading uploads uploadFile "+new Date()+"imgPath:"+imgPath);
		FileOutputStream stream = new FileOutputStream(file);
		if (content != null)
			stream.write(content);
		
		
		log.info("\n\n antony loading uploads uploadFile "+new Date()+"SQLField:"+fileFolder + "/"+fileName);
		stream.close();
		return "/"+fileFolder + "/"+fileName;
		
	}

}
