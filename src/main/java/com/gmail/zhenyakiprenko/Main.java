package com.gmail.zhenyakiprenko;

import com.gmail.zhenyakiprenko.receiver.ReceiverThread;
import com.gmail.zhenyakiprenko.sender.SenderThread;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread receiver = new Thread(new ReceiverThread());
        Thread sender = new Thread(new SenderThread());

        System.out.println("Starting receiver and sender threads.");
        sender.start();
        Thread.sleep(2000);
        receiver.start();
    }
}
