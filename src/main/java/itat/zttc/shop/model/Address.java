package itat.zttc.shop.model;

import com.google.common.base.Objects;

public class Address {
    private int id;
    @ValidateForm(type = ValidateType.NotNull, errorMsg = "地址名称不能为空")
    private String name;
    @ValidateForm(type = ValidateType.NotNull, errorMsg = "联系电话不能为空")
    private String phone;
    private String postcode;
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return this == null;
        }
        if (!(obj instanceof Address)) {
            return false;
        }
        Address a = (Address) obj;

        return Objects.equal(a.getId(), this.getId()) &&
                Objects.equal(a.getName(), this.getName()) &&
                Objects.equal(a.getPhone(), this.getPhone()) &&
                Objects.equal(a.getPostcode(), this.getPostcode());
    }

    @Override
    public String toString() {
        return "Address [id=" + id + ", name=" + name + ", phone=" + phone
                + ", postcode=" + postcode + "]";
    }
}
