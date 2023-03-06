package org.example.homework4.task2.obstacle;

import org.example.homework4.task2.participant.Participant;

public abstract class Obstacle {
    public String obstacle;
    public Double distanceOrHigh;

    public Obstacle(String obstacle,Double distanceOrHigh) {
        this.obstacle = obstacle;
        this.distanceOrHigh = distanceOrHigh;
    }

    public abstract boolean overcome(Participant participant);
}
