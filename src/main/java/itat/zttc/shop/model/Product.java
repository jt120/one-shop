package itat.zttc.shop.model;

import java.math.BigDecimal;

public class Product {
	private int id;
	@ValidateForm(type=ValidateType.NotNull,errorMsg="商品名称不能为空")
	private String name;
	@ValidateForm(type=ValidateType.Number,errorMsg="商品价格的格式不正确，必须是数字")
	private BigDecimal price;
	private String intro;
	private String img;
	@ValidateForm(type=ValidateType.Number,errorMsg="商品库存的格式必须是数字")
	private int stock;
    private ProductStatus status = ProductStatus.SALE;
    private Category category;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", intro='" + intro + '\'' +
                ", img='" + img + '\'' +
                ", stock=" + stock +
                ", status=" + status.desc() +
                ", category=" + category +
                '}';
    }
}
