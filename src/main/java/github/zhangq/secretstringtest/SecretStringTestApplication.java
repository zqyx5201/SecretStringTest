package github.zhangq.secretstringtest;

import github.zhangq.secretstringtest.entity.SomeEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangqiuyang
 * Created on 2018/8/17.
 */
@SpringBootApplication
@RestController
public class SecretStringTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecretStringTestApplication.class, args);
    }

    @RequestMapping("/test")
    public ResponseEntity test(@RequestBody SomeEntity entity) {
        System.out.println("the request normal value is :" + entity.getNormal());
        System.out.println("the request secret value is :" + entity.getSecret().getValue());
        return
                ResponseEntity.ok(entity.getNormal() + " || " + entity.getSecret().getValue());
    }
}
