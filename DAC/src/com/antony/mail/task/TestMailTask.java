package com.antony.mail.task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import org.antonyframework.support.mail.MailBEAN;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.antony.mail.bean.MailTask;

public class TestMailTask extends MailTask {

	private static final Log logger = LogFactory.getLog(TestMailTask.class);

	public List getMailList() throws Exception {

		int count = 0;
		String empno = "", content = "";
		NumberFormat df = new DecimalFormat("#,##0");
		StringBuffer query = new StringBuffer();

		Connection con = null;
		PreparedStatement ps = null;
		List users = new ArrayList();
		// users.add(new HashMap().put("夏良松", "xialiangsong@ycombo.com"));
		Map user1 = new HashMap();
		user1.put("name", "夏良松");
		user1.put("email", "121668728@qq.com");
		users.add(user1);
//		
//		Map user2 = new HashMap();
//		user2.put("name", "test");
//		user2.put("email", "test@ycombo.com");
//		users.add(user2);
//		
//		
//		Map user3 = new HashMap();
//		user3.put("name", "吴熙多");
//		user3.put("email", "wuxiduo@ycombo.com");
//		users.add(user3);
//		
//		
//		Map user4 = new HashMap();
//		user4.put("name", "寻明华");
//		user4.put("email", "xunminghua@ycombo.com");
//		users.add(user4);
//		
//		
//		Map user5 = new HashMap();
//		user5.put("name", "杨昌钊");
//		user5.put("email", "yangchangzhao@ycombo.com");
//		users.add(user5);
//		
//		Map user6 = new HashMap();
//		user6.put("name", "丁开迪");
//		user6.put("email", "dingkaidi@ycombo.com");
//		users.add(user6);
//		
//		
//		Map user7 = new HashMap();
//		user7.put("name", "郑晓宇");
//		user7.put("email", "zhengxiaoyu@ycombo.com");
//		users.add(user7);
//		
//		Map user8 = new HashMap();
//		user8.put("name", "夏良松");
//		user8.put("email", "xialiangsong@ycombo.com");
//		users.add(user8);
		
		List result = new ArrayList();
		ListIterator it = users.listIterator();

		try {
			while (it.hasNext()) {
				Map next = (Map) it.next();
				String name = (String) next.get("name");
				String email = (String) next.get("email");
				System.out.println("name:" + name + "email:" + email);
				MailBEAN mail = new MailBEAN();
				mail.setSubject("[测试邮件]  欢迎使用玩伴  ");
				mail.addReceiver(email + ";");
				// mail content
				content = " \n";
				content += "<P style=\"margin:10px 0 20px\"><STRONG style=\"font-size:14px\">尊敬的"
						+ name + "</STRONG></P>\n";
				content += "<P style=\"margin:10px 0\"> 　　欢迎使用玩伴的服务。您的帐号是<STRONG style=\"color:#005590\">"
						+ email + "</STRONG>。</P>\n";
				content += "<P style=\"margin:10px 0\">　　我是李浩  我现在正在编写\"从系统发出邮件\"的接口</P>\n";
				content += "<P style=\"margin:10px 0\">　 这是一封测试邮件   @@@！！！　</P>\n";
				content += "<P style=\"margin:10px 0\">　不好意思   可能还需要发几封邮件   测试一下效率的问题</P>\n";

				content += "<P style=\"margin:10px 0\">　　 </P>\n";

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
