package edu.jsu.mcis;

import java.util.*; 

public class Job {
	
	private String name;
	private Queue<Task> queue;
	private int counter; 
	
	public Job(String n){
		name = n;
		queue = new LinkedList<Task>();
		counter = 0; 
	}
	
	public void addTask(Task t){
		boolean b = queue.add(t);
		counter++;
		if(!b){
			throw new NullPointerException();
		}
	}
	
	public Task getNextTask(){
		return queue.remove();
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