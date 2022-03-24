package org.app.dao;

import org.app.models.Fairy;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cvenkman on Mar, 2022
 **/
@Component
public class WinxDao {
    //show, save, update, delete
    private static final String URL = "jdbc:postgresql://localhost:5432/winxfairies";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "1234";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Fairy> index() {
        List<Fairy> fairiesList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM fairies";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Fairy fairy = new Fairy();

                fairy.setName(resultSet.getString("name"));
                fairy.setAge(resultSet.getInt("age"));
                fairy.setPowers(resultSet.getString("powers"));

                fairiesList.add(fairy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fairiesList;
    }

    public Fairy show(String name) {
        Fairy fairy = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM fairies WHERE name=?");
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            fairy = new Fairy();
            fairy.setAge(resultSet.getInt("age"));
            fairy.setName(resultSet.getString("name"));
            fairy.setPowers(resultSet.getString("powers"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fairy;
    }

    public void save(Fairy fairy) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO fairies VALUES(?, ?, ?)");
            preparedStatement.setString(1, fairy.getName());
            preparedStatement.setInt(2, fairy.getAge());
            preparedStatement.setString(3, fairy.getPowers());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
