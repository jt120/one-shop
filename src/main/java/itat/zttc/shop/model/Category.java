package itat.zttc.shop.model;

import com.google.common.base.Objects;

public class Category {
	private int id;
	@ValidateForm(type=ValidateType.NotNull,errorMsg="类别名称不能为空 ")
	private String name;
	
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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return this == null;
        }

        if (!(obj instanceof Category)) {
            return false;
        }

        Category ca = (Category) obj;
        return Objects.equal(ca.getName(), this.getName());
    }
}
