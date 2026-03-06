package com.atmbanksimulator;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage window) {
        Bank bank = new Bank();

        
        bank.addBankAccount("10001", "11111", 100, Bank.AccountType.STANDARD);
        bank.addBankAccount("10002", "22222", 50, Bank.AccountType.STUDENT);

        UIModel UIModel = new UIModel(bank);
        View view = new View();
        Controller controller = new Controller();

        view.controller = controller;
        controller.UIModel = UIModel;
        UIModel.view = view;

        view.start(window);
        UIModel.initialise();
    }
}