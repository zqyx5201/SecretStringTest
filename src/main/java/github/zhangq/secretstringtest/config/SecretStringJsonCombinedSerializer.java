package github.zhangq.secretstringtest.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.node.TextNode;
import java.io.IOException;
import org.springframework.boot.jackson.JsonComponent;

/**
 * @author zhangqiuyang
 * Created on 2018/8/17.
 */
@JsonComponent
public class SecretStringJsonCombinedSerializer {


    /**
     * 密文序列化
     */
    public static class SecretStringJsonSerializer extends JsonSerializer<SecretString> {
        /**
         * 重写序列化SecretString类型字段
         *
         * @param secretString
         * @param jsonGenerator
         * @param serializerProvider
         * @throws IOException
         */
        @Override
        public void serialize(SecretString secretString, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
                throws IOException {

            jsonGenerator.writeString(secretString.decryptValue());
        }
    }

    /**
     * 密文反序列化
     */
    public static class SecretStringJsonDeserializer extends JsonDeserializer<SecretString> {

        @Override
        public SecretString deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
                throws IOException {
            TreeNode treeNode = jsonParser.getCodec().readTree(jsonParser);
            return new SecretString(SecurityUtil.encryptString(((TextNode) treeNode).asText()));
        }
    }


}