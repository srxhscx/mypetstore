package csu.web.mypetstore.service;

import csu.web.mypetstore.domain.Category;
import csu.web.mypetstore.domain.CategoryDTO;
import csu.web.mypetstore.domain.Item;
import csu.web.mypetstore.domain.Product;
import csu.web.mypetstore.persistence.CategoryDAO;
import csu.web.mypetstore.persistence.ItemDAO;
import csu.web.mypetstore.persistence.ProductDAO;
import csu.web.mypetstore.persistence.impl.CategoryDaoImpl;
import csu.web.mypetstore.persistence.impl.ItemDaoImpl;
import csu.web.mypetstore.persistence.impl.ProductDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class CatalogService {
    private CategoryDAO categoryDAO;
    private ItemDAO itemDAO;
    private ProductDAO productDAO;

    public CatalogService(){
        this.categoryDAO = new CategoryDaoImpl() ;
        this.itemDAO = new ItemDaoImpl();
        this.productDAO = new ProductDaoImpl();
    }
    public List<Category> getCategoryList() {
        return categoryDAO.getCategoryList();
    }

    public Category getCategory(String categoryId) {
        return categoryDAO.getCategory(categoryId);
    }

    public Product getProduct(String productId) {
        return productDAO.getProduct(productId);
    }

    public List<Product> getProductListByCategory(String categoryId) {
        return productDAO.getProductListByCategory(categoryId);
    }

    public List<CategoryDTO> getProductListByCategory1(String categoryId) {

        List<Product> productList=productDAO.getProductListByCategory(categoryId);

        List<CategoryDTO> categoryDTOList=new ArrayList<>();

        for(Product product :productList){
            String desc=product.getDescription();
            desc=desc.substring(desc.indexOf("\"")+1,desc.lastIndexOf("\""));
            CategoryDTO categoryDTO=new CategoryDTO();
            categoryDTO.setName(product.getName());
            categoryDTO.setDesc((desc));
            categoryDTO.setProductId(product.getProductId());
            categoryDTOList.add(categoryDTO);

        }

        return categoryDTOList;
    }

    // TODO enable using more than one keyword
    public List<Product> searchProductList(String keyword) {
        return productDAO.searchProductList("%" + keyword.toLowerCase() + "%");
    }

    public List<Item> getItemListByProduct(String productId) {
        return itemDAO.getItemListByProduct(productId);
    }

    public Item getItem(String itemId) {
        return itemDAO.getItem(itemId);
    }

    public boolean isItemInStock(String itemId) {
        return itemDAO.getInventoryQuantity(itemId) > 0;
    }
}
