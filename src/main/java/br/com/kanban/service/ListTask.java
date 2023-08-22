package br.com.kanban.service;

import br.com.kanban.model.Filter;
import br.com.kanban.model.StatusTask;
import br.com.kanban.model.Task;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListTask {

    public static void list(TaskService taskService, Scanner in) throws SQLException {


        System.out.println(" 1 - " + Filter.ALFABETICAMENTE.getDescricao());
        System.out.println(" 2 - "  + Filter.STATUS.getDescricao());
        System.out.println(" 3 - " + Filter.SEM.getDescricao());
        String filtro = in.nextLine();
        List<Task> taskList = new ArrayList<>();
        switch (filtro){
            case "1":
                taskList = taskService.listTask(Filter.ALFABETICAMENTE);
                System.out.println(taskList);
                break;
            case "2":
                taskList = taskService.listTask(Filter.STATUS);
                System.out.println(taskList);
                break;
            case "3":
               taskList = taskService.listAllTasks();
                System.out.println(taskList);
                break;
        }


    }
}
