package rabbitmq.simple;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author diaopengwei
 * @date 2022/12/20
 * @apiNote
 */
public class Consumer {

    public static void main(String[] args) {

        //    所有的中间件都是基于tcp/ip协议 只不过rabbitmq遵循的是AMQP协议；因为tcp/ip无法满足消息队列
        //    IP和端口
        //    创建链接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.21.128");
        factory.setPort(5672);
        factory.setUsername("admin");
        factory.setPassword("admin");
        factory.setVirtualHost("/");
        //    创建链接Connection
        Connection connection = null;
        Channel channel  = null;
        try {
            connection = factory.newConnection("生产者");
            //    通过链接获取通道
            channel = connection.createChannel();
            //    通过通道创建交换机；声明队列；绑定关系；路由key，发送消息和接收消息
            channel.basicConsume("queue1", true, new DeliverCallback() {
                @Override
                public void handle(String s, Delivery delivery) throws IOException {
                    System.out.println("收到的消息是："+new String(delivery.getBody(), "utf-8"));
                }
            }, new CancelCallback() {
                @Override
                public void handle(String s) throws IOException {
                    System.out.println("消息接收失败");
                }
            });
            System.in.read();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        } finally {
            //    关闭通道
            if (channel != null && channel.isOpen()){
                try {
                    channel.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (TimeoutException e) {
                    throw new RuntimeException(e);
                }
            }
            //    关闭链接
            if (connection != null && connection.isOpen()){
                try {
                    connection.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }



    }
}
