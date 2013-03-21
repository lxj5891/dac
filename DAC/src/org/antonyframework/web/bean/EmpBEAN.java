///*
// * @(#) EmpBEAN.java
// * Copyright 2002 by SK C&C. All rights reserved.
// * �� Program�� �Ϻ� �Ǵ� ��θ� SK C&C���� ���Ǿ���
// * ����, ����, �����ϴ� ������ ������ �����Ǿ� �ֽ��ϴ�.
// */
//
//package org.antonyframework.web.bean;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//
//
///**
// * ������ ����
// * @system : Common
// * @sub system :
// * @author :  Hong Y.C
// * @date : 2003/01/21
// *
// * @modifying developer :
// * @modifying date :
// * @modifying description :
// */
//public class EmpBEAN implements Serializable {
//
//
//
//	private String empNo; 						// ���
//	private String name; 						// �̸�
//	private String email; 						// �̸����ּ�
//	private String officePhone; 				// ���� ��ȭ��ȣ
//	private String cellPhone; 					// �޴���ȭ��ȣ
//	private String ssn; 						// �ֹε�Ϲ�ȣ
//	private String jikuiID; 					// �����ڵ�
//	private String jikuiName; 					// ������
//    private String sinbunCode;                  // �ź��ڵ�
//    private String sinbunName;                  // �źи�
//	private String vendorStatus; 				// ���ȸ�����(���ȸ�� �������� �ƴ��� ���� [Y] )�?�� [C]
//    private String vendorCode;                  // ���ȸ�� Code�� (��¾�ü ������ ���)
//    private String vendorName;                  // ���ȸ��� (��¾�ü ������ ���)
//	private String originOrgID;					// �� �Ҽ� �� ORG_ID
//	private String originOrgName;				// �� �Ҽ� ����
//	private String recentDate;                  // �ֱ� �α��� ����
//    private String birthSts;                    // ���� ���/���� ����
//    private String birthDay;                    // ����
//    private String currentMenuContextType="";	// ���� ���õ� �޴� ���ý�ƮŸ��
//    private String custChangePassword="";     // �?�� �н����带 �����ߴ��� ���� 
//    /**
//	 * ������ ������ ���� ���� ������ �ִ� List.
//	 * ORDER_TYPE�� �İ��� ������ ���� �η��� ��Ҽ�, �İ�,
//	 * ����, ���� ������� ������ ���Եȴ�.
//	 */
//	private List orgMapList = new ArrayList();
//
//	/**
//	 * ����ڿ��� �Ҵ�� ������Ʈ ������ ������ ������ ����Ʈ.
//	 */
//	private List generalRoles;
//
//	/**
//	 * ����ڿ��� �Ҵ�� ������Ʈ ���� ����Ʈ�� �ϳ��� ������Ʈ�� ���� ���Ѹ��� �Ҵ��.
//	 */
//	private List projectRoles;
//
//	private ProjectBEAN project;		// ����ڰ� ������ ������Ʈ ����
//
//	/**
//	 * Ŀ�´�Ƽ�� �����ִ� �Խ����� ������� �޴��� �׷��ֱ����� �޴��� ���д�
//	 * 20051017 ������
//	 */
//	private List CommunityMenuList = new ArrayList();
//	/**
//	 * Ŀ�´�Ƽ�� �����ִ� �Խ����� ������� �޴��� �׷��ֱ����� �о��� ���д�
//	 * 20051017 ������
//	 */
//	private List CommunityPathList = new ArrayList();
//
//
//
//
//	public EmpBEAN() {}
//
//	public String getEmpNo() {
//		return this.empNo;
//	}
//
//	public void setEmpNo(String empNo) {
//		this.empNo = empNo;
//	}
//
//	public String getName() {
//		return this.name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getEMail() {
//		return this.email;
//	}
//
//	public void setEMail(String email) {
//		this.email = email;
//	}
//
//	public String getOfficePhone() {
//		return this.officePhone;
//	}
//
//	public void setOfficePhone(String officePhone) {
//		this.officePhone = officePhone;
//	}
//
//	public String getCellPhone() {
//		return this.cellPhone;
//	}
//
//	public void setCellPhone(String cellPhone) {
//		this.cellPhone = cellPhone;
//	}
//
//	public String getJikuiID() {
//		return this.jikuiID;
//	}
//
//	public void setJikuiID(String jikuiID) {
//		this.jikuiID = jikuiID;
//	}
//
//	public String getJikuiName() {
//		return this.jikuiName;
//	}
//
//	public void setJikuiName(String jikuiName) {
//		this.jikuiName = jikuiName;
//	}
//
//    public String getSinbunCode() {
//        return this.sinbunCode;
//    }
//
//    public void setSinbunCode(String sinbunCode) {
//        this.sinbunCode = sinbunCode;
//    }
//
//    public String getSinbunName() {
//        return this.sinbunName;
//    }
//
//    public void setSinbunName(String sinbunName) {
//        this.sinbunName = sinbunName;
//    }
//
//    public String getBirthSts() {
//        return this.birthSts;
//    }
//
//    public void setBirthSts(String birthSts) {
//        this.birthSts = birthSts;
//    }
//
//    public String getBirthDay() {
//        return this.birthDay;
//    }
//
//    public void setBirthDay(String birthDay) {
//        this.birthDay = birthDay;
//    }
//    public String getVendorStatus() {
//        return this.vendorStatus;
//    }
//	public void setVendorStatus(String vendorStatus) {
//		this.vendorStatus = vendorStatus;
//	}
//
//    public String getVendorCode() {
//        return this.vendorCode;
//    }
//
//    public void setVendorCode(String vendorCode) {
//        this.vendorCode = vendorCode;
//    }
//
//    public String getVendorName() {
//        return this.vendorName;
//    }
//
//    public void setVendorName(String vendorName) {
//        this.vendorName = vendorName;
//    }
//
//	public String getSSN() {
//		return this.ssn;
//	}
//
//	public void setSSN(String ssn) {
//		this.ssn = ssn;
//	}
//
//	public List getOrgMapList() {
//		return orgMapList;
//	}
//
//	/**
//	 * �ֱ� �α��� ���ڸ� �����Ѵ�.
//	 * @param recentDate
//	 */
//	public void setRecentDate(String recentDate) {
//		this.recentDate = recentDate;
//	}
//
//	/**
//	 * �ֱ� �α��� ������ ��ȯ�Ѵ�.
//	 * @return
//	 */
//	public String getRecentDate() {
//		return recentDate;
//	}
//
//	/**
//	 * �޴����ؽ�Ʈ Ÿ���� �����Ѵ�
//     * 20051122 ������ �߰�
//	 * @param mainPageType
//	 */
//	public void setCurrentMenuContextType(String currentMenuContextType) {
//		this.currentMenuContextType = currentMenuContextType;
//	}
//
//	/**
//	 * �޴����ؽ�Ʈ Ÿ����  ��ȯ�Ѵ�.
//	 * 20051122 ������ �߰�
//	 * @mainPageType
//	 */
//	public String getCurrentMenuContextType() {
//		return currentMenuContextType;
//	}
//
//    /**
//     * �? ü���� �н����� ����
//     * 20060106 ������ �߰�
//     * @param mainPageType
//     */
//    public void setCustChangePassword(String custChangePassword) {
//        this.custChangePassword = custChangePassword;
//    }
//
//    /**
//     * �? ü���� �н����� ����
//     * 20060106 ������ �߰�
//     * @mainPageType
//     */
//    public boolean isCustChangePassword() {
//        if("Y".equals(custChangePassword)) return true;
//        return false;
//    }
//    
//
//
//	public List getCommunityMenuList(){
//		return this.CommunityMenuList;
//	}
//	public void setCommunityMenuList(List CommunityMenuList){
//		this.CommunityMenuList = CommunityMenuList;
//	}
//	public List getCommunityPathList(){
//		return this.CommunityPathList;
//	}
//	public void setCommunityPathList(List CommunityPathList){
//		this.CommunityPathList = CommunityPathList;
//	}
//
//
//	/**
//	 * OrgId �ڵ带 <code>List</code>�� ��Ƽ� ��ȯ��.
//	 * @return
//	 */
//	public List getOrgIdAsList() {
//		List result = new ArrayList();
//		if (orgMapList == null) return result;
//		for (int i = 0; i < orgMapList.size(); i++) {
//			result.add(((OrgMapBEAN)orgMapList.get(i)).getOrgID());
//		}
//		return result;
//	}
//
//    /**
//     * ��Ҽ�/���� ������ <code>List</code>�� ��Ƽ� ��ȯ��.
//     * 2004.11.30 ������ �߰�
//     * @return
//     */
//    public List getOROrgIdAsList() {
//        List result = new ArrayList();
//        if (orgMapList == null) return result;
//
//        dbHashtable hsOrg = new dbHashtable();
//        hsOrg.put("CODE", this.getOriginOrgID());
//        hsOrg.put("NAME", this.getOriginOrgName());
//        result.add(hsOrg);
//
//        for (int i = 0; i < orgMapList.size(); i++) {
//            OrgMapBEAN orgMap = (OrgMapBEAN) orgMapList.get(i);
//            if((orgMap.getOrderType() == null) || (orgMap.getOrderType().trim().equals("")) || (orgMap.getOrderType().trim().equals("����")))
//            {
//                if((orgMap.getPcCode()!=null) && (!orgMap.getPcCode().equals(this.getOriginPcCode())))
//                {
//                    dbHashtable hsTmp = new dbHashtable();
//                    hsTmp.put("CODE", orgMap.getOrgID());
//                    hsTmp.put("NAME", orgMap.getOrgName());
//                    result.add(hsTmp);
//                }
//            }
//        }
//        return result;
//    }
//
//    /**
//     * �Ҽ� �μ��� ProfitCenter Code�� ��ȯ���ش�.
//     * @return
//     */
//    public String getPCCode(String id) {
//        String sPC="";
//        if (orgMapList.size() == 0) return "";
//        for (int i = 0; i < orgMapList.size(); i++) {
//            OrgMapBEAN orgMap = (OrgMapBEAN) orgMapList.get(i);
//            if(orgMap.getOrgID().equals(id))
//            {
//                sPC = orgMap.getPcCode();
//                break;
//            }
//        }
//
//        return sPC;
//    }
//
//	/**
//	 * CC �ڵ带 <code>List</code>�� ��Ƽ� ��ȯ��.
// 	 * @return
// 	 */
//	public List getCcCodeAsList() {
//		List result = new ArrayList();
//		if (orgMapList == null) return result;
//		for (int i = 0; i < orgMapList.size(); i++) {
//			result.add(((OrgMapBEAN)orgMapList.get(i)).getCcCode());
//		}
//		return result;
//	}
//
//	public void setOrgMapList(List orgMapList) {
//		this.orgMapList = orgMapList;
//	}
//
//	public void addOrgMap(OrgMapBEAN orgMap) {
//		if (orgMap == null)
//			return;
//		orgMapList.add(orgMap);
//	}
//
//	/**
//	 * ������Ʈ �̿��� ������ �߰���. ����ڰ� �������̸� <b>����(101)</b>
//	 * ������ �߰��Ѵ�.
//	 * @param roles
//	 */
//	public void addRoles(List roles) {
//		generalRoles = roles;
//		if (!(isVendor() || isCustomer() )) {
//			generalRoles.add(RoleBEAN.getRole("R010", "�Ϲݻ����", "G"));
//		}
//	}
//    public List getRoles(){ 
//        return this.generalRoles;
//    }
//
//	/**
//	 * ������Ʈ ������ �߰��Ѵ�. ����ڰ� �������̸� <b>������Ʈ����(401)</b>
//	 * ������, �ƴϸ� <b>���ȸ������(402)</b> ������ �߰��Ѵ�.
//	 * �α��� �Ǵ� Project Change �ÿ� ���ȴ�.
//	 * @param roles
//	 */
//	public void addProjectRoles(List roles) {
//		this.projectRoles = roles;
//        if (!hasProcessProject()) return;
//		if (isVendor())
//        {
//            // 2004.10.04
//            // �ӽ÷� �߰�ȣ (���:100002) ����Ը� ������...
//            if(!empNo.equals("100002"))
//            {
//                projectRoles.add(RoleBEAN.getRole("409", "���ȸ������", "VEMP"));
//            }
//        } else if(isCustomer()){
//        	projectRoles.add(RoleBEAN.getRole("499", "Ŀ�´�Ƽ�?", "CUSTOMER"));
//        } else if(isConsortium()){
//        	projectRoles.add(RoleBEAN.getRole("498", "���ҽþ��η�", "CONSORTIUM"));
//		} else {
//			projectRoles.add(RoleBEAN.getRole("401", "������Ʈ����", "MEMBER"));
//		}
//	}
//
//	/**
//	 * ������Ʈ ������ �߰��Ѵ�. ����ڰ� �ϳ� �̻��� ������ ������ �ִ� ��쿡��
//	 * <b>������Ʈ����(401)</b>�Ǵ� <b>���ȸ������(409)</b> ������ �߰��Ѵ�.
//	 * @param roles
//	 */
//	public void addDefaultProjectRoles(List roles) {
//		this.projectRoles = roles;
//		if (projectRoles.size() == 0) return;
//		if (isVendor()) {
//            projectRoles.add(RoleBEAN.getRole("409", "���ȸ������", "VEMP"));
//		} else {
//			projectRoles.add(RoleBEAN.getRole("401", "������Ʈ����", "MEMBER"));
//		}
//	}
//    public List getProjectRoles(){
//        return this.projectRoles;
//    }
//	/**
//	 * ��Ҽ� �μ��� ID�� ��ȯ���ش�.
//	 * @return
//	 */
//	public String getOriginOrgID() {
//		if (this.originOrgID == null) {
//			if (orgMapList.size() == 0)
//				return null;
//			OrgMapBEAN orgMap = (OrgMapBEAN) orgMapList.get(0);
//			this.originOrgID = orgMap.getOrgID();
//		}
//		return this.originOrgID;
//	}
//
//    public void setOriginOrgID(String originOrgID){
//        this.originOrgID =originOrgID ;
//    }
//
//	/**
//	 * ��Ҽ� �μ����� ��ȯ���ش�.
//	 * @return
//	 */
//	public String getOriginOrgName() {
//		if (this.originOrgName == null) {
//			if (orgMapList.size() == 0)
//				return null;
//			OrgMapBEAN orgMap = (OrgMapBEAN) orgMapList.get(0);
//			this.originOrgName = orgMap.getOrgName();
//		}
//		return this.originOrgName;
//	}
//
//    public void setOriginOrgName(String originOrgName){
//        this.originOrgName =originOrgName ;
//    }
//
//
//	/**
//	 * ��Ҽ� �μ��� ProfitCenter Code�� ��ȯ���ش�.
//	 * @return
//	 */
//	public String getOriginPcCode() {
//		if (orgMapList.size() == 0)
//			return null;
//		OrgMapBEAN orgMap = (OrgMapBEAN) orgMapList.get(0);
//		return orgMap.getPcCode();
//	}
//
//	/**
//	 * ��Ҽ� �μ��� ProfitCenter���� ��ȯ���ش�.
//	 * @return
//	 */
//	public String getOriginPcName() {
//		if (orgMapList.size() == 0)
//			return null;
//		OrgMapBEAN orgMap = (OrgMapBEAN) orgMapList.get(0);
//		return orgMap.getPcName();
//	}
//
//	public String getOriginJikcheakID() {
//		if (orgMapList.size() == 0)
//			return null;
//		OrgMapBEAN orgMap = (OrgMapBEAN) orgMapList.get(0);
//		return orgMap.getJikcheakID();
//	}
//
//	public String getJikcheakName() {
//		if (orgMapList.size() == 0)
//			return null;
//		OrgMapBEAN orgMap = (OrgMapBEAN) orgMapList.get(0);
//		return orgMap.getJikcheakName();
//	}
//
//	/**
//	 * �İ� �μ� ID�� ��ȯ���ش�.
//	 * @return
//	 */
//	public String getDispatchOrgID() {
//		if (orgMapList.size() == 0)
//			return null;
//		for (int i = 0; i < orgMapList.size(); i++) {
//			OrgMapBEAN orgMap = (OrgMapBEAN) orgMapList.get(i);
//			if (orgMap.getOrderType() != null
//				&& orgMap.getOrderType().trim().equals("�İ�"))
//				return orgMap.getOrgID();
//		}
//		return null;
//	}
//
//	/**
//	 * �İߺμ����� ��ȯ���ش�.
//	 * @return
//	 */
//	public String getDispatchOrgName() {
//		if (orgMapList.size() == 0)
//			return null;
//		for (int i = 0; i < orgMapList.size(); i++) {
//			OrgMapBEAN orgMap = (OrgMapBEAN) orgMapList.get(i);
//			if (orgMap.getOrderType() != null
//				&& orgMap.getOrderType().trim().equals("�İ�"))
//				return orgMap.getOrgName();
//		}
//		return null;
//	}
//
//	/**
//	 * �İ� �μ��� ProfitCenter Code�� ��ȯ���ش�.
//	 * @return
//	 */
//	public String getDispatchPcCode() {
//		if (orgMapList.size() == 0)
//			return null;
//		for (int i = 0; i < orgMapList.size(); i++) {
//			OrgMapBEAN orgMap = (OrgMapBEAN) orgMapList.get(i);
//			if (orgMap.getOrderType() != null
//				&& orgMap.getOrderType().trim().equals("�İ�"))
//				return orgMap.getPcCode();
//		}
//		return null;
//	}
//
//	/**
//	 * �İ� �μ��� ProfitCenter���� ��ȯ���ش�.
//	 * @return
//	 */
//	public String getDispatchPcName() {
//		if (orgMapList.size() == 0)
//			return null;
//		for (int i = 0; i < orgMapList.size(); i++) {
//			OrgMapBEAN orgMap = (OrgMapBEAN) orgMapList.get(i);
//			if (orgMap.getOrderType() != null
//				&& orgMap.getOrderType().trim().equals("�İ�"))
//				return orgMap.getPcName();
//		}
//		return null;
//	}
//	/**
//	 * ������� �Ҽ� �ι� ������ ������ �´�.
//	 * ������ ������ �ִ��� üũ�Ѵ�.
//	 * @return
//	 */
//	public String getPorgID2() {
//		if (orgMapList.size() == 0) return null;
//		OrgMapBEAN orgMap = (OrgMapBEAN) orgMapList.get(0);
//		return orgMap.getPorgID2();
//	}
//
//	/**
//	 * ������� �Ҽ� �ι����� ������ �´�.
//	 * ������ ������ �ִ��� üũ�Ѵ�.
//	 * @return
//	 */
//	public String getPorgName2(){
//		if (orgMapList.size() == 0) return null;
//		OrgMapBEAN orgMap = (OrgMapBEAN) orgMapList.get(0);
//		return orgMap.getPorgName2();
//	}
//
//	/**
//	 * ������� �Ҽ� ���� ������ ������ �´�.
//	 * ������ ������ �ִ��� üũ�Ѵ�.
//	 * @return
//	 */
//	public String getPorgID3() {
//		if (orgMapList.size() == 0) return null;
//		OrgMapBEAN orgMap = (OrgMapBEAN) orgMapList.get(0);
//		return orgMap.getPorgID3();
//	}
//
//	/**
//	 * ������� �Ҽ� ���θ��� ������ �´�.
//	 * ������ ������ �ִ��� üũ�Ѵ�.
//	 * @return
//	 */
//	public String getPorgName3(){
//		if (orgMapList.size() == 0) return null;
//		OrgMapBEAN orgMap = (OrgMapBEAN) orgMapList.get(0);
//		return orgMap.getPorgName3();
//	}
//
//	/**
//	 * ����ڰ� ����(103), �������(104), ������(105), ��ǥ�̻�(106) ����
//	 * ������ ������ �ִ��� üũ�Ѵ�.
//	 * @return
//	 */
//	public boolean isManager() {
//		return isUserInRole("103") ||
//			   isUserInRole("104") ||
//			   isUserInRole("105") ||
//			   isUserInRole("106");
//	}
//	/**
//	 * ����ڰ�
//     * My Project ����(308)
//     * ����Admin����(309)
//     * ����������(327)   <== (X)
//     * TE Admin ����(330)
//     * OS AM ���� ����(339)
//	 * 	���� ������ ������ �ִ��� üũ�Ѵ�.
//	 *
//	 * @author najongwon
//	 * @since 20050708
//	 * @return boolean
//	 */
//	public boolean isAdmin() {
//		return isUserInRole("308") ||
//			   isUserInRole("309") ||
//			   isUserInRole("330") ||
//			   isUserInRole("339");
//	}
//	/**
//	 * ����ڰ� �ӿ�(�������(104), ������(105), ��ǥ�̻�(106)) ����
//	 * ������ ������ �ִ��� üũ�Ѵ�.
//	 * @return
//	 */
//	public boolean isExecutive() {
//		return isUserInRole("104") ||
//			   isUserInRole("105") ||
//			   isUserInRole("106");
//	}
//
//	/**
//	 * ����ڰ� �ش� ���Ѹ���Ʈ �߿� �ϳ� �̻��� ������
//	 * �ִ����� üũ�Ѵ�.
//	 * @param roles ���� ����Ʈ (RoleBEAN)
//	 * @return
//	 */
//	public boolean isUserInRole(List roles) {
//		if (roles == null) return false;
//		for (int i = 0; i < roles.size(); i++) {
//			RoleBEAN role = (RoleBEAN) roles.get(i);
//			if (isUserInRole(role))
//				return true;
//		}
//		return false;
//	}
//
//	/**
//	 * ����ڰ� �ش� ���� ID�� ���� ������ ������ �ִ�����
//	 * üũ�Ѵ�.
//	 * @param roleId ���� ID �Ǵ� �ɺ�
//	 * @return
//	 */
//	public boolean isUserInRole(String roleId) {
//		for (int i = 0; generalRoles != null && i < generalRoles.size(); i++) {
//			RoleBEAN role = (RoleBEAN) generalRoles.get(i);
//			if (role.equals(roleId))
//				return true;
//		}
//		for (int i = 0; projectRoles != null && i < projectRoles.size(); i++) {
//			RoleBEAN role = (RoleBEAN) projectRoles.get(i);
//			if (role.equals(roleId))
//				return true;
//		}
//		return false;
//	}
//
//	/**
//	 * ����ڰ� ������ ������ �ִ����� üũ�Ѵ�.
//	 * @param object RoleBEAN
//	 * @return
//	 */
//	public boolean isUserInRole(RoleBEAN object) {
//
//		for (int i = 0; generalRoles != null && i < generalRoles.size(); i++) {
//			RoleBEAN role = (RoleBEAN) generalRoles.get(i);
//			if (role.equals(object))
//				return true;
//		}
//		for (int i = 0; projectRoles != null && i < projectRoles.size(); i++) {
//			RoleBEAN role = (RoleBEAN) projectRoles.get(i);
//			if (role.equals(object))
//				return true;
//		}
//		return false;
//	}
//
//    /**
//     * ����ڰ� 1�� �̻��� ������ ������ �ִ����� üũ�Ѵ�.
//     * @return
//     */
//    public boolean isUserInRole() {
//        if((generalRoles!=null)&&(generalRoles.size()>0)) return true;
//        if((projectRoles!=null)&&(projectRoles.size()>0)) return true;
//        return false;
//    }
//
//    /*
//     *  2004.09.03 ������ ���� (private => public)
//     */
//	public boolean isVendor() {
//		return "Y".equals(vendorStatus);
//	}
//    /*
//     *  2005.09.21 ������ �߰� (�? ����)
//     *  2006.04.20 ������ �߰� (���ҽþ� �η� ����)
//     */
//    public boolean isCustomer() {
//        return "C".equals(vendorStatus);
//    }
//    /*
//     *  2006.04.20 ������ �߰� (���ҽþ� �η� ����)
//     */
//    public boolean isConsortium() {
//        return "X".equals(vendorStatus);
//    }
//	/**
//	 * ����ڰ� ������Ʈ�� ������ �ִ����� üũ�Ѵ�.
//	 * @return
//	 */
//	public boolean hasProject() {
//		return project != null;
//	}
//
//	/**
//	 * ������� ���õ� ������Ʈ Ŀ�´�Ƽ�� ���ٱ����ִ� �Խ��� ������ ��ȯ�Ѵ�.
//	 * @return
//	 */
//	public boolean hasProjectBoard() {
//		return hasProcessProject() && project.hasProjectBoard();
//	}
//
//	public void setHasProjectBoard(boolean hasProjectBoard){
//		if(hasProcessProject()){
//			project.setHasProjectBoard(hasProjectBoard);
//		}
//	}
//	/**
//	 * ������� ���õ� ������Ʈ Ŀ�´�Ƽ�� ���ٱ��� ���θ� ��ȯ�Ѵ�.
//	 * @return
//	 */
//	public boolean isActiveProjectCommunity() {
//		return hasProcessProject() && project.isActiveProjectCommunity();
//	}
//
//	public void setIsActiveProjectCommunity(boolean isActiveProjectCommunity){
//		if(hasProcessProject()){
//			project.setIsActiveProjectCommunity(isActiveProjectCommunity);
//		}
//	}
//
//	public ProjectBEAN getProject() {
//		return project;
//	}
//
//	public void setProject(ProjectBEAN project) {
//		this.project = project;
//	}
//
//	/**
//	 * ����ڰ� ���� ������Ʈ�� ������ �ִ����� üũ�Ѵ�.
//	 * @return
//	 */
//	public boolean hasProcessProject() {
//		return hasProject() && project.isProcessProject();
//
//	}
//
//	public String toString() {
//		String result =
//			   "[EmpBEAN: {EmpNo=" + empNo +
//					   ", Name=" + name +
//					   ", Email=" + email +
//					   ", Office Phone=" + officePhone +
//					   ", Cell Phone=" + cellPhone +
//					   ", SSN=" + ssn +
//                       ", jikuiID=" + jikuiID +
//                       ", Position=" + jikuiName +
//                       ", sinbunCode=" + sinbunCode +
//                       ", Sinbun=" + sinbunName +
//                       ", vendorStatus=" + vendorStatus +
//                       ", vendorCode=" + vendorCode +
//                       ", vendorName=" + vendorName +
//                       ", originOrgID=" + originOrgID +
//                       ", originOrgName=" + originOrgName +
//                       ", recentDate=" + recentDate +
//                       ", birthSts=" + birthSts +
//                       ", birthDay=" + birthDay +
//                       ", currentMenuContextType=" + currentMenuContextType +
//                       ", custChangePassword=" + custChangePassword +
//					   ", PC Code="+ (getDispatchPcCode()==null ? getOriginPcCode() : getDispatchPcCode()) +
//			   "}]<br><br>";
//		result += "[Organizations= {" + orgMapList + "]<br><br>";
//		result += "[General Roles= {" + generalRoles + "]<br><br>";
//		if (hasProject()) {
//			result +=
//			  "[ProjectBEAN: {Number=" + project.getNumber() +
//			  			  ", Name=" + project.getName() +
//			  			  ", Type=" + project.getType() +
//                          ", isActiveProjectCommunity=" + project.isActiveProjectCommunity() +
//			  			  ", hasProjectBoard=" + project.hasProjectBoard() +
//			  			  "}]<br><br>";
//			result += "[Project Roles= {" + projectRoles + "]<br><br>";
//		}
//		if (hasProcessProject()) {
//			result +=
//			  "[ProjectINFO: " + project.getProjectInfo() +
//			  "]<br><br>";
//		}
//		return result;
//	}
//
//}
