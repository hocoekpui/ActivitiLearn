package com.example.activitilearn;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TaskTest {

    @Autowired
    private TaskService taskService;

    @Test
    public void getTasks() {
        List<Task> taskList = taskService.createTaskQuery().list();
        for (Task task : taskList) {
            System.out.println("Id：" + task.getId());
            System.out.println("Name：" + task.getName());
            System.out.println("Assignee：" + task.getAssignee());
        }
    }

    @Test
    public void getTasksByAssignee() {
        List<Task> list = taskService.createTaskQuery().taskAssignee("a").list();
        for (Task tk : list) {
            System.out.println("Id：" + tk.getId());
            System.out.println("Name：" + tk.getName());
            System.out.println("Assignee：" + tk.getAssignee());
        }
    }

    @Test
    public void completeTask() {
        taskService.complete("4869204a-39ca-11ee-91a7-1c697af4d14b");
    }

    @Test
    public void claimTask() {
        taskService.claim("4869204a-39ca-11ee-91a7-1c697af4d14b", "b");
    }

    @Test
    public void setTaskAssignee() {
        /*归还*/
        taskService.setAssignee("4869204a-39ca-11ee-91a7-1c697af4d14b", "null");
        /*交办*/
        taskService.setAssignee("4869204a-39ca-11ee-91a7-1c697af4d14b", "a");
    }
}
