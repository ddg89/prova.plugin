package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.F;
import model.Threshold;

class Db {
	
	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";

	static final String DB_URL = "jdbc:mysql://localhost/plugin";
	Connection dbConnection = null;

	static final String USER = "root";
	static final String PASS = "";
	public Db(){
		
	}
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection conn = null;

		Class.forName(DRIVER_NAME);
		// System.out.println("Connecting to a selected database...");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		// System.out.println("Connected database successfully...");

		return conn;

	}

	public Statement getStatement() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER_NAME);
		dbConnection = DriverManager.getConnection(DB_URL, USER, PASS);

		Statement stmt = dbConnection.createStatement();

		return stmt;
	}

	public static List<Threshold> getThresholdList(String fName) throws ClassNotFoundException, SQLException {
		Connection conn = Db.getConnection();
		String sql = "SELECT id FROM f WHERE name=?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, fName);
		ResultSet rs = preparedStatement.executeQuery();
		List<Integer> FidList = new ArrayList<Integer>();
		while (rs.next()) {
			FidList.add(rs.getInt("id"));
		}
		List<Integer> thIdList = new ArrayList<Integer>();
		for (Integer id : FidList) {
			String sql2 = "SELECT * FROM f_thresholds WHERE f_id=?";
			PreparedStatement preparedStatement2 = conn.prepareStatement(sql2);
			preparedStatement2.setInt(1, id);
			ResultSet rs2 = preparedStatement2.executeQuery();
			while (rs2.next()) {
				thIdList.add(rs2.getInt(2));
			}

		}
		List<Threshold> thresholdList = new ArrayList<Threshold>();
		for (Integer id : thIdList) {
			String sql1 = "SELECT name FROM thresholds WHERE id=?";
			PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
			preparedStatement1.setInt(1, id);
			ResultSet rs1 = preparedStatement1.executeQuery();
			while (rs1.next()) {
				Threshold temp = new Threshold(rs1.getString(1));

				thresholdList.add(temp);

			}
			rs1.close();
		}
		return thresholdList;
	}
	public static List<String> getDo(String contextName) throws ClassNotFoundException, SQLException {
		Connection conn = Db.getConnection();
		String sql = "SELECT id FROM context WHERE name=?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, contextName);
		ResultSet rs = preparedStatement.executeQuery();
		List<Integer> contextIdList = new ArrayList<Integer>();
		while (rs.next()) {
			contextIdList.add(rs.getInt("id"));
		}
		List<Integer> DoIdList = new ArrayList<Integer>();
		for (Integer id : contextIdList) {
			String sql2 = "SELECT * FROM do_context WHERE context_id=?";
			PreparedStatement preparedStatement2 = conn.prepareStatement(sql2);
			preparedStatement2.setInt(1, id);
			ResultSet rs2 = preparedStatement2.executeQuery();
			while (rs2.next()) {
				DoIdList.add(rs2.getInt(2));
			}

		}
		List<String> doNameList = new ArrayList<String>();
		for (Integer id : DoIdList) {
			String sql1 = "SELECT name FROM do WHERE id=?";
			PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
			preparedStatement1.setInt(1, id);
			ResultSet rs1 = preparedStatement1.executeQuery();
			
			while (rs1.next()) {
				doNameList.add(rs1.getString(1));
				
			}
			rs1.close();
		}
		return doNameList;
	}
	public static List<F> getFListToCompare(String fName) throws ClassNotFoundException, SQLException{
		Connection conn = Db.getConnection();
		String sql = "SELECT id FROM f WHERE name=?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, fName);
		ResultSet rs = preparedStatement.executeQuery();
		List<Integer> FidList = new ArrayList<Integer>();
		while (rs.next()) {
			FidList.add(rs.getInt("id"));
		}
		List<Integer> fToCompIdList = new ArrayList<Integer>();
		for (Integer id : FidList) {
			String sql2 = "SELECT * FROM f_f WHERE f_id=?";
			PreparedStatement preparedStatement2 = conn.prepareStatement(sql2);
			preparedStatement2.setInt(1, id);
			ResultSet rs2 = preparedStatement2.executeQuery();
			while (rs2.next()) {
				fToCompIdList.add(rs2.getInt(2));
			}

		}
		List<F> fList = new ArrayList<F>();
		for (Integer id : fToCompIdList) {
			String sql1 = "SELECT * FROM f WHERE id=?";
			PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
			preparedStatement1.setInt(1, id);
			ResultSet rs1 = preparedStatement1.executeQuery();
			while (rs1.next()) {
				F f;
				String name =rs1.getString(2);
				String card = rs1.getString(4);
				if(card.toLowerCase().equals("unary")){
					f=new Fbool(name,card);
				}else{
					f = new Fint(name,card);
				}
				fList.add(f);

			}
			rs1.close();
		}
		return fList;
	}
	public static List<F> getFList() throws ClassNotFoundException, SQLException {
		Connection conn = Db.getConnection();
		// String sql1 = "SELECT name FROM f WHERE post=?";
		String sql1 = "SELECT * FROM f";
		PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
		// preparedStatement1.setInt(1, 56);
		ResultSet rs1 = preparedStatement1.executeQuery();
		List<F> fList = new ArrayList<F>();

		while (rs1.next()) {
			
			F f;
			String name =rs1.getString(2);
			String card = rs1.getString(4);
			if(card.toLowerCase().equals("unary")){
				f=new Fbool(name,card);
			}else{
				f = new Fint(name,card);
			}
			fList.add(f);
		}
		rs1.close();
		return fList;
	}
	public Connection getDbConnection() {
		return dbConnection;
	}
	public void setDbConnection(Connection dbConnection) {
		this.dbConnection = dbConnection;
	}
	public static String getDriverName() {
		return DRIVER_NAME;
	}
	public static String getDbUrl() {
		return DB_URL;
	}
	public static String getUser() {
		return USER;
	}
	public static String getPass() {
		return PASS;
	}
}
