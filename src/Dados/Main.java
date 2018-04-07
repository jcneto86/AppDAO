package Dados;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Main {

    public static void main(String[] args) throws ParseException {

        Calendar calendar = Calendar.getInstance();
        Date dtLancamento = new Date();
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        dtLancamento = sdf.parse("14/11/2012");

        DAO<RentFilm> locacaoDao = new RentFilmDAO();
        RentFilm locacao = new RentFilm(
                0,
                1,
                20,
                (Date) calendar.getTime(),
                (Date) calendar.getTime()
        );

        locacaoDao.create(locacao);
    }


}
