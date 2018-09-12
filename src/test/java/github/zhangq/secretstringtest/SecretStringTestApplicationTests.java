package github.zhangq.secretstringtest;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author zhangqiuyang
 * Created on 2018/8/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SecretStringTestApplicationTests {

    @Autowired
    protected WebApplicationContext context;

    protected MockMvc mockMvc;

    @Before
    public void setUp() {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(context);
        mockMvc = builder.build();
    }

    @Test
    public void test() throws Exception {
        String url = "/test";
        JSONObject args = new JSONObject();
        args.put("normal", "normal");
        args.put("secret", "secret");

        ResultActions actions = mockMvc.perform(
                post(url).contentType(MediaType.APPLICATION_JSON_UTF8).content(args.toString()).accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk())
                .andExpect(content().string("normal || terces"));
    }
}
