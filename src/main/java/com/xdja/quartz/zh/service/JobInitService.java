package com.xdja.quartz.zh.service;


import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("jobInitService")
@Slf4j
public class JobInitService {

	@Resource
	private Scheduler scheduler;

	public <T extends Job> void doInitJob(String cron, String key, String group, Class<T> tClass) {

		try {

			log.info("开始初始化任务:{}, cron:{}, key:{}, group:{}", tClass.getName(), cron, key, group);
			JobKey jobKey = createJobKey(key, group);

			JobDetail jobDetail;
			if (scheduler.checkExists(jobKey)) {
				scheduler.deleteJob(jobKey);
			}

			jobDetail = JobBuilder.newJob(tClass).withIdentity(jobKey).build();

			TriggerKey triggerKey = createTriggerKey(key, group);
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerKey)
					.withSchedule(CronScheduleBuilder.cronSchedule(cron).withMisfireHandlingInstructionIgnoreMisfires())
					.startNow()
					.build();

			scheduler.scheduleJob(jobDetail, trigger);

		} catch (SchedulerException e) {

			log.error("初始化任务 [{}] 异常", tClass.getName(), e);
		}
	}

	private JobKey createJobKey(String key, String group) {
		return new JobKey(key, group);
	}

	private TriggerKey createTriggerKey(String key, String group) {
		return new TriggerKey(key, group);
	}

}
