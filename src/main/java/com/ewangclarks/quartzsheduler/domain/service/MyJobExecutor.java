package com.ewangclarks.quartzsheduler.domain.service;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class MyJobExecutor implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap jobDataMap = jobExecutionContext.getMergedJobDataMap();
        String jobId = (String) jobDataMap.get("jobID");
        log.info("Job Started-" + jobId + " at:" + new Date());
    }
}
