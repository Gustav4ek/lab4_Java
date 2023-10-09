package com.example.lab4;

/**
 * Класс для управления квартирами и расчета их стоимости.
 */
public class ApartmentManager {

    /**
     * Точка входа в программу.
     *
     * @param args Параметры командной строки (не используются).
     */
    public static void main(String[] args) {
        // Создание объекта квартиры в центре
        Apartment CenterApart = new Apartment("Ирининская", 24, 1348, 30);
        // Создание объекта квартиры в пригороде
        Apartment VillageApart = new Apartment();
        // Создание копии объекта квартиры в центре
        Apartment CopyCenterApart = new Apartment(CenterApart);
        // Настройка параметров квартиры в пригороде
        VillageApart.setAddress("Ломоносова");
        VillageApart.setNumber(2);
        VillageApart.setCost(1000);
        VillageApart.setSize(35);
        // Расчет стоимости квартиры в центре
        double CenterApartCost = CenterApart.CountApartmentCost();
        // Расчет стоимости квартиры в пригороде (здесь, возможно, ошибка - должна быть villageApart.CountApartmentCost())
        double VillageApartCost = CenterApart.CountApartmentCost();
        // Вывод стоимости квартиры с учетом площади
        System.out.println("Стоимость квартиры с учетом площади: " + CopyCenterApart.CountApartmentCost());
        // Создание объекта квартиры в центре с указанными параметрами
        ApartmentCenter frstCenterApart = new ApartmentCenter(5, 10);
        // Создание объекта квартиры в центре с параметрами по умолчанию
        ApartmentCenter scndCenterApart = new ApartmentCenter();
        // Создание копии объекта квартиры в центре
        ApartmentCenter thrdCenterApart = new ApartmentCenter(frstCenterApart);
        // Настройка номера этажа и этажности квартиры в центре
        scndCenterApart.setFloorNumber(1);
        scndCenterApart.setFloorCount(5);
        // Расчет стоимости квартиры в центре с учетом этажа и этажности
        System.out.println("Стоимость квартиры в центре с учетом этажа и этажности дома: " + thrdCenterApart.CountCenterApartmentCost(CenterApartCost));
        // Создание объекта квартиры в пригороде с указанным расстоянием от центра
        VillageApartment frstVillageApart = new VillageApartment(15);
        // Создание объекта квартиры в пригороде с параметрами по умолчанию
        VillageApartment scndVillageApart = new VillageApartment();
        // Создание копии объекта квартиры в пригороде
        VillageApartment thrdVillageApart = new VillageApartment(frstVillageApart);
        // Установка расстояния от центра для квартиры в пригороде
        scndVillageApart.setR(20);
        // Расчет стоимости квартиры в пригороде с учетом расстояния от центра
        System.out.println("Стоимость квартиры в пригороде с учетом расстояния от центра: " + thrdVillageApart.CountVillageApartmentCost(VillageApartCost));
    }
}