package org.example.homework26.Builder;

class CarBuilder {
    private Car car;

    CarBuilder() {
        car = new Car();
    }

    CarBuilder setEngine(String engine) {
        car.setEngine(engine);
        return this;
    }

    CarBuilder setTires(String tires) {
        car.setTires(tires);
        return this;
    }

    CarBuilder setSeats(String seats) {
        car.setSeats(seats);
        return this;
    }

    Car build() {
        return car;
    }
}
