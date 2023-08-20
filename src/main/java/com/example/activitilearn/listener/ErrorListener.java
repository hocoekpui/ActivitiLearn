package com.example.activitilearn.listener;

import org.activiti.engine.delegate.BpmnError;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class ErrorListener implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) {
        /*错误事件应用场景不多，只要用于自动执行代码的错误处理*/
        throw new BpmnError("Error_1trdts1");
    }
}
