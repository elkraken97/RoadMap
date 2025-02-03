
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class numero14 {
    public static void main(String[] args) {
   /*     LocalDateTime actual = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        System.out.println(actual.format(formato));
        String fechacumple = "2006/09/06 18:15:45";
        LocalDateTime cum = LocalDateTime.parse(fechacumple,formato);

        Period p = Period.between(cum.toLocalDate(),actual.toLocalDate());


        LocalDateTime t = cum.plusYears(p.getYears()).plusMonths(p.getMonths()).plusDays(p.getDays());

        Duration d = Duration.between(t,actual);
        System.out.println("tienes:"+p.getYears()+" años "
                +p.getMonths()+" meses "
                +p.getDays()+" Dias "
                +d.toHours()+" Horas "
                +(d.toMinutes() % 60)
                +" Minutos "+(d.toSeconds())%60 + " segundos" );*/

        //DIFICULTAD EXTRA
        LocalDateTime date = LocalDateTime.of(2006,9,6,18,30,6);

        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println(date.format(f));
        System.out.println(date.getDayOfYear());
        System.out.println(date.getDayOfWeek().getDisplayName(TextStyle.FULL,new Locale("ES","mx")));
        System.out.println(date.getMonth().getDisplayName(TextStyle.FULL,new Locale("ES","mx")));





    }
}
