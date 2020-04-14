package com.xdja.quartz.zh.task;


import com.xdja.quartz.zh.service.JobInitService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JobInit {

	@Autowired
	private JobInitService jobInitService;


	public void init() {
		try {
			log.info("开始初始化job");
			schedulerRefreshExportJob();
		} catch (Exception e) {
			log.error("初始化异常");
		}
	}

	private void schedulerRefreshExportJob() {
		jobInitService.doInitJob("*/5 * * * *  ?", "refreshExportJob", "refreshExportJob", SyncPamsJob.class);
	}

}
