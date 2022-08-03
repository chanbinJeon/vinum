package vinum.user;
import static vinum.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberDAO {
	private Connection con;
	private static MemberDAO instance;
	private static String tablename = "vinummember";
	
	private MemberDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static MemberDAO getInstance() {
		if(instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public String selectLoginId(String memberId, String memberPasswd) {
		// TODO Auto-generated method stub
		//DAO ( Data Access Object)
		String loginId = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT memberId FROM "+tablename+" WHERE memberId = ? AND memberPasswd = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPasswd);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				loginId = rs.getString("memberId");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
			
		}
		return loginId;
	}
	
	public String selectExistMemberId(String memberId) {
		// TODO Auto-generated method stub
		String existId = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT memberId FROM "+tablename+" WHERE memberId = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				//���� ���ڵ尡 �ϳ��� ������...
				existId = rs.getString("memberId");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
			
		}
		return existId;
	}

	public int insertMember(MemberVO newMemberVO) {
		// TODO Auto-generated method stub
		int insertCount=0;		
		PreparedStatement pstmt = null;		
		String sql = "INSERT INTO "+tablename+" VALUES (?,?,?,?,?)";
		//String sql = "SELECT * FROM member";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,newMemberVO.getMemberId());
			pstmt.setString(2, newMemberVO.getMemberPassword());	
			pstmt.setString(3, newMemberVO.getMembernickname());
			pstmt.setString(4, newMemberVO.getMemberEmail());
			pstmt.setString(5, newMemberVO.getMemberphone());
									
			insertCount = pstmt.executeUpdate();						
		}catch  (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);			
		}
		return insertCount;
	}
		
}
