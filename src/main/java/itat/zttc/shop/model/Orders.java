package itat.zttc.shop.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Orders {
	private int id;
	private Date buyDate;
	private Date payDate;
	private Date confirmDate;
    private OrderStatus status = OrderStatus.NEW_ORDER;
    private User user;
	private Address address;
	private List<CartProduct> products;
	/**
	 * 所花费的价格，这个价格是可以修改的
	 */
	private BigDecimal price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Date getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<CartProduct> getProducts() {
        return products;
    }

    public void setProducts(List<CartProduct> products) {
        this.products = products;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", buyDate=" + buyDate +
                ", payDate=" + payDate +
                ", confirmDate=" + confirmDate +
                ", orderStatus=" + status.desc() +
                ", user=" + user +
                ", address=" + address +
                ", products=" + products +
                ", price=" + price +
                '}';
    }
}
