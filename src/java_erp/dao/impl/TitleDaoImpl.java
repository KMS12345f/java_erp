package java_erp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java_erp.dao.TitleDao;
import java_erp.dto.Title;
import java_erp.util.JdbcUtil;

public class TitleDaoImpl implements TitleDao {
	
	private static final TitleDaoImpl instance = new TitleDaoImpl();
	
	public static TitleDaoImpl getInstance() {
		return instance;
	}
	
	private TitleDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Title> selectTitleByAll() {
		//1 쿼리문 필요
		String sql = "select tno, tname from title";
		ArrayList<Title> list = null;
		
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			list = new ArrayList<Title>();
			while(rs.next()) {
				list.add(getTitle(rs));
			}
		} catch (SQLException e) {
			System.err.println("sql 문법 오류 sql check하시오~~~");
			e.printStackTrace();
		}
		return list;
	}

	private Title getTitle(ResultSet rs) throws SQLException {
		int tNo = rs.getInt("tno");
		String tName = rs.getString("tname");
		Title title = new Title(tNo, tName);
		return new Title(tNo, tName);
	}

	@Override
	public Title selectTitleByNo(Title title) {
		String sql = "select tno, tname from title where tno = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
				pstmt.setInt(1, title.gettNO());
				try(ResultSet rs = pstmt.executeQuery()){
					if(rs.next()) {
						return getTitle(rs);
						}	
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
		return null;
	}

	@Override
	public int insertTitle(Title title) {
		String sql = "insert into title values( ?, ?)";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setInt(1, title.gettNO());
			pstmt.setString(2, title.gettName());
			System.out.println("pstmt >>> " + pstmt);
			return pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int updateTitle(Title title) {
		String sql = "update title set tname = ? where tno = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
			System.out.println("pstmt >>> " + pstmt);
			pstmt.setString(1, title.gettName());
			pstmt.setInt(2, title.gettNO());
			System.out.println("pstmt >>> " + pstmt);
			return pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteTitle(Title title) {
		String sql = "delete from title where tno = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
			
			pstmt.setInt(1, title.gettNO());
			System.out.println("pstmt >>> " + pstmt);
			return pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

}
