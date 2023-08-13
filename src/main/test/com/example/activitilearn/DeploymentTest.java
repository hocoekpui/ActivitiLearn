package com.example.activitilearn;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

@SpringBootTest
public class DeploymentTest {

    @Autowired
    private RepositoryService repositoryService;

    @Test
    public void initDeploymentBPMN() {
        String filename = "bpmn/deployment.bpmn";
        repositoryService.createDeployment().addClasspathResource(filename).deploy();
    }

    @Test
    public void initDeploymentZIP() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("bpmn/deployment.bpmn");
        if (inputStream != null) {
            ZipInputStream zip = new ZipInputStream(inputStream);
            repositoryService.createDeployment().addZipInputStream(zip).deploy();
        }
    }

    @Test
    public void getDeploymentInfo() {
        List<Deployment> list = repositoryService.createDeploymentQuery().list();
        for (Deployment deployment : list) {
            System.out.println("Id：" + deployment.getId());
            System.out.println("DeploymentTime：" + deployment.getDeploymentTime());
        }
    }
}
