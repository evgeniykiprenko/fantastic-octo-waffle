package com.gmail.zhenyakiprenko.sender;

import com.gmail.zhenyakiprenko.constants.JmsConstants;
import com.gmail.zhenyakiprenko.receiver.Receiver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;



public class SenderThread implements Runnable {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            LocalDateTime now = LocalDateTime.now();
            Sender.send(String.format("Current time: %s.", dtf.format(now)));
            try {
                Thread.sleep(JmsConstants.PERIOD);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
