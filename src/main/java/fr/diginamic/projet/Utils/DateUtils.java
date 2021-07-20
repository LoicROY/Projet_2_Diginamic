package fr.diginamic.projet.Utils;

import fr.diginamic.projet.Entity.Absence;
import fr.diginamic.projet.Entity.CongePaye;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public final class DateUtils {
    private static final String DEFAULT_FORMAT = "dd/MM/yyyy";

    public static String format(LocalDate localDate) {
        return format(localDate, DEFAULT_FORMAT);
    }

    public static String format(LocalDate localDate, String format) {
        return localDate.format(DateTimeFormatter.ofPattern(format));
    }

    public static long daysBetween(LocalDate localDateInclusive, LocalDate localDateExclusive){
        return ChronoUnit.DAYS.between(localDateInclusive, localDateExclusive.plusDays(1));
    }

    public static boolean isSaturdayOrSunday(LocalDate localDate){
        return localDate.getDayOfWeek().equals(DayOfWeek.SATURDAY) || localDate.getDayOfWeek().equals(DayOfWeek.SUNDAY);
    }
    public static long interval(Absence absence){
        return ChronoUnit.DAYS.between(((CongePaye) absence).getDateDebut(), ((CongePaye) absence).getDateFin());
    }
}
