package org.rptp.java.MailSystem.Utiles.Interfaces;

import org.rptp.java.MailSystem.Utiles.Interfaces.Sendable;

public interface MailService {
    Sendable processMail(Sendable mail);
}
