package org.example;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.BasicConfigurator;

import javax.jms.*;

public class Consumer {
    public static void main(String[] args) throws  JMSException {
        BasicConfigurator.configure();

        ConnectionFactory factory = new ActiveMQConnectionFactory();
        Connection connection = factory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("queue/messages");
        MessageConsumer consumer = session.createConsumer(destination);

        System.out.println("Consumer is listening");
        consumer.setMessageListener(message -> {
            try {
                TextMessage textMessage = (TextMessage) message;
                String txt = textMessage.getText();
                System.out.println("[Sender] : " + txt);
                message.acknowledge();
            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }
}
