package com.jbr.backend.config;

import com.jbr.backend.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

//实现动态定时任务
@Component
@EnableScheduling
public class MyDynamicTask implements SchedulingConfigurer {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private static final String DEFAULT_CRON = "0/30 * * * * ?";
    private String cron = DEFAULT_CRON;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(new Runnable() {
            @Override
            public void run() {
                // 定时任务的业务逻辑
                System.out.println("动态Crawler，当前时间：" + dateFormat.format(new Date()));
            }
        }, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                // 定时任务触发，可修改定时任务的执行周期
                CronTrigger trigger = new CronTrigger(cron);
                Date nextExecDate = trigger.nextExecutionTime(triggerContext);
                return nextExecDate;
            }
        });
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

}
