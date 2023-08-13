package com.example.activitilearn;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProcessInstanceTest {

    @Autowired
    private RuntimeService runtimeService;

    @Test
    public void initProcessInstance() {
        runtimeService.startProcessInstanceByKey("DeploymentTest", "businessKey");
    }

    @Test
    public void getProcessInstances() {
        List<ProcessInstance> list = runtimeService.createProcessInstanceQuery().list();
        for (ProcessInstance pi : list) {
            System.out.println("ProcessInstanceId：" + pi.getProcessInstanceId());
            System.out.println("ProcessDefinitionId：" + pi.getProcessDefinitionId());
            System.out.println("isEnded：" + pi.isEnded());
            System.out.println("isSuspended：" + pi.isSuspended());
        }
    }

    @Test
    public void suspendProcessInstance() {
        runtimeService.suspendProcessInstanceById("f7ed3ab3-39bf-11ee-8cca-1c697af4d14b");
    }

    @Test
    public void activateProcessInstance() {
        runtimeService.activateProcessInstanceById("f7ed3ab3-39bf-11ee-8cca-1c697af4d14b");
    }

    @Test
    public void delProcessInstance() {
        runtimeService.deleteProcessInstance("f7ed3ab3-39bf-11ee-8cca-1c697af4d14b", "delete");
    }
}
