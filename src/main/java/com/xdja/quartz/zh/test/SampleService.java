package com.xdja.quartz.zh.test;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by david on 2015-01-20.
 */
@Service
@Slf4j
public class SampleService {

    private static int a = 0;

    public void hello() {
        a++;
        log.info("我的第"+a+"次打印 -- Hello World!");
    }
}
