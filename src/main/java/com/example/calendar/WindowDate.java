package com.example.calendar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;

public class WindowDate {
    public boolean changedate = true;
    public int month, year;
    @FXML
    private Button ButtonDone;

    @FXML
    private Button ButtonMonth1;

    @FXML
    private Button ButtonMonth2;

    @FXML
    private Button ButtonMonth3;

    @FXML
    private Button ButtonMonth4;

    @FXML
    private Button ButtonMonth5;

    @FXML
    private Button ButtonMonth6;

    @FXML
    private Button ButtonMonth7;

    @FXML
    private Button ButtonYear1;

    @FXML
    private Button ButtonYear2;

    @FXML
    private Button ButtonYear3;

    @FXML
    private Button ButtonYear4;

    @FXML
    private Button ButtonYear5;

    @FXML
    private Button ButtonYear6;

    @FXML
    private Button ButtonYear7;

    @FXML
    void ClickButtonDone(ActionEvent event) {
        ButtonDone.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("calendar-window.fxml"));
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
    void ClickButtonMonth1(ActionEvent event) {

        RenameButtonMonth();
    }

    @FXML
    void ClickButtonMonth2(ActionEvent event) {
        if(month - 1 <= 0) month += 12;
        HelloController.dateNow.setMonth(month - 1);
        RenameButtonMonth();
    }

    @FXML
    void ClickButtonMonth3(ActionEvent event) {
        if(month - 2 <= 0) month += 12;
        HelloController.dateNow.setMonth(month - 2);
        RenameButtonMonth();
    }

    @FXML
    void ClickButtonMonth4(ActionEvent event) {
        if(month - 3 <= 0) month += 12;
        HelloController.dateNow.setMonth(month - 3);
        RenameButtonMonth();
    }

    @FXML
    void ClickButtonMonth5(ActionEvent event) {
        if(month + 1 >= 12) month -= 12;
        HelloController.dateNow.setMonth(month + 1);
        RenameButtonMonth();
    }

    @FXML
    void ClickButtonMonth6(ActionEvent event) {
        if(month + 2 >= 12) month -= 12;
        HelloController.dateNow.setMonth(month + 2);
        RenameButtonMonth();
    }

    @FXML
    void ClickButtonMonth7(ActionEvent event) {
        if(month + 3 >= 12) month -= 12;
        HelloController.dateNow.setMonth(month + 3);
        RenameButtonMonth();
    }

    @FXML
    void ClickButtonYear1(ActionEvent event) {
        RenameButtonYear();
    }

    @FXML
    void ClickButtonYear2(ActionEvent event) {
        HelloController.dateNow.setYear(year - 1);
        RenameButtonYear();
    }

    @FXML
    void ClickButtonYear3(ActionEvent event) {
        HelloController.dateNow.setYear(year - 2);
        RenameButtonYear();
    }

    @FXML
    void ClickButtonYear4(ActionEvent event) {
        HelloController.dateNow.setYear(year - 3);
        RenameButtonYear();
    }

    @FXML
    void ClickButtonYear5(ActionEvent event) {
        HelloController.dateNow.setYear(year + 1);
        RenameButtonYear();
    }

    @FXML
    void ClickButtonYear6(ActionEvent event) {
        HelloController.dateNow.setYear(year + 2);
        RenameButtonYear();
    }

    @FXML
    void ClickButtonYear7(ActionEvent event) {
        HelloController.dateNow.setYear(year + 3);
        RenameButtonYear();
    }

    @FXML
    private void initialize() {
        isChangeDate();
        Locale loc = Locale.forLanguageTag("ru");
        month = HelloController.dateNow.getMonth();
        year = HelloController.dateNow.getYear();
        ButtonMonth1.setText(Month.of(month + 1).getDisplayName(TextStyle.FULL_STANDALONE, loc));
        if(month <= 0) month += 12;
        ButtonMonth2.setText(Month.of(month).getDisplayName(TextStyle.FULL_STANDALONE, loc));
        if(month - 1 <= 0) month += 12;
        ButtonMonth3.setText(Month.of(month - 1).getDisplayName(TextStyle.FULL_STANDALONE, loc));
        if(month - 2 <= 0) month += 12;
        ButtonMonth4.setText(Month.of(month - 2).getDisplayName(TextStyle.FULL_STANDALONE, loc));
        if(month + 2 >= 13) month -= 13;
        ButtonMonth5.setText(Month.of(month + 2).getDisplayName(TextStyle.FULL_STANDALONE, loc));
        if(month + 3 >= 13) month -= 13;
        ButtonMonth6.setText(Month.of(month + 3).getDisplayName(TextStyle.FULL_STANDALONE, loc));
        if(month + 4 >= 13) month -= 13;
        ButtonMonth7.setText(Month.of(month + 4).getDisplayName(TextStyle.FULL_STANDALONE, loc));

        ButtonYear1.setText(String.valueOf(year  + 1900 ));
        ButtonYear2.setText(String.valueOf(year  + 1900 - 1));
        ButtonYear3.setText(String.valueOf(year  + 1900 - 2));
        ButtonYear4.setText(String.valueOf(year  + 1900 - 3));
        ButtonYear5.setText(String.valueOf(year  + 1900 + 1));
        ButtonYear6.setText(String.valueOf(year  + 1900 + 2));
        ButtonYear7.setText(String.valueOf(year  + 1900 + 3));
    }

    public static boolean isChangeDate() {
        return false;
    }
    public void RenameButtonYear(){
        year = HelloController.dateNow.getYear();
        ButtonYear1.setText(String.valueOf(year  + 1900));
        ButtonYear2.setText(String.valueOf(year  + 1900 - 1));
        ButtonYear3.setText(String.valueOf(year  + 1900 - 2));
        ButtonYear4.setText(String.valueOf(year  + 1900 - 3));
        ButtonYear5.setText(String.valueOf(year  + 1900 + 1));
        ButtonYear6.setText(String.valueOf(year  + 1900 + 2));
        ButtonYear7.setText(String.valueOf(year  + 1900 + 3));
    }
    public void RenameButtonMonth(){
        Locale loc = Locale.forLanguageTag("ru");
        month = HelloController.dateNow.getMonth();

        ButtonMonth1.setText(Month.of(month + 1).getDisplayName(TextStyle.FULL_STANDALONE, loc));
        if(month <= 0) month += 12;
        ButtonMonth2.setText(Month.of(month).getDisplayName(TextStyle.FULL_STANDALONE, loc));
        if(month - 1 <= 0) month += 12;
        ButtonMonth3.setText(Month.of(month - 1).getDisplayName(TextStyle.FULL_STANDALONE, loc));
        if(month - 2 <= 0) month += 12;
        ButtonMonth4.setText(Month.of(month - 2).getDisplayName(TextStyle.FULL_STANDALONE, loc));
        if(month + 2 >= 13) month -= 12;
        ButtonMonth5.setText(Month.of(month + 2).getDisplayName(TextStyle.FULL_STANDALONE, loc));
        if(month + 3 >= 13) month -= 12;
        ButtonMonth6.setText(Month.of(month + 3).getDisplayName(TextStyle.FULL_STANDALONE, loc));
        if(month + 4 >= 13) month -= 12;
        ButtonMonth7.setText(Month.of(month + 4).getDisplayName(TextStyle.FULL_STANDALONE, loc));


    }
}


