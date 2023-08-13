package com.example.activitilearn;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class VariableTest {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Test
    public void initProcessInstanceWithArgs() {
        Map<String, Object> variables = new HashMap<>();
        variables.put("assignee1", "a");
        runtimeService.startProcessInstanceByKey("VariableTest", "businessKey", variables);
    }

    @Test
    public void completeTaskWithArgs() {
        Map<String, Object> variables = new HashMap<>();
        variables.put("assignee2", "b");
        taskService.complete("11b3d192-39cd-11ee-98c5-1c697af4d14b", variables);
    }

    @Test
    public void setGlobalVariables() {
        runtimeService.setVariable("11b271fc-39cd-11ee-98c5-1c697af4d14b", "global", "true");
    }

    @Test
    public void setLocalVariables() {
        taskService.setVariableLocal("287f6353-39cd-11ee-9d61-1c697af4d14b", "local", "true");
    }
}
