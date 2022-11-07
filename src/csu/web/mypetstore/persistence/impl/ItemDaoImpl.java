package csu.web.mypetstore.persistence.impl;

import csu.web.mypetstore.domain.Item;
import csu.web.mypetstore.persistence.ItemDAO;

import java.util.List;
import java.util.Map;

public class ItemDaoImpl implements ItemDAO {

    private static final String UPDATE_INVENTORY_QUANTITY =
            "UPDATE INVENTORY SET QTY = QTY - ? WHERE ITEMID = ?";

    private static final String GET_INVENTORY_QUANTITY  =
            "SELECT QTY AS value FROM INVENTORY WHERE ITEMID = ?";

    private static final String GET_ITEM_LIST_BY_PRODUCT =
            "SELECT I.ITEMID, LISTPRICE, UNITCOST, SUPPLIER AS supplierId, I.PRODUCTID AS \"product.productId\", NAME AS \"product.name\", DESCN AS \"product.description\", CATEGORY AS \"product.categoryId\",STATUS, ATTR1 AS attribute1, ATTR2 AS attribute2, ATTR3 AS attribute3, ATTR4 AS attribute4, ATTR5 AS attribute5 FROM ITEM I, PRODUCT PWHERE P.PRODUCTID = I.PRODUCTID AND I.PRODUCTID = ?";

    @Override
    public void updateInventoryQuantity(Map<String, Object> var1) {

    }

    @Override
    public int getInventoryQuantity(String var1) {
        return 0;
    }

    @Override
    public List<Item> getItemListByProduct(String var1) {
        return null;
    }

    @Override
    public Item getItem(String var1) {
        return null;
    }
}
