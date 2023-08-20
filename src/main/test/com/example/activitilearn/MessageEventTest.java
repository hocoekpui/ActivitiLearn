package com.example.activitilearn;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.Execution;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MessageEventTest {

    @Autowired
    private RuntimeService runtimeService;

    @Test
    public void withdraw() {
        /*流程启动时将撤回节点编号和事件编号保存到变量中，为判断历史任务是否支持撤回提供参考*/
        Execution execution = runtimeService.createExecutionQuery().messageEventSubscriptionName("Message_36k29td").processInstanceId("e7bb88ee-3f1e-11ee-86b4-00ff50a6cd56").singleResult();
        runtimeService.messageEventReceived("Message_36k29td", execution.getId());
    }
}
