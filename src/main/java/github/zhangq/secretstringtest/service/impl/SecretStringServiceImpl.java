package github.zhangq.secretstringtest.service.impl;

import github.zhangq.secretstringtest.dao.SecretStringServiceDao;
import github.zhangq.secretstringtest.entity.SomeEntity;
import github.zhangq.secretstringtest.service.SecretStringService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangqiuyang
 * Created on 2018/9/26.
 */
@Slf4j
@Service
public class SecretStringServiceImpl implements SecretStringService {
    private final SecretStringServiceDao dao;

    @Autowired
    public SecretStringServiceImpl(SecretStringServiceDao dao) {
        this.dao = dao;
    }


    @Override
    public void save(SomeEntity entity) {
        dao.save(entity);
    }
}
