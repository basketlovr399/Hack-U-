import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class jdbc extends Calculator{
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		//接続に必要なデータ
		String server = "サーバー"; //Mysqlサーバー
		String user = "ユーザー名"; //ユーザー名
		String pass = "パスワード"; //パスワード
		String db = "DB名"; //データベース名
		String url = "URL"
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Int total = 0;
		
		//カロリー計算用のリスト
		Int foodlist[];
		
		//食べ物リスト
		String foods[];
		
		try {
			do{
				System.out.print('食べ物か数値を入力してください');
				Object food = sc.next();
				
				if (food instanceof String){
					String sql = "select * from user where vename = " + food;

					//接続
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(url, user, pass);


					pstmt = con.prepareStatement(sql);

					 //SQL文の実行
					rs = pstmt.executeQuery(sql);
					rs.next();

					//値を取得
					Int food_calories = rs.getInt('calories');
					String food_name = rs.getString('vename');

					//リストに追加
					foodlist.add(food_calories);
					foods.add(food_name);

					//0以外はループ終了
					System.out.print('合計を出力しますか？');
					total = sc.nextInt();	
				}else{
					//入力で変数の中身が値の時はその値以下の食べ物を表示
					String sql = "select * from user where calories = " + food;

					//接続
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(url, user, pass);


					pstmt = con.prepareStatement(sql);

					 //SQL文の実行
					rs = pstmt.executeQuery(sql);
					
					while(rs.next()){
						Int food_calories = rs.getInt('calories');
						if(cal <= food){
							
							String food_name = rs.getString('vename');

							//リストに追加
							foodlist.add(food_calories);
							foods.add(food_name);
						}
					}

					
			}while(total == 0);
			
			//抽象クラスのメソッドを呼び出す
			Calculator calc = new Calculator();
			
			//表示
			System.out.print(calc.sum_calories(foodlist));
			calc.show_food(foods);
				
				
		}catch(SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VenderError: " + ex.getErrorCode());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
