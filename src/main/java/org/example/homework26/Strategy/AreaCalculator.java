package org.example.homework26.Strategy;

class AreaCalculator {
    private AreaStrategy areaStrategy;

    AreaCalculator(AreaStrategy areaStrategy) {
        this.areaStrategy = areaStrategy;
    }

    double computeArea() {
        return areaStrategy.computeArea();
    }
}
