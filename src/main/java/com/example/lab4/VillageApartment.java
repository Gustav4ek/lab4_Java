package com.example.lab4;
/**
 * Подкласс квартиры для квартиры в пригороде.
 */
public class VillageApartment extends Apartment{
    private int r;

    /**
     * Конструктор для создания объекта VillageApartment с указанным расстоянием от центра.
     *
     * @param r Расстояние от центра.
     */
    public VillageApartment(int r) {
        this.r = r;
    }

    /**
     * Конструктор для создания объекта VillageApartment со значением расстояния от центра по умолчанию.
     */
    public VillageApartment() {
        this.r = 0;
    }
    /**
     * Конструктор для создания копии объекта VillageApartment.
     *
     * @param aparts Существующий объект VillageApartment для копирования.
     */
    public VillageApartment(VillageApartment aparts){
        r = aparts.r;
    }

    /**
     * Устанавливает расстояние от центра для квартиры в пригороде.
     *
     * @param r Новое расстояние от центра.
     */
    public void setR(int r) {
        this.r = r;
    }

    /**
     * Возвращает текущее расстояние от центра для квартиры в пригороде.
     *
     * @return Расстояние от центра.
     */
    public int getR() {
        return r;
    }

    /**
     * Рассчитывает общую стоимость квартиры в пригороде с учетом расстояния от центра.
     *
     * @param apsCost Стоимость квартиры до применения надбавок.
     * @return Общая стоимость квартиры в пригороде.
     */
    public double CountVillageApartmentCost(double apsCost) {
        double cost = apsCost;
        if (r<10) {
            cost +=cost/100*5;
        }
        else cost -=0.02 * this.r;
        return cost;
    }
}

