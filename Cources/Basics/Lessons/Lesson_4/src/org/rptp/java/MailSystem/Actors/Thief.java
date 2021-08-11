package org.rptp.java.MailSystem.Actors;

import org.rptp.java.MailSystem.Utiles.Interfaces.MailService;
import org.rptp.java.MailSystem.Utiles.Interfaces.Sendable;
import org.rptp.java.MailSystem.Utiles.MailPackage;
import org.rptp.java.MailSystem.Utiles.Package;

public class Thief implements MailService {
    int minPrice;
    private int stolenValue;
    static final int ZERO_PRICE = 0;

    public Thief(int minPrice) {
        this.minPrice = minPrice;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if(mail instanceof MailPackage
                && ((MailPackage) mail).getContent().getPrice() >= minPrice) {
            String stolenContent = "stones instead of " + ((MailPackage) mail).getContent().getContent();
            stolenValue = stolenValue + ((MailPackage) mail).getContent().getPrice();
            Package stolenPackage = new Package(stolenContent, ZERO_PRICE);
            mail = new MailPackage(mail.getFrom(), mail.getTo(), stolenPackage);
        }
        return mail;
    }

    public int getStolenValue() {
        return stolenValue;
    }
}
