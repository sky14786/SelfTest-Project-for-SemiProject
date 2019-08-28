package test.driver.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;


import common.template.JDBCTemplate;
import test.driver.model.vo.Driver;

public class DriverDao {
	Properties prop = new Properties();

	public DriverDao() {
		try {
			String path=DriverDao.class.getResource("/sql/notice/notice-query.properties").getPath();
			prop.load(new FileReader(path + "../sql/"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int joinDriver(Connection conn, Driver temp) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("joinDriver");
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, temp.getId());
			pstmt.setString(2, temp.getDateOfBirth());
			pstmt.setString(3, temp.getCarType());
			pstmt.setString(4, temp.getdLicense());
			pstmt.setString(5, temp.getbLicense());
			pstmt.setString(6, temp.getCarPic());

			result = pstmt.executeUpdate();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

}
