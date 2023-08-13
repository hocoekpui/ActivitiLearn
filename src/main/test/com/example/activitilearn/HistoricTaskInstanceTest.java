package com.example.activitilearn;

import org.activiti.engine.HistoryService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class HistoricTaskInstanceTest {
    @Autowired
    private HistoryService historyService;

    @Test
    public void HistoricTaskInstanceByUser() {
        List<HistoricTaskInstance> list = historyService.createHistoricTaskInstanceQuery().orderByHistoricTaskInstanceEndTime().asc().taskAssignee("a").list();
        for (HistoricTaskInstance hi : list) {
            System.out.println("Id：" + hi.getId());
            System.out.println("ProcessInstanceId：" + hi.getProcessInstanceId());
            System.out.println("Name：" + hi.getName());
        }
    }

    @Test
    public void HistoricTaskInstanceByPiID() {
        List<HistoricTaskInstance> list = historyService.createHistoricTaskInstanceQuery().orderByHistoricTaskInstanceEndTime().asc().processInstanceId("47eedc4f-39c9-11ee-91b3-1c697af4d14b").list();
        for (HistoricTaskInstance hi : list) {
            System.out.println("Id：" + hi.getId());
            System.out.println("Name：" + hi.getName());
        }
    }
}
