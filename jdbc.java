import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc {
	public static void main(String args[]) {
		//接続に必要なデータ
		String server = "localhost:3307"; //Mysqlサーバー
		String user = "root"; //ユーザー名
		String pass = "Fang1373"; //パスワード
		String db = "hack_u"; //データベース名
		String url = "jdbc:mysql://" + server + "/" + db; //JDBCのURL
		
		
		
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