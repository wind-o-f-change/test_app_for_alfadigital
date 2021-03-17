package com.alfadigital.testapp.dao;



import com.alfadigital.testapp.connection.ConnectionManager;
import com.alfadigital.testapp.connection.ConnectionManagerJdbcImpl;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class BoxDaoJdbcImpl implements BoxDao {
    private static final ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();

    //    Обработку и логгирование ошибок не делал т.к этого нет в задании


    @Override
    public void saveWithId(int id) {
        try (Connection connection = connectionManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO BOX values (?)", Statement.NO_GENERATED_KEYS)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveWithAllParam(int id, int box_id) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO BOX values (?, ?)", Statement.NO_GENERATED_KEYS)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, box_id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
