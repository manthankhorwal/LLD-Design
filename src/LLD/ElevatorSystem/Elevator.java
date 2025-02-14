package LLD.ElevatorSystem;

import java.util.Comparator;
import java.util.PriorityQueue;
//Lift if going up will serve all the up going request
//Lift if going down will serve all the down going request
//we are taking two priorityQueues , one min and one max
//Elevator will first start from 0th floor , so it go up
//So currentQueue is min Heap , and we will insert floor request into min heap if we going towards that floor and closest floor in the heap will be served first.
//And all request we cannot fulfil because request must be going down , so we will put it in pending which is currently max heap
//so Once all up going request is completed , we will swap currentQueue with pendingQueue , so now currentQueue become maxHeap which is good because now lift has served up going request
// and now it will serve the down going request, so for down going we need the closest floor first to us .
//and in swapping pending become min heap , so it will be used when lift completes all down request and will go up.
public class Elevator {
private int id;
private int currentFloor;
private State state;
private PriorityQueue<Integer> currentQueue;
private PriorityQueue<Integer> pendingQueue;
private Display innerDisplay;
private Display outerDisplay;
    public Elevator(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.state = State.IDLE;
        this.currentQueue = new PriorityQueue<>();
        this.pendingQueue = new PriorityQueue<>(Comparator.reverseOrder());
        this.innerDisplay = new Display();
        this.outerDisplay = new Display();

    }
    public void addRequest(int floor,Direction direction){
        if (state.equals(State.IDLE)) {
            state = (floor > currentFloor) ? State.MOVING_UP : State.MOVING_DOWN;
            currentQueue.offer(floor);
        } else if (state.equals(State.MOVING_UP) && direction.equals(Direction.UP) && floor >= currentFloor) {
            currentQueue.offer(floor);
        } else if (state.equals(State.MOVING_DOWN) && direction.equals(Direction.DOWN) && floor <= currentFloor) {
            currentQueue.offer(floor);
        } else {
            pendingQueue.offer(floor);
        }
    }
public void processRequests() {
    while (!currentQueue.isEmpty()) {
        int nextFloor = currentQueue.poll();
        while (currentFloor != nextFloor) {
            if (state.equals(State.MOVING_UP)) currentFloor++;
            else if (state.equals(State.MOVING_DOWN)) currentFloor--;

            // Update displays
            innerDisplay.update(currentFloor, state);
            outerDisplay.update(currentFloor, state);

            System.out.println("Elevator " + id + " Inside Display: " + innerDisplay);
            System.out.println("Elevator " + id + " Outside Display: " + outerDisplay);
        }
    }
    if (pendingQueue.isEmpty()) {
        state = State.IDLE;
        innerDisplay.update(currentFloor, state);
        outerDisplay.update(currentFloor, state);
    } else {
      switchDirection();
      PriorityQueue<Integer> temp;
      temp=currentQueue;
      currentQueue=pendingQueue;
      pendingQueue=temp;
      processRequests();
    }
}
    private void switchDirection() {
        if (state.equals(State.MOVING_UP)) {
            state = State.MOVING_DOWN;
        } else if (state.equals(State.MOVING_DOWN)) {
            state = State.MOVING_UP;
        }
    }
public int getCurrentFloor(){
    return currentFloor;
}
public State getState(){
        return state;
}
public int getId(){
        return id;
}
}
