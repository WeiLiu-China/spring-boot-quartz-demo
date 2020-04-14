package com.xdja.quartz.zh.task;

import com.xdja.quartz.zh.test.SampleService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yxb on  2018/10/10
 */
@Slf4j
public class SyncPamsJob implements Job {

	@Autowired
	private SampleService sampleService;

	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		log.debug("定时简单测试任务开始...");
		try {
			sampleService.hello();
			if (sampleService == null) {
				throw new Exception("获取sampleService对象失败");
			}
		} catch (Exception e) {
			log.error("同步简单测试任务失败:{}", e.getMessage(), e);
			return;
		}
		log.debug("定时简单测试任务结束...");
	}

}
