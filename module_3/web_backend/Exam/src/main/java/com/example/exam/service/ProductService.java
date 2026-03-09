package com.example.exam.service;

import com.example.exam.entity.Product;
import com.example.exam.util.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService{
    private final String FIND_ALL = "SELECT * FROM products";
    private final String FIND_BY_ID = "SELECT * FROM products WHERE id = ?";
    private final String INSERT = "INSERT INTO products(name, price, quantity, color, category_id) VALUES(?,?,?,?,?)";
    private final String DELETE_BY_ID = "DELETE FROM products WHERE id = ?";
    private final String UPDATE = "UPDATE products SET name=?, price=?, quantity=?, color=?, category_id=? WHERE id=?";
    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                int categoryId = resultSet.getInt("category_id");
                products.add(new Product(id, name, price, quantity, color, categoryId));
            }
        }catch (SQLException e){
            System.out.println("Không thể kết nối cơ sở dữ liệu!");
        }
        return products;
    }

    @Override
    public Product findById(int id) {
        try (Connection conn = ConnectDB.getConnectDB();
             PreparedStatement ps = conn.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getInt("quantity"),
                        rs.getString("color"),
                        rs.getInt("category_id")
                );
            }
        } catch (SQLException e) { System.out.println("Lỗi findById"); }
        return null;
    }

    @Override
    public boolean save(Product product) {
        try (Connection conn = ConnectDB.getConnectDB();
             PreparedStatement ps = conn.prepareStatement(INSERT)) {
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getQuantity());
            ps.setString(4, product.getColor());
            ps.setInt(5, product.getCategoryId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Lỗi thêm sản phẩm: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        try (Connection conn = ConnectDB.getConnectDB();
             PreparedStatement ps = conn.prepareStatement(DELETE_BY_ID)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            return rows == 1;
        } catch (SQLException e) {
            System.out.println("Lỗi xóa sản phẩm");
        }
        return false;
    }

    @Override
    public boolean update(Product product) {
        try (Connection conn = ConnectDB.getConnectDB();
             PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getQuantity());
            ps.setString(4, product.getColor());
            ps.setInt(5, product.getCategoryId());
            ps.setInt(6, product.getId());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println("Lỗi update");
        }
        return false;
    }

    @Override
    public List<Product> findByCategory(int categoryId) {
        return List.of();
    }
}
