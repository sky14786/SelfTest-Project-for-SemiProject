package test.boardmatching.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import common.template.JDBCTemplate;
import test.boardmatching.model.vo.BoardMatching;

public class BoardMatchingDao {
	Properties prop = new Properties();

	public BoardMatchingDao() {
		String path = getClass().getResource("/").getPath() + "sql.boardMatching/boardMatching-query.properties";
		try {
			prop.load(new FileReader(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int wrtieBoardMatching(Connection conn, BoardMatching bTemp) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("writeBoardMatching");
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bTemp.getWrtier());
			pstmt.setString(2, bTemp.getTitle());
			pstmt.setString(3, bTemp.getStartAddr());
			pstmt.setString(4, bTemp.getEndAddr());
			pstmt.setString(5, bTemp.getEtc());
			pstmt.setInt(6, bTemp.getCarTypeNo());

			result = pstmt.executeUpdate();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

}
