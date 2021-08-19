package fr.diginamic.projet.Utils;

import fr.diginamic.projet.Entity.AbsenceObligatoire;
import fr.diginamic.projet.Service.AbsenceObligatoireService;
import fr.diginamic.projet.Service.JourFerieService;
import fr.diginamic.projet.Service.RttEmployeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public final class DateUtils {

    private static AbsenceObligatoireService absenceObligatoireService;
    private static final String DEFAULT_FORMAT = "dd/MM/yyyy";

    @Autowired
    public void setAbsenceObligatoireService(AbsenceObligatoireService absenceObligatoireService){
        DateUtils.absenceObligatoireService = absenceObligatoireService;
    }

    public static String format(LocalDate localDate) {
        return format(localDate, DEFAULT_FORMAT);
    }

    public static String format(LocalDate localDate, String format) {
        return localDate.format(DateTimeFormatter.ofPattern(format));
    }

    public static long daysBetween(LocalDate localDateInclusive, LocalDate localDateExclusive){
        return ChronoUnit.DAYS.between(localDateInclusive, localDateExclusive.plusDays(1));
    }

    public static long workedDaysBetween(LocalDate startDate, LocalDate endDate){
        if (endDate.isBefore(startDate)){
            throw new DateTimeException("La date de fin ne peut pas être avant la date de début");
        }

        long days = daysBetween(startDate, endDate);
        LocalDate dateToCheck = startDate;

        do {
            if (isNotWorked(dateToCheck)){
                days--;
            }
            dateToCheck = dateToCheck.plusDays(1);
        } while (!dateToCheck.isEqual(endDate));

        return days;
    }

    public static boolean isSaturdayOrSunday(LocalDate localDate){
        return localDate.getDayOfWeek().equals(DayOfWeek.SATURDAY) || localDate.getDayOfWeek().equals(DayOfWeek.SUNDAY);
    }

    public static boolean isNotWorked(LocalDate localDate){
        return isSaturdayOrSunday(localDate) ||
                getAbsenceObligatoire().stream().anyMatch(absence -> compareExceptYear(localDate, absence.getDate()))
                ;
    }

    public static List<AbsenceObligatoire> getAbsenceObligatoire(){
        return absenceObligatoireService.findAll();
    }

    public static boolean compareExceptYear(LocalDate localDatetoCompare, LocalDate localDateReference){
        return localDatetoCompare.getMonth().equals(localDateReference.getMonth()) &&
                localDatetoCompare.getDayOfMonth() == (localDateReference.getDayOfMonth());
    }
}
