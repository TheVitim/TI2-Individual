package com.crudcarro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO {
    private Connection con;

    public CarroDAO() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/teste";
        String user = "ti2cc";
        String password = "ti@cc";
        con = DriverManager.getConnection(url, user, password);
    }

    public void inserir(Carro carro) throws SQLException {
        String sql = "INSERT INTO Carro(modelo, marca, ano, cor, preco) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, carro.getModelo());
            ps.setString(2, carro.getMarca());
            ps.setInt(3, carro.getAno());
            ps.setString(4, carro.getCor());
            ps.setDouble(5, carro.getPreco());
            ps.executeUpdate();
        }
    }

    public List<Carro> listar() throws SQLException {
        List<Carro> lista = new ArrayList<>();
        String sql = "SELECT * FROM Carro ORDER BY id";
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Carro c = new Carro(
                    rs.getInt("id"),
                    rs.getString("modelo"),
                    rs.getString("marca"),
                    rs.getInt("ano"),
                    rs.getString("cor"),
                    rs.getDouble("preco")
                );
                lista.add(c);
            }
        }
        return lista;
    }

    public void atualizar(Carro carro) throws SQLException {
        String sql = "UPDATE Carro SET modelo=?, marca=?, ano=?, cor=?, preco=? WHERE id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, carro.getModelo());
            ps.setString(2, carro.getMarca());
            ps.setInt(3, carro.getAno());
            ps.setString(4, carro.getCor());
            ps.setDouble(5, carro.getPreco());
            ps.setInt(6, carro.getId());
            ps.executeUpdate();
        }
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM Carro WHERE id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}