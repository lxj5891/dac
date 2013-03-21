package com.antony.mail.task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antonyframework.service.factory.IConnectionFactory;
import org.antonyframework.support.mail.MailBEAN;
import org.antonyframework.util.StringEncryptUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.antony.mail.bean.MailTask;

public class Sm3001MailTask extends MailTask {

	private static final Log logger = LogFactory.getLog(Sm3001MailTask.class);

	private String name = "李浩";
	private String email = "7923495@qq.com";
	private String pass = "123456";
	private String imgUrl = "http://www.ycombo.com/combo/uploads/mail/sm3001/00003.jpg";
	private String schoolName = "上海大学";
	private String UID = "20001";
	private String title = "HI 李浩  组合你想要的生活   欢迎加入YCOMBO ";
	private String text = "text";

	private String sql = "select SEQ,NAME,EMAIL,FILEPATH,UID,PASS,SCHOOL from sm3001 where id = ?";

	private PreparedStatement ps;

	private ResultSet rs;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUID() {
		return UID;
	}

	public void setUID(String uID) {
		UID = uID;
	}

	public String[] sm3001Id;

	public void setSm3001Id(String[] sm3001Id) {
		this.sm3001Id = sm3001Id;
	}

	public List<MailBEAN> getMailList() throws Exception {
		String content = "";
		Connection conn = getConnection(IConnectionFactory.DB_DEV);
		for (String sid : sm3001Id) {
			MailBEAN mail = new MailBEAN();
			ps = conn.prepareStatement(sql);
			ps.setString(1, sid);
			rs = ps.executeQuery();
			if (rs.next()) {
				String seq = rs.getString(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String imgpath = rs.getString(4);
				String uid = rs.getString(5);
				String pass = rs.getString(6);
				String school = rs.getString(7);
				setName(name);
				setEmail(email);
				setImgUrl(imgpath);
				setUID(uid);
				setPass(pass);
				setSchoolName(school);

				System.out.println("name:" + name + "email:" + email);
				mail.setSenderName("YCOMBO玩伴");
				mail.setSenderAddr("ycombo@ycombo.com");
				mail.setSubject("HI  "+ getName() +"  组合你想要的生活   欢迎加入YCOMBO");
				mail.addReceiver(getEmail() + ";");
				// mail content
				
				//恭喜您已经入驻Y!COMBO社交平台，由Y!COMBO组织的“校园社团top10”活动马上就要开始了，上传活动照片，展现独特风采，就有可能成为校园社团的前十名哦~赶快加入到校园社团Top10的争夺战中来吧
				
				content = " \n";
				content += "<P style=\"margin:10px 0 20px\"><STRONG style=\"font-size:14px\">尊敬的"
						+ getName() + "</STRONG></P>\n";
				content += "<P style=\"margin:10px 0\"> 　恭喜您已经入驻Y!COMBO社交平台，由Y!COMBO组织的“校园社团top10”活动马上就要开始了，上传活动照片，展现独特风采，就有可能成为校园社团的前十名哦~赶快加入到校园社团Top10的争夺战中来吧!</P>\n";
				content += "<P style=\"margin:10px 0\">　　<img src=\""
						+ getImgUrl() + "\"   maxwidth=\"400px\"></img></P>\n";
				
				content += "<P style=\"margin:10px 0\">　　　　同时我们很荣幸地邀请使用我们已为您建立起初始账户加入Y！COMBO成为先锋社交达人</P>\n";
				content += "<P style=\"margin:10px 0\">　　用户名：" + getEmail()
						+ "(邮箱地址)</P>\n";
				content += "<P style=\"margin:10px 0\">　　初始密码：" + getPass()
						+ "（可更改）</P>\n";
				
				
				content += "<P style=\"margin:10px 0\">　　在Y!COMBO中您账户出生地现为您自动置在"
						+ getSchoolName()
						+ "中并作为该校的时尚先锋<br>参与校园TOP10的评选，快叫上你的亲朋好友来为你投票并拔得头筹吧！</P>\n";
				content += "<P style=\"margin:10px 0\">　　祝你在Y!COMBO玩得愉快！</P>\n";
				mail.setContent(content);
				mail.setLink(true);
				String url = "combo/invent.do?UID="
						+ StringEncryptUtil.encrypt(UID);
				mail.setActionUrl(url);
				mail.setFileName("d://COMBO//Combo_FAQ.ppt");
				Map mailInfo = new HashMap();
				mailInfo.put("UID", uid);
				mail.setMailInfo(mailInfo);
				result.add(mail);
			}
		}
		return result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public int size() {
		length = result.size();
		return length;
	}

}
