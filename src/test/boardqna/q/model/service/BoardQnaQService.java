package test.boardqna.q.model.service;

import java.sql.Connection;

import common.template.JDBCTemplate;
import test.boardqna.q.model.dao.BoardQnaQDao;
import test.boardqna.q.model.vo.BoardQnaQ;

public class BoardQnaQService {
	private BoardQnaQDao dao = new BoardQnaQDao();

	public int createDummy(BoardQnaQ temp) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.createDummy(conn, temp);
		if (result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

}
