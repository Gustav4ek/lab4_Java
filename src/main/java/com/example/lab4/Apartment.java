package com.example.lab4;

/**
 * Класс, представляющий квартиру.
 * Каждая квартира имеет адрес, номер, стоимость 1 м² и площадь.
 */
    public class Apartment {
        private String address;
        private int number;
        private double cost;
        private double size;
        /**
         * Конструктор для создания объекта Apartment с указанными параметрами.
         *
         * @param address Адрес квартиры.
         * @param number Номер квартиры.
         * @param cost Стоимость 1 м².
         * @param size Площадь квартиры.
         */

        public Apartment(String address, int number, int cost, int size) {
            this.address = address;
            this.cost = cost;
            this.size = size;
            this.number = number;
        }

        /**
         * Конструктор для создания объекта Apartment с значениями по умолчанию.
         */

        public Apartment() {
            this.address = "";
            this.number = 0;
            this.cost = 0;
            this.size = 0;
        }

        /**
         * Конструктор для создания копии объекта Apartment.
         *
         * @param aparts Существующий объект Apartment для копирования.
         */

        public Apartment(Apartment aparts) {
            address = aparts.address;
            cost = aparts.cost;
            size = aparts.size;
            number = aparts.number;
        }

        /**
         * Устанавливает адрес квартиры.
         *
         * @param address Новый адрес квартиры.
         */
        public void setAddress(String address) {
            this.address = address;
        }
        /**
         * Устанавливает номер квартиры.
         *
         * @param number Новый номер квартиры.
         */
        public void setNumber(int number) {
            this.number = number;
        }
        /**
         * Устанавливает стоимость 1 м².
         *
         * @param cost Новая стоимость 1 м².
         */
        public void setCost(double cost) {
            this.cost = cost;
        }
        /**
         * Устанавливает площадь квартиры.
         *
         * @param size Новая площадь квартиры.
         */
        public void setSize(double size) {
            this.size = size;
        }
        /**
         * Возвращает адрес квартиры.
         *
         * @return Адрес квартиры.
         */
        public String getAddress() {
            return address;
        }
        /**
         * Возвращает номер квартиры.
         *
         * @return Номер квартиры.
         */
        public int getNumber() {
            return number;
        }
        /**
         * Возвращает стоимость 1 м².
         *
         * @return Стоимость 1 м².
         */
        public double getCost() {
            return cost;
        }
        /**
         * Возвращает площадь квартиры.
         *
         * @return Площадь квартиры.
         */
        public double getSize() {
            return size;
        }
        /**
         * Рассчитывает общую стоимость квартиры.
         *
         * @return Общая стоимость квартиры.
         */
        public double CountApartmentCost() {
            return this.cost * this.size;
        }
    }

