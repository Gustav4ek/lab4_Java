
package com.example.lab4;
/**
 * Подкласс квартиры для квартиры в центре города.
 * Унаследован от базового класса Apartment.
 */
public class ApartmentCenter extends Apartment {
    private int FloorNumber;
    private int FloorCount;

    /**
     * Конструктор для создания объекта ApartmentCenter с указанными параметрами.
     *
     * @param floorNumber Номер этажа квартиры в центре.
     * @param floorCount  Общее количество этажей в доме.
     */
    public ApartmentCenter(int floorNumber, int floorCount) {
        this.FloorNumber = floorNumber;
        this.FloorCount = floorCount;
    }

    /**
     * Конструктор для создания объекта ApartmentCenter со значениями по умолчанию.
     */
    public ApartmentCenter() {
        this.FloorNumber = 0;
        this.FloorCount = 0;
    }

    /**
     * Конструктор для создания копии объекта ApartmentCenter.
     *
     * @param aparts Существующий объект ApartmentCenter для копирования.
     */
    public ApartmentCenter(ApartmentCenter aparts) {
        FloorNumber = aparts.FloorNumber;
        FloorCount = aparts.FloorCount;
    }

    /**
     * Устанавливает номер этажа квартиры в центре.
     *
     * @param floorNumber Новый номер этажа.
     */
    public void setFloorNumber(int floorNumber) {
        FloorNumber = floorNumber;
    }

    /**
     * Устанавливает общее количество этажей в доме.
     *
     * @param floorCount Новое общее количество этажей.
     */
    public void setFloorCount(int floorCount) {
        FloorCount = floorCount;
    }

    /**
     * Возвращает номер этажа квартиры в центре.
     *
     * @return Номер этажа.
     */
    public int getFloorNumber() {
        return FloorNumber;
    }

    /**
     * Возвращает общее количество этажей в доме.
     *
     * @return Общее количество этажей.
     */
    public int getFloorCount() {
        return FloorCount;
    }

    /**
     * Рассчитывает общую стоимость квартиры в центре с учетом надбавки за расположение и корректировки для первого и последнего этажа.
     *
     * @param apsCost Стоимость квартиры до применения надбавок.
     * @return Общая стоимость квартиры в центре.
     */
    public double CountApartmentCost(double apsCost) {
        double cost = apsCost;
        cost += cost / 100 * 5;
        if (this.FloorNumber == 1 || this.FloorNumber == this.FloorCount || this.FloorNumber == this.FloorCount - 1) {
            cost -= 500;
        }
        return cost;
    }
}