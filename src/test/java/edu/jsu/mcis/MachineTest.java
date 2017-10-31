package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class MachineTest {
	
	private Machine testMachine;
	private Task task;
	
	@Test
	public void testCreateMachineNameOnly() {
		testMachine = new Machine("lathe");
		assertEquals(testMachine.getName(), "lathe");
		assertEquals(testMachine.getDowntime(), 0);
		assertEquals(testMachine.getCurrentState(), Machine.State.IDLE);
		assertEquals(testMachine.getRemainingTime(), 0);
	}
	
	@Test
	public void testCreateMachineNameAndDowntime() {
		testMachine = new Machine("lathe", 4);
		assertEquals(testMachine.getName(), "lathe");
		assertEquals(testMachine.getDowntime(), 4);
		assertEquals(testMachine.getCurrentState(), Machine.State.IDLE);
		assertEquals(testMachine.getRemainingTime(), 0);
	}

	@Test
	public void testSetDowntimeSetsDowntime() {
		testMachine = new Machine("lathe");
		assertEquals(testMachine.getDowntime(), 0);
		testMachine.setDowntime(3);
		assertEquals(testMachine.getDowntime(), 3);
		
		testMachine = new Machine("lathe", 7);
		assertEquals(testMachine.getDowntime(), 7);
		testMachine.setDowntime(2);
		assertEquals(testMachine.getDowntime(), 2);
	}
	
	@Test
	public void testAddTaskAddsTask() {
		testMachine = new Machine("lathe");
		task = new Task("lathe");
		testMachine.addTask(task);
		assertEquals(testMachine.getWaitingQueueSize(), 1);
	}
	
}