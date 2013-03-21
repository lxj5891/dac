package org.antonyframework.support.mail;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.mail.internet.InternetAddress;


public class MailBEAN implements Serializable {

	

	private final String IMAGE_URL_SERVER = "http://www.ycombo.com";
	private long id;				// 메일 id(DB 테이블에서 PK로 사용됨)
	
	private Map mailInfo;
	
	public Map getMailInfo() {
		return mailInfo;
	}

	public void setMailInfo(Map mailInfo) {
		this.mailInfo = mailInfo;
	}

	private String actionUrl;
	
	private String empno; // �޴� ��� ���

	private String senderAddr; // ������ ��� �̸��� �ּ�

	private String senderName; // ������ ��� �̸�

	private String receiverAddr; // �޴� ��� �̸��� �ּ�

	private String subject; // ����

	private String bodyTitle; // ����

	private String content; // ����

	private String sendStatus; // ��� ���� ���� FLAG

	private InternetAddress from; // �߽���(������

	private List fileList = new ArrayList(); // ÷������

	private List receiverList = new ArrayList(); // ������ ����Ʈ

	private List ccsList = new ArrayList(); // ������ ����Ʈ

	private List bccList = new ArrayList(); // ��� ������ ����Ʈ
	
	private String moveAct;
	
	private boolean link = true;

	private String ccs; 	// 받는 사람 이메일 주소
    private String bcc;     // 받는 사람 이메일 주소
	public boolean dbFlag = true;
	
    
    

	public boolean isDbFlag() {
		return dbFlag;
	}

	public void setDbFlag(boolean dbFlag) {
		this.dbFlag = dbFlag;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCcs() {
		return ccs;
	}

	public void setCcs(String ccs) {
		this.ccs = ccs;
	}

	public String getBcc() {
		return bcc;
	}

	public void setBcc(String bcc) {
		this.bcc = bcc;
	}

	public String getActionUrl() {
		return actionUrl;
	}

	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}

	/* ������ ��� �̸��� �ּ� */
	public void setSenderAddr(String senderAddr) {

		this.senderAddr = senderAddr;
	}

	public String getSenderAddr() {

		return senderAddr;
	}

	/* ������ ��� �̸� */
	public void setSenderName(String senderName) {

		this.senderName = senderName;
	}

	public String getSenderName() {

		return senderName;
	}

	/* �޴� ��� ��� */
	public void setEmpNo(String empNo) {

		this.empno = empNo;
	}

	public String getEmpNo() {

		return empno;
	}

	/* �޴� ��� �̸��� �ּ� */
	public void setReceiverAddr(String receiverAddr) {

		this.receiverAddr = receiverAddr;
	}

	public String getReceiverAddr() {

		return receiverAddr;
	}

	/* ���� */
	public void setSubject(String subject) {

		this.subject = subject;
	}

	public String getSubject() {

		return subject;
	}

	public void setBodyTitle(String bodyTitle) {

		this.bodyTitle = bodyTitle;
	}

	public String getBodyTitle() {

		return bodyTitle;
	}

	public void setContent(String content) {

		this.content = content;
	}

	public String getContent() {

		return content;
	}

	/* ÷������ */
	public void setFileName(String filename) {

		this.fileList.add(filename);
	}

	public List getFileList() {

		return fileList;
	}

	/* ��� ���� ���� FLAG */
	public void setSendStatus(String sendStatus) {

		this.sendStatus = sendStatus;
	}

	public String getSendStatus() {

		return sendStatus;
	}

	/* �߽���:schedule */
	public InternetAddress getFromAddr() {

		return from;
	}

	public void setFromAddr(String from, String name) {

		this.from = getAddress(from, name);
	}

	/* ������ ����Ʈ */
	public InternetAddress[] getReceiverList() {

		InternetAddress[] address = new InternetAddress[receiverList.size()];
		return (InternetAddress[]) receiverList.toArray(address);
	}

