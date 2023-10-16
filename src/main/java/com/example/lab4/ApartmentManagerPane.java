package com.example.lab4;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

/**
 * Пользовательский элемент управления (панель) для отображения информации о квартирах.
 */
public class ApartmentManagerPane extends VBox {
    private TextField streetField;
    private TextField costPerSquareMeterField;
    private TextField areaField;
    private RadioButton centerRadioButton;
    private RadioButton suburbRadioButton;
    private TextField floorNumberField;
    private TextField totalFloorsField;
    private TextField distanceToCenterField;
    private Button calculateButton;
    private Label resultLabel;

    /**
     * Конструктор класса. Инициализирует и отображает информацию о квартирах.
     */
    public ApartmentManagerPane() {
        setPadding(new Insets(10));
        setSpacing(10);

        streetField = new TextField();
        streetField.setPromptText("Название улицы");

        costPerSquareMeterField = new TextField();
        costPerSquareMeterField.setPromptText("Стоимость 1 кв. м");

        areaField = new TextField();
        areaField.setPromptText("Площадь");

        centerRadioButton = new RadioButton("Квартира в центре");
        suburbRadioButton = new RadioButton("Квартира в пригороде");

        ToggleGroup group = new ToggleGroup();
        centerRadioButton.setToggleGroup(group);
        suburbRadioButton.setToggleGroup(group);

        floorNumberField = new TextField();
        floorNumberField.setPromptText("Этаж");

        totalFloorsField = new TextField();
        totalFloorsField.setPromptText("Всего этажей");

        distanceToCenterField = new TextField();
        distanceToCenterField.setPromptText("Расстояние до центра");

        calculateButton = new Button("Рассчитать стоимость");
        calculateButton.setOnAction(e -> calculateCost());

        resultLabel = new Label();

        // Добавление элементов на панель
        getChildren().addAll(streetField, costPerSquareMeterField, areaField, centerRadioButton, suburbRadioButton,
                floorNumberField, totalFloorsField, distanceToCenterField, calculateButton, resultLabel);

        // Слушатель для изменения интерфейса в зависимости от выбора пользователя
        group.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            RadioButton selectedRadioButton = (RadioButton) newValue;

            if (selectedRadioButton == centerRadioButton) {
                getChildren().remove(distanceToCenterField);
                if (!getChildren().contains(floorNumberField)) {
                    getChildren().addAll(floorNumberField, totalFloorsField);
                }
            } else if (selectedRadioButton == suburbRadioButton) {
                getChildren().removeAll(floorNumberField, totalFloorsField);
                if (!getChildren().contains(distanceToCenterField)) {
                    getChildren().add(distanceToCenterField);
                }
            }
        });
    }

    private void calculateCost() {
        String street = streetField.getText();
        double costPerSquareMeter = Double.parseDouble(costPerSquareMeterField.getText());
        double area = Double.parseDouble(areaField.getText());

        Apartment property;

        if (centerRadioButton.isSelected()) {
            property = new ApartmentCenter();
            String floorNumberText = floorNumberField.getText();
            String totalFloorsText = totalFloorsField.getText();

            if (!floorNumberText.isEmpty() && !totalFloorsText.isEmpty()) {
                ((ApartmentCenter) property).setFloorNumber(Integer.parseInt(floorNumberText));
                ((ApartmentCenter) property).setFloorCount(Integer.parseInt(totalFloorsText));
            } else {
                // Handle the case where floorNumber or totalFloors is empty
                // You can show an error message or take appropriate action
                return;
            }
        } else if (suburbRadioButton.isSelected()) {
            property = new VillageApartment();
            String distanceToCenterText = distanceToCenterField.getText();

            if (!distanceToCenterText.isEmpty()) {
                ((VillageApartment) property).setR(Integer.parseInt(distanceToCenterText));
            } else {
                // Handle the case where distanceToCenter is empty
                // You can show an error message or take appropriate action
                return;
            }
        } else {
            property = new Apartment();
        }

        property.setAddress(street);
        property.setCost(costPerSquareMeter);
        property.setSize(area);

        double totalCost = property.CountApartmentCost();
        resultLabel.setText("Общая стоимость квартиры: " + totalCost);
    }
}