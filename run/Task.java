
public class Task {
	
	private String name;
	private int time;
	private String jobName; 
	
	public Task(String s){
		name = s;
		time = 0;
	}
	
	public Task(String s, String t, String jName){
		name = s;
		time = Integer.parseInt(t);
		jobName = jName; 
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
		return jobName;
	}
	
}