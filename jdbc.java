import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc {
	public static void main(String args[]) {
		//接続に必要なデータ
		String server = "サーバー"; //Mysqlサーバー
		String user = "ユーザー名"; //ユーザー名
		String pass = "パスワード"; //パスワード
		String db = "DB名"; //データベース名
		String url = "URL"
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			System.out.println("接続成功です！");
		}catch(SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VenderError: " + ex.getErrorCode());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
