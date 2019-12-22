package itu.celikelni.ipc;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class Server {

    static final Logger logger = LoggerFactory.getLogger(Server.class);

    @RabbitListener(queues = "${smoc.rabbitmq.queue}")
    public String process(Message msg) throws UnknownHostException {
        InetAddress localhost = InetAddress.getLocalHost();
        String ipAddr = localhost.getHostAddress();
        String hostname = localhost.getHostName();
        logger.info("Subscriber::process()");
        logger.info("Ip Addr of server  = {}",ipAddr);
        logger.info("Hostname of server = {}",hostname);
        logger.info("Message Received from client. Hostname of client={}, IP of client={}",msg.getHostname(),msg.getIpAddr());
        return "ACKNOWLEDGE";
    }


}
