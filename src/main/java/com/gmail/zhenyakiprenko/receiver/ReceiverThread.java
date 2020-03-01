package com.gmail.zhenyakiprenko.receiver;

import com.gmail.zhenyakiprenko.constants.JmsConstants;

public class ReceiverThread implements Runnable {

    @Override
    public void run() {
        System.out.println("I hear something each 10 seconds:");
        for (int i = 0; i < 50; i++) {
            Receiver.receive().ifPresent(System.out::println);
            try {
              Thread.sleep(JmsConstants.PERIOD);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
        }
    }
}
