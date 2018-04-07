/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author mpgsa
 */
public class ClientsDAO extends DAO<Clients> {

    @Override
    public Clients find(int id) {
        Clients c = new Clients();
        try {
            ResultSet result = this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeQuery(
                            "select * from cliente where id_cliente = " + id
                    );
            if (result.first()) {
                c = new Clients(id,
                        result.getString("nome"),
                        result.getString("email"),
                        result.getString("telefone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public Clients create(Clients obj) {
        try {
            PreparedStatement prepare =
                    this.connect
                            .prepareStatement(
                                    "insert into cliente "
                                            + "(nome, "
                                            + "email, telefone) "
                                            + "values (?, ?, ?)"
                                    , Statement.RETURN_GENERATED_KEYS);

            prepare.setString(1, obj.getNome());
            prepare.setString(2, obj.getEmail());
            prepare.setString(3, obj.getTelefone());


            prepare.executeUpdate();


            ResultSet rs = prepare.getGeneratedKeys();
            if (rs.next()) {
                obj.setId_cliente(rs.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public Clients upDate(Clients obj) {
        try {
            this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeUpdate(
                    "update cliente set nome = '"
                            + obj.getNome() + "',"
                            + "email = '"
                            + obj.getEmail() + "',"
                            + "where telefone = " + obj.getId_cliente()
            );
            obj = this.find(obj.getId_cliente());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public void delete(Clients obj) {
        try {
            this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeUpdate(
                    "delete from cliente where id_cliente = "
                            + obj.getId_cliente()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
