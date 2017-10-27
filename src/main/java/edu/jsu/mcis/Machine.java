/** 
 * The Machine object implements a queue of Tasks,
 * given by Jobs.
 */
 
package edu.jsu.mcis;
 
import java.util.*; 
 
public class Machine {
	
	private Queue<Task> waiting;
	private String name;
	private enum State
		{ ACTIVE, IDLE, CHANGEOVER };
	private State currentState;
	private Task currentTask;
	private int downtime;
	private int remainingTime;
	
	public Machine(String n) {
		this(n, 0);
	}
	
	public Machine(String n, int dt) {
		name = n;
		downtime = dt;
		currentState = State.IDLE;
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
	
	public Task getCurrentTask() {
		if(waiting.size() > 0) {
			return currentTask;
		}
		else return null;
	}
	
	public void addTask(Task t) {
		waiting.add(t);
	}
	
	public void start() {
		if(waiting.size() > 0) {
			currentTask = waiting.remove();
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
		}
		else if(remainingTime <= 0 && currentState == State.CHANGEOVER) {
			if(waiting.size() > 0) {
				start();
			}
			else {
				currentState = State.IDLE;
			}
		}
	}
	
}