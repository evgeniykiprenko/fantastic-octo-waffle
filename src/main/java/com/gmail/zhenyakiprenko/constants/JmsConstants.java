package com.gmail.zhenyakiprenko.constants;

import org.apache.activemq.ActiveMQConnection;

public interface JmsConstants {

    String URL = ActiveMQConnection.DEFAULT_BROKER_URL;
    String SUBJECT = "JCG_QUEUE";
}
