package org.rptp.java.MailService;

public class Salary implements Sendable<Integer>{
    private String from, to;
    private int salary;

    public Salary(String from, String to, int salary) {
        this.from = from;
        this.to = to;
        this.salary = salary;
    }

    public String getTo() {
        return to;
    }

    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public Integer getContent() {
        return salary;
    }
}
