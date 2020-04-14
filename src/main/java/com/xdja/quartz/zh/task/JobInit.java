package com.xdja.quartz.zh.task;


import com.xdja.quartz.zh.service.JobInitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobInit {

	private static final Logger LOGGER = LoggerFactory.getLogger(JobInit.class);


	@Autowired
	private JobInitService jobInitService;


	public void init() {
		try {
			LOGGER.info("开始初始化job");
			schedulerRefreshExportJob();
		} catch (Exception e) {
			LOGGER.error("初始化异常");
		}
	}

	private void schedulerRefreshExportJob() {
		jobInitService.doInitJob("*/5 * * * *  ?", "refreshExportJob", "refreshExportJob", SyncPamsJob.class);
	}

}
