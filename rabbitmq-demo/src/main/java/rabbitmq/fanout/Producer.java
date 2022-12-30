package rabbitmq.fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author diaopengwei
 * @date 2022/12/20
 * @apiNote
 */
public class Producer {

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
            //    通过链接获取通道  rabbitmq为什么是基于通道处理而不是链接  链接是短链接；会经过三次握手四次挥手
            // 这里把链接做成了长连接
            channel = connection.createChannel();
            //    通过通道创建交换机；声明队列；绑定关系；路由key，发送消息和接收消息
            String queueName = "queue1";
            /**
             * @params1 队列名字
             * @Params2 是否要持久化 durable=false  所谓的持久化消息是否存盘 true为持久化  非持久化会存盘吗？会存盘，但会随着服务器重启而丢失；
             * @Params2 排它性 是否是一个独占队列
             * @Params2 是否自动删除  随着最后一个消费者消费完毕是否把队列删除
             * @Params2 携带一些附加参数 在队列中带一些别的信息，现在写各null
             */
            channel.queueDeclare(queueName,false,false,false,null);
            //    准备消息
            String message = "hello rabbitmq";
            //    发送消息给队列
            /**
             * @params1 交换机  @Params2 队列名 路由key @Params3，消息的状态控制 @Params4 消息内容（主题）
             * 面试题:可以存在没有交换机的队列吗？ 不可能存在的；虽然没有指定交换机但是一定会存在一个默认的交换机
             */
            //定义交换机
            String exchangeName = "fanout_exchanage";
            //定义routingkey
            String routingKey = "";
            channel.basicPublish(exchangeName,routingKey, null,message.getBytes());
            System.out.println("消息发送成功");

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
