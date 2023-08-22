package br.com.kanban.service;

import br.com.kanban.model.Filter;
import br.com.kanban.model.StatusTask;
import br.com.kanban.model.Task;
import br.com.kanban.repository.TaskRepository;

import java.sql.SQLException;
import java.util.List;

public class TaskService {

    private TaskRepository taskRepository;
    public TaskService(){
        taskRepository = new TaskRepository();
    }
    public void createTask(Task task) throws SQLException {
        taskRepository.insertTask(task);
    }

    public List<Task> listAllTasks() throws SQLException {
        return taskRepository.listAllTasks();
    }

    public List<Task> listTask(Filter filter) throws SQLException {
        return taskRepository.listTaskByFilter(filter);
    }



    public Task getTaskById(Integer id) {
        return taskRepository.getTaskById(id);
    }

    public void changeTaskStatus(Task task, StatusTask newStaus) throws SQLException {
        taskRepository.changeTaskStatus(task,newStaus);
    }
}

