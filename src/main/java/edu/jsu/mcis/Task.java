package edu.jsu.mcis;

public class Task {
	
	private String name; 
	private int time;
	
	public Task(String s){
		name = s;
		time = 0;
	}
	
	public Task(String s, int t){
		name = s;
		time = t;
	}
	
	public String getName(){
		return name; 
	}
	
	public void setTime(int t){
		time = t; 
	}
	
	public int getTime(){
		return time;
	}
	
	public String toString(){
		return name;
	}
}