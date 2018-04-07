
package Dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class FilmDAO extends DAO<Film> {

    @Override
    public Film find(int id) {
        Film f = new Film();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            ).executeQuery(
                    "select * from filme where id_filme = " + id
            );


            if (result.first()) {
                f = new Film(id,
                        result.getString("titulo"),
                        result.getString("descricao"),
                        result.getInt("ano"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public Film create(Film obj) {
        try {
            PreparedStatement prepare =
                    this.connect
                            .prepareStatement(
                                    "insert into filme "
                                            + "(titulo, "
                                            + "descricao, ano) "
                                            + "values (?, ?, ?)"
                                    , Statement.RETURN_GENERATED_KEYS);

            prepare.setString(1, obj.getTitulo());
            prepare.setString(2, obj.getDescricao());
            prepare.setInt(3, obj.getAno());


            prepare.executeUpdate();


            ResultSet rs = prepare.getGeneratedKeys();
            if (rs.next()) {
                obj.setId_filme(rs.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public Film upDate(Film obj) {
        try {
            this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeUpdate(
                    "update filme set titulo = ' "
                            + obj.getTitulo() + "'"
                            + "where id_film = " + obj.getId_filme()
            );
            obj = this.find(obj.getId_filme());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public void delete(Film obj) {
        try {
            this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeUpdate(
                    "delete from filme where id_filme = "
                            + obj.getId_filme()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
