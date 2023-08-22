package br.com.kanban.repository;

import br.com.kanban.config.Database;
import br.com.kanban.model.Filter;
import br.com.kanban.model.StatusTask;
import br.com.kanban.model.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    private Database database = Database.getInstance();

    public void insertTask(Task task) throws SQLException {
        try {


            String query = "INSERT INTO TASK (taskName,taskStatus) VALUES (?,?)";
            database.open_connection();
            PreparedStatement preparedStatement = database.executeQuery(query);
            preparedStatement.setString(1,task.getName());
            preparedStatement.setString(2,task.getStatusTaskEnum().toString());

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Task cadastrada");

            preparedStatement.close();
            database.close_connection();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void changeTaskStatus(Task task,StatusTask newStatus) throws SQLException {
        try {


            String query = "UPDATE TASK SET taskStatus = (?) where idTask = (?)";
            database.open_connection();
            PreparedStatement preparedStatement = database.executeQuery(query);
            preparedStatement.setString(1,newStatus.toString());
            preparedStatement.setInt(2,task.getId());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected>0) //System.out.println("Task alterada");

            preparedStatement.close();
            database.close_connection();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



    public List<Task> listAllTasks() throws SQLException {
        try {

            String query = "SELECT * FROM TASK";
            database.open_connection();
            Statement statement = database.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            List<Task> taskList = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("idTask");
                String name = resultSet.getString("taskName");
                String status = resultSet.getString("taskStatus");
                Task task = new Task(id,name, StatusTask.convert(status));
                taskList.add(task);
            }

            statement.close();
            database.close_connection();

            return  taskList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }





    public List<Task> listTaskByFilter(Filter filter) throws SQLException {
        try {

            String query = "SELECT * FROM TASK";


            if(filter!=null){
                String order = "";
                if(filter == Filter.ALFABETICAMENTE) order = " order by  taskName asc";
                else if(filter == Filter.STATUS) order = " order by  taskStatus asc";
                query += order;
            }

            database.open_connection();
            Statement statement = database.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            List<Task> taskList = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("idTask");
                String name = resultSet.getString("taskName");
                String status = resultSet.getString("taskStatus");
                Task task = new Task(id,name, StatusTask.convert(status));
                taskList.add(task);
            }

            statement.close();
            database.close_connection();

            return  taskList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Task getTaskById(Integer id) {
        try {

            String query = "SELECT * FROM TASK where idTask = (?)";
            database.open_connection();
            PreparedStatement preparedStatement = database.executeQuery(query);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            Task task = new Task();
            while (resultSet.next()) {
                int idTask = resultSet.getInt("idTask");
                String name = resultSet.getString("taskName");
                String status = resultSet.getString("taskStatus");
                task = new Task(idTask,name, StatusTask.convert(status));

            }

            preparedStatement.close();
            database.close_connection();

            return  task;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
