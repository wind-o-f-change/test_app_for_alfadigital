package com.alfadigital.testapp.dao;


import com.alfadigital.testapp.connection.ConnectionManager;
import com.alfadigital.testapp.connection.ConnectionManagerJdbcImpl;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemDaoJdbcImpl implements ItemDao {
    private static final ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();

    //    Обработку и логгирование ошибок не делал т.к этого нет в задании


    @Override
    public List<Integer> getByBoxIdAndColor(int box_id, String color) {
        List<Integer> list = new ArrayList<>();
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT id FROM ITEM WHERE contained_in = ? and color = ?")) {
            preparedStatement.setInt(1, box_id);
            preparedStatement.setString(2, color);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    list.add(resultSet.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(list);
        return list;
    }

    @Override
    public void saveWithId(int id) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO ITEM values (?)", Statement.NO_GENERATED_KEYS)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveWithIdAndBoxId(int id, int box_id) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO ITEM values (?, ?)", Statement.NO_GENERATED_KEYS)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, box_id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveWithIdAndColor(int id, String color) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO ITEM values (?, ?)", Statement.NO_GENERATED_KEYS)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, color);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveWithAllParam(int id, int box_id, String color) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO ITEM values (?, ?, ?)", Statement.NO_GENERATED_KEYS)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, box_id);
            preparedStatement.setString(3, color);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
