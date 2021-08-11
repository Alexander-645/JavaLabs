package com.epam.alexandr_steblyuk.java.lesson_1.task_4;

import com.epam.alexandr_steblyuk.java.lesson_1.task_4.education_programs.EducationProgram;
import com.epam.alexandr_steblyuk.java.lesson_1.task_4.utiles.DateCalcHelper;

import java.time.LocalDateTime;
import java.util.*;

public class EducationPlan {
    static Map<String, EducationProgram[]> edProgramMap = new HashMap<>();

    public EducationPlan(List<Student> students, List<EducationProgram[]> en) {
        for(Student student:students) {
            String studentName = student.getName();
            if (!edProgramMap.containsKey(studentName)) {
                edProgramMap.put(studentName, en.get((int)(Math.random()+0.5)));
            }
        }
    }

    public static String getPlan(String studentName) {

        StringBuilder answerBuilder = new StringBuilder(studentName);

        try {
            answerBuilder.append(" (");
            answerBuilder.append(edProgramMap.get(studentName)[0].getName());
            answerBuilder.append(") - ");
        } catch (NullPointerException e) {
            System.out.println("This student does not exists in plan!");
            System.exit(1);
        }

        return answerBuilder.toString();
    }

    public static EducationProgram[] getEducationProgram(String studentName) {
        EducationProgram[] educationProgram = new EducationProgram[1];

        try {
            educationProgram = edProgramMap.get(studentName);
        } catch (NullPointerException e) {
            System.out.println("This student does not exists in plan!");
            System.exit(1);
        }

        return educationProgram;
    }

    public String getEducationPlan(LocalDateTime date) {
        Set<Map.Entry<String, EducationProgram[]>> ep = edProgramMap.entrySet();
        StringBuilder educationPlanBuilder = new StringBuilder();
        for (Map.Entry entry: ep) {
            LocalDateTime endDate = DateCalcHelper
                    .calcEndDate(LocalDateTime.of(2021, 4, 25, 11, 0),
                            EducationPlan.getEducationProgram((String) entry.getKey())[0].getProgramTime());
            educationPlanBuilder.append(EducationPlan.getPlan((String) entry.getKey())
                    + DateCalcHelper.calcDateDiff(date, endDate));
            educationPlanBuilder.append("\n");
        }

        return educationPlanBuilder.toString();
    }
}
