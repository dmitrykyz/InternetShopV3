package by.pvt.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Dmitry on 10/23/2016.
 */
@Entity
@Table(name = "T_PRODUCT")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "F_PRODUCT_ID")
    @GenericGenerator(name = "increment", strategy = "increment")
    @GeneratedValue(generator = "increment")
    private Integer idProduct;

    @Column(name = "nameProduct")
    private String nameProduct;
    @Column(name = "price")
    private Double price;
    @Column(name = "status")
    private Integer status = 1; //1 - shop has this product; 0 - shop do not has this product

    @ManyToMany(mappedBy = "productList")
    private List<Order> orderList;

    public Product() {

    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return new EqualsBuilder()
                .append(nameProduct, product.nameProduct)
                .append(price, product.price)
                .append(status, product.status)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(nameProduct)
                .append(price)
                .append(status)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Product{" +
                "nameProduct='" + nameProduct + '\'' +
                ", price=" + price +
                ", status=" + status +
                '}';
    }
}