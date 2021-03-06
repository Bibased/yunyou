package com.yunyou;

import ch.qos.logback.core.rolling.helper.RenameUtil;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;
import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lds on 2017/4/26.
 */
public class NormalTest {
    @Test
    public void test() throws IOException {
        String hashed = BCrypt.hashpw("654321",BCrypt.gensalt());
        System.out.println(hashed);
        System.out.println(BCrypt.hashpw("654321",hashed));
        Lock lock = new ReentrantLock();
        lock.lock();;

    }

    public static void main(String[] args) {
        long t = System.currentTimeMillis();
        long m = 0;
        for (int i = 0; i<10000000;i++)
            m  = m+ 2*i/3+i*i;
        System.out.println(System.currentTimeMillis() - t);

    }
}
