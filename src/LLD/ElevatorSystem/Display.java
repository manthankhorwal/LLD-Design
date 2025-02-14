package LLD.ElevatorSystem;

public class Display {
    private int currentFloor;
    private State direction;

    Display() {
        currentFloor = 0;

    }

    public void update(int currentFloor, State direction) {
        this.currentFloor = currentFloor;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Display{" +
                "currentFloor=" + currentFloor +
                ", direction='" + direction + '\'' +
                '}';
    }

    public void show() {
        System.out.println("Floor: " + currentFloor + " Direction: " + direction);
    }

}
