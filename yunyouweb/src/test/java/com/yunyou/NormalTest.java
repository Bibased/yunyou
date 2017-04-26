package com.yunyou;

import ch.qos.logback.core.rolling.helper.RenameUtil;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by lds on 2017/4/26.
 */
public class NormalTest {
    @Test
    public void test() throws IOException {
        File file = new File("F:\\workspace\\yunyou\\yunyouweb\\src\\main\\resources\\templates\\static\\img\\sp0.jpeg");
        double ratio = 1;
        if (file.length() > 640*320)
            ratio = 640.0*320/file.length();
        Thumbnails.of(file).scale(ratio).outputFormat("jpg").toFiles(Rename.PREFIX_DOT_THUMBNAIL);
    }
}
