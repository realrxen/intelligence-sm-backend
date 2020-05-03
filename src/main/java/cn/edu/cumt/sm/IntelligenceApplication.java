package cn.edu.cumt.sm;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.edu.cumt.sm.dao")
public class IntelligenceApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntelligenceApplication.class, args);
    }

}
