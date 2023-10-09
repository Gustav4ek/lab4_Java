package com.example.lab4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Главный класс приложения для управления квартирами с графическим интерфейсом JavaFX.
 */
public class ApartmentManagerApp extends Application {
    /**
     * Точка входа в приложение. Запускает графический интерфейс.
     *
     * @param args Аргументы командной строки (не используются).
     */
    public static void main(String[] args) {
        launch(args);
    }
    /**
     * Метод, который будет вызван при запуске приложения. Инициализирует основные элементы интерфейса.
     *
     * @param primaryStage Основная сцена приложения.
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Управление квартирами");

        // Создаем главное меню
        MenuBar menuBar = new MenuBar();
        Menu aboutMenu = new Menu("О программе");
        MenuItem aboutAuthorItem = new MenuItem("Об авторе");
        aboutAuthorItem.setOnAction(e -> showAboutAuthorDialog());
        MenuItem exitItem = new MenuItem("Выход");
        exitItem.setOnAction(e -> primaryStage.close());
        aboutMenu.getItems().addAll(aboutAuthorItem, exitItem);
        menuBar.getMenus().add(aboutMenu);

        // Создаем основной контент
        VBox mainLayout = new VBox();
        mainLayout.getChildren().addAll(menuBar, new ApartmentManagerPane());

        Scene scene = new Scene(mainLayout, 600, 400);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
    /**
     * Отображает диалоговое окно с информацией об авторе приложения.
     */
    private void showAboutAuthorDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Об авторе");
        alert.setHeaderText(null);
        alert.setContentText("Автор: Ярослав Будюхин\nДата: " + getCurrentDate());
        alert.showAndWait();
    }
    /**
     * Получает текущую дату и возвращает ее в виде строки.
     *
     * @return Строка с текущей датой.
     */
    private String getCurrentDate() {
        // Здесь можно использовать классы для работы с датой и временем
        return "09.10.2023";
    }
}