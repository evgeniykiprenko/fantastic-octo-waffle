package com.gmail.zhenyakiprenko.sender;

import com.gmail.zhenyakiprenko.constants.JmsConstants;
import com.gmail.zhenyakiprenko.util.JmsUtils;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

public class Sender {

    public static void send(String message) {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(JmsConstants.URL);
        Connection connection = null;
        Session session = null;

        try {
            connection = connectionFactory.createConnection();
            connection.start();

            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            //Queue where to write
            Destination destination = session.createQueue(JmsConstants.SUBJECT);

            MessageProducer producer = session.createProducer(destination);

            TextMessage textMessage = session.createTextMessage(message);

            producer.send(textMessage);
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            JmsUtils.endConnection(connection, session);
        }
    }
}
