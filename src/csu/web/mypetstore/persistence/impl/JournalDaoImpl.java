package csu.web.mypetstore.persistence.impl;

import com.mysql.cj.jdbc.CallableStatement;
import csu.web.mypetstore.domain.Journal;
import csu.web.mypetstore.persistence.DBUtil;
import csu.web.mypetstore.persistence.JournalDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JournalDaoImpl implements JournalDAO {
    private static final String UPDATE_JOURNAL = "INSERT INTO journal (USERNAME,ACTION,URL,TIME)VALUES(?,?,?,?)";
    public void write(Journal journal) throws SQLException {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_JOURNAL);
        preparedStatement.setString(1,journal.getUsername());
        preparedStatement.setString(2,journal.getAction());
        preparedStatement.setString(3,journal.getUrl());
        preparedStatement.setString(4,journal.getTime());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();


        connection.close();
    }
}
