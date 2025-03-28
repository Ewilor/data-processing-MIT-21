package org.example;

class SMSNotification extends Notification {
    @Override public void send() {
        System.out.println("SMS notification");
    }
}
