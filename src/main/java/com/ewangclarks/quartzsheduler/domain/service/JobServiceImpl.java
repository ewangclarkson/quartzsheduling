package com.ewangclarks.quartzsheduler.domain.service;

import com.ewangclarks.quartzsheduler.service.JobService;
import lombok.RequiredArgsConstructor;
import org.quartz.*;
import org.springframework.stereotype.Service;

import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;

@RequiredArgsConstructor
@Service
public class JobServiceImpl implements JobService {

    private final Scheduler scheduler;

    @Override
    public String startJob(String data) throws SchedulerException {
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("jobID", data);
            JobDetail job = newJob(MyJobExecutor.class)
                    .withIdentity("jobIdentity-1")
                    .usingJobData(jobDataMap)
                    .build();

            Trigger trigger = newTrigger()
                    .withIdentity("triggerIdentity-1")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInSeconds(60)
                            .withRepeatCount(10))
                    .build();
            scheduler.scheduleJob(job, trigger);
        return "Job scheduled successfully";
    }
}
