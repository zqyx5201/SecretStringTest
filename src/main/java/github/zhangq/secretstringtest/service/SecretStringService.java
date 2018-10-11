package github.zhangq.secretstringtest.service;


import github.zhangq.secretstringtest.entity.SomeEntity;

/**
 * @author zhangqiuyang
 * Created on 2018/9/26.
 */
public interface SecretStringService {
    /**
     * 保存
     *
     * @param entity
     */
    void save(SomeEntity entity);
}
