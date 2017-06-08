package com.victornieto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by victor.nieto.castan on 08/06/2017.
 */
public class ProducerRunner implements CommandLineRunner {

    @Value("${client.duration:0}")
    private int duration ;

    @Autowired
    private ConfigurableApplicationContext ctx ;

    @Override
    public void run(String... arg0) throws Exception {
        System.out.println("Ready ... running for " + duration + " ms");
        Thread.sleep(duration);
        ctx.close();
    }
}
