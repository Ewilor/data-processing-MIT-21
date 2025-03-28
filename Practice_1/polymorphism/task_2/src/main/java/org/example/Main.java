package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Notification email_notification = new EmailNotification();
        Notification sms_notification = new SMSNotification();
        Notification notification = new Notification();

        notification.send();
        email_notification.send();
        sms_notification.send();
    }
}
