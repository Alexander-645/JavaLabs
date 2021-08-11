package com.epam.alexandr_steblyuk.java.lesson_1.task_4.utiles;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

public class DateCalcHelper {
    private static List<LocalDate> holidays = Arrays.asList(LocalDate.of(2021, 5, 1),
                                                            LocalDate.of(2021, 5, 2),
                                                            LocalDate.of(2021, 5, 3),
                                                            LocalDate.of(2021, 5, 8),
                                                            LocalDate.of(2021, 5, 9),
                                                            LocalDate.of(2021, 5, 10));

    public static LocalDateTime calcEndDate(LocalDateTime startDate, int programHours) {
        LocalDateTime endDate = startDate;

        while (programHours > 0) {
            int dayOfWeek = endDate.getDayOfWeek().getValue();
            int dayOfMonth = endDate.getDayOfMonth();
            int hour = endDate.getHour();
            if(dayOfWeek > 5 || holidays.contains(endDate.toLocalDate()) || hour >= 18) {
                endDate = endDate.plusDays(1);
                endDate = endDate.withHour(10);
                continue;
            }
            endDate = endDate.plusHours(1);
            programHours--;
        }

        return endDate;
    }

    public static String calcDateDiff(LocalDateTime currentDate, LocalDateTime endDate) {
        StringBuilder answerBuilder = new StringBuilder();

        if(currentDate.getHour() >= 18)
            currentDate = currentDate.withHour(18);

        if(currentDate.getHour() < 10) {
            currentDate = currentDate.minusDays(1);
            currentDate = currentDate.withHour(18);
        }

        int diffOfDays = Math.abs(endDate.getDayOfYear() - currentDate.getDayOfYear());
        int diffOfHours = Math.abs(endDate.getHour() - currentDate.getHour());

        answerBuilder.append("Обучение ");

        if(currentDate.isAfter(endDate) || currentDate.isEqual(endDate)) {
            answerBuilder.append("закончено. После окончания прошло\n");
            if(diffOfDays!=0)
                answerBuilder.append(diffOfDays).append(" д. ");
            answerBuilder.append(diffOfHours).append(" ч. ");
        }

        if(currentDate.isBefore(endDate)) {
            answerBuilder.append("не закончено. До окончания осталось\n");
            if(diffOfDays!=0)
                answerBuilder.append(diffOfDays).append(" д. ");
            answerBuilder.append(diffOfHours).append(" ч. ");
        }

        answerBuilder.append("Дата окончания обучения - ")
                .append(endDate.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG, FormatStyle.SHORT)));

        return answerBuilder.toString();
    }
}
