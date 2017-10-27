package edu.jsu.mcis;

import java.util.*; 

public class Job {
	
	private Queue<Task> queue;
	
	public Job(){
		queue = new LinkedList<Task>();
	}
	public void add(Task t){
		queue.add(t);
	}
	public Task getNextTask(){
		return queue.remove();
	}
}