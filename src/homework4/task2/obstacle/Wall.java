package homework4.task2.obstacle;

import homework4.task2.participant.Participant;

public class Wall extends Obstacle {
    public Wall(String obstacle, Double distanceOrHigh) {
        super(obstacle, distanceOrHigh);
    }

    @Override
    public boolean overcome(Participant participant) {
        if (this.distanceOrHigh > participant.maxClimbingHeight) {
            System.out.println("Участник[" + participant.name + "] не прошел препятствие["
                    + this.obstacle + "] на дистанции[" + this.distanceOrHigh + "]. Пройдено["
                    + participant.maxClimbingHeight + "]\n");
            System.out.println("Участник[" + participant.name + "] выбыл!");
            return false;
        } else if (this.distanceOrHigh < participant.maxClimbingHeight || this.distanceOrHigh.equals(participant.maxClimbingHeight)) {
            System.out.println("Участник[" + participant.name + "] прошел препятствие["
                    + this.obstacle + "] на дистанции[" + this.distanceOrHigh + "]\n");
            participant.jump(this.obstacle);
            return true;
        } else {
            return false;
        }
    }
}
