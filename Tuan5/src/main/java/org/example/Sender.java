package org.example;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.BasicConfigurator;

import javax.jms.*;
import java.util.Scanner;

public class Sender {
    public static void main(String[] args) throws JMSException {
        BasicConfigurator.configure();
        Scanner scanner = new Scanner(System.in);

        ConnectionFactory factory = new ActiveMQConnectionFactory();
        Connection connection = factory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("queue/messages");
        MessageProducer producer = session.createProducer(destination);
        Message message;
        session.run();

        while (true){
            System.out.print("Input message: ");
            String text = scanner.nextLine();
            if (text.isEmpty())
                break;

            message = session.createTextMessage(text);
            producer.send(message);

        }
        session.close();
        connection.close();
    }
}
