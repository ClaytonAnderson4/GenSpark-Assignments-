package org.genspark;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {


        ApplicationContext context1 = new ClassPathXmlApplicationContext("Spring.xml");
        Student stu = (Student) context1.getBean("Student");
        System.out.println(stu);

        ApplicationContext context2 = new AnnotationConfigApplicationContext(AppConfig.class);
        Student stu2 = (Student) context2.getBean(Student.class);
        System.out.println(stu2);



    }
}
