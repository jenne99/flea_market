package bean;

/**
 * 購入商品情報を扱うDTOクラス
 * @author 菅田
 */
public class OrderedItem {
    // フィールド変数定義
    private String userid; // ユーザID
    private String itemName; // アイテムの名前
    private String date; // 購入日付

    // コンストラクタ定義(初期化処理)
    public OrderedItem() {
        this.userid = null;
        this.itemName = null;
        this.date = null;
    }

    // 各フィールド変数のGetメソッド定義
    public String getUserid() {
        return userid;
    }

    public String getitemName() {
        return itemName;
    }

    public String getDate() {
        return date;
    }

    // 各フィールド変数のSetメソッド定義
    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setitemName(String itemName) {
        this.itemName = itemName;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
