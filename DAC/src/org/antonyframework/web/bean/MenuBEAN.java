package org.antonyframework.web.bean;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



/**
 * @author ���ȯ
 * @date 2003. 12. 12.
 *
 * �޴��� ���� ������ ������ �ִ� Ŭ����
 */
public class MenuBEAN implements Serializable {

	public static final int FIRST_LEVEL = 0;	// ���� �޴�
	public static final int SECOND_LEVEL = 1;	// ���� �޴�

	private String id;					// �޴� ID
	private String name;				// �̸�
	private String action;				// act ��
	private String type;				// ���� {N=�⺻, P=�ľ�}
	private String status;				// ���� {Y=���, N=����}
	private String parent;              //�����޴�
	private String rank;                //�޴���
	private int    level;               //�޴� depth
	private String context;             //�޴� context

	private String order;               //�Է¹��� ORDER
	private boolean parentChange;       //PARENT ���濩��
	private boolean orderChange;        //ORDER ���濩��

	private List children;				// ���� �޴� ����Ʈ (���� �޴��� ���Ե� �޴� ����Ʈ)
	private List roles;					// �ش� �޴��� ���� ���� ���� ����Ʈ

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAction() {
		return action == null
				? "N/A"
				: action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
    
    public String getDepthString() {
        String DepthString="";
        for(int i=0 ; i < this.level ; i++){
            DepthString = DepthString + "&nbsp;";
        }
        return DepthString;
    }    
    
	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	/**
	 * �޴��� ORGINAL ORDER�� ��ȯ�Ѵ�.
	 * @return
	 */
	public String getOrginOrder() {
		return rank.substring(rank.lastIndexOf("-")+1);
	}

	/**
	 * ����ڷ� ���� �Է¹��� ORDER�� �����Ѵ�.
	 * @param order
	 */
	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * ����ڷ� ���� �Է¹��� ORDER�� ��ȯ�Ѵ�.
	 * @return
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * �޴��� PARENT�� ����� ��� ���濩�θ� �����Ѵ�.
	 *
	 */
	public void setChangeParent() {
		parentChange = true;
	}

	/**
	 * �޴��� PARENT�� ����Ǿ����� TRUE�� �����Ѵ�.
	 * @return
	 */
	public boolean isChangeParent() {
		return parentChange;
	}

	/**
	 * �޴��� ORDER�� ����� ��� ���濩�θ� �����Ѵ�.
	 *
	 */
	public void setChangeOrder() {
		orderChange = true;
	}

	/**
	 * �޴��� ORDER�� ����Ǿ����� TRUE�� �����Ѵ�.
	 * @return
	 */
	public boolean isChangeOrder() {
		return orderChange;
	}

	/**
	 * �� �޴��� ���� �޴��� �߰��Ѵ�.
	 * @param child
	 */
	public void addChild(MenuBEAN child) {
		if (children == null) children = new ArrayList();
		children.add(child);
	}

	public List getChildren() {
		return children;
	}

	/**
	 * �� �޴��� ������ �� �ִ� ���� ����Ʈ�� �߰��Ѵ�.
	 * @param roles
	 */
	public void addRoles(List roles) {
		this.roles = roles;
	}

	public List getRoles() {
		return roles;
	}

	/**
	 * ����ڰ� �� �޴��� ������ �� �ִ����� üũ�Ѵ�.
	 * @param user
	 * @return
	 */
//	public boolean isAllowed(EmpBEAN user) {
//		if (children != null && children.size() > 0) {
//			for (int i = 0; i < children.size(); i++) {
//				MenuBEAN child = (MenuBEAN) children.get(i);
//				if (child.isAllowed(user))
//					return true;
//			}
//			return false;
//		}
//		return checkRole(user);
//	}

	/**
	 * ������ üũ�Ѵ�.
	 * @param user
	 * @return
	 */
//	private boolean checkRole(EmpBEAN user) {
//		return user.isUserInRole(roles);
//	}

	public boolean isHeaderMenu() {
		return "N/A".equals(parent);
	}

	public boolean hasChildMenu() {
		return children != null && children.size() > 0 ;
	}

	public String toString() {
		return "[MenuBEAN: Id=" + id +
						", Name=" + name +
						", Action=" + action +
						", Type=" + type +
						", Status=" + status +
						", Parent=" + parent +
						", Rank=" + rank +
				"]";
	}

}
