package core;

import junit.framework.TestCase;

public class CalTest extends TestCase {
	
	public void testAdd() {
		CalSolver solver = new CalSolver();
		assertEquals(4, solver.add(2, 2));
	}
	//case
			//1 not reach 21
			//2 blackjeck
			//3 reach 21 but more than 2 card
			//-1 not enough card
			//0 greater than 21
	
	public void testcheckBlackJeck() {
		CalSolver solver = new CalSolver();
		assertEquals(2, solver.CheckAce(2,21));
	}
	
	public void testcheckNoCard() {
		CalSolver solver = new CalSolver();
		assertEquals(-1, solver.CheckAce(0,31));
	}
	
	public void testcheckOneCard() {
		CalSolver solver = new CalSolver();
		assertEquals(-1, solver.CheckAce(1,21));
	}
	
	public void testcheckThreeCard21() {
		CalSolver solver = new CalSolver();
		assertEquals(3, solver.CheckAce(3,21));
	}
	
	public void testcheckThreeCard22() {
		CalSolver solver = new CalSolver();
		assertEquals(0, solver.CheckAce(3,22));
	}
	
	public void testcheckThreeCard17() {
		CalSolver solver = new CalSolver();
		assertEquals(1, solver.CheckAce(3,17));
	}
}
