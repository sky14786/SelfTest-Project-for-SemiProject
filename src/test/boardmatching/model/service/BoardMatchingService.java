package test.boardmatching.model.service;

import java.sql.Connection;

import common.template.JDBCTemplate;
import test.boardmatching.model.dao.BoardMatchingDao;
import test.boardmatching.model.vo.BoardMatching;

public class BoardMatchingService {
	private BoardMatchingDao dao = new BoardMatchingDao();

	public int writeBoardMatching(BoardMatching bTemp) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.wrtieBoardMatching(conn, bTemp);
		if (result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;

	}

}
