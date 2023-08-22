package br.com.kanban.config;

import java.sql.*;

public class Database {
    private static Database databaseInstance;
    private Connection connection;
    private PreparedStatement preparedStatement;
    public Database(){

    }

    //Singleton
    public static Database getInstance(){
        if(databaseInstance == null){
            databaseInstance = new Database();
        }
        return databaseInstance;
    }
    public void  open_connection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.connection =  DriverManager.getConnection(DatabaseConfigs.URL, DatabaseConfigs.USERNAME, DatabaseConfigs.PASSWORD);

    }

    public PreparedStatement  executeQuery(String query) throws SQLException {
        this.preparedStatement  = this.connection.prepareStatement(query);
        return this.preparedStatement;

    }

    public void  close_connection() throws SQLException {
        this.connection.close();
    }

    public Connection getConnection(){
        return this.connection;
    }
}
