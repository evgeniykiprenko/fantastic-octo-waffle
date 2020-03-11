package com.gmail.zhenyakiprenko.util;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Session;

public class JmsUtils {

    public static void endConnection(Connection connection, Session session) {
        if (session != null) {
            try {
                session.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
