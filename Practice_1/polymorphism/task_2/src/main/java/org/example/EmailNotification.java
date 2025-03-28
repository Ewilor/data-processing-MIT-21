package org.example;

class EmailNotification extends Notification {
    @Override public void send() {
        System.out.println("Email notification");
    }
}