	public void addReceiver(String receiver) {

		if (receiver.trim() != null && !receiver.trim().equals("")) {
			StringTokenizer stk = new StringTokenizer(receiver, ";");
			String receiverTemp = null;
			if (stk.countTokens() > 1) {
				while (stk.hasMoreTokens()) {
					receiverTemp = stk.nextToken() + ";";
					addReceiver(receiverTemp, null);
				}
			}
			else {
				addReceiver(receiver, null);
			}
		}

	}

	public void addReceiver(String receiver, String name) {

		if (receiver == null || receiver.trim().equals(""))
			return;
		this.receiverList.add(getAddress(receiver, name));
	}

	/* ������ */
	public InternetAddress[] getCCSList() {

		InternetAddress[] address = new InternetAddress[ccsList.size()];
		return (InternetAddress[]) ccsList.toArray(address);
	}

	public void addCCS(String ccs) {

		if (ccs.trim() != null && !ccs.trim().equals("")) {
			StringTokenizer stk = new StringTokenizer(ccs, ";");
			String ccsTemp = null;
			if (stk.countTokens() > 1) {
				while (stk.hasMoreTokens()) {
					ccsTemp = stk.nextToken() + ";";
					addCCS(ccsTemp, null);
				}
			}
			else {
				addCCS(ccs, null);
			}
		}
	}

	public void addCCS(String ccs, String name) {

		this.ccsList.add(getAddress(ccs, name));
	}

	/* ��� ������ */
	public InternetAddress[] getBCCList() {

		InternetAddress[] address = new InternetAddress[bccList.size()];
		return (InternetAddress[]) bccList.toArray(address);
	}

	public void addBCC(String bcc) {

		if (bcc.trim() != null && !bcc.trim().equals("")) {
			StringTokenizer stk = new StringTokenizer(bcc, ";");
			String bccTemp = null;
			if (stk.countTokens() > 1) {
				while (stk.hasMoreTokens()) {
					bccTemp = stk.nextToken() + ";";
					addBCC(bccTemp, null);
				}
			}
			else {
				addBCC(bcc, null);
			}
		}
	}

	public void addBCC(String bcc, String name) {

		this.bccList.add(getAddress(bcc, name));
	}

