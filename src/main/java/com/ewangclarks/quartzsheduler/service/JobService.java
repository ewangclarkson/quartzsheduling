package com.ewangclarks.quartzsheduler.service;

import org.quartz.SchedulerException;

public interface JobService {
    String startJob(String data) throws SchedulerException;
}
