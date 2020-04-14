package com.xdja.quartz.zh.task;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class AllInit implements InitializingBean {
	private static final Logger LOGGER = LoggerFactory.getLogger(AllInit.class);

	@Autowired
	private JobInit jobInit;


	@Override
	public void afterPropertiesSet() throws Exception {
		if (jobInit != null) {
			jobInit.init();
		}
	}

}
