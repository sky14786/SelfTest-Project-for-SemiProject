package test.boardqna.q.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import common.template.JDBCTemplate;
import test.boardqna.q.model.vo.BoardQnaQ;

public class BoardQnaQDao {
	Properties prop = new Properties();

	public BoardQnaQDao() {
		String path = getClass().getResource("/").getPath() + "sql/boardQnaQ/boardqnaq-query.properties";
		try {
			System.out.println(path);
			prop.load(new FileReader(path));

		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	public int createDummy(Connection conn, BoardQnaQ temp) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("createDummy");
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, temp.getqUser());
			pstmt.setString(2, temp.getTitle());
			pstmt.setString(3, temp.getEtc());
			pstmt.setInt(4, temp.getType());

			result = pstmt.executeUpdate();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

}
