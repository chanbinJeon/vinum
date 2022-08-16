/**
 * 
 */
package vinum.poll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author user
 *
 */
public class PollDAO implements PollDAOIF {
	
	private static String polltablename = "vinumpoll";
	private static String pollquestiontablename = "pollquestion";
	private static String pollchoicetablename = "pollchoice";
	private Connection con = null;
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	
	private PollDAO() {
		// TODO Auto-generated constructor stub
	}
	
	private static PollDAO instance;
	
	public static  PollDAO getInstance() {
		if(instance == null) {
			instance = new PollDAO();
		}
		return instance;
	}
	
	@Override
	public void listPolls() {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM "+polltablename;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public long selectPoll(long pollindex) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//PollVO pollVO = new PollVO();
		String sql = "SELECT * FROM "+polltablename+" WHERE pollindex="+pollindex;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return pollindex;
	}

	@Override
	public int insertPoll(PollVO pollVO) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int insertCount = 0;
		String polltitle = pollVO.getPolltitle();
		String pollauthor = pollVO.getPollauthor();
		String sql = "INSERT INTO "+polltablename+" (polltitle, pollauthor) VALUES (\""+polltitle+"\", \""+pollauthor+"\")";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return insertCount;
	}

	@Override
	public int updatePoll(PollVO pollVO) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int updateCount = 0;
		long pollindex = pollVO.getPollindex();
		String polltitle = pollVO.getPolltitle();
		String pollauthor = pollVO.getPollauthor();
		String sql = "UPDATE "+polltablename+" SET polltitle = \""+polltitle+"\", pollauthor = \""+pollauthor+"\" WHERE pollindex = "+pollindex;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return updateCount;
	}

	@Override
	public int deletePoll(long pollindex) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int deleteCount = 0;
		String sql = "DELETE "+polltablename+" WHERE pollindex="+pollindex;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return deleteCount;
	}

	@Override
	public void listPollquestions(long pollindex) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM "+pollquestiontablename+" WHERE pollindex="+pollindex+")";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public int insertPollquestion(PollquestionVO questionVO) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int insertcount = 0;
		String sql = "INSERT INTO "+pollquestiontablename+"(questioncontext) VALUES (\""+questionVO.getQuestioncontext()+"\") WHERE pollindex="+questionVO.getPollindex()+")";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return insertcount;
	}

	@Override
	public int updatePollquestion(PollquestionVO questionVO) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int updatecount = 0;
		String sql = "UPDATE "+pollquestiontablename+" SET questioncontext=\""+questionVO.getQuestioncontext()+"\" WHERE pollindex="+questionVO.getPollindex()+")";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return updatecount;
	}

	@Override
	public int deletePollquestion(short questionindex) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int deletecount = 0;
		String sql = "DELETE FROM "+pollquestiontablename+" WHERE "+questionindex;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return deletecount;
	}

	@Override
	public void listPollquestionchoices(long pollindex, short questionindex) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM "+pollchoicetablename;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public int insertPollquestionchoice(PollquestionselectVO choiceVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePollquestionchoice(PollquestionselectVO choiceVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePollquestionchoice(byte choiceindex) {
		// TODO Auto-generated method stub
		return 0;
	}


	public int insertPollAdmin(vinum.admin.poll.vo.PollVO pollVO) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int insertcount = 0;
		
	    
		
		String sql = "INSERT INTO pollAdmin (pollId, pollSubject, pollDesc) VALUES (poll_seq.nextval, ?, ?)";
		try {
			sql = "SELECT MAX(pollId) FROM pollAdmin";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			int pollId = 0;
			if(rs.next()) {
				pollId = rs.getInt("pollId") + 1;
			}
			else {
				pollId = 1;
			}
			
			
			
			sql = "INSERT INTO pollAdmin (pollId, pollSubject, pollDesc) VALUES (?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pollId);
			pstmt.setString(2, pollVO.getPollSubject());
			pstmt.setString(3, pollVO.getPollDesc());
			int pollAdminInsertCount  = pstmt.executeUpdate();
			
			sql = "INSERT INTO pollAdminAppend (pollId, pollQuestion, pollAnswer) VALUES (?, ?, ?)";
			pstmt.setInt(1, pollId);
			pstmt.setString(2, pollVO.getPollQuestion());
			pstmt.setString(3, pollVO.getPollAnswer());
			int pollAdminAppendInsertCount  = pstmt.executeUpdate();
			
			if(pollAdminInsertCount > 0 && pollAdminAppendInsertCount > 0) {
				insertcount = 1;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return insertcount;
	}

}
























