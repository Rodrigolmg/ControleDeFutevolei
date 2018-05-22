/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import fabricaabstrata.CategoriaAbstrata;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import persistencia.PCategoria;

/**
 *
 * @author rodri
 */
public class Teste {
    public static void main(String[] args) {
        try {
            
            PCategoria teste = new PCategoria();
            
            CategoriaAbstrata a;
            
            a = teste.consultar(1);
            
            System.out.println(a.getDescricao());
            
//            String d = "10/06/2018";
//            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//            Date test4 = df.parse(d);
//            
//            java.sql.Date test5 = new java.sql.Date(test4.getTime());
//            
//            System.out.println(df.format(test5));
            
//            java.sql.Date data = java.sql.Date.valueOf(LocalDate.now());
//            DateTime test = new DateTime(data);
//            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//            System.out.println(df.format(data.getTime()));
            
//            String d = "10/06/2018";
//            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//            
//            GregorianCalendar data = (GregorianCalendar) Calendar.getInstance();
//            GregorianCalendar teste = new GregorianCalendar();
//            DateTime test = new DateTime(data);
//
//            Date da = df.parse(d);
//            teste.setTime(da);
//            Date test3;
//            
//            test3 = test.toDate();
//            DateTime test2 = new DateTime(teste);
//            int dif = Days.daysBetween(test, test2).getDays();
//            System.out.println(dif);
//            System.out.println(df.format(test3));
        } catch (Exception e) {
        }
    }
}
