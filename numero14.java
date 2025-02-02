import javax.print.attribute.standard.Finishings;
import java.text.DateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class numero14 {
    public static void main(String[] args) {
        LocalDateTime actual = LocalDateTime.now();
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
                +" Minutos "+(d.toSeconds())%60 + " segundos" );
    }
}
