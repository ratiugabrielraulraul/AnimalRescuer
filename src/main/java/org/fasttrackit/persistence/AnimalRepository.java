package org.fasttrackit.persistence;

import org.fasttrackit.domain.Animal;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalRepository {

    public void createAnimal(String name, int age, int healthStatus, int hunger, int mood, String favoriteActivity, String
            favoriteFood, String spiritMood) throws SQLException, IOException, ClassNotFoundException {

        String insertSql = "INSERT INTO animal (name, age ,health_status, hunger , mood , favorite_food, favorite_activity, " +
                "spirit_mood) VALUES (?,?,?,?,?,?,?,?)";

        try (Connection connection = DatabaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setInt(3, healthStatus);
            preparedStatement.setInt(4, hunger);
            preparedStatement.setInt(5, mood);
            preparedStatement.setString(6, favoriteActivity);
            preparedStatement.setString(7, favoriteFood);
            preparedStatement.setString(8, spiritMood);

            preparedStatement.executeUpdate();
        }
    }

    public List<Animal> getAnimal() throws SQLException, IOException, ClassNotFoundException {
        String query = "SELECT id, name, age, health_status, hunger, mood, favorite_activity, favorite_food, spirit_mood" +
                "FROM animal";

        try (Connection connection = DatabaseConfiguration.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(query);

            List<Animal> animals = new ArrayList<>();

            while (resultSet.next()) {
                Animal animal = new Animal();
                animal.setId(resultSet.getLong("id"));
                animal.setName(resultSet.getString("name"));
                animal.setAge(resultSet.getInt("age"));
                animal.setHealthStatus(resultSet.getInt("health_status"));
                animal.setHunger(resultSet.getInt("hunger"));
                animal.setMood(resultSet.getInt("mood"));
                animal.setFavoriteActivity(resultSet.getString("favorite_activity"));
                animal.setFavoriteFood(resultSet.getString("favorite_food"));

                animal.setSpiritMood(resultSet.getString("spirit_mood"));


                animals.add(animal);
            }
            return animals;

        }

    }

    public Animal getAnimal(String name) throws SQLException, IOException, ClassNotFoundException {
        String query = "SELECT id, name ,age ,health_status, hunger, mood, favorite_food, favorite_activity, spirit_mood FROM animal WHERE `name`= ?";

        try (Connection connection = DatabaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                Animal animal = new Animal();
                animal.setId(resultSet.getInt("id"));
                animal.setName(resultSet.getString("name"));
                animal.setAge(resultSet.getInt("age"));
                animal.setHealthStatus(resultSet.getInt("health_status"));
                animal.setHunger(resultSet.getInt("hunger"));
                animal.setMood(resultSet.getInt("mood"));
                animal.setFavoriteActivity(resultSet.getString("favorite_activity"));
                animal.setFavoriteFood(resultSet.getString("favorite_food"));
                animal.setSpiritMood(resultSet.getString("spirit_mood"));
                return animal;
            }
        }
        return null;
    }

    public void updateAnimal(long id, String name, int hunger, int mood) throws SQLException, IOException, ClassNotFoundException {
        String sql = "UPDATE animal set `name` = ? , `hunger` = ?, `mood` = ? WHERE id = ?";
        try (Connection connection = DatabaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, hunger);
            preparedStatement.setInt(3, mood);
            preparedStatement.setLong(4, id);
            preparedStatement.executeUpdate();

        }
    }

    public void deleteAnimal(long id) throws SQLException, IOException, ClassNotFoundException {
        String sql = "DELETE FROM animal WHERE id = ?";

        try (Connection connection = DatabaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        }
    }
}
