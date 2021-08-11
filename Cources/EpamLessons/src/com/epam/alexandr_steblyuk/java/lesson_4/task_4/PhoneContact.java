package com.epam.alexandr_steblyuk.java.lesson_4.task_4;

import java.io.Serializable;

public class PhoneContact implements Serializable {
    public String contactName;
    public String phoneNumber;

    public PhoneContact(String name, String phone) {
        contactName = name;
        phoneNumber = phone;
    }
}
