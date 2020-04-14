package com.xdja.quartz.zh.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by david on 2015-01-20.
 */
@Service
public class SampleService {

    static int a = 0;
    private static final Logger LOG = LoggerFactory.getLogger(SampleService.class);

    public void hello() {
        a++;
        LOG.info("我的第"+a+"次打印 -- Hello World!");
    }
}
