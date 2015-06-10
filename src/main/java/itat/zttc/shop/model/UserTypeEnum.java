package itat.zttc.shop.model;

/**
 * since 2015/6/10.
 */
public enum UserTypeEnum {
    USER(1,"普通用户"),
    ADMIN(2, "管理员");

    private int code;
    private String desc;

    UserTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int code() {
        return this.code;
    }

    public String desc() {
        return this.desc;
    }

    public static UserTypeEnum codeOf(int c) {
        for (UserTypeEnum os : UserTypeEnum.values()) {
            if (os.code == c) {
                return os;
            }
        }
        return UserTypeEnum.USER;
    }
}
