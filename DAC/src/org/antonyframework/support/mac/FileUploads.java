package org.antonyframework.support.mac;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploads extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileUploads() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("上传图片");
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			Iterator items;
			try {
				items = upload.parseRequest(request).iterator();
				while (items.hasNext()) {
					FileItem item = (FileItem) items.next();
					if (!item.isFormField()) {
						String name = item.getName();
						String fileName = name.substring(
								name.lastIndexOf('\\') + 1, name.length());
						String path = "D:\\COMBO\\workspace\\Antony\\WebRoot\\uploads"
								+ File.separatorChar + fileName;
						
						
						File uploaderFile = new File(path);
						item.write(uploaderFile);
						response.setContentType("text/html");
						response.setCharacterEncoding("GB2312");
						PrintWriter out = response.getWriter();

						out.print("<font size='2'>�ϴ��ļ�Ϊ:" + name + "<br>����ĵ�ַΪ"
								+ path + "</font>");

					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

}
