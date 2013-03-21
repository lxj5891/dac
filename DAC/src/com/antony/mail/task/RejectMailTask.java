package com.antony.mail.task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.antonyframework.support.mail.MailBEAN;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.antony.mail.bean.MailTask;

public class RejectMailTask extends MailTask {

	private static final Log logger = LogFactory.getLog(RejectMailTask.class);

	private String title = "[测试邮件]";
	private String text = "text";

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

	public List getMailList() throws Exception {

		String empno = "", content = "";
		NumberFormat df = new DecimalFormat("#,##0");
		StringBuffer query = new StringBuffer();

		Connection con = null;
		PreparedStatement ps = null;
		con = getConnection(0);
		String sql = "select * from cm_email_test where id = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		List users = new ArrayList();
		while (rs.next()) {
			String name = rs.getString(2);
			String email = rs.getString(3);
			Map user1 = new HashMap();
			user1.put("name", name);
			user1.put("email", email);
			users.add(user1);

		}

		List result = new ArrayList();
		ListIterator it = users.listIterator();
		try {
			while (it.hasNext()) {
				MailBEAN mail = new MailBEAN();
				Map next = (Map) it.next();
				String name = (String) next.get("name");
				String email = (String) next.get("email");
				System.out.println("name:" + name + "email:" + email);
				mail.setSenderName("YCOMBO玩伴");
				mail.setSenderAddr("ycombo@ycombo.com");
				mail.setSubject(title);
				mail.addReceiver(email + ";");
				// mail content
				content = " \n";
				content += "<P style=\"margin:10px 0 20px\"><STRONG style=\"font-size:14px\">尊敬的"
						+ name + "</STRONG></P>\n";
				content += "<P style=\"margin:10px 0\"> 　　欢迎使用玩伴的服务。您的帐号是<STRONG style=\"color:#005590\">"
						+ email + "</STRONG>。</P>\n";
				content += "<P style=\"margin:10px 0\">　　我是李浩  我现在正在编写\"从系统发出邮件\"的接口</P>\n";
				content += "<P style=\"margin:10px 0\">　　" + text + "</P>\n";
				mail.setContent(content);
				mail.setLink(true);
				mail.setActionUrl("combo/index.do");
				result.add(mail);
			}
		} catch (Exception e) {
			logger.info(this.getClass().getName() + " Exception : "
					+ e.getMessage());
			throw e;
		} finally {
			closeStatement(ps);
			closeConnection(con);
		}

		return result;
	}
}
