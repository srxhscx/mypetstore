package csu.web.mypetstore.persistence.impl;

import csu.web.mypetstore.domain.Item;
import csu.web.mypetstore.domain.Journal;
import csu.web.mypetstore.domain.LineItem;
import csu.web.mypetstore.domain.Product;
import csu.web.mypetstore.persistence.DBUtil;
import csu.web.mypetstore.persistence.LineItemDAO;
import csu.web.mypetstore.persistence.SequenceDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LineItemDAOimpl implements LineItemDAO {

    private static final String INSERT_LINEITEM = "INSERT INTO LINEITEM (ORDERID, LINENUM, ITEMID, QUANTITY, UNITPRICE)\n" +
            "    VALUES (?,?,?,?,?)";
    private static final String SELECT_LINEITEM =
            "SELECT ORDERID,LINENUM AS lineNumber,ITEMID,QUANTITY,UNITPRICE FROM LINEITEM WHERE ORDERID =?";
    public void insertLineItem(LineItem lineItem) throws SQLException {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(INSERT_LINEITEM);
        preparedStatement.setString(1,""+lineItem.getOrderId());
        preparedStatement.setString(2,""+lineItem.getLineNumber());
        preparedStatement.setString(3,lineItem.getItemId());
        preparedStatement.setString(4,""+lineItem.getQuantity());
        preparedStatement.setString(5,""+lineItem.getUnitPrice());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();

    }
    public List<LineItem> getLineItemsByOrderId(int orderId) throws SQLException {
        List<LineItem> list =new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(SELECT_LINEITEM);
        preparedStatement.setString(1,""+orderId);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            LineItem item = new LineItem();
            item.setOrderId(resultSet.getInt(1));
            item.setLineNumber(resultSet.getInt(2));
            item.setItemId(resultSet.getString(3));
            item.setQuantity(resultSet.getInt(4));
            item.setUnitPrice(resultSet.getBigDecimal(5));
            list.add(item);
        }
        resultSet.close();

        preparedStatement.close();
        connection.close();
    return list;
    }


}
