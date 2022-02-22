import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class jdbc extends Calculator{
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(Systemn.in);
		
		//接続に必要なデータ
		String server = "サーバー"; //Mysqlサーバー
		String user = "ユーザー名"; //ユーザー名
		String pass = "パスワード"; //パスワード
		String db = "DB名"; //データベース名
		String url = "URL"
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from user";
		Int total = 0;
		
		//カロリー計算用のリスト
		Int foodlist[];
		
		String food = sc.next();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
// 			System.out.println("接続成功です！");
			
			pstmt = con.prepareStatement(sql);
			
// 			SQL文の実行
			rs = pstmt.executeQuery(sql);
			while(rs.next()){
				if (food.equals(rs.getString("vename"))){
					fooodlist.add(rs.getInt("calories));
					
				}
				for (int i = 0; i <= foodlist.length; i++){
					total += foodlist[i]
				}
			}
				
		}catch(SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VenderError: " + ex.getErrorCode());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
