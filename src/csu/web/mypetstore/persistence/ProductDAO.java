package csu.web.mypetstore.persistence;

import csu.web.mypetstore.domain.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> getProductListByCategory(String var1);

    Product getProduct(String var1);

    List<Product> searchProductList(String var1);
}
