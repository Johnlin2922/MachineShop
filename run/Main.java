
import java.io.*; 
import java.util.*; 

public class Main {
	
	private static MachineShop shop; 
	public static void main(String[] args) {
		
		try{
			Scanner s = new Scanner(new File("input.txt"));
			shop = new MachineShop(s);
			System.out.println("Time,Machine Queues, Active Jobs, Finished Times");
			int counter = 0; 
			shop.init(); 
			while(!shop.allMachinesDone()){
				System.out.println(shop.toString());
			}
			
		}
		catch (FileNotFoundException e){
			e.getMessage();
		}
		
		
	}

}