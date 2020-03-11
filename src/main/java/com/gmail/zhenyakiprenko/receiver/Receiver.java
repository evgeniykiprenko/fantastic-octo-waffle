package com.gmail.zhenyakiprenko.receiver;

import com.gmail.zhenyakiprenko.constants.JmsConstants;
import com.gmail.zhenyakiprenko.util.JmsUtils;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.util.Optional;

public class Receiver {

    public static Optional<String> receive() {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(JmsConstants.URL);
        Optional<String> result = Optional.empty();
        Connection connection = null;
        Session session = null;

        try {
            connection = connectionFactory.createConnection();
            connection.start();

            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createQueue(JmsConstants.SUBJECT);
            MessageConsumer consumer = session.createConsumer(destination);

            Message message = consumer.receive();

            if (message instanceof TextMessage) {
                result = Optional.of(((TextMessage) message).getText());
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            JmsUtils.endConnection(connection, session);
        }


        return result;
    }
}
