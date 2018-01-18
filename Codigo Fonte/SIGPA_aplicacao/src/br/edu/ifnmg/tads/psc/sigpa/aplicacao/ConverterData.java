/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.psc.sigpa.aplicacao;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ananda
 */
public class ConverterData {
    
    public static Date FormatarData(String data) throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        Date dataSql = new Date(format.parse(data).getTime());
        return dataSql;
    }
    
    public static String DataParaString(Date data){
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        String dataString = format.format(data);
        return dataString;
    }
    
    public static Time FormatarHora (String horario) throws ParseException{
        DateFormat format = new SimpleDateFormat("HH:MM");
        Time horaSql = new Time (format.parse(horario).getTime());
        return horaSql;
    }
    
    public static String HoraParaString(Time hora){
        SimpleDateFormat format = new SimpleDateFormat("HH:MM");
        String horaString = format.format(hora);
        return horaString;
    }
    
}