	/* Address �� */
	private InternetAddress getAddress(String address, String name) {

		try {
			System.out.println("BEAN:formatAddress(address)" + formatAddress(address));
			return new InternetAddress(formatAddress(address), name, "utf-8");
		}
		catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e.toString());
		}
	}

	public String getMoveAct() {

		return moveAct;
	}

	public void setMoveAct(String moveAct) {

		this.moveAct = moveAct;
	}

	/* �ٷΰ��� */
	public void setLink(boolean link) {

		this.link = link;
	}

	private String formatAddress(String address) {

		//System.out.println("BEAN:address:" + address);
		if (address.indexOf("@") == -1) {
			return "skcc." + address + "@sk.com";
		}
		else {
			return address.substring(0, address.length() - 1);
		}
	}
	
    public final String getHtmlContent() {
    	StringBuffer sb = new StringBuffer();
    	sb.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
    	sb.append("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
    	sb.append("<head>\n");
    	sb.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
    	sb.append("</head>\n");
    	sb.append("<body>\n");
    	sb.append("<TABLE width=\"604\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n");
    	sb.append("<TR>\n");
    	sb.append("<TD><IMG src=\"").append(IMAGE_URL_SERVER).append("/mail/").append("ycombologo_v2.jpg\" height=\"31\"></TD>\n");
    	sb.append("</TR>\n");
    	sb.append("<TR>\n");
    	sb.append("<TD><IMG src=\"").append(IMAGE_URL_SERVER).append("/mail/").append("hdycombo.jpg\" width=\"604\" height=\"50\"></TD>\n");
        sb.append("</TR>\n");
        sb.append("<TR>\n");
        sb.append("<TD background=\"").append(IMAGE_URL_SERVER).append("/mail/").append("bgy.jpg\" style=\"background-repeat:repeat-y\">\n");
        sb.append("<DIV style=\"padding:15px 25px 25px;font-size:12px;line-height:20px;font-family:Verdana, sans-serif\">\n");
        sb.append(this.getContent());
        if (link) {
			String username = "";
			try{
				username = this.getEmpNo();
			}catch(Exception e){}
			String sActEmpEval = IMAGE_URL_SERVER + "/"+actionUrl;
			
	    	//sb.append("<center><a href=\"").append(sActEmpEval).append("\"><img src=\"").append(IMAGE_URL_SERVER).append("/images/mail/btn_quick.gif\" width=\"141\" height=\"43\" border=\"0\"></a></center>\n");
			sb.append("<center><a href=\"").append(sActEmpEval).append("\"><img src=\"http://www.ycombo.com/mail/btn.jpg\" width=\"141\" height=\"43\" border=\"0\"></a></center>\n");
		}
        sb.append("<DIV style=\"border-top:1px dotted #81A3D1;margin:50px 0;padding:5px;color:#515151\">\n");
		sb.append("	<STRONG>在此要声明<BR></STRONG>\n");
		sb.append("	· Combo·玩伴是一个非盈利性质的网站，我们的主创团队也大都是在校大学生，我们真正站在学生的一方。<BR>\n");
		sb.append("	· 在此，我们承诺不会以任何形式向与我们合作的学生组织/社团收取任何费用，现在不会，将来更不会。<BR>\n");
		sb.append("	· Combo也只有以其不商业、不做作的态度才能结交更多的伙伴，一起成长。<BR>\n");
		sb.append("	· 我们希望能通过让更多的校园新势力入驻Combo使得这块只属于年轻人的土壤更加丰饶。<BR>\n");
		sb.append("	· 希望通过自己的努力使得更多志同道合的人们聚在一起。<BR>\n");
		sb.append("	· 希望更多的学生组织/社团因为有Combo走得更好、更远。<BR>\n");
		sb.append("</DIV>\n");
		sb.append("<P style=\"margin:10px 0;text-align:left\"><STRONG> 官方网站：<a href=\"http://www.ycombo.com/\">点击进入</a></STRONG></P>\n");
		sb.append("<P style=\"margin:10px 0;text-align:left\"><STRONG> 联系我们：<a href=\"http://www.ycombo.com/combo/commons/contact.html\">点击进入</a></STRONG></P>\n");
		sb.append("<br> \n");
		sb.append("<br> \n");
		sb.append("<P style=\"margin:10px 0;text-align:right\"><STRONG> -- Y!COMBO运维中心</STRONG></P>\n");
		sb.append("</DIV>\n");
        
        sb.append("</TD>\n");
        sb.append("</TR>\n");
        sb.append("<TR>\n");
        sb.append("<TD background=\"").append(IMAGE_URL_SERVER).append("/mail/").append("bgy.jpg\" style=\"background-repeat:repeat-y\">\n");
        
        sb.append("</TD>\n");
        sb.append("</TR>\n");
        sb.append("<TR>\n");
       	sb.append("<TD><IMG src=\"").append(IMAGE_URL_SERVER).append("/mail/").append("ft.jpg\" width=\"604\" height=\"6\"></TD>\n");
       	sb.append("</TR>\n");
       	sb.append("</TABLE>\n");
		
    	sb.append("</body>");
    	sb.append("</html>");
    	return sb.toString();
    }
	
	public String toString() {

		StringBuffer result = new StringBuffer();
		result.append("[Mail Information]");
		result.append("\n\tFrom:" + from.getAddress() + "(" + from.getPersonal() + ")");
		result.append("\n\tTo:" + asString(getReceiverList()));
		result.append("\n\tCCS:" + asString(getCCSList()));
		result.append("\n\tBCC:" + asString(getBCCList()));
		result.append("\n\tSubject:" + subject);
		result.append("\n\tBody:" + content);
		return result.toString();
	}

	public String asString(InternetAddress[] addresses) {
		String result = "";
		for (int i = 0; i < addresses.length; i++) {
			result += (addresses[i].getAddress() + ";");
		}
		return result;		
	} 
}
