/** 
 * The Machine object implements a queue of Tasks,
 * given by Jobs.
 */
 
package edu.jsu.mcis;
 
import java.util.*; 
 
public class Machine {
	
	private Queue<Task> waiting;
	private String name;
	public enum State
		{ ACTIVE, IDLE, CHANGEOVER };
	private State currentState;
	private Task currentTask;
	private int downtime;
	private int remainingTime;
	private int size; 
	private boolean isFinished;
	
	public Machine(String n) {
		this(n, 0);
	}
	
	public Machine(String n, int dt) {
		waiting = new LinkedList<Task>();
		name = n;
		downtime = dt;
		currentState = State.IDLE;
		remainingTime = 0;
		isFinished = false;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDowntime(int dt) {
		downtime = dt;
	}

	public int getDowntime() {
		return downtime;
	}

	public State getCurrentState() {
		return currentState;
	}
	
	public int getRemainingTime() {
		return remainingTime;
	}
	
	public Task getCurrentTask() {
		if(waiting.size() > 0) {
			return currentTask;
		}
		else return null;
	}
	
	public void addTask(Task t) {
		size++;
		waiting.add(t);
	}
	
	public int getWaitingQueueSize() {
		return size;
	}
	
	public boolean isTaskFinished() {
		return isFinished;
	}
	
	public void start() {
		if(size > 0) {
			currentTask = waiting.remove();
			size--; 
			remainingTime = currentTask.getTime();
			currentState = State.ACTIVE;
		}
	}
	
	public void finish() {
		currentState = State.CHANGEOVER;
		remainingTime = downtime;
	}
	
	public void tick() {
		remainingTime--;
		if(remainingTime <= 0 && currentState == State.ACTIVE) {
			finish();
			isFinished = true;
		}
		else if(remainingTime <= 0 && currentState == State.CHANGEOVER) {
			if(size > 0) {
				start();
			}
			else {
				currentState = State.IDLE;
			}
			isFinished = false;
		}
	}
	
}