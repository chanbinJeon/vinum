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

//	public MemberVO selectLoginMember(String id, String passwd) {
//		// TODO Auto-generated method stub
//		MemberVO loginMember =null;
//		PreparedStatement pstmt  = null;
//		ResultSet rs =null;
//		String sql = "SELECT * FROM member WHERE memberId = ? AND memberPassword = ?";
//		//String sql = "SELECT * FROM member";
//		try {
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1,id);
//			pstmt.setString(2,passwd);
//			
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				
//				loginMember =new MemberVO(); //if���� ��������
//				loginMember.setMemberAddr(rs.getString("memberAddr"));
//				loginMember.setMemberAge(rs.getInt("memberAge"));
//				loginMember.setMemberCountry(rs.getString("memberCountry"));
//				loginMember.setMemberEmail(rs.getString("memberEmail"));
//				loginMember.setMemberGender(rs.getString("memberGender"));
//				loginMember.setMemberId(rs.getString("memberId"));
//				loginMember.setMemberName(rs.getString("memberName"));
//				loginMember.setMemberTel(rs.getString("memberTel"));
//				loginMember.setMemberPassword(rs.getString("memberPassword"));
//				
//			}
//		}catch  (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//			close(rs);
//		}
//		return loginMember;
//	}
	public String selectLoginId(String memberId, String memberPasswd) {
		// TODO Auto-generated method stub
		//DAO ( Data Access Object)
		String loginId = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT memberId FROM vinummember WHERE memberId = ? AND memberPasswd = ?";

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
		String sql = "SELECT memberId FROM member WHERE memberId = ?";

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

	/*public ArrayList<ZipCodeVO> selectZipCodeList(String ro) {
		// TODO Auto-generated method stub
		
		ArrayList<ZipCodeVO> zipCodeList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM zipCodeTable WHERE ro LIKE ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,"%"+ ro+"%");
			rs = pstmt.executeQuery();

			if(rs.next()) {
				//���� ���ڵ尡 �ϳ��� ������...
				zipCodeList = new ArrayList<ZipCodeVO>();
				ZipCodeVO zipCodeVO = null;
				do {
					zipCodeVO= new ZipCodeVO();
					zipCodeVO.setBunzi(rs.getString("bunzi"));
					zipCodeVO.setDou(rs.getString("do"));
					zipCodeVO.setGu(rs.getString("gu"));
					zipCodeVO.setRo(rs.getString("ro"));
					zipCodeVO.setSi(rs.getString("si"));
					zipCodeVO.setZipCode(rs.getString("zipCode"));
					zipCodeVO.setZipCodeId(rs.getInt("zipCodeId"));
					
					zipCodeList.add(zipCodeVO);
				}while(rs.next());
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
			
		}		
		return zipCodeList;
	}*/

	public int insertMember(MemberVO newMemberVO) {
		// TODO Auto-generated method stub
		int insertCount=0;		
		PreparedStatement pstmt  = null;		
		String sql = "INSERT INTO member VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		//String sql = "SELECT * FROM member";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,newMemberVO.getMemberId());			
			pstmt.setString(2,newMemberVO.getMemberName());
			pstmt.setInt(3, newMemberVO.getMemberAge());
			pstmt.setString(4, newMemberVO.getMemberEmail());
			pstmt.setString(5, newMemberVO.getMemberAddr1());
			pstmt.setString(6, newMemberVO.getMemberAddr2());
			pstmt.setString(7, newMemberVO.getZipCode());
			pstmt.setString(8, newMemberVO.getMemberTel());
			pstmt.setString(9, newMemberVO.getMemberGender());
			pstmt.setString(10, newMemberVO.getMemberCountry());
			pstmt.setString(11, newMemberVO.getMemberPassword());
									
			insertCount = pstmt.executeUpdate();						
		}catch  (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);			
		}
		return insertCount;
	}
		
}
