package com.example.exam.service;

import com.example.exam.entity.Category;
import com.example.exam.util.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryService implements ICategoryService{
    private final String FIND_ALL = "SELECT id, name FROM categories";
    private final String FIND_BY_ID = "SELECT id, name FROM categories WHERE id = ?";
    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                categories.add(new Category(id, name));
            }
        }catch (SQLException e){
            System.out.println("Không thể kết nối cơ sở dữ liệu!");
        }
        return categories;
    }

    @Override
    public Category findById(int id) {
        try (Connection connection = ConnectDB.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                int categoryId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                return new Category(categoryId, name);
            }
        }catch (SQLException e){
            System.out.println("Không thể kết nối cơ sở dữ liệu!");
        }
        return null;
    }

    @Override
    public boolean save(Category category) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(Category category) {
        return false;
    }
}
