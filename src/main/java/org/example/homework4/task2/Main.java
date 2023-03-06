package org.example.homework4.task2;

import org.example.homework4.task2.obstacle.Obstacle;
import org.example.homework4.task2.obstacle.RunningTrack;
import org.example.homework4.task2.obstacle.Wall;
import org.example.homework4.task2.participant.Human;
import org.example.homework4.task2.participant.Participant;
import org.example.homework4.task2.participant.Robot;
import org.example.homework4.task2.participant.Cat;

public class Main {
    public static void start(Participant[] participants, Obstacle[] obstacles) {
        for (Participant par : participants) {
            for (Obstacle obs : obstacles) {
                boolean pass = obs.overcome(par);
                if (!pass) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Participant[] participants = {
                new Human("Bob", 1.0, 30.0),
                new Cat("Tom", 2.5, 1000.0),
                new Robot("T-800", 20.0, 10000.0),
        };
        Obstacle[] obstacles = {
                new Wall("Wall", 2.0),
                new RunningTrack("RunningTrack", 20.0),
                new Wall("Wall1", 0.5),
                new Wall("Wall2", 1.5),
                new RunningTrack("RunningTrack2", 2000.0)
        };
        start(participants, obstacles);
    }
}