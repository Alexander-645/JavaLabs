package org.rptp.java.MailSystem.Actors;

import org.rptp.java.MailSystem.Exceptions.IllegalPackageException;
import org.rptp.java.MailSystem.Exceptions.StolenPackageException;
import org.rptp.java.MailSystem.Utiles.Interfaces.MailService;
import org.rptp.java.MailSystem.Utiles.Interfaces.Sendable;
import org.rptp.java.MailSystem.Utiles.MailPackage;

public class Inspector implements MailService {
    @Override
    public Sendable processMail(Sendable mail) throws IllegalPackageException, StolenPackageException {
        if(mail instanceof MailPackage) {
            if (((MailPackage) mail).getContent().getContent().contains("weapons")
                    || ((MailPackage) mail).getContent().getContent().contains("banned substance")) {
                throw new IllegalPackageException();
            }
            else if(((MailPackage) mail).getContent().getContent().contains("stones")) {
                throw new StolenPackageException();
            }
        }
        return mail;
    }
}
