package com.gmail.zhenyakiprenko;

import com.gmail.zhenyakiprenko.receiver.Receiver;
import com.gmail.zhenyakiprenko.sender.Sender;

public class Main {

    public static void main(String[] args) {
//        Sender.send("Hello, Alyona!");
        Receiver.receive().ifPresent(System.out::println);
    }
}
