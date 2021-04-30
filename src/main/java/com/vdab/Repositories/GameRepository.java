package com.vdab.Repositories;


import com.vdab.domain.Category;
import com.vdab.domain.Difficulty;
import com.vdab.domain.Game;
import com.vdab.services.Main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class GameRepository {

    public Game findFifthGame() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/games", "root", "P@ssw0rd")) {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("select * from game as g inner join category as c on g.category_id = c.id inner join difficulty as d on g.difficulty_id = d.id where g.id = 5");
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
            return Game.builder()
                    .id(resultSet.getInt("g.id"))
                    .gameName(resultSet.getString("game_name"))
                    .editor(resultSet.getString("editor"))
                    .author(resultSet.getString("author"))
                    .age(resultSet.getString("age"))
                    .yearEdition(resultSet.getInt("year_edition"))
                    .minPlayers(resultSet.getInt("min_players"))
                    .maxPlayers(resultSet.getInt("max_players"))
                    .category(new Category(resultSet.getInt("c.id"),resultSet.getString("category_name")))
                    .playDuration(resultSet.getString("play_duration"))
                    .difficulty(new Difficulty(resultSet.getInt("d.id"), resultSet.getString("difficulty_name")))
                    .price(resultSet.getDouble("price"))
                    .image(resultSet.getString("image"))
                    .build();


        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Game findGameByName(String string) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/games", "root", "P@ssw0rd")) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from game where LOWER(game_name) LIKE ?");
            preparedStatement.setString(1, "%" + string +  "%");
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
            return Game.builder()
                    .gameName(resultSet.getString("game_name"))
                    .editor(resultSet.getString("editor"))
                    .age(resultSet.getString("age"))
                    .price(resultSet.getDouble("price"))
                    .build();

        } catch (Exception e){
            System.out.println("No such game");
            Main main = new Main();
            main.findGameByName();
            return null;
        }
    }

    public List<Game> showAllGames() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/games", "root", "P@ssw0rd")) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from game order by game_name");
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            List<Game> gameList = new ArrayList<>();

            while (resultSet.next()){
            Game game = Game.builder()
                    .gameName(resultSet.getString("game_name"))
                    .editor(resultSet.getString("editor"))
                    .price(resultSet.getDouble("price")).build();
            gameList.add(game);
        }
        return gameList;

        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Game showAndChoose(String string) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/games", "root", "P@ssw0rd")) {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("select * from game as g inner join category as c on g.category_id = c.id inner join difficulty as d on g.difficulty_id where LOWER(game_name) LIKE ?" );
            preparedStatement.setString(1, "%" + string + "%");
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();

            resultSet.next();
                return Game.builder()
                        .gameName(resultSet.getString("game_name"))
                        .category(Category.builder().id(resultSet.getInt("c.id"))
                        .categoryName(resultSet.getString("category_name")).build())
                        .difficulty(Difficulty.builder().id(resultSet.getInt("d.id"))
                        .difficultyName(resultSet.getString("difficulty_name")).build())
                        .build();

        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
