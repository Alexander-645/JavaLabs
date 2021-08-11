package org.rptp.java.MailSystem.Actors;

import org.rptp.java.MailSystem.Utiles.Interfaces.MailService;
import org.rptp.java.MailSystem.Utiles.Interfaces.Sendable;
import org.rptp.java.MailSystem.Utiles.MailMessage;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Spy implements MailService {
    private static final Logger LOGGER_SPY = Logger.getLogger(MailMessage.class.getName());

    @Override
    public Sendable processMail(Sendable mail) {
        if(mail instanceof MailMessage) {
            if ((mail.getFrom().equals("Austin Powers")
                    || mail.getTo().equals("Austin Powers"))) {
                LOGGER_SPY.log(Level.WARNING, "Detected " +
                                "target mail correspondence: " +
                                "from {0} to {1} \"{2}\"",
                        new Object[]{mail.getFrom(), mail.getTo(), ((MailMessage) mail).getMessage()});
            } else {
                LOGGER_SPY.log(Level.INFO, "Usual correspondence: " +
                        "from {0} to {1}", new Object[]{mail.getFrom(), mail.getTo()});
            }
        }

        return mail;
    }
}
