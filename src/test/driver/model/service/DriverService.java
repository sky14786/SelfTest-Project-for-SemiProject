package test.driver.model.service;

import java.sql.Connection;

import common.template.JDBCTemplate;
import test.driver.model.dao.DriverDao;
import test.driver.model.vo.Driver;

public class DriverService {
	private DriverDao dao = new DriverDao();

	public int joinDriver(Driver temp) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.joinDriver(conn, temp);

		if (result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

}
