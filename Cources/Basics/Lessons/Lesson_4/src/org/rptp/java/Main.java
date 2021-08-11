package org.rptp.java;

import jdk.jfr.StackTrace;
import org.rptp.java.CallerClassAndMethod.CallerClassAndMethod;
import org.rptp.java.MailSystem.Actors.Inspector;
import org.rptp.java.MailSystem.Actors.Spy;
import org.rptp.java.MailSystem.Actors.Thief;
import org.rptp.java.MailSystem.Actors.UntrustworthlyMailWorker;
import org.rptp.java.MailSystem.Utiles.Interfaces.MailService;
import org.rptp.java.MailSystem.Utiles.MailMessage;
import org.rptp.java.MailSystem.Utiles.MailPackage;
import org.rptp.java.MailSystem.Utiles.Package;

import java.util.logging.*;

public class Main {

    public static void main(String[] args) {
//        execTask1();
        execTask3();
    }

//    public static void execTask1() {
//        System.out.println(CallerClassAndMethod.getCallerClassAndMethodName());
//    }


    public static void execTask3() {
        MailMessage message = new MailMessage("Alexander", "Austin", "Hello, motherfucker!");
        MailPackage mailPackage = new MailPackage("Me", "You", new Package("weapons", 100000000));
        Spy spy = new Spy();
        Thief thief = new Thief(50);
        Inspector inspector = new Inspector();

        UntrustworthlyMailWorker worker =
                new UntrustworthlyMailWorker(new MailService[]
                        {spy, thief, thief, inspector}, mailPackage);
        System.out.println(thief.getStolenValue());

    }
}
