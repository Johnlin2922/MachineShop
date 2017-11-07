package edu.jsu.mcis;

import java.util.*; 

public class Job {
	
	private String name;
	private Queue<Task> queue;
	private int counter; 
	private Task currentTask; 
	
	public Job(String n){
		name = n;
		queue = new LinkedList<Task>();
		counter = 0; 
	}
	
	public Task getCurrentTask(){
		return currentTask; 
	}
	
	public void addTask(Task t){
		boolean b = queue.add(t);
		counter++;
		if(!b){
			throw new NullPointerException();
		}
	}
	
	public Task getNextTask(){
		currentTask = queue.remove(); 
		counter--; 
		return currentTask;
	}
	
	public boolean isFinished(){
		if(queue.size() == 0){
			return true; 
		}
		return false; 
	}
	
	public int getTimeLeft(){
		Queue<Task> temp = queue;

		int timeLeft = 0;
		for(int i = 0; i < counter; i++){
			timeLeft += temp.remove().getTime();
		}
		
		return timeLeft; 
	}
	
	public int getNumJobs(){	
		return counter; 
	}
}