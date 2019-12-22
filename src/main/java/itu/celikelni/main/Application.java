package itu.celikelni.main;

import itu.celikelni.ipc.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/*
 *Reference: http://candidjava.com/tutorial/spring-boot-rabbitmq-example-using-maven/
 */

@SpringBootApplication
@ComponentScan(basePackages = {"itu.celikelni.ipc"})
public class Application implements CommandLineRunner {

    @Autowired
    private Server server;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("MAIN CLASS of SERVER PROCESS HAS BEEN STARTED.");
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
