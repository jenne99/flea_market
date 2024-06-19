package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 取引情報に関するDAOクラス
 * @author 谷本
 */
public class DealDAO {

	//データベース接続情報
	private static String RDB_DRIVE = "org.mariadb.jdbc.Driver";
	private static String URL = "jdbc:mariadb://localhost/furima_db";
	private static String USER = "root";
	private static String PASS = "root123";

	/**
	 * @メソッド名	: getConnection
	 * @説明		: データベースにアクセスするメソッド
	 * @param		: 無し
	 * @return		: 無し
	 */
	private static Connection getConnection() {
		try {
			Class.forName(RDB_DRIVE);
			Connection con = DriverManager.getConnection(URL, USER, PASS);
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public void insert(int item_id, int user_id) {
		Connection con = null;
		Statement smt = null;

		//SQL文の設定
		String sql = "INSERT INTO deal_info VALUES(NULL," + item_id + "," + user_id + ","
				+ 0 + "," + 0 + "," + ",CURDATE())";

		/*
		//特定の日付で購入したい場合に使うSQL文の設定(主にデバッグ用)
		String day = "'2024-07-01'";
		String sql = "INSERT INTO deal_info VALUES(NULL," + item_id + "," + user_id + ","
				+ 0 + "," + 0 + "," + "," + day +")";
		*/

		try {
			//DB接続
			con = getConnection();
			smt = con.createStatement();

			//SQL文の発行
			ResultSet rs = smt.executeQuery(sql);

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			//リソースの解放
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {

				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {

				}
			}
		}
	}
}
