package bean;

/**
 * 取引情報を扱うDTOクラス
 * @author 谷本
 */
public class Deal {

	private int deal_id;//取引ID
	private int item_id;//出品物ID
	private int user_id;//購入者(ユーザーID)
	private int payment;//入金状況(0なら未入金、1なら入金済み)
	private int status;//発送状況(0なら未発送、1なら発送済み)
	private String day;//取引確定日時

	//コンストラクタ(引数なし)
	public Deal() {
		deal_id = 0;
		item_id = 0;
		user_id = 0;
		payment = 0;
		status = 0;
		day = null;
	}

	/*SETメソッド*/
	public void setDeal_id(int deal_id) {
		this.deal_id = deal_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setDay(String day) {
		this.day = day;
	}

	/*GETメソッド*/
	public int getDeal_id() {
		return deal_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public int getPayment() {
		return payment;
	}

	public int getStatus() {
		return status;
	}

	public String getDay() {
		return day;
	}
}
