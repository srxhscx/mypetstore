package csu.web.mypetstore.action;

import java.util.List;

import csu.web.mypetstore.domain.Category;
import csu.web.mypetstore.domain.Item;
import csu.web.mypetstore.domain.Product;
import csu.web.mypetstore.service.CatalogService;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.SessionScope;
import net.sourceforge.stripes.integration.spring.SpringBean;

@SessionScope
public class CatalogActionBean extends AbstractActionBean {
    private static final long serialVersionUID = 5849523372175050635L;
    private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";
    private static final String VIEW_CATEGORY = "/WEB-INF/jsp/catalog/Category.jsp";
    private static final String VIEW_PRODUCT = "/WEB-INF/jsp/catalog/Product.jsp";
    private static final String VIEW_ITEM = "/WEB-INF/jsp/catalog/Item.jsp";
    private static final String SEARCH_PRODUCTS = "/WEB-INF/jsp/catalog/SearchProducts.jsp";
    @SpringBean
    private CatalogService catalogService;
    private String keyword;
    private String categoryId;
    private Category category;
    private List<Category> categoryList;
    private String productId;
    private Product product;
    private List<Product> productList;
    private String itemId;
    private Item item;
    private List<Item> itemList;

    public CatalogActionBean() {
    }

    public String getKeyword() {
        return this.keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getItemId() {
        return this.itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Item getItem() {
        return this.item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<Category> getCategoryList() {
        return this.categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Product> getProductList() {
        return this.productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Item> getItemList() {
        return this.itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @DefaultHandler
    public ForwardResolution viewMain() {
        return new ForwardResolution("/WEB-INF/jsp/catalog/Main.jsp");
    }

    public ForwardResolution viewCategory() {
        if (this.categoryId != null) {
            this.productList = this.catalogService.getProductListByCategory(this.categoryId);
            this.category = this.catalogService.getCategory(this.categoryId);
        }

        return new ForwardResolution("/WEB-INF/jsp/catalog/Category.jsp");
    }

    public ForwardResolution viewProduct() {
        if (this.productId != null) {
            this.itemList = this.catalogService.getItemListByProduct(this.productId);
            this.product = this.catalogService.getProduct(this.productId);
        }

        return new ForwardResolution("/WEB-INF/jsp/catalog/Product.jsp");
    }

    public ForwardResolution viewItem() {
        this.item = this.catalogService.getItem(this.itemId);
        this.product = this.item.getProduct();
        return new ForwardResolution("/WEB-INF/jsp/catalog/Item.jsp");
    }

    public ForwardResolution searchProducts() {
        if (this.keyword != null && this.keyword.length() >= 1) {
            this.productList = this.catalogService.searchProductList(this.keyword.toLowerCase());
            return new ForwardResolution("/WEB-INF/jsp/catalog/SearchProducts.jsp");
        } else {
            this.setMessage("Please enter a keyword to search for, then press the search button.");
            return new ForwardResolution("/WEB-INF/jsp/common/Error.jsp");
        }
    }

    public void clear() {
        this.keyword = null;
        this.categoryId = null;
        this.category = null;
        this.categoryList = null;
        this.productId = null;
        this.product = null;
        this.productList = null;
        this.itemId = null;
        this.item = null;
        this.itemList = null;
    }
}
