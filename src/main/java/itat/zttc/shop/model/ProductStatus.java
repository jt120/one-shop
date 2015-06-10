package itat.zttc.shop.model;

/**
 * since 2015/6/10.
 */
public enum  ProductStatus {

    SALE(1, "卖"),
    NOT_SALE(2, "不能卖");

    private int code;
    private String desc;

    private ProductStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int code() {
        return code;
    }

    public String desc() {
        return desc;
    }

    public static ProductStatus codeOf(int c) {
        for (ProductStatus os : ProductStatus.values()) {
            if (os.code == c) {
                return os;
            }
        }
        return ProductStatus.SALE;
    }
}
