package org.rptp.java.MailService;

public interface Sendable <T>{
    String getTo();
    String getFrom();
    T getContent();
}
