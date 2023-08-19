package com.example.activitilearn.listener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class TkListener implements TaskListener {
    @Override
    public void notify(DelegateTask delegateTask) {
        /*一般用于消息提醒与动态修改环节执行人*/
        System.out.println("Assignee：" + delegateTask.getAssignee());
        delegateTask.setVariable("variables", "something");
    }
}
