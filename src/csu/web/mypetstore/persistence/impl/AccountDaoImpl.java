package csu.web.mypetstore.persistence.impl;

import csu.web.mypetstore.domain.Account;
import csu.web.mypetstore.persistence.AccountDAO;
import csu.web.mypetstore.persistence.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDaoImpl implements AccountDAO {

    private static final String GET_ACOUNT_BY_USERNME =
            "SELECT\n" +
                    "          SIGNON.USERNAME,\n" +
                    "          ACCOUNT.EMAIL,\n" +
                    "          ACCOUNT.FIRSTNAME,\n" +
                    "          ACCOUNT.LASTNAME,\n" +
                    "          ACCOUNT.STATUS,\n" +
                    "          ACCOUNT.ADDR1 AS address1,\n" +
                    "          ACCOUNT.ADDR2 AS address2,\n" +
                    "          ACCOUNT.CITY,\n" +
                    "          ACCOUNT.STATE,\n" +
                    "          ACCOUNT.ZIP,\n" +
                    "          ACCOUNT.COUNTRY,\n" +
                    "          ACCOUNT.PHONE,\n" +
                    "          PROFILE.LANGPREF AS languagePreference,\n" +
                    "          PROFILE.FAVCATEGORY AS favouriteCategoryId,\n" +
                    "          PROFILE.MYLISTOPT AS listOption,\n" +
                    "          PROFILE.BANNEROPT AS bannerOption,\n" +
                    "          BANNERDATA.BANNERNAME\n" +
                    "    FROM ACCOUNT, PROFILE, SIGNON, BANNERDATA\n" +
                    "    WHERE ACCOUNT.USERID = ?\n" +
                    "      AND SIGNON.USERNAME = ACCOUNT.USERID\n" +
                    "      AND PROFILE.USERID = ACCOUNT.USERID\n" +
                    "      AND PROFILE.FAVCATEGORY = BANNERDATA.FAVCATEGORY";

    private static final String GET_ACOUNT_BY_USERNME_AND_PASSWORD =
            "SELECT\n" +
                    "      SIGNON.USERNAME,\n" +
                    "      ACCOUNT.EMAIL,\n" +
                    "      ACCOUNT.FIRSTNAME,\n" +
                    "      ACCOUNT.LASTNAME,\n" +
                    "      ACCOUNT.STATUS,\n" +
                    "      ACCOUNT.ADDR1 AS address1,\n" +
                    "      ACCOUNT.ADDR2 AS address2,\n" +
                    "      ACCOUNT.CITY,\n" +
                    "      ACCOUNT.STATE,\n" +
                    "      ACCOUNT.ZIP,\n" +
                    "      ACCOUNT.COUNTRY,\n" +
                    "      ACCOUNT.PHONE,\n" +
                    "      PROFILE.LANGPREF AS languagePreference,\n" +
                    "      PROFILE.FAVCATEGORY AS favouriteCategoryId,\n" +
                    "      PROFILE.MYLISTOPT AS listOption,\n" +
                    "      PROFILE.BANNEROPT AS bannerOption,\n" +
                    "      BANNERDATA.BANNERNAME\n" +
                    "    FROM ACCOUNT, PROFILE, SIGNON, BANNERDATA\n" +
                    "    WHERE ACCOUNT.USERID = ?\n" +
                    "      AND SIGNON.PASSWORD = ?\n" +
                    "      AND SIGNON.USERNAME = ACCOUNT.USERID\n" +
                    "      AND PROFILE.USERID = ACCOUNT.USERID\n" +
                    "      AND PROFILE.FAVCATEGORY = BANNERDATA.FAVCATEGORY";

    private static final String INSERT_ACCOUNT =
            "INSERT INTO ACCOUNT\n" +
                    "      (EMAIL, FIRSTNAME, LASTNAME, STATUS, ADDR1, ADDR2, CITY, STATE, ZIP, COUNTRY, PHONE, USERID)\n" +
                    "    VALUES\n" +
                    "      (?, ?, ?, ?, ?,  ?, ?, ?, ?, ?, ?, ?)";

    private static final String INSERT_PROFILE =
            "INSERT INTO PROFILE (LANGPREF, FAVCATEGORY, USERID)\n" +
                    "    VALUES (?, ?, ?)";

    private static final String INSERT_SIGNON =
            "INSERT INTO SIGNON (PASSWORD,USERNAME)\n" +
                    "    VALUES (?, ?)";

    private static final String UPDATE_ACCOUNT =
            "UPDATE ACCOUNT SET\n" +
                    "      EMAIL = ?,\n" +
                    "      FIRSTNAME = ?,\n" +
                    "      LASTNAME = ?,\n" +
                    "      STATUS = ?,\n" +
                    "      ADDR1 = ?,\n" +
                    "      ADDR2 = ?,\n" +
                    "      CITY = ?,\n" +
                    "      STATE = ?,\n" +
                    "      ZIP = ?,\n" +
                    "      COUNTRY = ?,\n" +
                    "      PHONE = ?\n" +
                    "    WHERE USERID = ?";

    private static final String UPDATE_PROFILE =
            "UPDATE PROFILE SET\n" +
                    "      LANGPREF = ?,\n" +
                    "      FAVCATEGORY = ?\n" +
                    "    WHERE USERID = ?";

    private static final String UPDATE_SIGNON =
            "INSERT INTO SIGNON (PASSWORD,USERNAME)\n" +
                    "    VALUES (?, ?)";

    private Account resultSetToAccount(ResultSet resultSet) throws Exception{
        Account account = new Account();
        account.setBannerOption(resultSet.getBoolean("banneroption"));
        account.setBannerName(resultSet.getString("bannername"));
        account.setCity(resultSet.getString("city"));
        account.setCountry(resultSet.getString("country"));
        account.setEmail(resultSet.getString("email"));
        account.setFavouriteCategoryId(resultSet.getString("favouriteCategoryId"));
        account.setFirstName(resultSet.getString("firstname"));
        account.setLastName(resultSet.getString("lastname"));
        account.setLanguagePreference(resultSet.getString("LanguagePreference"));
        account.setListOption(resultSet.getBoolean("ListOption"));
        account.setAddress1(resultSet.getString("Address1"));
        account.setAddress2(resultSet.getString("Address2"));
//        account.setPassword(resultSet.getString("password"));
        account.setPhone(resultSet.getString("phone"));
        account.setState(resultSet.getString("state"));
        account.setStatus(resultSet.getString("status"));
        account.setUsername(resultSet.getString("username"));
        account.setZip(resultSet.getString("zip"));
        return account;
    }

    @Override
    public Account getAccountByUsername(String var1) {
        Account account = null;
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ACOUNT_BY_USERNME);
            preparedStatement.setString(1,var1);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                account = resultSetToAccount(resultSet);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public Account getAccountByUsernameAndPassword(Account var1) {
        Account account = null;
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ACOUNT_BY_USERNME_AND_PASSWORD);
            preparedStatement.setString(1,var1.getUsername());
            preparedStatement.setString(2,var1.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                account = resultSetToAccount(resultSet);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public void insertAccount(Account var1) {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACCOUNT);
            preparedStatement.setString(1,var1.getEmail());
            preparedStatement.setString(2,var1.getFirstName());
            preparedStatement.setString(3,var1.getLastName());
            preparedStatement.setString(4,var1.getStatus());
            preparedStatement.setString(5,var1.getAddress1());
            preparedStatement.setString(6,var1.getAddress2());
            preparedStatement.setString(7,var1.getCity());
            preparedStatement.setString(8,var1.getState());
            preparedStatement.setString(9,var1.getZip());
            preparedStatement.setString(10,var1.getCountry());
            preparedStatement.setString(11,var1.getPhone());
            preparedStatement.setString(12,var1.getUsername());
            ResultSet resultSet = preparedStatement.executeQuery();
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void insertProfile(Account var1) {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROFILE);
            preparedStatement.setString(1,var1.getLanguagePreference());
            preparedStatement.setString(2,var1.getFavouriteCategoryId());
            preparedStatement.setString(3,var1.getUsername());
            ResultSet resultSet = preparedStatement.executeQuery();
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void insertSignon(Account var1) {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SIGNON);
            preparedStatement.setString(1,var1.getPassword());
            preparedStatement.setString(2,var1.getUsername());
            ResultSet resultSet = preparedStatement.executeQuery();
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateAccount(Account var1) {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ACCOUNT);
            preparedStatement.setString(1,var1.getEmail());
            preparedStatement.setString(2,var1.getFirstName());
            preparedStatement.setString(3,var1.getLastName());
            preparedStatement.setString(4,var1.getStatus());
            preparedStatement.setString(5,var1.getAddress1());
            preparedStatement.setString(6,var1.getAddress2());
            preparedStatement.setString(7,var1.getCity());
            preparedStatement.setString(8,var1.getState());
            preparedStatement.setString(9,var1.getZip());
            preparedStatement.setString(10,var1.getCountry());
            preparedStatement.setString(11,var1.getPhone());
            preparedStatement.setString(12,var1.getUsername());
            ResultSet resultSet = preparedStatement.executeQuery();
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateProfile(Account var1) {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PROFILE);
            preparedStatement.setString(1,var1.getLanguagePreference());
            preparedStatement.setString(2,var1.getFavouriteCategoryId());
            preparedStatement.setString(3,var1.getUsername());
            ResultSet resultSet = preparedStatement.executeQuery();
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateSignon(Account var1) {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SIGNON);
            preparedStatement.setString(1,var1.getPassword());
            preparedStatement.setString(2,var1.getUsername());
            ResultSet resultSet = preparedStatement.executeQuery();
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        AccountDAO accountDAO = new AccountDaoImpl();
        Account account = new Account();
        account.setUsername("j2ee");
        account.setPassword("j2ee");
        Account result = accountDAO.getAccountByUsername("j2ee");
        System.out.println("success");
    }
}
