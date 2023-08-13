package com.example.activitilearn;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProcessDefinitionTest {

    @Autowired
    private RepositoryService repositoryService;

    @Test
    public void getDefinitions() {
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().list();
        for (ProcessDefinition pd : list) {
            System.out.println("Name：" + pd.getName());
            System.out.println("Key：" + pd.getKey());
            System.out.println("ResourceName：" + pd.getResourceName());
            System.out.println("DeploymentId：" + pd.getDeploymentId());
            System.out.println("Version：" + pd.getVersion());
        }
    }

    @Test
    public void deleteDefinition() {
        String id = "d0b2e055-39bd-11ee-a91e-1c697af4d14b";
        repositoryService.deleteDeployment(id, true);
    }
}
