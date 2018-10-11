package github.zhangq.secretstringtest.dao;

import github.zhangq.secretstringtest.entity.SomeEntity;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author zhangqiuyang
 * Created on 2018/10/11.
 */
@org.apache.ibatis.annotations.Mapper
@Repository
public interface SecretStringServiceDao extends Mapper<SomeEntity>, MySqlMapper<SomeEntity> {
    /**
     * save entity
     *
     * @param entity
     */
    void save(SomeEntity entity);
}
