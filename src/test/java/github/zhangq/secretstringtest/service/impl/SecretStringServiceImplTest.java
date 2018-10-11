package github.zhangq.secretstringtest.service.impl;

import github.zhangq.secretstringtest.config.SecretString;
import github.zhangq.secretstringtest.entity.SomeEntity;
import github.zhangq.secretstringtest.service.SecretStringService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhangqiuyang
 * Created on 2018/10/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SecretStringServiceImplTest {

    @Autowired
    private SecretStringService secretStringService;

    @Test
    public void save() {
        SomeEntity entity = new SomeEntity();
        entity.setNormal("normal");
        entity.setSecret(new SecretString("secret"));
        secretStringService.save(entity);
    }
}