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

import java.util.*;
 
public class MachineShop {
	
	private Machine[] machines;
	private Job[] jobs;
	private int time; 

	
	public MachineShop(Scanner data) {
		machines = new Machine[Integer.parseInt(data.nextLine())];
		
		for(int i = 0; i < machines.length; i++) {
			String[] arr = data.nextLine().split("\\s+");
			machines[i] = new Machine(arr[0], Integer.parseInt(arr[1]));
		}
		
		jobs = new Job[data.nextInt()];
		String[] jobData;
		data.nextLine();
		for(int i = 0; i < jobs.length; i++) {
			jobData = data.nextLine().split("\\s+");
			jobs[i] = new Job(jobData[0]);
			
			for(int j = 2; j < (jobData.length); j+=2) {
				jobs[i].addTask(new Task(jobData[j], jobData[j+1], jobData[0]));
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
				if(temp.getName().equals(machines[j].getName())) {
					machines[j].addTask(temp);
				}
			}
		}
	}
	
	private void tick() {
		time++;
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
		int counter = 10; 
		while(counter > 0) {
			counter--;
			tick(); 
			System.out.println(toString());
			
		}
	}
	
	public String toString(){
		String representation = ""; 
		representation += time + "|";
		for(int i = 0; i < machines.length; i++){
			representation += machines[i].getWaitingList() + "|";
		}
		
		return representation; 
	}
	
	
}