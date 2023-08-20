package com.example.activitilearn.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

import java.util.ArrayList;

public class MultiInstanceListener implements ExecutionListener {

    @Override
    public void notify(DelegateExecution execution) {
        ArrayList<String> assigneeList = new ArrayList<>();
        assigneeList.add("a");
        assigneeList.add("b");
        assigneeList.add("c");
        execution.setVariable("assigneeList", assigneeList);
    }
}
