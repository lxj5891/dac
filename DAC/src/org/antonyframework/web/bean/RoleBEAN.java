/*
 * @(#) RoleBEAN.java
 * Copyright 2002 by SK C&C. All rights reserved.
 * �� Program�� �Ϻ� �Ǵ� ��θ� SK C&C���� ���Ǿ��� 
 * ����, ����, �����ϴ� ������ ������ �����Ǿ� �ֽ��ϴ�.
 */

package org.antonyframework.web.bean;

import java.io.Serializable;

/**
 * ������ ���� ���� ������ ��Ÿ���� Ŭ������ ���� ��� �̿ܿ�����
 * ������� �ʴ� ���� �⺻���� �Ѵ�.
 * 
 * @system : ����
 * @sub system :  
 * @author :  ���ȯ
 * @date : 2003/12/15
 * 
 * @modifying developer : 
 * @modifying date : 
 * @modifying description : 
 */

public class RoleBEAN implements Serializable {

	private String id; 				// ���� ID
	private String name;			// ���� ��
	private String symbol;			// ���� �ɺ�
	private String admin_status;			// ���� ���� ����
	private String status;			// ���� (Y = ���, N = ����)

	/**
	 * ���� ID�� ���� ��ü�� ��ȯ�ϴ� Factory Method
	 * @param id ���� ID
	 * @return
	 */
	public static RoleBEAN getRole(String id) {
		return getRole(id, null, null);
	}

	/**
	 * ���� ID, ���Ѹ�, �ɺ� ������ ��ü�� ��ȯ�ϴ� Factory Method
	 * @param id ���� ID
	 * @param name ���� ��
	 * @param symbol �ɺ�
	 * @return
	 */
	public static RoleBEAN getRole(String id,
								   String name,
								   String symbol) {
		return new RoleBEAN(id, name, symbol);
	}
	
	/**
	 * ��ü ���� ��� �����ͷ� ���� ��ü�� ��ȯ�ϴ� Factory Method
	 * �� ȭ�鿡�� ����.
	 * @param id ���� ID
	 * @param name ���� ��
	 * @param symbol �ɺ�
	 * @param admin status ����
	 * @param status ����
	 * @return
	 */
	public static RoleBEAN getRole(String id, String name,
								   String symbol, String admin_status,
								   String status)
	{
		RoleBEAN result = getRole(id);
		result.name = name;
		result.symbol = symbol;
		result.admin_status = admin_status;
		result.status = status;
		return result;
	}
	
	private RoleBEAN(String id, String name, String symbol) {
		this.id = id;
		this.name = name;
		this.symbol = symbol;
	}

	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getSymbol() {
		return symbol;
	}

	public String getAdminStatus() {
		return admin_status;
	}

	public String getStatus() {
		return status;
	}

	public boolean equals(Object object) {
		return object instanceof RoleBEAN
				? equals((RoleBEAN)object)
				: false;
	}

	/**
	 * ���� ID�� �̿��Ͽ� �� ������ ���� ���� ����.
	 * @param role
	 * @return
	 */
	public boolean equals(RoleBEAN role) {
		if (role == null) return false;
		return (id.equals(role.getId()));
	}

	/**
	 * ���� ID�� �ɺ��� �̿��Ͽ� �� ������ ���� ���� ����.
	 * ������ ���� ����� JSP���� �ɺ��� �̿��Ͽ� ���� �� ó����
	 * �ϴ� �κ��� ����.
	 * @param roleId ���� ID �Ǵ� �ɺ�
	 * @return
	 */
	public boolean equals(String roleId) {
		if (roleId == null) return false;
		return roleId.equals(id) || roleId.equals(symbol);
	}

	public String toString() {
		return name + "(" + id + ", " + symbol + ")";
	}

}