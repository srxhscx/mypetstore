package csu.web.mypetstore.persistence.impl;

import csu.web.mypetstore.domain.Account;
import csu.web.mypetstore.domain.Consignee;
import csu.web.mypetstore.persistence.ConsigneeDAO;
import csu.web.mypetstore.persistence.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author RongXing 1360908370@qq.com
 * @version 2022/12/27 13:08
 * @ since JDK11
 */
public class ConsigneeDAOImpl implements ConsigneeDAO {
    private static final String GET_CONSIGNEE_BY_USERNAME = "SELECT id,username,firstname,lastname,add1,add2,city,state,zip,country from consignee WHERE USERNAME = ?";

    @Override
    public List<Consignee> getConsigneeByUsername(String username){
        List<Consignee> consigneeList = new ArrayList<>();
        Consignee consignee = null;
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_CONSIGNEE_BY_USERNAME);
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                consignee = resultSetToConsignee(resultSet);
                consigneeList.add(consignee);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return consigneeList;
    }

    private Consignee resultSetToConsignee(ResultSet resultSet) throws Exception{
        Consignee c = new Consignee();
        c.setId(resultSet.getInt(1));
        c.setUsername(resultSet.getString(2));
        c.setFirstName(resultSet.getString(3));
        c.setLastName(resultSet.getString(4));
        c.setAddress1(resultSet.getString(5));
        c.setAddress2(resultSet.getString(6));
        c.setCity(resultSet.getString(7));
        c.setState(resultSet.getString(8));
        c.setZip(resultSet.getString(9));
        c.setCountry(resultSet.getString(10));
        return c;
    }
}
