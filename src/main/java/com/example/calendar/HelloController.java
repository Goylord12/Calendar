package com.example.calendar;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static java.util.Calendar.DAY_OF_WEEK;
import static javax.swing.JOptionPane.*;

public class HelloController {

    public static boolean dateChanged = true;
    public SimpleDateFormat month, numberMonth, numberDay, numberDayWeek, year ,time, secondYear;
    public  java.util.Calendar calendar = java.util.Calendar.getInstance();
    public static Date dateNow = new Date();

    public Integer daysMonth;
    public Integer lastDaysMonth;
    public float mon;
    private ObservableList<Calendar> calendarData = FXCollections.observableArrayList();
    private ObservableList<Event> eventData = FXCollections.observableArrayList();
    public int dayOfWeek;

    @FXML
    private TableView<Calendar> Calendar;

    @FXML
    private TableView<Event> Event;

    @FXML
    private TableColumn<Event, String> EventColumn;

    @FXML
    private TableColumn<Event, String> TimeColumn;


    @FXML
    private TableColumn<Calendar, String> Friday;

    @FXML
    private TableColumn<Calendar, String> Monday;

    @FXML
    public  Button Month;

    @FXML
    private TableColumn<Calendar, String> Saturday;

    @FXML
    private TableColumn<Calendar, String> Sunday;

    @FXML
    private TableColumn<Calendar, String> Thursday;

    @FXML
    private TableColumn<Calendar, String> Tuesday;

    @FXML
    private TableColumn<Calendar, String> Wednesday;

    @FXML
    private Button Year;



    @FXML
    void ClickButtonMonth(ActionEvent event) {
        Month.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("calendar-date.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void ClickButtonYear(ActionEvent event) {

//        JOptionPane.showMessageDialog(null, Calendar.getSelectionModel().getSelectedItem().getMonday());
        Year.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("calendar-date.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    private void initialize() {

        Calendar.getSelectionModel().setCellSelectionEnabled(true);
        Calendar.setEditable(false);
//        Calendar.set;

        calendar.set(Integer.valueOf(year.format(dateNow)) , Integer.valueOf(month.format(dateNow)) - 1 , 1);
//        showMessageDialog(null, calendar.getFirstDayOfWeek());
        dayOfWeek = calendar.get(DAY_OF_WEEK);
        if(dateChanged){
            Month.setText(NameMonth(month.format(dateNow)));
            Year.setText(year.format(dateNow));
        }
        else {
            Month.setText(NameMonth(month.format(dateNow)));
            Year.setText(year.format(dateNow));
        }

        initData();
        // устанавливаем тип и значение которое должно хранится в колонке
        Monday.setCellValueFactory(new PropertyValueFactory<Calendar, String>("monday"));
        Tuesday.setCellValueFactory(new PropertyValueFactory<Calendar, String>("tuesday"));
        Wednesday.setCellValueFactory(new PropertyValueFactory<Calendar, String>("wednesday"));
        Thursday.setCellValueFactory(new PropertyValueFactory<Calendar, String>("thursday"));
        Friday.setCellValueFactory(new PropertyValueFactory<Calendar, String>("friday"));
        Saturday.setCellValueFactory(new PropertyValueFactory<Calendar, String>("saturday"));
        Sunday.setCellValueFactory(new PropertyValueFactory<Calendar, String>("sunday"));

        TimeColumn.setCellValueFactory(new PropertyValueFactory<Event, String>("time"));
        EventColumn.setCellValueFactory(new PropertyValueFactory<Event, String>("event"));

        // заполняем таблицу данными
        Calendar.setItems(calendarData);
        Event.setItems(eventData);
    }

    private void initData() {

        CalendarDataBase calendarDataBase = new CalendarDataBase();
        java.sql.Date date = new java.sql.Date(2023-11-11);
        com.example.calendar.Event event = new Event(date,"sdf", "sdf");
        calendarDataBase.setEvent(event);
        int c = 1;
//        JOptionPane.showMessageDialog(null, String.valueOf(dayOfWeek));
        List<String> nums = new ArrayList<>();
        if(dayOfWeek == 1) dayOfWeek = 8;
        for(int i = (lastDaysMonth + 1) - (dayOfWeek - 2); i <= lastDaysMonth + 1; i++){
            if(i == lastDaysMonth + 1 ) break;
            nums.add(String.valueOf(i));
        }
        for(int s = 1; s <= daysMonth + 1; s++){
            if(s == daysMonth + 1 ) break;
            nums.add(String.valueOf(s));


        }
        while(nums.size() % 7 != 0){

            nums.add(String.valueOf(c));
            c++;
        }

        for(int z = 0; z <= nums.size() - 1; z += 7){
            calendarData.add(new Calendar(nums.get(z), nums.get(z + 1), nums.get(z + 2), nums.get(z + 3), nums.get(z + 4), nums.get(z + 5), nums.get(z + 6)));
        }
//        int nums[] = new int[daysMonth + x];
//        for(int i = daysMonth; x != 0; x--){
////            chyslo.ad;
////        }
//        JOptionPane.showMessageDialog(null, x);
//        calendarData.add(new Calendar("1", "2", "3", "4", "5", "6", "7"));
//        calendarData.add(new Calendar("8", "9", "10", "11", "12", "13", "14"));
//        calendarData.add(new Calendar("15", "16", "17", "18", "19", "20", "21"));
//        calendarData.add(new Calendar("22", "23", "24", "25", "26", "27", "28"));
//        calendarData.add(new Calendar("29", "30", "31", "1", "2", "3", "4"));
    }

    public String NameMonth(String month){
        switch (month){
            case "1":
                lastDaysMonth = 31;
                daysMonth = 31;
                mon = 11;
                return "Январь";
            case "2":
                lastDaysMonth = 31;
                if(Integer.valueOf( secondYear.format(dateNow)) % 4 == 0){
                    daysMonth = 29;
                }
                else{
                    daysMonth = 28;
                }

                mon = 12;
                return "Февраль";
            case "3":
                lastDaysMonth = 28;
                daysMonth = 31;
                mon = 1;
                return "Март";
            case "4":
                lastDaysMonth = 31;
                daysMonth = 31;
                mon = 2;
                return "Апрель";
            case "5":
                lastDaysMonth = 31;
                daysMonth = 31;
                mon = 3;
                return "Май";
            case "6":
                lastDaysMonth = 31;
                daysMonth = 30;
                mon = 4;
                return "Июнь";
            case "7":
                lastDaysMonth = 30;
                daysMonth = 31;
                mon = 5;
                return "Июль";
            case "8":
                lastDaysMonth = 31;
                daysMonth = 31;
                mon = 6;
                return "Август";
            case "9":
                lastDaysMonth = 31;
                daysMonth = 30;
                mon = 7;
                return "Сентябрь";
            case "10":
                lastDaysMonth = 30;
                daysMonth = 31;
                mon = 8;
                return "Октябрь";
            case "11":
                lastDaysMonth = 31;
                daysMonth = 30;
                mon = 9;
                return "Ноябрь";
            case "12":
                lastDaysMonth = 30;
                daysMonth = 31;
                mon = 10;
                return "Декабрь";

        }
        return month;
    }

    public HelloController(){

        month = new SimpleDateFormat("M");
        numberMonth = new SimpleDateFormat("d");
        numberDay = new SimpleDateFormat("E");
        numberDayWeek = new SimpleDateFormat("F");
        year = new SimpleDateFormat("yyyy");
        secondYear = new SimpleDateFormat("yy");
        time = new SimpleDateFormat("HH.mm");

    }

    public static int getDayNumberNew(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day.getValue();
    }
}