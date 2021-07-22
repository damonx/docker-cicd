package nz.co.spark.flowable.workflow.poc.service.impl;

import nz.co.spark.flowable.workflow.poc.domain.Process;
import nz.co.spark.flowable.workflow.poc.domain.TaskInfo;
import nz.co.spark.flowable.workflow.poc.service.ProcessService;

import org.flowable.engine.HistoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.engine.runtime.ProcessInstanceBuilder;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProcessServiceImpl implements ProcessService
{
    @Autowired
    protected RuntimeService runtimeService;

    @Autowired
    protected TaskService taskService;

    @Autowired
    protected HistoryService historyService;

    @Override
    public String hello(final String name)
    {
        return "Hi, " + name;
    }

    protected Process convertBasicProcessInstance(final ProcessInstance processInstance, final Process process)
    {
        process.setExecutionId(processInstance.getId());
        process.setProcessDefinitionId(processInstance.getProcessDefinitionId());
        process.setProcessDefinitionName(processInstance.getProcessDefinitionName());
        process.setName(processInstance.getName());
        process.setProcessInstanceId(processInstance.getProcessInstanceId());
        process.setDescription(processInstance.getDescription());
        process.setStartTime(processInstance.getStartTime());
        process.setStartUser(processInstance.getStartUserId());
        process.setProcessDefinitionKey(processInstance.getProcessDefinitionKey());

        return process;
    }

    @Override
    public ProcessInstanceBuilder createProcess(final Process process)
    {
        final ProcessInstanceBuilder processInstanceBuilder = runtimeService.createProcessInstanceBuilder()
            .processDefinitionKey(process.getProcessDefinitionKey());

        return processInstanceBuilder;
    }

    @Override
    public void deleteProcessByProcessInstanceId(final String processInstanceId)
    {
        runtimeService.deleteProcessInstance(processInstanceId, "");
    }

    @Override
    public List<ProcessInstance> queryProcessesByProcessDefinitionKey(final String processDefinitionKey)
    {
        return runtimeService.createProcessInstanceQuery()
            .processDefinitionKey(processDefinitionKey)
            .list();
    }

    @Override
    public List<ProcessInstance> queryProcessesByProcessInstanceId(final String processInstanceId)
    {
        return runtimeService.createProcessInstanceQuery()
            .processInstanceId(processInstanceId)
            .list();
    }

    @Override
    public List<ProcessInstance> queryProcessesByStarter(final String starter)
    {
        return runtimeService.createProcessInstanceQuery()
            .startedBy(starter)
            .list();
    }

    @Override
    public List<ProcessInstance> queryRunningProcesses()
    {
        return runtimeService.createProcessInstanceQuery()
            .list();
    }

    protected Process convertBasicHistoricProcessInstance(final HistoricProcessInstance historicProcessInstance, final Process process)
    {

        process.setExecutionId(historicProcessInstance.getId());
        process.setProcessDefinitionId(historicProcessInstance.getProcessDefinitionId());
        process.setProcessDefinitionName(historicProcessInstance.getProcessDefinitionName());
        process.setName(historicProcessInstance.getName());
        process.setProcessInstanceId(historicProcessInstance.getSuperProcessInstanceId());
        process.setDescription(historicProcessInstance.getDescription());
        process.setStartTime(historicProcessInstance.getStartTime());
        process.setStartUser(historicProcessInstance.getStartUserId());
        process.setProcessDefinitionKey(historicProcessInstance.getProcessDefinitionKey());

        return process;
    }

    @Override
    public List<HistoricProcessInstance> queryFinishedProcesses()
    {
        return historyService.createHistoricProcessInstanceQuery()
            .finished()
            .list();
    }

    private TaskInfo convertTask(final Task task)
    {
        final TaskInfo taskInfo = new TaskInfo();

        taskInfo.setId(task.getId());
        taskInfo.setName(task.getName());
        taskInfo.setDescription(task.getDescription());
        taskInfo.setAssignee(task.getAssignee());
        taskInfo.setExecutionId(task.getExecutionId());
        taskInfo.setProcessInstanceId(task.getProcessInstanceId());
        taskInfo.setProcessDefinitionId(task.getProcessDefinitionId());
        taskInfo.setTaskDefinitionId(task.getTaskDefinitionId());
        taskInfo.setTaskDefinitionKey(task.getTaskDefinitionKey());
        taskInfo.setPriority(task.getPriority());
        taskInfo.setCreateTime(task.getCreateTime());

        return taskInfo;
    }

    @Override
    public List<TaskInfo> queryTasksInProcess(final String pid)
    {
        return taskService.createTaskQuery()
            .processInstanceId(pid)
            .orderByTaskCreateTime()
            .desc()
            .list()
            .stream()
            .map(t -> convertTask(t))
            .collect(Collectors.toList());
    }

    @Override
    public List<TaskInfo> queryTasksByAssignee(final String assignee)
    {
        return taskService.createTaskQuery()
            .taskAssignee(assignee)
            .orderByTaskCreateTime()
            .desc()
            .list()
            .stream()
            .map(t -> convertTask(t))
            .collect(Collectors.toList());
    }

    @Override
    public List<TaskInfo> queryTasksByCandidateGroup(final String candidateGroup)
    {
        return taskService.createTaskQuery()
            .taskCandidateGroup(candidateGroup)
            .orderByTaskCreateTime()
            .desc()
            .list()
            .stream()
            .map(t -> convertTask(t))
            .collect(Collectors.toList());
    }

    @Override
    public List<TaskInfo> queryTasksByCandidateGroups(final List<String> candidateGroups)
    {
        return taskService.createTaskQuery()
            .taskCandidateGroupIn(candidateGroups)
            .orderByTaskCreateTime()
            .desc()
            .list()
            .stream()
            .map(t -> convertTask(t))
            .collect(Collectors.toList());
    }

    @Override
    public List<TaskInfo> queryTasksByTaskID(final String taskId)
    {
        return taskService.createTaskQuery()
            .taskId(taskId)
            .orderByTaskCreateTime()
            .desc()
            .list()
            .stream()
            .map(t -> convertTask(t))
            .collect(Collectors.toList());
    }

    @Override
    public void handleTask(final String taskId, final Boolean approve)
    {
        final Task task = taskService.createTaskQuery()
            .taskId(taskId)
            .singleResult();

        if (task == null) {
            throw new RuntimeException("There is no task.");
        }

        final HashMap<String, Object> map = new HashMap<>();
        map.put("approved", approve);
        taskService.complete(taskId, map);
    }
}
