package sw.zNoUse;

import java.sql.*;

public class SelectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;

		try {
			String driver = "org.mariadb.jdbc.Driver";
			String url = "jdbc:mariadb://127.0.0.1:3306";
			String dbUser = "simpleDeveloper";
			String dbUserPWD = "1234";

			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbUser, dbUserPWD);
			
			String query = "SELECT * FROM `simpleboard`.`tb_member`";
			stmt = conn.prepareStatement(query);
			
			rset = stmt.executeQuery();
			
			while(rset.next()) {
				System.out.println("id : " + rset.getString(1));
				System.out.println("pw : " + rset.getString(2));
			}
			rset.close();
			stmt.close();
			conn.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
