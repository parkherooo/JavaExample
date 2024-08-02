package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

//테이블+Mgr
public class MemberMgr {
	private DBConnectionMgr pool;
	
	public MemberMgr() {
		//싱글톤 패턴
		pool = DBConnectionMgr.getInstance();
	}
	//저장 : insert, post
	public boolean insertMember(MemberBean bean) {
		Connection con = null;
		PreparedStatement pstmt =null;
		String sql = null;
		boolean flag =false;
		try {
			con = pool.getConnection();
			sql = "insert tblmember values (null,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,bean.getName());
			pstmt.setString(2,bean.getPhone());
			pstmt.setString(3,bean.getAddress());
			pstmt.setString(4,bean.getTeam());
			//DML : insert, update, delete ->excuteUpdate 
			int cnt = pstmt.executeUpdate(); 
			if(cnt ==1)
				flag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con,pstmt);
		}
		return flag;
	}
	//리스트
	public Vector<MemberBean> listMember(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<MemberBean>vlist = new Vector<MemberBean>();
		try {
			con = pool.getConnection();
			sql = "select * from tblmember";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) { 
				MemberBean bean = new MemberBean();
				bean.setNum(rs.getInt(1)); //1은 첫번째 컬럼
				bean.setName(rs.getString(2));
				bean.setPhone(rs.getString(3));
				bean.setAddress(rs.getString(4));
				bean.setTeam(rs.getString(5));
				vlist.addElement(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
	//레코드 한개 : select (db1)
	public MemberBean getMember(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		MemberBean bean = new MemberBean();
		try {
			con = pool.getConnection();
			sql = "select * from tblmember where num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) { //2개 이상의 레코드는 절대 리턴되지않음
				bean.setNum(rs.getInt(1)); //1은 첫번째 컬럼
				bean.setName(rs.getString(2));
				bean.setPhone(rs.getString(3));
				bean.setAddress(rs.getString(4));
				bean.setTeam(rs.getString(5));
			}	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
	
	//수정 : update (db2)
	public boolean updateMembe(MemberBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "update  tblmember set name = ?, phone = ?, address = ?, team = ? where num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,bean.getName());
			pstmt.setString(2,bean.getPhone());
			pstmt.setString(3,bean.getAddress());
			pstmt.setString(4,bean.getTeam());
			pstmt.setInt(5, bean.getNum());
			if(pstmt.executeUpdate()==1) flag =true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	//삭제 delete (db2)
	public boolean deleteMember(int num) {
			Connection con = null;
			PreparedStatement pstmt = null;
			String sql = null;
			boolean flag = false;
			try {
				con = pool.getConnection();
				sql = "delete from tblmember where num = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, num);
				if(pstmt.executeUpdate()==1) flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt);
			}
			return flag;
	}
	//팀 이름 리스트(중복제거)
	public Vector<String> getTeamList(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<String> vlist = new Vector<String>();
		try {
			con = pool.getConnection();
			sql = "select distinct team from tblmember";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vlist.addElement(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
	//우편번호 검색
 	public Vector<ZipcodeBean> searchZipcode(String area3){
		//java.sql
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null; //테이블 스키마와 레코드 리턴
		String sql = null;
		Vector<ZipcodeBean> vlist = new Vector<ZipcodeBean>();
		try {
			//pool에서 Connection 빌려옴.
			con = pool.getConnection();
			sql = "select *from tblzipcode where area3 like ?";
			pstmt = con.prepareStatement(sql);
			//area3 like '%광평로%'
			pstmt.setString(1, "%"+area3+"%"); //1은 첫번째 물음표로 향함
			rs =pstmt.executeQuery(); //select 는 Query
			//결과로 받은 데이터에 커서는 첫번째 레코드 위에 있음
			while (rs.next()) { 
				ZipcodeBean bean = new ZipcodeBean();
				bean.setZipcode(rs.getString("zipcode"));
				bean.setArea1(rs.getString("area1"));
				bean.setArea2(rs.getString("area2"));
				bean.setArea3(rs.getString("area3"));
				//bean 을 Vector 저장
				vlist.addElement(bean);
			}
			//System.out.println("리턴 레코드 갯수 : " + vlist.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//con은 반납하고 pstmt, rs 는c close	
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
		}
	public static void main(String[] args) {
		MemberMgr mgr = new MemberMgr();
		//mgr.searchZipcode("광평로");
		MemberBean bean = new MemberBean();
		bean.setName("이재훈");
		bean.setPhone("010-5555-2323");
		bean.setAddress("부산시 연제구");
		bean.setTeam("동의대");
		boolean result = mgr.insertMember(bean);
		System.out.println(result);
		
	}
}
