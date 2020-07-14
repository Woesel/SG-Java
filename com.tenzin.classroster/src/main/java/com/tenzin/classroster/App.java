package com.tenzin.classroster;

import com.tenzin.classroster.controller.ClassRosterController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Tenzin Woesel May 10, 2020
 */
public class App {

    public static void main(String[] args) {
//        UserIO myIo = new UserIOConsoleImpl();
//        ClassRosterView myView = new ClassRosterView(myIo);
//        ClassRosterDao myDao = new ClassRosterDaoFileImpl();
//        ClassRosterAuditDao myAuditDao
//                = new ClassRosterAuditDaoFileImpl();
//        ClassRosterServiceLayer myService
//                = new ClassRosterServiceLayerImpl(myDao, myAuditDao);
//        ClassRosterController controller
//                = new ClassRosterController(myService, myView);
//        controller.run();

//        ApplicationContext ctx
//                = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ClassRosterController controller
//                = ctx.getBean("controller", ClassRosterController.class);
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.tenzin.classroster");
        appContext.refresh();
        ClassRosterController controller
                = appContext.getBean("classRosterController", ClassRosterController.class);
        controller.run();
    }

}
