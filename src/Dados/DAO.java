
package Dados;

import java.sql.Connection;


public abstract class DAO<T> {
    public Connection connect = ConnectionFilmClubSQL.getInstance();


    public abstract T find(int id);

    public abstract T create(T obj);

    public abstract T upDate(T obj);

    public abstract void delete(T obj);
}
