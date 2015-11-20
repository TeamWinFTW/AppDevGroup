package ie.james;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import utility.FileParser;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class FrameWorksAss1Application {

    public static void main(String[] args) {

     List<Exhibit> exhibits=null;

        SpringApplication.run(FrameWorksAss1Application.class, args);
        ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("spring-config.xml");

        try {
            exhibits=new FileParser().parseFromJson("C:\\Users\\User\\Desktop\\Frameworks\\682506");

        } catch (IOException e) {
            e.printStackTrace();
        }
        for(Exhibit e: exhibits){

            DAOImpl daoImpl=context.getBean(DAOImpl.class);
            daoImpl.save(e);
        }
        System.out.println("Done");


        }





        }
