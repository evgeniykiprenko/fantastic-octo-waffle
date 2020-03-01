package com.gmail.zhenyakiprenko.producer;

import com.gmail.zhenyakiprenko.constants.JmsConstants;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

public class Producer {

    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(JmsConstants.URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //Queue where to write
        Destination destination = session.createQueue(JmsConstants.SUBJECT);

        MessageProducer producer = session.createProducer(destination);

        TextMessage message = session.createTextMessage("Hello, World! We need to talk!");

        producer.send(message);

        System.out.println(String.format("JCG printing %s ", message.getText()));
        connection.close();
    }
}
