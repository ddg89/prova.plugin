package model2;



class Db {

	/*private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";

	static final String DB_URL = "jdbc:mysql://localhost/plugin";

	static final String USER = "root";
	static final String PASS = "";

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		
		Class.forName(DRIVER_NAME);
		String dbURL1 = "jdbc:derby:codejava/webdb1;create=true";
        Connection conn1 = DriverManager.getConnection(dbURL1);
        if (conn1 != null) {
            System.out.println("Connected to database #1");
        }

		return conn;

	}

	Connection dbConnection = null;

	public Statement getStatement() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER_NAME);
		dbConnection = DriverManager.getConnection(DB_URL, USER, PASS);

		Statement stmt = dbConnection.createStatement();

		return stmt;
	}

	public void getThreshold() throws ClassNotFoundException, SQLException {
		int id = 1;
		Db db = new Db();
		Statement stmt = db.getStatement();
		Connection conn = db.getConnection();
		String sql1 = "SELECT topic FROM wikiTopics WHERE post=?";
		PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
		preparedStatement1.setInt(1, id);
		ResultSet rs1 = preparedStatement1.executeQuery();

		while (rs1.next()) {
			rs1.getString("topic");

		}
		rs1.close();
	}*/

}
