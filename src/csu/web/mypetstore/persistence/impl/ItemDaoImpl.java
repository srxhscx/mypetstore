package csu.web.mypetstore.persistence.impl;

import csu.web.mypetstore.domain.Item;
import csu.web.mypetstore.domain.Product;
import csu.web.mypetstore.persistence.DBUtil;
import csu.web.mypetstore.persistence.ItemDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ItemDaoImpl implements ItemDAO {

    private static final String GET_ITEM_LIST_BY_PRODUCT = "SELECT I.ITEMID,LISTPRICE,UNITCOST,SUPPLIER AS supplierId," +
            "I.PRODUCTID AS \"product.productId\",NAME AS \"product.name\",DESCN AS \"product.description\",CATEGORY AS \"product.categoryId\"," +
            "STATUS,ATTR1 AS attribute1,ATTR2 AS attribute2,ATTR3 AS attribute3,ATTR4 AS attribute4,ATTR4 AS attribute5 FROM ITEM I, PRODUCT P " +
            "WHERE P.PRODUCTID = I.PRODUCTID AND I.PRODUCTID = ?";

    private static final String GET_ITEM = "select" +
            "      I.ITEMID," +
            "      LISTPRICE," +
            "      UNITCOST," +
            "      SUPPLIER AS supplierId," +
            "      I.PRODUCTID AS \"product.productId\"," +
            "      NAME AS \"product.name\"," +
            "      DESCN AS \"product.description\"," +
            "      CATEGORY AS \"product.categoryId\"," +
            "      STATUS," +
            "      ATTR1 AS attribute1," +
            "      ATTR2 AS attribute2," +
            "      ATTR3 AS attribute3," +
            "      ATTR4 AS attribute4," +
            "      ATTR5 AS attribute5," +
            "      QTY AS quantity" +
            "    from ITEM I, INVENTORY V, PRODUCT P" +
            "    where P.PRODUCTID = I.PRODUCTID" +
            "      and I.ITEMID = V.ITEMID" +
            "      and I.ITEMID = ?";

    private static final String UPDATE_INVENTORY_QUANTITY = "UPDATE INVENTORY SET QTY = QTY - ? WHERE ITEMID = ?";

    private static final String GET_INVENTORY_QUANTITY = "SELECT QTY AS value FROM INVENTORY WHERE ITEMID = ?";

    @Override
    public void updateInventoryQuantity(Map<String, Object> param) {
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_INVENTORY_QUANTITY);
            String itemId = param.keySet().iterator().next();
            String increment =(String) param.get(itemId);
            preparedStatement.setString(1,increment);
            preparedStatement.setString(2,itemId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getInventoryQuantity(String itemId) {
        int result = -1;
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_INVENTORY_QUANTITY);
            preparedStatement.setString(1,itemId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                result = resultSet.getInt(1);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> getItemListByProduct(String productId) {
        List<Item> itemList = new ArrayList<>();
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ITEM_LIST_BY_PRODUCT);
            preparedStatement.setString(1,productId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Item item = new Item();
                item.setItemId(resultSet.getString(1));
                item.setListPrice(resultSet.getBigDecimal(2));
                item.setUnitCost(resultSet.getBigDecimal(3));
                item.setSupplierId(resultSet.getInt(4));
                Product product = new Product();
                product.setProductId(resultSet.getString(5));
                product.setName(resultSet.getString(6));
                product.setDescription(resultSet.getString(7));
                product.setCategoryId(resultSet.getString(8));
                item.setProduct(product);
                item.setStatus(resultSet.getString(9));
                item.setAttribute1(resultSet.getString(10));
                item.setAttribute2(resultSet.getString(11));
                item.setAttribute3(resultSet.getString(12));
                item.setAttribute4(resultSet.getString(13));
                item.setAttribute5(resultSet.getString(14));
                itemList.add(item);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return itemList;
    }

    @Override
    public Item getItem(String itemId) {
        Item item = null;
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ITEM);
            preparedStatement.setString(1,itemId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                item = new Item();
                item.setItemId(resultSet.getString(1));
                item.setListPrice(resultSet.getBigDecimal(2));
                item.setUnitCost(resultSet.getBigDecimal(3));
                item.setSupplierId(resultSet.getInt(4));
                Product product = new Product();
                product.setProductId(resultSet.getString(5));
                product.setName(resultSet.getString(6));
                product.setDescription(resultSet.getString(7));
                product.setCategoryId(resultSet.getString(8));
                item.setProduct(product);
                item.setStatus(resultSet.getString(9));
                item.setAttribute1(resultSet.getString(10));
                item.setAttribute2(resultSet.getString(11));
                item.setAttribute3(resultSet.getString(12));
                item.setAttribute4(resultSet.getString(13));
                item.setAttribute5(resultSet.getString(14));
                item.setQuantity(resultSet.getInt(15));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return item;
    }
}
