package github.zhangq.secretstringtest.entity;

import github.zhangq.secretstringtest.config.SecretString;
import lombok.Data;

/**
 * @author zhangqiuyang
 * Created on 2018/9/12.
 */
@Data
public class SomeEntity {
    private String normal;
    private SecretString secret;
}
