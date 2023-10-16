package com.example.lab4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Главный класс приложения управления квартирами.
 */
public class ApartmentManagerApp extends Application {
    private Button cityButton;
    private Button suburbButton;
    private TextField streetField;
    private TextField costPerSquareMeterField;
    private TextField areaField;
    private TextField distanceToCenterField;
    private TextField floorCountField;
    private TextField floorNumberField;
    private Label resultLabel;

    /**
     * Точка входа в приложение.
     *
     * @param args Параметры командной строки.
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Apartment Manager");

        // Создание меню
        MenuBar menuBar = new MenuBar();
        Menu authorMenu = new Menu("Об авторе");
        MenuItem authorItem = new MenuItem("Автор: Ярослав Будюхин");
        authorMenu.getItems().add(authorItem);

        Menu fileMenu = new Menu("Файл");
        MenuItem exitItem = new MenuItem("Выход");
        exitItem.setOnAction(e -> System.exit(0));
        fileMenu.getItems().add(exitItem);

        menuBar.getMenus().addAll(authorMenu, fileMenu);

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().add(menuBar);

        cityButton = new Button("Квартира в центре");
        suburbButton = new Button("Квартира в пригороде");

        cityButton.setOnAction(e -> showCityFields());
        suburbButton.setOnAction(e -> showSuburbFields());

        root.getChildren().addAll(cityButton, suburbButton);

        Scene scene = new Scene(root, 1000, 500);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /**
     * Метод для отображения полей ввода при выборе квартиры в центре.
     */
    private void showCityFields() {
        cityButton.setVisible(false);
        suburbButton.setVisible(false);

        streetField = new TextField();
        streetField.setPromptText("Название улицы");

        costPerSquareMeterField = new TextField();
        costPerSquareMeterField.setPromptText("Стоимость 1 кв м");

        areaField = new TextField();
        areaField.setPromptText("Площадь");

        floorCountField = new TextField();
        floorCountField.setPromptText("Этажность дома");

        floorNumberField = new TextField();
        floorNumberField.setPromptText("Этаж");

        Button calculateButton = new Button("Рассчитать");
        calculateButton.setOnAction(e -> calculateCityApartmentCost());

        resultLabel = new Label("");

        VBox root = (VBox) cityButton.getParent();
        root.getChildren().addAll(streetField, costPerSquareMeterField, areaField, floorCountField, floorNumberField, calculateButton, resultLabel);
    }

    /**
     * Метод для отображения полей ввода при выборе квартиры в пригороде.
     */
    private void showSuburbFields() {
        cityButton.setVisible(false);
        suburbButton.setVisible(false);

        streetField = new TextField();
        streetField.setPromptText("Название улицы");

        costPerSquareMeterField = new TextField();
        costPerSquareMeterField.setPromptText("Стоимость 1 кв м");

        areaField = new TextField();
        areaField.setPromptText("Площадь");

        distanceToCenterField = new TextField();
        distanceToCenterField.setPromptText("Расстояние до центра");

        Button calculateButton = new Button("Рассчитать");
        calculateButton.setOnAction(e -> calculateSuburbApartmentCost());

        resultLabel = new Label("");

        VBox root = (VBox) suburbButton.getParent();
        root.getChildren().addAll(streetField, costPerSquareMeterField, areaField, distanceToCenterField, calculateButton, resultLabel);
    }

    private void calculateCityApartmentCost() {
        String street = streetField.getText();
        double costPerSquareMeter = Double.parseDouble(costPerSquareMeterField.getText());
        double area = Double.parseDouble(areaField.getText());
        int floorCount = Integer.parseInt(floorCountField.getText());
        int floorNumber = Integer.parseInt(floorNumberField.getText());

        Apartment DefaultApartment = new Apartment();
        ApartmentCenter cityProperty = new ApartmentCenter(floorNumber, floorCount);
        DefaultApartment.setAddress(street);
        DefaultApartment.setCost(costPerSquareMeter);
        DefaultApartment.setSize(area);

        double CostApartment = DefaultApartment.CountApartmentCost();
        double totalCost = cityProperty.CountApartmentCost(CostApartment);
        resultLabel.setText("Общая стоимость квартиры в центре: " + totalCost);
    }

    private void calculateSuburbApartmentCost() {
        String street = streetField.getText();
        double costPerSquareMeter = Double.parseDouble(costPerSquareMeterField.getText());
        double area = Double.parseDouble(areaField.getText());
        int distanceToCenter = Integer.parseInt(distanceToCenterField.getText());

        Apartment DefaultApartment = new Apartment();
        VillageApartment suburbProperty = new VillageApartment(distanceToCenter);
        DefaultApartment.setAddress(street);
        DefaultApartment.setCost(costPerSquareMeter);
        DefaultApartment.setSize(area);

        double CostApartment = DefaultApartment.CountApartmentCost();
        double totalCost = suburbProperty.CountApartmentCost(CostApartment);
        resultLabel.setText("Общая стоимость квартиры в пригороде: " + totalCost);
    }
}