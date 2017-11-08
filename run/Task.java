
public class Task {
	
	private String name;
	private int time;
	
	public Task(String s){
		name = s;
		time = 0;
	}
	
	public Task(String s, String t){
		name = s;
		time = Integer.parseInt(t);
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