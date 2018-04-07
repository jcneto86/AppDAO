
package Dados;

import java.sql.*;


public class RentFilmDAO extends DAO<RentFilm> {

    @Override
    public RentFilm find(int id) {
        RentFilm r = new RentFilm();
        try {
            ResultSet result = this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeQuery(
                            "select * from RentFilm where id_locacao = " + id
                    );
            if (result.first()) {
                r = new RentFilm(id,
                        result.getInt("id_cliente"),
                        result.getInt("id_filme"),
                        result.getDate("data_locacao"),
                        result.getDate("data_devolucao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }

    @Override
    public RentFilm create(RentFilm obj) {
        try {
            PreparedStatement prepare =
                    this.connect
                            .prepareStatement(
                                    "insert into locacao "
                                            + "(id_cliente, "
                                            + "id_filme, data_locacao, data_devolucao) "
                                            + "values (?, ?, ?, ?)"
                                    , Statement.RETURN_GENERATED_KEYS);

            prepare.setInt(1, obj.getId_cliente());
            prepare.setInt(2, obj.getId_filme());
            prepare.setDate(3, new java.sql.Date(obj.getData_locacao().getTime()));
            prepare.setDate(4, new java.sql.Date(obj.getData_devolucao().getTime()));


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
    public RentFilm upDate(RentFilm obj) {
        try {
            this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeUpdate(
                    "update locacao set data_devolucao = "
                            + obj.getData_devolucao()
                            + " where id_filme = " + obj.getId_filme()
            );
            obj = this.find(obj.getId_locacao());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public void delete(RentFilm obj) {
        try {
            this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeUpdate(
                    "delete from RentFilm where id_RentFilm = "
                            + obj.getId_locacao()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
