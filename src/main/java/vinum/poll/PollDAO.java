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
	private Connection con = null;
	
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
		return 0;
	}

	@Override
	public int insertPoll(PollVO pollVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePoll(PollVO pollVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePoll(PollVO pollVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void listPollquestions() {
		// TODO Auto-generated method stub

	}

	@Override
	public int insertPollquestion(PollquestionVO questionVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePollquestion(PollquestionVO questionVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePollquestion(PollquestionVO questionVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void listPollquestionchoices() {
		// TODO Auto-generated method stub

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
	public int deletePollquestionchoice(PollquestionselectVO choiceVO) {
		// TODO Auto-generated method stub
		return 0;
	}

}
