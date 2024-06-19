package servlet;

import java.io.IOException;
import java.util.ArrayList;

import bean.OrderedItem;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * 各ユーザーが自身の購入した商品情報を閲覧するための機能に関するサーブレット
 * @autnor 谷本
 */

/*
 * メモ
 * 
 * UserクラスやOrderedItemDAOクラスがまだ完成していないのでエラーが発生している。
 * 各クラスが完成次第修正する。
 * 
 * @谷本
 * 06/19/17:34
 */

@WebServlet("/orderList")
public class OrderListServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//エラーが発生した際の "エラー文" と "エラー画面からの遷移先" を保存する変数を宣言
		String error = "";
		String cmd = "";

		try {
			//セッションスコープからユーザー情報の取得
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");

			//セッション切れの確認
			if (user == null) {
				error = "セッション切れの為、購入履歴は表示出来ません。";
				cmd = "logout";
				return;
			}

			//DBから自身が購入した書籍情報を取得し、リストに格納
			OrderedItemDAO objDao = new OrderedItemDAO();
			ArrayList<OrderedItem> orderedItem_list = objDao.selectByUser(user.getUserid());

			//リクエストスコープに格納
			request.setAttribute("orderedItem_list", orderedItem_list);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、購入履歴は表示出来ません。";
			cmd = "logout";
		} finally {
			//エラーの有無で遷移先を決定
			if (error.equals("")) {
				//エラーが無い場合orderList.jspへ遷移
				request.getRequestDispatcher("/view/orderList.jsp").forward(request, response);
			} else {
				//エラーが有る場合error.jspへ遷移
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
