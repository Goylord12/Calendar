package com.example.calendar;

import java.sql.*;
public class CalendarDataBase extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
//        Class.forName("com.mysql.jdbc.Driver");
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        dbConnection = DriverManager.getConnection(connectionString, dbUser,dbPass);
        return dbConnection;

    }
    public void setEvent(Event event){

        String insert = "INSERT INTO eventtable (date, time, event) " + "VALUES (?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setDate(1,event.getDate());
            prSt.setString(2, event.getTime());
            prSt.setString(3, event.getEvent());
            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public ResultSet getEvent(Event event){
        ResultSet resSet = null;

        try {

            String select = "select * from public.\"Event\" where date =?";
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setDate(1,event.getDate());
            prSt.setString(2, event.getTime());
            prSt.setString(3, event.getEvent());

            resSet =  prSt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return resSet;
    }
}









