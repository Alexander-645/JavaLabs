package org.rptp.java.MailSystem.Actors;

import org.rptp.java.MailSystem.Utiles.Interfaces.MailService;
import org.rptp.java.MailSystem.Utiles.Interfaces.Sendable;
import org.rptp.java.MailSystem.Utiles.RealMailService;

public class UntrustworthlyMailWorker implements MailService {

    RealMailService realMailService = new RealMailService();

    public UntrustworthlyMailWorker(MailService[] mailServices, Sendable mail) {
        for(int i = 1; i < mailServices.length; i++) {
            mailServices[i].processMail(mailServices[i - 1].processMail(mail));
        }
        realMailService.processMail(mailServices[mailServices.length-1].processMail(mail));
    }

    @Override
    public Sendable processMail(Sendable mail) {

        return mail;
    }

    public RealMailService getRealMailService() {
        return realMailService;
    }
}
