package nz.co.spark.flowable.workflow.poc.controller;

import nz.co.spark.flowable.workflow.poc.domain.HolidayRequestProcess;
import nz.co.spark.flowable.workflow.poc.domain.TaskInfo;
import nz.co.spark.flowable.workflow.poc.service.impl.HolidayRequestServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flowable/holidayRequest")
public class HolidayRequestController
{

    @Autowired
    private HolidayRequestServiceImpl holidayRequestService;

    @GetMapping(value = {"/hello"})
    public String hello(@RequestParam(value = "name") final String name)
    {
        return holidayRequestService.hello(name);
    }

    @PostMapping(value = {"/processes"})
    public HolidayRequestProcess createProcess(@RequestBody final HolidayRequestProcess process)
    {
        final HolidayRequestProcess holidayRequestProcess = holidayRequestService.createHolidayRequestProcess(process);

        return holidayRequestProcess;
    }

    @DeleteMapping(value = {"/processes/{pid}"})
    public void deleteProcess(@PathVariable final String pid)
    {
        holidayRequestService.deleteProcessByProcessInstanceId(pid);
    }

    @GetMapping(value = {"/processes/all"})
    public List<HolidayRequestProcess> getAllProcesses()
    {
        final List<HolidayRequestProcess> holidayRequestProcesses = holidayRequestService.getAllProcesses();

        return holidayRequestProcesses;
    }

    @GetMapping(value = {"/processes/running"})
    public List<HolidayRequestProcess> getRunningProcesses()
    {
        final List<HolidayRequestProcess> holidayRequestProcesses = holidayRequestService.getRunningProcesses();

        return holidayRequestProcesses;
    }

    @GetMapping(value = {"/processes/finished"})
    public List<HolidayRequestProcess> getFinishedProcesses()
    {
        final List<HolidayRequestProcess> holidayRequestProcesses = holidayRequestService.getFinishedProcesses();

        return holidayRequestProcesses;
    }

    @GetMapping(value = {"/processes/definitionKey"})
    public List<HolidayRequestProcess> getProcessesByProcessDefinitionKey(@RequestParam("processDefinitionKey") final String processDefinitionKey)
    {
        final List<HolidayRequestProcess> holidayRequestProcesses = holidayRequestService.getProcessesByProcessDefinitionKey(processDefinitionKey);

        return holidayRequestProcesses;
    }

    @GetMapping(value = {"/processes/instanceId"})
    public List<HolidayRequestProcess> getProcessesByProcessInstanceId(@RequestParam("processInstanceId") final String processInstanceId)
    {
        final List<HolidayRequestProcess> holidayRequestProcesses = holidayRequestService.getProcessesByProcessInstanceId(processInstanceId);

        return holidayRequestProcesses;
    }

    @GetMapping(value = {"/processes/starter"})
    public List<HolidayRequestProcess> getProcessesByStarter(@RequestParam("starter") final String starter)
    {
        final List<HolidayRequestProcess> holidayRequestProcesses = holidayRequestService.getProcessesByStarter(starter);

        return holidayRequestProcesses;
    }

    @GetMapping(value = {"/{pid}/tasks"})
    public List<TaskInfo> getTasksInProcess(@PathVariable final String pid)
    {
        final List<TaskInfo> tasks = holidayRequestService.queryTasksInProcess(pid);

        return tasks;
    }

    @GetMapping(value = {"/tasks/assignee"})
    public List<TaskInfo> getTasksByAssignee(@RequestParam("assignee") final String assignee)
    {
        final List<TaskInfo> tasks = holidayRequestService.queryTasksByAssignee(assignee);

        return tasks;
    }

    @GetMapping(value = {"/tasks/group"})
    public List<TaskInfo> getTasksByCandidateGroup(@RequestParam("candidateGroup") final String candidateGroup)
    {
        final List<TaskInfo> tasks = holidayRequestService.queryTasksByCandidateGroup(candidateGroup);

        return tasks;
    }

    @GetMapping(value = {"/tasks/groups"})
    public List<TaskInfo> getTasksByCandidateGroups(@RequestParam("candidateGroups") final List<String> candidateGroups)
    {
        final List<TaskInfo> tasks = holidayRequestService.queryTasksByCandidateGroups(candidateGroups);

        return tasks;
    }

    @GetMapping(value = {"/tasks/taskId"})
    public List<TaskInfo> getTasksByTaskId(@RequestParam("taskId") final String taskId)
    {
        final List<TaskInfo> tasks = holidayRequestService.queryTasksByTaskID(taskId);

        return tasks;
    }

    @PostMapping(value = {"/tasks/{taskId}"})
    public void handleTask(@PathVariable final String taskId, @RequestParam final Boolean approve)
    {
        holidayRequestService.handleTask(taskId, approve);
    }

}
