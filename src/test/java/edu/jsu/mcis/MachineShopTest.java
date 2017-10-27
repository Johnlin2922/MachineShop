package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class MachineShopTest {

	@Test
	public void testTaskConstructorAndGetter() {
		Task t = new Task("task 1", 5);
		assertEquals("task 1", t.getName());
	}
	
	@Test
	public void testJobConstructorAndGetter() {
		Task t = new Task("task 1", 5);
		Job j = new Job();
		j.addTask(t);
		assertEquals(t, j.getNextTask());
	}
	
	@Test
	public void testJobGetsTimeLeftAndNumJobs() {
		Task t = new Task("task 1", 5);
		Task t2 = new Task("task 2", 2);
		Task t3 = new Task("task 3", 4);
		Task t4 = new Task("task 4", 3);
		
		Job j = new Job();
		j.addTask(t);
		j.addTask(t2);
		j.addTask(t3);
		j.addTask(t4);
		assertEquals(14, j.getTimeLeft());
		assertEquals(4, j.getNumJobs());
	
	}
}
