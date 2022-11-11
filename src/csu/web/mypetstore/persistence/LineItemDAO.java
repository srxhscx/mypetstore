package csu.web.mypetstore.persistence;

import csu.web.mypetstore.domain.LineItem;

import java.sql.SQLException;
import java.util.List;

public interface LineItemDAO {
    List<LineItem> getLineItemsByOrderId(int orderId) throws SQLException;

    void insertLineItem(LineItem lineItem) throws SQLException;
}
