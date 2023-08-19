package com.example.activitilearn.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.delegate.Expression;

import javax.annotation.Resource;
import java.util.Date;

public class ProcListener implements ExecutionListener {
    @Resource
    private Expression noticeType;

    @Override
    public void notify(DelegateExecution execution) {
        /*一般用于统计执行时长*/
        System.out.println("Event: " + execution.getEventName());
        System.out.println("ProcessDefinitionId: " + execution.getProcessDefinitionId());
        if ("start".equals(execution.getEventName())) {
            System.out.println("StartTime: " + new Date());
        } else if ("end".equals(execution.getEventName())) {
            System.out.println("EndTime: " + new Date());
        }
        System.out.println("noticeType: " + noticeType.getValue(execution).toString());
    }
}
