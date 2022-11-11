package csu.web.mypetstore.persistence.impl;

import csu.web.mypetstore.domain.Category;
import csu.web.mypetstore.persistence.DBUtil;
import csu.web.mypetstore.persistence.SequenceDAO;

import csu.web.mypetstore.domain.Sequence;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SequenceDAOimpl implements SequenceDAO {

    private static final String SELECT_SEQUENCE = "SELECT name, nextid\n" +
            "    FROM SEQUENCE\n" +
            "    WHERE NAME = ?";
    private static final String UPDATE_SEQUENCE =
            "UPDATE SEQUENCE\n" +
                    "    SET NEXTID = ?\n" +
                    "    WHERE NAME = ?";


    @Override
    public Sequence getSequence(Sequence sequence) {

        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SEQUENCE);
            preparedStatement.setString(1,sequence.getName());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
               sequence = new Sequence();
                sequence.setName(resultSet.getString("name"));
                sequence.setNextId(resultSet.getInt("nextid"));

            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return sequence;
    }


    @Override
    public void updateSequence(Sequence sequence) {
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SEQUENCE);
            preparedStatement.setInt(1,sequence.getNextId());
            preparedStatement.setString(2,sequence.getName());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
