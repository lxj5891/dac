package org.antonyframework.web.common.menu;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antonyframework.service.common.BaseService;
import org.antonyframework.web.bean.MenuBEAN;
import org.antonyframework.web.bean.RoleBEAN;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MenuManager extends BaseService {

	private static final Log logger = LogFactory.getLog(MenuManager.class);
	private static MenuManager mm = null;

	private List headerMenus = null;
	private Map roleMap = null;
	private Map menuStrMap = null;

	private MenuManager() {
	}

	public static MenuManager getInstance() {
		if (mm == null) {
			mm = new MenuManager();
			mm.load();
		}

		return mm;
	}

	private synchronized void load() {
		Connection con = null;
		try {
			con = getConnection();
			headerMenus = new ArrayList();
			roleMap = new HashMap();
			menuStrMap = new HashMap();
			// new MenuDB().loadMenuManager(con, this);
			logger.info("[MenuManager loaded] " + this);
		} catch (Exception e) {
			logger.fatal("Cannot load Menu Manager.", e);
			throw new RuntimeException(e.toString());
		} finally {
			closeConnection(con);
		}
	}

	public static void reset() {
		MenuManager.getInstance().load();
		logger.info("[MenuManager reloaded] " + mm);
	}

	public void addMenu(MenuBEAN menu) {
		headerMenus.add(menu);
	}

	public void addRole(String menuId, List roles) {
		roleMap.put(menuId, roles);
	}

	/**
	 * ����� ����������� �����.
	 * 
	 * @param out
	 * @param user
	 */
	// public void printLoginInfo(JspWriter out, EmpBEAN user) throws
	// IOException {
	// // DBDateTimeUtil dtu = DBDateTimeUtil.getInstance();
	// // dtu.init();
	// // out.print(dtu.getLoginDateString());
	// // out.print("<B>");
	// // out.print(user.getName());
	// // out.print("</B>");
	// }

	private String getRoleMenus(String roleId) {
		StringBuffer sb = new StringBuffer();

		sb.append("<ul>");
		for (int i = 0; i < headerMenus.size(); i++) {
			MenuBEAN menu = (MenuBEAN) headerMenus.get(i);
			sb.append("\n\t<li><a action=\"");
			sb.append(menu.getAction());
			sb.append("\">");
			sb.append(menu.getName());
			sb.append("</a>");
			List subMenu = menu.getChildren();
			boolean flag = false;
			if (subMenu != null && subMenu.size() > 0) {
				for (int j = 0; j < subMenu.size(); j++) {
					MenuBEAN smenu = (MenuBEAN) subMenu.get(j);
					if (isUsed(smenu.getId(), roleId)) {
						if (!flag) {
							sb.append("\n\t\t<ul>\n");
							flag = true;
						}
						sb.append("\t\t\t<li><a action=\"");
						sb.append(smenu.getAction());
						sb.append("\">");
						sb.append(smenu.getName());
						sb.append("</a></li>\n");
					}
				}
				if (flag) {
					sb.append("\t\t</ul>\n");
				}
			}
			sb.append("\t</li>");
		}
		sb.append("\n</ul>\n");
		sb.append("<span style=\"height:3px;background-color:#2D231D;width:100%;font-size:1px\"></span>\n");

		return sb.toString();
	}

	/**
	 * ����� Ÿ��Ʋ �޴��� �����.
	 * 
	 * @param out
	 * @param user
	 */
	// public void printHeaderMenu(JspWriter out, EmpBEAN user) throws
	// IOException {
	// String role = ((RoleBEAN)user.getRoles().get(0)).getId();
	//
	// if (!menuStrMap.containsKey(role)) {
	// menuStrMap.put(role, getRoleMenus(role));
	// }
	// out.print(menuStrMap.get(role));
	// }

	private boolean isUsed(String menuid, String roleId) {
		List list = (List) roleMap.get(menuid);

		if (list == null) {
			return false;
			// ��� �ø��� false�� ����
		}

		for (int i = 0; i < list.size(); i++) {
			RoleBEAN role = (RoleBEAN) list.get(i);
			if (role.getId().trim().equals(roleId)) {
				return true;
			}
		}

		return false;
	}
}
