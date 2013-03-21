//package com.skcc.exp.common.db.menu;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import com.skcc.exp.base.bean.ListBEAN;
//import com.skcc.exp.base.db.BaseDB;
//import com.skcc.exp.base.db.PreparedStatementSetter;
//import com.skcc.exp.common.bean.RoleBEAN;
//import com.skcc.exp.common.bean.menu.MenuBEAN;
//import com.skcc.exp.common.cmd.menu.MenuManager;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//
///**
// * @author ���ȯ
// * @date 2003. 12. 12.
// *
// * �޴��� ����� DB Ȱ���� ó���ϴ� Ŭ����
// */
//public class MenuDB extends BaseDB {
//
//	private Map roleMap = new HashMap();
//	private Map projectTypeMap = new HashMap();
//    private static final Log LOG = LogFactory.getLog(MenuDB.class);
//
//	/**
//	 * <code>Menu</code>�� ���� �ۼ���.
//	 * @param con
//	 * @param menu
//	 * @throws SQLException
//	 */
//	public void insertMenu(Connection con, MenuBEAN menu)
//	throws SQLException {
//		StringBuffer query = new StringBuffer();
//		query.append("INSERT INTO CM_MENU_MB (ID,NAME,ACTION,TYPE,STATUS,PARENT,RANK,CONTEXT,REGDATE)");
//		query.append(" VALUES(?, ?, ?, ?, ?, ?, ?,?,sysdate)");
//		
//		PreparedStatement ps = null;
//		try {
//			ps = con.prepareStatement(query.toString());
//			ps.setString(1, menu.getId());
//			ps.setString(2, menu.getName());
//			ps.setString(3, menu.getAction());
//			ps.setString(4, "N");
//			ps.setString(5, menu.getStatus());
//			ps.setString(6, menu.getParent());
//			if  (menu.getOrder().equals(" "))
//			     ps.setString(7, getMyDefaultRank(con, menu.getParent(), menu.getContext()));
//			else ps.setString(7, getMyRank(con, menu.getParent(), menu.getOrder()));
//			ps.setString(8, menu.getContext());
//
//			ps.execute();
//		}catch(Exception e){
//			LOG.error(e.getMessage(),e);
//			LOG.error("\n"+query.toString());
//			throw new SQLException(e.getMessage());
//		} finally {
//			closeStatement(ps);
//		}
//	}
//
//	/**
//	 * �޴� ������ �����Ѵ�.
//	 * @param con
//	 * @param menu
//	 * @throws SQLException
//	 */
//	public void updateMenu(Connection con, MenuBEAN menu)
//	throws SQLException {
//		StringBuffer query = new StringBuffer();
//		query.append("UPDATE CM_MENU_MB SET ID = ?, NAME = ?, ACTION = ?, TYPE = ?,");
//		query.append(      "STATUS = ?, PARENT = ?");
//		if (menu.isChangeParent() || menu.isChangeOrder())
//		    query.append(  " , RANK = ?");
//		query.append(" WHERE ID = ?");
//
//		PreparedStatement ps = null;
//		int index = 1;
//		try {
//			ps = con.prepareStatement(query.toString());
//			ps.setString(index++, menu.getId());
//			ps.setString(index++, menu.getName());
//			ps.setString(index++, menu.getAction());
//			ps.setString(index++, menu.getType());
//			ps.setString(index++, menu.getStatus());
//			ps.setString(index++, menu.getParent());
//			if (menu.isChangeParent() || menu.isChangeOrder())
//			    ps.setString(index++, getMyRank(con, menu.getParent(), menu.getOrder()));
//			ps.setString(index++, menu.getId());
//			ps.execute();
//		}
//		catch(Exception e){
//			LOG.error(e.getMessage(),e);
//			LOG.error("\n"+query.toString());
//			throw new SQLException(e.getMessage());
//		} 
//		finally {
//			closeStatement(ps);
//		}
//	}
//
//	/**
//	 * �޴��� �����Ѵ�.
//	 * @param con
//	 * @param id �޴� ID
//	 * @throws SQLException
//	 */
//	public void deleteMenu(Connection con, String id)
//	throws SQLException {
//		StringBuffer query = new StringBuffer();
//		query.append("DELETE FROM CM_MENU_MB WHERE ID = ?");
//		PreparedStatement ps = null;
//		try {
//			ps = con.prepareStatement(query.toString());
//			ps.setString(1, id);
//			ps.execute();
//		}catch(Exception e){
//			LOG.error(e.getMessage(),e);
//			LOG.error("\n"+query.toString()+"\n id=["+id+"] ");
//			throw new SQLException(e.getMessage());
//		} finally {
//			closeStatement(ps);
//		}
//	}
//
//
//	/**
//	 * �޴��� �� ������ ��ȯ�Ѵ�.
//	 * @param con
//	 * @param menuId �޴� ID
//	 * @return
//	 * @throws SQLException
//	 */
//	public MenuBEAN getMenu(Connection con, String menuId)
//	throws SQLException {
//		String QUERY_FIELD =
//			"SELECT ID, NAME, ACTION, TYPE, STATUS, PARENT, RANK, LEVEL, CONTEXT ";
//		StringBuffer query = new StringBuffer();
//		query.append(QUERY_FIELD);
//		query.append( " FROM CM_MENU_MB");
//		query.append(" WHERE ID = ?");
//		
//		//System.out.println("Menu================>"+query.toString());
//		
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			ps = con.prepareStatement(query.toString());
//			ps.setString(1, menuId);
//			rs = ps.executeQuery();
//			return rs.next() ? load(rs) : null;
//		}catch(Exception e){
//			LOG.error(e.getMessage(),e);
//			LOG.error("\n"+query.toString()+"\n menuId=["+menuId+"] ");
//			throw new SQLException(e.getMessage());
//		} finally {
//			closeResultSet(rs);
//			closeStatement(ps);
//		}
//	}
//
//	/**
//	 * �޴� ī�װ?�� �����ϴ� ���� �޴� ����Ʈ�� ��ȯ�Ѵ�.
//	 * @param con
//	 * @param categoryId �޴� ī�װ?(Admin, �ӿ�, ����, ����, ���, T&E)
//	 * @return
//	 * @throws SQLException
//	 */
//	public List getFirstMenuList(Connection con, String categoryId)
//	throws SQLException {
//		String QUERY_FIELD =
//			"SELECT ID, NAME, ACTION, TYPE, STATUS, PARENT, RANK,LEVEL,  CONTEXT";
//		StringBuffer query = new StringBuffer();
//		query.append(QUERY_FIELD);
//		query.append(" FROM CM_MENU_MB");
//		/*
//		query.append(" WHERE CONTEXT = '" + categoryId + "'");
//		query.append(" AND PARENT = 'N/A'");
//		*/
//		query.append(" WHERE PARENT = 'N/A'");
//		query.append(" ORDER BY CONTEXT,RANK");
//		
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			ps = con.prepareStatement(query.toString());
//			rs = ps.executeQuery();
//
//			List result = new ArrayList();
//			while (rs.next()) {
//				result.add(load(rs));
//			}
//			return result;
//		}catch(Exception e){
//			LOG.error(e.getMessage(),e);
//			LOG.error("\n"+query.toString()+"\n categoryId=["+categoryId+"] ");
//			throw new SQLException(e.getMessage());
//		} finally {
//			closeResultSet(rs);
//			closeStatement(ps);
//		}
//	}
//
//	/**
//	 * ���� �޴� ����Ʈ�� ��ȯ�Ѵ�.
//	 * @param con
//	 * @param firstMenuId ���� �޴� ID
//	 * @return
//	 * @throws SQLException
//	 */
//	public List getSecondMenuList(Connection con, String categoryId, int pageNo) throws SQLException {
//		/*
//		StringBuffer query = new StringBuffer();
//		query.append("SELECT ID,NAME,ACTION,TYPE,STATUS,PARENT,RANK,LEVEL,CONTEXT\n");
//		query.append(" FROM CM_MENU_MB\n");
//		query.append(" START WITH ID = '").append(categoryId).append("'\n");
//		query.append(" CONNECT BY PRIOR ID = PARENT");
//		query.append(" ORDER BY CONTEXT,RANK");
//		//System.out.println(query.toString());
//		return getDynaListBEAN(con, query.toString(), pageNo,
//						new PreparedStatementSetter() {
//							public void setPreparedStatement(PreparedStatement ps) throws SQLException {
//							}
//						}
//				   );
//				   
//		*/
//		
//		String QUERY_FIELD =
//			"SELECT ID, NAME, ACTION, TYPE, STATUS, PARENT, RANK, LEVEL, CONTEXT";
//		StringBuffer query = new StringBuffer();
//		query.append(QUERY_FIELD);
//		query.append(" FROM CM_MENU_MB");
//		query.append(" START WITH ID = ?");
//		query.append(" CONNECT BY PRIOR ID = PARENT");
//		query.append(" ORDER BY CONTEXT,RANK");
//		
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			ps = con.prepareStatement(query.toString());
//			ps.setString(1,categoryId);
//			rs = ps.executeQuery();
//			List result = new ArrayList();
//			while (rs.next()) {
//				result.add(load(rs));
//			}
//			return result;
//		}catch(Exception e){
//			LOG.error(e.getMessage(),e);
//			LOG.error("\n"+query.toString()+"\n firstMenuId=["+categoryId+"] ");
//			throw new SQLException(e.getMessage());
//		} finally {
//			closeResultSet(rs);
//			closeStatement(ps);
//		}
//		
//	}
//
//	/**
//	 * MenuManager�� �����Ѵ�.
//	 * @param con
//	 * @param MenuManager
//	 * @throws SQLException
//	 */
//	public void loadMenuManager(Connection con, MenuManager result)
//	throws SQLException {
//		String QUERY_FIELD = "SELECT ID, NAME, ACTION, TYPE, STATUS, PARENT, RANK, LEVEL, CONTEXT";
//		StringBuffer query = new StringBuffer();
//		query.append(QUERY_FIELD);
//		query.append(" FROM CM_MENU_MB");
//		query.append(" WHERE STATUS = 'Y'");
//		query.append(" START WITH PARENT = 'N/A'");
//		query.append(" CONNECT BY PRIOR ID = PARENT");
//		query.append(" ORDER BY CONTEXT,RANK");
//		
//		System.out.println("Menu query===>>>"+query);
//
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		MenuBEAN menu = null;
//		MenuBEAN parent = null;
//		HashMap menuHash = new HashMap();
//		try {
//			loadRole(con, result);
//
//			//loadProjectType(con);
//			ps = con.prepareStatement(query.toString());
//			rs = ps.executeQuery();
//
//			while (rs.next()) {
//				menu = load(rs);
//				menuHash.put(rs.getString(1), menu);
//				if (rs.getString("LEVEL").equals("1")) {
//					result.addMenu(menu);
//				} else {
//					parent = (MenuBEAN)menuHash.get(rs.getString("PARENT"));
//					parent.addChild(menu);
//				}
//			}
//		}catch(Exception e){
//			LOG.error(e.getMessage(),e);
//			LOG.error("\n"+query.toString());
//			throw new SQLException(e.getMessage());
//		} finally {
//			closeResultSet(rs);
//			closeStatement(ps);
//		}
//	}
//
//	/**
//	 * �޴��� ������ ���� ������ �ε��Ѵ�.
//	 * �޴�ID�� ���� ROLE LIST�� HashMap�� �����Ѵ�.
//	 * @param con
//	 * @throws SQLException
//	 */
//	private void loadRole(Connection con, MenuManager result)	throws SQLException {
//
//		// �޴��� ������ ���� ������ �����´�.
//		//private static final
//		String LIST_ROLE = "SELECT UNIQUE MENU_ID, ROLE_ID FROM CM_MENU_ROLE_WB ORDER BY MENU_ID, ROLE_ID";
//		String menuId = null;
//		List roles = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			ps = con.prepareStatement(LIST_ROLE);
//			rs = ps.executeQuery();
//
//			while (rs.next()) {
//				if (rs.getString(1).equals(menuId)) {
//					roles.add(getRole(rs));
//				} else {
//					menuId = rs.getString(1);
//					roles = new ArrayList();
//					roles.add(getRole(rs));
//					result.addRole(menuId, roles);
//					//roleMap.put(menuId, roles);
//				}
//			}
//		}
//		catch(Exception e){
//			LOG.error(e.getMessage(), e);
//			LOG.error("\n" + LIST_ROLE);
//			throw new SQLException(e.getMessage());
//		} 
//		finally {
//			closeResultSet(rs);
//			closeStatement(ps);
//		}
//	}
//
//	private RoleBEAN getRole(ResultSet rs) throws SQLException {
//		return RoleBEAN.getRole(rs.getString(2));
//	}
//
//	private String getProjectType(ResultSet rs) throws SQLException {
//		return rs.getString(2);
//	}
//
//	private MenuBEAN load(ResultSet rs) throws Exception {
//		MenuBEAN result = new MenuBEAN();
//		result.setId(rs.getString(1));
//		result.setName(rs.getString(2));
//		result.setAction(rs.getString(3));
//		result.setType(rs.getString(4));
//		result.setStatus(rs.getString(5));
//		result.setParent(rs.getString(6));
//		result.setRank(rs.getString(7));
//		result.setLevel(rs.getInt(8));
//		result.setContext(rs.getString(9));
//
//		result.addRoles((List) roleMap.get(result.getId()));
//		return result;
//	}
//
//	/**
//	 * Parent Menu�� �� �� �ִ� �޴� �˻�
//	 * @author YSOH
//	 * @since  2004.05.11
//	 * @param  con
//	 * @param  context   �˻������ �Ǵ� CONTEXT
//	 * @param  menuId    �˻����� ���ܵǴ� �޴����̵�(PARENT�� �����ϰ��� �ϴ� �޴����̵�)
//	 * @return PARENT�� �ɼ� �ִ� �޴� ����Ʈ
//	 * @throws SQLException
//	 */
//	public List getParentMenuList(Connection con, String context, String menuId)
//	throws SQLException {
//		String QUERY_FIELD =
//			"SELECT ID, NAME, ACTION, TYPE, STATUS, PARENT, RANK, LEVEL, CONTEXT";
//		StringBuffer query = new StringBuffer();
//		query.append(QUERY_FIELD);
//		query.append(" FROM CM_MENU_MB");
//		query.append(" WHERE CONTEXT = ?");
//		query.append("   AND LEVEL < 3");
//		query.append("   AND STATUS = 'Y'");
//		if (menuId != null) {
//			query.append("   AND ID != ?");
//			query.append("   AND PARENT != ?");
//		}
//		query.append(" START WITH PARENT = 'N/A'");
//		query.append(" CONNECT BY PRIOR ID = PARENT");
//		query.append(" ORDER BY CONTEXT,RANK");
//
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			ps = con.prepareStatement(query.toString());
//			ps.setString(1,context);
//			if (menuId != null) {
//				ps.setString(2,menuId);
//				ps.setString(3,menuId);
//			}
//			rs = ps.executeQuery();
//			List result = new ArrayList();
//			while (rs.next()) {
//				result.add(load(rs));
//			}
//			return result;
//		}catch(Exception e){
//			LOG.error(e.getMessage(),e);
//			LOG.error("\n"+query.toString());
//			throw new SQLException(e.getMessage());
//		} finally {
//			closeResultSet(rs);
//			closeStatement(ps);
//		}
//	}
//
//    /**
//     * PARENT�� ��� CHILD �޴��� �˻��Ѵ�.
//     * @author YSOH
//	 * @since  2004.05.17
//     * @param  con
//     * @param  menuId PARENT �޴����̵�
//     * @return CHILD �޴� ����Ʈ
//     * @throws SQLException
//     */
//	public List getDescendantList(Connection con, String menuId)
//	throws SQLException {
//		String QUERY_FIELD =
//			"SELECT ID, NAME, ACTION, TYPE, STATUS, PARENT, RANK, LEVEL, CONTEXT";
//		StringBuffer query = new StringBuffer();
//		query.append(QUERY_FIELD);
//		query.append(" FROM CM_MENU_MB");
//		query.append(" WHERE STATUS = 'Y'");
//		query.append(" START WITH PARENT = ?");
//		query.append(" CONNECT BY PRIOR ID = PARENT");
//		query.append(" ORDER BY CONTEXT,RANK");
//
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			ps = con.prepareStatement(query.toString());
//			ps.setString(1,menuId);
//			rs = ps.executeQuery();
//			List result = new ArrayList();
//			while (rs.next()) {
//				result.add(load(rs));
//			}
//			return result;
//		}catch(Exception e){
//			LOG.error(e.getMessage(),e);
//			LOG.error("\n"+query.toString()+"\n menuId=["+menuId+"] ");
//			throw new SQLException(e.getMessage());
//		} finally {
//			closeResultSet(rs);
//			closeStatement(ps);
//		}
//	}
//
//	/**
//     * PARENT�� CHILD �޴����� �˻��Ѵ�.
//     * @author YSOH
//	 * @since  2004.05.17
//     * @param  con
//     * @param  context �޴�CONTEXT
//     * @param  menuId  PARENT �޴����̵�
//     * @return CHILD �޴� ����Ʈ
//     * @throws SQLException
//     */
//	public List getChildList(Connection con, String context, String menuId)
//	throws SQLException {
//		String QUERY_FIELD =
//			"SELECT ID, NAME, ACTION, TYPE, STATUS, PARENT, RANK, LEVEL, CONTEXT";
//		StringBuffer query = new StringBuffer();
//		query.append(QUERY_FIELD);
//		query.append(" FROM CM_MENU_MB");
//		query.append(" WHERE STATUS = 'Y'");
//		query.append("   AND PARENT = ?");
//		query.append("   AND CONTEXT = ?");
//		query.append(" ORDER BY CONTEXT,RANK");
//
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			ps = con.prepareStatement(query.toString());
//			ps.setString(1,menuId);
//			ps.setString(2,context);
//			rs = ps.executeQuery();
//			List result = new ArrayList();
//			while (rs.next()) {
//				result.add(load(rs));
//			}
//			return result;
//		}catch(Exception e){
//			LOG.error(e.getMessage(),e);
//			LOG.error("\n"+query.toString()+"\n context=["+context+"] \n menuId=["+menuId+"]");
//			throw new SQLException(e.getMessage());
//		} finally {
//			closeResultSet(rs);
//			closeStatement(ps);
//		}
//	}
//
//
//	/**
//	 * �޴��� RANK�� �����Ѵ�. parentRank +"-" + order
//	 * @author YSOH
//	 * @since  2004.05.17
//	 * @param con
//	 * @param menuId     RANK�� ����Ǵ� �޴� ���̵�
//	 * @param parentRank PARENT �޴��� RANK
//	 * @param order      CHILD �޴���  ORDER
//	 * @throws SQLException
//	 */
//	public void updateOrderMenu(Connection con, String menuId, String parentRank, String order)
//	throws SQLException {
//		//private static final
//		String UPDATE_MENU_ORDER =
//		    "UPDATE CM_MENU_MB SET RANK = ? WHERE ID = ?";
//		PreparedStatement ps = null;
//		try {
//			ps = con.prepareStatement(UPDATE_MENU_ORDER);
//			if  (parentRank != null)
//			     ps.setString(1, parentRank + "-" + order);
//			else ps.setString(1, order);
//			ps.setString(2,menuId);
//			ps.executeUpdate();
//		}catch(Exception e){
//			LOG.error(e.getMessage(),e);
//			LOG.error("\n"+UPDATE_MENU_ORDER+"\n menuId=["+menuId+"] \n parentRank=["+parentRank+"] \n order=["+order+"]");
//			throw new SQLException(e.getMessage());
//		} finally {
//			closeStatement(ps);
//		}
//	}
//
//	/**
//	 * PARENT �޴��� RANK�� �˻��Ѵ�.
//	 * @author YSOH
//	 * @since  2004.05.17
//	 * @param parentMenuId  PARENT �޴� ���̵�
//	 * @return
//	 */
//	public String getParentRank(Connection con, String parentMenuId)
//	throws SQLException {
//		//private static final
//		String PARENT_RANK =
//		    "SELECT RANK FROM CM_MENU_MB WHERE ID = ?";
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			ps = con.prepareStatement(PARENT_RANK);
//			ps.setString(1,parentMenuId);
//			rs = ps.executeQuery();
//
//			return rs.next() == true ? rs.getString(1) : null;
//		}catch(Exception e){
//			LOG.error(e.getMessage(),e);
//			LOG.error("\n"+PARENT_RANK+"\n parentMenuId=["+parentMenuId+"] ");
//			throw new SQLException(e.getMessage());
//		} finally {
//			closeResultSet(rs);
//			closeStatement(ps);
//		}
//	}
//
//	/**
//	 * �޴����̳� �޴��� ���� PARENT�� �ٸ� PARENT�� �����Ҷ� TARGET PARENT��
//	 * ������ ORDER�� �ο��Ѵ�.
//	 * @author YSOH
//	 * @since  2004.05.17
//	 * @param  con
//	 * @param  parentMenuId  PARENT �޴� ���̵�
//	 * @param  context       �޴� CONTEXT
//	 * @return �޴��� ���ο� RANK
//	 * @throws SQLException
//	 */
//	private String getMyDefaultRank(Connection con, String parentMenuId, String context)
//	throws SQLException {
//		//private static final
//		String CHILD_COUNT =
//			"SELECT COUNT(ID) FROM CM_MENU_MB WHERE PARENT = ? AND CONTEXT = ?";
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			int order = 0;
//			String parentRank = getParentRank(con, parentMenuId);
//
//			ps = con.prepareStatement(CHILD_COUNT);
//			ps.setString(1, parentMenuId);
//			ps.setString(2, context);
//			rs = ps.executeQuery();
//			if (rs.next()) order = rs.getInt(1);
//
//			return parentRank != null ? parentRank + "-" + getTwoNumerConvert(Integer.toString(order + 1))
//			                          : getTwoNumerConvert(Integer.toString(order + 1));
//		}catch(Exception e){
//			LOG.error(e.getMessage(),e);
//			LOG.error("\n"+CHILD_COUNT+"\n parentMenuId=["+parentMenuId+"] \n context=["+context+"]");
//			throw new SQLException(e.getMessage());
//		} finally {
//			closeResultSet(rs);
//			closeStatement(ps);
//		}
//	}
//
//	/**
//	 * �޴����̳� �޴��� ���� PARENT�� �ٸ� PARENT�� �����Ҷ� TARGET PARENT��
//	 * ������ ORDER�� �����Ѵ�.
//	 * @author YSOH
//	 * @since  2004.05.17
//	 * @param  con
//	 * @param  parentMenuId  PARENT �޴� ���̵�
//	 * @param  order         ȭ�鿡�� ������ ORDER
//	 * @return �޴��� ���ο� RANK
//	 * @throws SQLException
//	 */
//	private String getMyRank(Connection con, String parentMenuId, String order)
//	throws SQLException {
//		//PreparedStatement ps = null;
//		try {
//			String parentRank = getParentRank(con, parentMenuId);
//			return parentRank != null ? parentRank + "-" + order
//									  : order;
//		}catch(Exception e){
//			LOG.error(e.getMessage(),e);
//			LOG.error(" parentMenuId=["+parentMenuId+"] \n order=["+order+"]");
//			throw new SQLException(e.getMessage());
//		} finally {
//			//closeStatement(ps);
//		}
//	}
//}
