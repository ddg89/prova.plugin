package model2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model2.F;
import model2.Threshold;

class Db {

	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";

	static final String DB_URL = "jdbc:mysql://localhost/plugin";
	Connection dbConnection = null;

	static final String USER = "root";
	static final String PASS = "";

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection conn = null;
		Statement stmt = null;

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
		System.out.println(FidList.toString());
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
		System.out.println(thIdList.toString());
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

	public static List<F> getFList() throws ClassNotFoundException, SQLException {
		Connection conn = Db.getConnection();
		// String sql1 = "SELECT name FROM f WHERE post=?";
		String sql1 = "SELECT name FROM f";
		PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
		// preparedStatement1.setInt(1, 56);
		ResultSet rs1 = preparedStatement1.executeQuery();
		List<F> fList = new ArrayList<F>();

		while (rs1.next()) {
			F temp = new F(rs1.getString("name"));
			fList.add(temp);

		}
		rs1.close();
		return fList;
	}
}
