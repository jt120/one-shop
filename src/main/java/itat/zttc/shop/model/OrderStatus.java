package itat.zttc.shop.model;

/**
 * 四种状态:1表示已下订单、2表示已付款、3、表示已发货、4、表示确认收货
 */
public enum  OrderStatus {

    NEW_ORDER(1,"已下订单"),
    PAY(2, "已付款"),
    SEND(3, "已发货"),
    RECEIVE(4, "确认收货");

    private int code;
    private String desc;

    private OrderStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int code() {
        return code;
    }

    public String desc() {
        return desc;
    }

    public static OrderStatus codeOf(int c) {
        for (OrderStatus os : OrderStatus.values()) {
            if (os.code == c) {
                return os;
            }
        }
        return OrderStatus.NEW_ORDER;
    }
}
