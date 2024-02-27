package com.ewangclarks.quartzsheduler.controller;


import com.ewangclarks.quartzsheduler.service.JobService;
import lombok.RequiredArgsConstructor;
import org.quartz.SchedulerException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class SchedulerController {
    private final JobService jobService;

    @GetMapping("/public/schedule/{data}")
    private ResponseEntity<String> startScheduler(@PathVariable String data) throws SchedulerException {
        return ResponseEntity.ok(jobService.startJob(data));
    }


}
