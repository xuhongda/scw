import com.xu.scw.listener.ActivitiListenner;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.event.ActivitiEventType;
import org.activiti.engine.repository.*;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @authorxuhongda on 2017/12/13
 * PACKAGE_NAME
 * scw-parent
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-activiti-config.xml"})
public class ActivitiTest {
    @Autowired
    private ProcessEngine processEngine;
    @Test
    public void test(){
        System.out.println(processEngine);
    }

    /**
     * 把流程文件保存到数据库中
     */
    @Test
    public void deploy(){
        if (processEngine != null){
            System.out.println(processEngine==null?"------------------------":"=====================");
            RepositoryService repositoryService = processEngine.getRepositoryService();
            if(repositoryService != null){
                System.out.println("com");
                Deployment deploy = repositoryService
                        .createDeployment()
                        .addClasspathResource("大军就是.bpmn")
                        .deploy();

                System.out.println(deploy.getId());
            }

        }

    }

    /**
     * repositoryService
     */
    @Test
    public void testQuery(){
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //create 什么表
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        System.out.println(processDefinitionQuery.processDefinitionKey("myProcess:5:17504").singleResult());

        DeploymentQuery deploymentQuery = repositoryService.createDeploymentQuery();
        Deployment deployment = deploymentQuery.deploymentId("1").singleResult();
        System.out.println(deployment.getId());
        //
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().list();
        System.out.println(list);
    }

    /**
     * testRuntimeService
     */
    @Test
    public void testRuntimeService(){
        RuntimeService runtimeService = processEngine.getRuntimeService();
        ActivitiListenner activitiListenner = new ActivitiListenner();

        //启动一个流程，一个流程定义可以有无数流程实例，他们是无状态的
        runtimeService.startProcessInstanceById
                (processEngine.getRepositoryService().createProcessDefinitionQuery().
                        processDefinitionKey("myProcess").latestVersion().singleResult().getId());

        //监听的事件类型
        ActivitiEventType jobExecutionSuccess = ActivitiEventType.JOB_EXECUTION_SUCCESS;
        ActivitiEventType activityStarted = ActivitiEventType.ACTIVITY_STARTED;
        ActivitiEventType activitySignaled = ActivitiEventType.ACTIVITY_SIGNALED;
       // runtimeService.addEventListener(activitiListenner);
        runtimeService.addEventListener(activitiListenner,jobExecutionSuccess,activitySignaled,activityStarted);

    }

    @Test
    public void testR2(){
        TaskService taskService = processEngine.getTaskService();
        TaskQuery taskQuery = taskService.createTaskQuery();
        List<Task> list = taskQuery.processInstanceId("5001").list();
        for(Task task:list){
            System.out.println(task==null?"==============":task);
            taskService.claim(task.getId(),"xx");
            taskService.complete(task.getId());
        }
    }

}
