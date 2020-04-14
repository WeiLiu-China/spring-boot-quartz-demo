package com.xdja.quartz.zh.task;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AllInit implements InitializingBean {

	@Autowired
	private JobInit jobInit;

	@Override
	public void afterPropertiesSet() throws Exception {
		if (jobInit != null) {
			jobInit.init();
		}
	}

}
