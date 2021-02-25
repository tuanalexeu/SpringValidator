package alekseytyan;

import alekseytyan.config.AppConfig;
import alekseytyan.entity.Singer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// @SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        // SpringApplication.run(DemoApplication.class, args);
    }

    // @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        Singer singer = ctx.getBean("countrySinger", Singer.class);

        System.out.println(singer);
    }
}
