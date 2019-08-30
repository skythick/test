package cn.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import cn.itcast.jdbc.JdbcUtils;
import cn.java.study.domain.Type;


public class Demo {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		ArrayList<Type> typelist=fun1();
		printlist3(typelist);
	}
	

	public static void printlist3(ArrayList<Type> typelist) {
		for (int i = 0; i < typelist.size(); i++) {
			Type tp = typelist.get(i);
			
			for (int j = 0; j < typelist.size(); j++) {
				
			}
			
		}
		
	}


	public static void printlist2(ArrayList<Type> typelist) {
		for (int i = 0; i < typelist.size(); i++) {
			Type tp = typelist.get(i);
			System.out.println(tp.getTid()+":"+tp.getTypename()+":"+ 
					tp.getParentid()+":"+tp.getRemarks());
		}
		
	}

	public  static void printlist(ArrayList<Integer> typelist) {
		for (int i = 0; i < typelist.size(); i++) {
			System.out.println(typelist.get(i));
		}
	}

	public static ArrayList<Type> fun1() throws SQLException, ClassNotFoundException{
		ArrayList<Type>  typeAllList = new ArrayList<Type>();
		Connection conn = JdbcUtils.getConnection();
		String sql = "SELECT * FROM videotype";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet reset =  pstmt.executeQuery();
		while (reset.next()){
			int id  = reset.getInt("id");
			String name = reset.getString("name");
			int parentid = reset.getInt("parentid");
			String remarks = reset.getString("remarks");
			Type type = saveToType(id,name,parentid,remarks);
			typeAllList.add(type);
		}
		conn.close();
		return typeAllList;
	}
	public static ArrayList<Integer> getAllParentid() throws ClassNotFoundException, SQLException{
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		Connection conn = JdbcUtils.getConnection();
		String sql = "SELECT DISTINCT parentid FROM videotype;";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			int parentid = rs.getInt("parentid");
			list.add(parentid);
		}
		conn.close();
		return list;
	}
	public static ArrayList<Type> getTypeByParentid(int parentid) throws SQLException{
		ArrayList<Type> typeList = new ArrayList<Type>();
		
		Connection conn = JdbcUtils.getConnection();
		String  sql=null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		if(parentid ==0){
			sql = "SELECT * FROM videotype WHERE  ISNULL(parentid)";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		}else{
			sql = "select * from videotype where parentid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, parentid);
		}
		rs = pstmt.executeQuery();
		while(rs.next()){
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int parentid1 = rs.getInt("parentid");
			String remarks = rs.getString("remarks");
			Type type = saveToType(id, name, parentid1, remarks);
			typeList.add(type);
		}
		conn.close();
		return typeList;
		
	}

	public static Type saveToType(int id, String name, int parentid1,
			String remarks) {
		Type type = new Type();
		type.setTid(id);
		type.setTypename(name);
		type.setParentid(parentid1);
		type.setRemarks(remarks);
		return type;
	}

}
