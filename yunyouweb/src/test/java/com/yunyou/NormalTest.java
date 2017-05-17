package com.yunyou;

import ch.qos.logback.core.rolling.helper.RenameUtil;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;
import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

import java.io.File;
import java.io.IOException;

/**
 * Created by lds on 2017/4/26.
 */
public class NormalTest {
    @Test
    public void test() throws IOException {
        String hashed = BCrypt.hashpw("654321",BCrypt.gensalt());
        System.out.println(hashed);
        System.out.println(BCrypt.hashpw("654321",hashed));
    }
}
