import com.google.gson.Gson;
import org.junit.Test;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by lds on 2017/4/18.
 */
public class NormalTest {
    @Test
    public void testFileMake(){
        TestCls testCls = new Gson().fromJson("{\"content\":\"JUST \\\" TEST\"}",TestCls.class);
        System.out.println(testCls.getContent());
    }
    class TestCls{
        String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
