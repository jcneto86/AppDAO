
package Dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFilmClubSQL
{
    private static final String url = "jdbc:mysql://localhost/locadora";
    private static final String user = "root";
    private static final String password = "a12345678";
    private static Connection connect;

    public static Connection getInstance()
    {
        if (connect == null)
        {
            try
            {
                connect = DriverManager.getConnection(url, user, password);

            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return connect;
    }
}
