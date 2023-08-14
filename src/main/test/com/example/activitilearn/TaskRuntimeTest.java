package com.example.activitilearn;

import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.api.task.model.Task;
import org.activiti.api.task.model.builders.TaskPayloadBuilder;
import org.activiti.api.task.runtime.TaskRuntime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TaskRuntimeTest {

    @Autowired
    private TaskRuntime taskRuntime;

    @Test
    public void getTasks() {
        Page<Task> tasks = taskRuntime.tasks(Pageable.of(0, 100));
        for (Task task : tasks.getContent()) {
            System.out.println("Id：" + task.getId());
            System.out.println("Name：" + task.getName());
            System.out.println("getStatus：" + task.getAssignee());
            System.out.println("getCreatedDate：" + task.getAssignee());
            if (task.getAssignee() == null) {
                System.out.println("getAssignee：null");
            } else {
                System.out.println("getAssignee：" + task.getAssignee());
            }
        }
    }

    @Test
    public void completeTask() {
        Task task = taskRuntime.task("xx");
        if (task.getAssignee() == null) {
            taskRuntime.claim(TaskPayloadBuilder.claim().withTaskId("id").build());
        }
        taskRuntime.complete(TaskPayloadBuilder.complete().withTaskId("id").build());
    }
}
