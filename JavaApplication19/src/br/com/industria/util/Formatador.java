/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.industria.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *
 * @author Meu Computador
 */
public class Formatador {
    public static String formatarData(LocalDate data){
        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy"   );
        return data.format(formatar);
    }
    
    public static String formatarSalario(BigDecimal salario){
        DecimalFormatSymbols br = new DecimalFormatSymbols(new Locale("pt", "BR"));
        DecimalFormat decimal =  new DecimalFormat("#,##0.00", br);
        return decimal.format(salario);
    }
    
     public static String formatarDiaMes(LocalDate data){
        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM");
        return data.format(formatar);
    }
}
