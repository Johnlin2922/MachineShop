/**
 * MachineShop.Java
 *
 * MachineShop is a class that applies Jobs to a set of Machines. </p>
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
		
	}
	
	private boolean allMachinesDone() {
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
	
	private void init() {
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
		}
	}
	
	public void run() {
		init();
		while(!allMachinesDone()) {
			tick(); 
		}
	}
	
	
}