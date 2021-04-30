package com.vdab.Repositories;

;
import com.vdab.domain.Category;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CategoryRepository {
    public Category findCategory1() {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/games", "root", "P@ssw0rd")) {
    PreparedStatement preparedStatement = connection.prepareStatement("select * from category where id = 1");
    preparedStatement.execute();
    ResultSet resultSet = preparedStatement.getResultSet();
    resultSet.next();
        return Category.builder().categoryName(resultSet.getString("category_name")).id(resultSet.getInt("id")).build();

      } catch (Exception e){
    e.printStackTrace();
        return null;
        }

    }
}
