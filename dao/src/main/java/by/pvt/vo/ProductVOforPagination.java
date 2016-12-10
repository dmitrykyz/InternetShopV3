package by.pvt.vo;

import by.pvt.entity.Product;

import java.util.List;

/**
 * Created by Admin on 22.11.2016.
 */
public class ProductVOforPagination {
    private Integer totalProductCount;
    private String page;
    private List<Product> productList;

    public ProductVOforPagination() {
    }

    public Integer getTotalProductCount() {
        return totalProductCount;
    }

    public void setTotalProductCount(Integer totalProductCount) {
        this.totalProductCount = totalProductCount;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
