package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class MachineShopTest {

	@Test
	public void testTaskConstructorAndGetter() {
		Task t = new Task("task 1", 5);
		assertEquals("task 1", t.getName());
	}
}