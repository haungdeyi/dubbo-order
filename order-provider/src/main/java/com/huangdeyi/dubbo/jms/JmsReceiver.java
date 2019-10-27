package com.huangdeyi.dubbo.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsReceiver {

    public static void main(String[] args) {
        //创建连接工厂
        //ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("" + "tcp://192.168.43.66:61616");

        //利用静态网络连接(t通过88主机消费)
        //ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("" + "tcp://192.168.43.88:61616");

        //利用静态网络进行容错连接（默认随机，randomize=false表示优先连接第一个地址）
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("" + "failover:(tcp://192.168.43.66:61616,tcp://192.168.43.88:61616)?randomize=false");
        //得到一个连接
        Connection connection = null;
        try {
            connection = connectionFactory.createConnection();
            //触发连接
            connection.start();
            //创建会话
            Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            //创建一个消息队列（队列存在则不会创建）
            Destination destination = session.createQueue("first-queue");
            //创建一个消息接收者
            MessageConsumer messageConsumer  = session.createConsumer(destination);
            //接收一条（消费）消息
            TextMessage message = (TextMessage)messageConsumer.receive();

            //客户端手动确认消息已被消费
            //message.acknowledge();
            System.out.println(message.getText());

            //commit
            session.commit();
            session.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
