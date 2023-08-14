package com.example.activitilearn;

import org.activiti.api.model.shared.model.VariableInstance;
import org.activiti.api.process.model.ProcessInstance;
import org.activiti.api.process.model.builders.ProcessPayloadBuilder;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProcessRuntimeTest {

    @Autowired
    private ProcessRuntime processRuntime;

    @Test
    public void getProcessInstance() {
        Page<ProcessInstance> processInstancePage = processRuntime.processInstances(Pageable.of(0, 10));
        for (ProcessInstance instance : processInstancePage.getContent()) {
            System.out.println("getId：" + instance.getId());
            System.out.println("getName：" + instance.getName());
            System.out.println("getStartDate：" + instance.getStartDate());
            System.out.println("getStatus：" + instance.getStatus());
            System.out.println("getProcessDefinitionId：" + instance.getProcessDefinitionId());
            System.out.println("getProcessDefinitionKey：" + instance.getProcessDefinitionKey());
        }
    }

    @Test
    public void initProcessInstanceWithArgs() {
        processRuntime.start(ProcessPayloadBuilder.start().withProcessDefinitionKey("id").withBusinessKey("businessKey").build());
    }


    @Test
    public void deleteProcessInstance() {
        processRuntime.delete(ProcessPayloadBuilder.delete().withProcessInstanceId("id").build());
    }

    @Test
    public void suspendProcessInstance() {
        processRuntime.suspend(ProcessPayloadBuilder.suspend().withProcessInstanceId("id").build());
    }

    @Test
    public void resumeProcessInstance() {
        processRuntime.resume(ProcessPayloadBuilder.resume().withProcessInstanceId("id").build());
    }

    @Test
    public void getVariables() {
        List<VariableInstance> list = processRuntime.variables(ProcessPayloadBuilder.variables().withProcessInstanceId("id").build());
        for (VariableInstance instance : list) {
            System.out.println("getName：" + instance.getName());
            System.out.println("getValue：" + instance.getValue());
            System.out.println("getTaskId：" + instance.getTaskId());
        }
    }
}
