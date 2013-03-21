package com.antony.service.sm.inf;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class SM3001Link {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private String uid;

	public SM3001Link(Connection connection) {
		// TODO Auto-generated constructor stub
		this.conn = connection;
	}

	public String getUidFromCOMBO(String email) {
		try {
			String sql = "select uid from c_user where email = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				uid = rs.getString("uid");
			} else {
				return "00000";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closePStatement(ps);
		}
		return uid;
	}

	public Map getUserInfoFromCOMBO(String email) {
		// TODO Auto-generated method stub
		String has = "select * from c_user where email = ?";
		String sql = "select u.UID,u.USERTRUENAME,u.PASSWD,p.LIMG,u.SCHOOL,s.SCHOOLNAME from c_user u,c_user_hdphoto p,m_school s where u.school = s.schoolid and u.uid = p.uid and u.email = ?";
		try {
			ps = conn.prepareStatement(has);
			ps.setString(1, email);
			System.out.println("");
			rs = ps.executeQuery();
			if (!rs.next()) {
				Map hasEmail = new HashMap();
				hasEmail.put("status", 301);
				return hasEmail;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closePStatement(ps);
		}

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				String SCHOOL = rs.getString(6);
				Map result = new HashMap();

				String UID = rs.getString(1);
				String USERTRUENAME = rs.getString(2);
				String PASSWD = rs.getString(3);
				String LIMG = rs.getString(4);

				result.put("UID", UID);
				result.put("USERTRUENAME", USERTRUENAME);
				if (PASSWD.equals("FCEA920F7412B5DA7BE0CF42B8C93759"))
					result.put("PASSWD", "1234567");
				else
					result.put("PASSWD", "保密");
				result.put("LIMG", LIMG);
				result.put("SCHOOL", SCHOOL);
				result.put("status", 200);
				return result;
			} else {
				Map result = new HashMap();
				result.put("status", 300);
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closePStatement(ps);
		}
		return null;
	}

	/**
	 * <code>ResultSet</code>를 닫는다.
	 * 
	 * @param ResultSet
	 *            rs
	 */
	protected void closeResultSet(ResultSet rs) {
		if (rs == null)
			return;
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * <code>Statement</code>를 닫는다.
	 * 
	 * @param Statement
	 *            st
	 */
	protected void closeStatement(Statement st) {
		if (st == null)
			return;
		try {
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * <code>PreparedStatement</code>를 닫는다.
	 * 
	 * @param PreparedStatement
	 *            ps
	 */
	protected void closeStatement(PreparedStatement ps) {
		if (ps == null)
			return;
		try {
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * <code>CallableStatement</code>를 닫는다.
	 * 
	 * @param CallableStatement
	 *            cs
	 */
	protected void closeStatement(CallableStatement cs) {
		if (cs == null)
			return;
		try {
			cs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * <code>PreparedStatement</code>를 닫는다.
	 * 
	 * @param PreparedStatement
	 *            ps
	 */
	protected void closePStatement(PreparedStatement ps) {
		if (ps == null)
			return;
		try {
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * <code>PreparedStatement</code>를 닫는다.
	 * 
	 * @param PreparedStatement
	 *            ps
	 */
	protected void closeCStatement(CallableStatement cs) {
		if (cs == null)
			return;
		try {
			cs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
