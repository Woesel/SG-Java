package com.tenzin.dvd;

import com.tenzin.dvd.controller.DVDController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Tenzin Woesel May 17, 2020
 */
public class App {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DVDController controller
                = context.getBean("controller", DVDController.class);
        controller.run();

    }

}
