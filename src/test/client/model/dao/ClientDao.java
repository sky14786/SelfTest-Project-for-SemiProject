package test.client.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import common.template.JDBCTemplate;
import test.client.model.vo.Client;

public class ClientDao {
	Properties prop = new Properties();

	public ClientDao() {
//		String path = this.getClass().getClassLoader().getResource("/sql/client/client-query.properties").getPath();
		String path = getClass().getResource("/").getPath() + "sql.client/client-query.properties";
		try {
			prop.load(new FileReader(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int joinClient(Connection conn, Client temp) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("joinClient");
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, temp.getId());
			pstmt.setString(2, temp.getPw());
			pstmt.setString(3, temp.getName());
			pstmt.setString(4, temp.getProfile());
			pstmt.setInt(5, temp.getUserType());

			result = pstmt.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int findClient(Connection conn, String id, String name) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("findClient");
		ResultSet rs = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = 1;
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int clientDuplicateCheck(Connection conn, String id) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("clientDuplicateCheck");
		ResultSet rs = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (!rs.next()) {
				result = 1;
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();

		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int resetPassword(Connection conn, String id, String pw) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("resetPassword");
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);

			result = pstmt.executeUpdate();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<String> allSelect(Connection conn) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("allSelect");
		ResultSet rs = null;
		ArrayList<String> temp = new ArrayList<String>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String phoneNum = rs.getString("id");
				temp.add(phoneNum);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return temp;
	}
}
