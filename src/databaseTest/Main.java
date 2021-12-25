package databaseTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:4306/info_cave";
		String uname = "root";
		String pass = "admin";
		String sql = "SELECT * FROM users WHERE user_email=? and user_password=?";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);
		PreparedStatement prst = con.prepareStatement(sql);
		prst.setString(1, "admin@gmail.com");
		prst.setString(2, "admin");
		ResultSet rs = prst.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString("user_fullName"));
		}
	}

}
