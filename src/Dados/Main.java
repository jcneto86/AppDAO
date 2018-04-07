package Dados;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;


public class Main {

    public static void main(String[] args) throws ParseException {

        Calendar calendar = Calendar.getInstance();
        Date dataLocacao = calendar.getTime();
        calendar.add(Calendar.DATE, 10);
        Date dataDevolucao = calendar.getTime();


        DAO<RentFilm> locacaoDao = new RentFilmDAO();
        RentFilm locacao = new RentFilm(
                0,
                1,
                20,
                dataLocacao,
                dataDevolucao
        );

        locacaoDao.create(locacao);
    }


}
