package com.example.lab4;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Пользовательский элемент управления (панель) для отображения информации о квартирах.
 */
public class ApartmentManagerPane extends VBox {
    /**
     * Конструктор класса. Инициализирует и отображает информацию о квартирах.
     */
    public ApartmentManagerPane() {
        setPadding(new Insets(10));
    // Создание объекта квартиры в центре
        Apartment centerApart = new Apartment("Ирининская", 24, 1348, 30);
        // Создание объекта квартиры в пригороде
        Apartment villageApart = new Apartment();
        // Создание копии объекта квартиры в центре
        Apartment copyCenterApart = new Apartment(centerApart);
        // Создание метки для отображения стоимости квартиры с учетом площади
        Label label = new Label("Стоимость квартиры с учетом площади: " + copyCenterApart.CountApartmentCost());
        // Добавление метки на панель
        getChildren().add(label);
    }
}