package com.example.activitilearn;

import org.activiti.engine.RuntimeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SignalCatchingEventTest {

    @Autowired
    private RuntimeService runtimeService;

    @Test
    public void start(){
        runtimeService.signalEventReceived("Signal_0urvt4n");
    }
}
