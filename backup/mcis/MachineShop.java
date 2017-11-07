/**
 * MachineShop.Java
 *
 * MachineShop is a class that applies Jobs to a set of Machines.
 * MachineShop also organizes applicable Machines, and keeps track
 * of the states of the Machines, using a Clock.
 * 
 * @author Pierce_Herron
 * @author Chase_Cook
 * @author Johnny_Lin
 */
 
package edu.jsu.mcis;

import java.util.*;
 
public class MachineShop {
	
	private Machine[] machines;
	private Job[] jobs;
	private int time; 

	
	public MachineShop(Scanner data) {
		machines = new Machine[data.nextInt()];
		
		for(int i = 0; i < machines.length; i++) {
			machines[i] = new Machine(data.next(), data.nextInt());
		}
		
		jobs = new Job[data.nextInt()];
		String[] jobData;
		
		for(int i = 0; i < jobs.length; i++) {
			jobData = data.nextLine().split(" ");
			jobs[i] = new Job(jobData[0]);
			
			for(int j = 2; j < (jobData.length - 2); j+=2) {
				jobs[i].addTask(new Task(jobData[i], jobData[i+1]));
			}
		}
		time = 0; 
		
	}
	
	public boolean allMachinesDone() {
		int finishedCount = 0;  
		for(int i = 0; i< machines.length; i++){
			if(machines[i].getWaitingQueueSize() == 0){
				finishedCount++; 
			}
		}
		if(finishedCount == machines.length){
			return true; 
		}
		return false;
	}
	
	public void init() {
		Task temp;
		
		for(int i = 0; i < jobs.length; i++) {
			temp = jobs[i].getNextTask();
			for(int j = 0; j < machines.length; j++) {
				if(temp.getName().equals(machines[i].getName())) {
					machines[i].addTask(temp);
				}
			}
		}
	}
	
	private void tick() {
		for(int i = 0; i < machines.length ; i++){
			machines[i].tick();
			if(machines[i].isTaskFinished()) {
				for(int j = 0; j < jobs.length; j++) {
					if(jobs[j].getCurrentTask() == machines[i].getCurrentTask() && jobs[j].getNumJobs() > 0) {
						Task temp = jobs[j].getNextTask();
						for(int k = 0; k < machines.length; k++) {
							if(temp.getName().equals(machines[i].getName())) {
								machines[i].addTask(temp);
							}
						}
					}
				}
			}
		}
	}
	
	public void run() {
		init();
		while(!allMachinesDone()) {
			tick(); 
		}
	}
	
	public String toString(){
		String representation = ""; 
		representation += time + "|";
		for(int i = 0; i < machines.length; i++){
			for(int j = 0; j < machines[i].getWaitingQueueSize(); i++){
				representation += machines[i].getCurrentTask().getName() + ", "; 
			}
		representation += "|";
		}
		
		return representation; 
	}
	
	
}