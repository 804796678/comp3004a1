package core;

import java.awt.print.Printable;

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
	
	public void testgetCardcard() {
		
		CalSolver solver = new CalSolver();
		System.out.printf("        my Jcard  : " +solver.getCard(11));
		System.out.printf("        my 3card  : " +solver.getCard(3));
	}
	
	public void testgetValueOfCard() {
		CalSolver solver = new CalSolver();
		assertEquals(10, solver.getValueOfCard(11));
		assertEquals(2, solver.getValueOfCard(2));
		assertEquals(10, solver.getValueOfCard(10));
		
		
	}
	
	public void testAiCard() {
		Ai dealer = new Ai();
		dealer.addtohandValue(3);
		dealer.increasenumberOfCard();
		dealer.addtohandValue(7);
		dealer.increasenumberOfCard();
		dealer.addtohandValue(3);
		dealer.increasenumberOfCard();
		dealer.addtohandValue(5);
		dealer.increasenumberOfCard();
		dealer.calValue();
		
		assertEquals(18, dealer.gethandValue1());
	}
	
	public void testAiCardwith1Ace() {
		Ai dealer = new Ai();
		dealer.addtohandValue(1);
		dealer.increasenumberOfCard();
		dealer.addtohandValue(7);
		dealer.increasenumberOfCard();
		dealer.addtohandValue(3);
		dealer.increasenumberOfCard();
		dealer.addtohandValue(5);
		dealer.increasenumberOfCard();
		dealer.calValue();
		
		assertEquals(16, dealer.gethandValue1());
		assertEquals(26, dealer.gethandValue2());
	}
	
	public void testAiCardwithoneAce() {
		Ai dealer = new Ai();
		dealer.addtohandValue(3);
		dealer.increasenumberOfCard();
		dealer.addtohandValue(7);
		dealer.increasenumberOfCard();
		dealer.addtohandValue(1);
		dealer.increasenumberOfCard();
		dealer.addtohandValue(5);
		dealer.increasenumberOfCard();
		dealer.calValue();
		
		assertEquals(16, dealer.gethandValue1());
		assertEquals(26, dealer.gethandValue2());
	}
	
	public void testAiCardwithtwoAce() {
		Ai dealer = new Ai();
		dealer.addtohandValue(3);
		dealer.increasenumberOfCard();
		dealer.addtohandValue(1);
		dealer.increasenumberOfCard();
		dealer.addtohandValue(1);
		dealer.increasenumberOfCard();
		dealer.addtohandValue(5);
		dealer.increasenumberOfCard();
		dealer.calValue();
		
		assertEquals(10, dealer.gethandValue1());
		assertEquals(20, dealer.gethandValue2());
	}
	
	public void testAiCardwiththreeAce() {
		Ai dealer = new Ai();
		dealer.addtohandValue(10);
		dealer.increasenumberOfCard();
		dealer.addtohandValue(1);
		dealer.increasenumberOfCard();
		dealer.addtohandValue(1);
		dealer.increasenumberOfCard();
		dealer.addtohandValue(1);
		dealer.increasenumberOfCard();
		dealer.calValue();
		
		assertEquals(13, dealer.gethandValue1());
		assertEquals(23, dealer.gethandValue2());
	}
	public void testAiCardString() {
		Ai dealer = new Ai();
		dealer.addCard("SK");
		dealer.increasenumberOfCard();
		dealer.addCard("SQ");
		dealer.increasenumberOfCard();
		dealer.addCard("SJ");
		dealer.increasenumberOfCard();
		int i = 0;
		for(i = 0; i <dealer. getnumberOfCard(); i++) {
			if(i == 0) {assertEquals("SK",dealer.getwhichcard(i));}
			if(i == 1) {assertEquals("SQ",dealer.getwhichcard(i));}
			if(i == 2) {assertEquals("SJ",dealer.getwhichcard(i));}
			
		}
		
	}
	
	public void testResult() {
		CalSolver solver = new CalSolver();
		Ai dealer = new Ai();
		Ai player = new Ai();
		player.addtohandValue(10);
		player.increasenumberOfCard();
		player.addtohandValue(10);
		player.increasenumberOfCard();
		dealer.addtohandValue(1);
		dealer.increasenumberOfCard();
		dealer.addtohandValue(10);
		dealer.increasenumberOfCard();
		dealer.calValue();
		player.calValue();
		assertEquals(20, player.gethandValue1());
		assertEquals(20, player.gethandValue2());
		assertEquals(11, dealer.gethandValue1());
		assertEquals(21, dealer.gethandValue2());
		String me = solver.Whoiwin(player.gethandValue1(), player.gethandValue2(), dealer.gethandValue1(), dealer.gethandValue2());
		
		assertEquals("Dealer Win",me);
	}
	
	public void testResult1() {
		CalSolver solver = new CalSolver();
		Ai dealer = new Ai();
		Ai player = new Ai();
		player.addtohandValue(1);
		player.increasenumberOfCard();
		player.addtohandValue(10);
		player.increasenumberOfCard();
		dealer.addtohandValue(10);
		dealer.increasenumberOfCard();
		dealer.addtohandValue(10);
		dealer.increasenumberOfCard();
		dealer.calValue();
		player.calValue();
		assertEquals(11, player.gethandValue1());
		assertEquals(21, player.gethandValue2());
		assertEquals(20, dealer.gethandValue1());
		assertEquals(20, dealer.gethandValue2());
		String me = solver.Whoiwin(player.gethandValue1(), player.gethandValue2(), dealer.gethandValue1(), dealer.gethandValue2());
		
		assertEquals("Player Win",me);
	}
	
	public void testResultdealer() {
		CalSolver solver = new CalSolver();
		Ai dealer = new Ai();
		Ai player = new Ai();
		player.addtohandValue(10);
		player.increasenumberOfCard();
		player.addtohandValue(10);
		player.increasenumberOfCard();
		player.addtohandValue(10);
		player.increasenumberOfCard();
		dealer.addtohandValue(1);
		dealer.increasenumberOfCard();
		dealer.addtohandValue(10);
		dealer.increasenumberOfCard();
		dealer.calValue();
		player.calValue();
		assertEquals(30, player.gethandValue1());
		assertEquals(30, player.gethandValue2());
		assertEquals(11, dealer.gethandValue1());
		assertEquals(21, dealer.gethandValue2());
		String me = solver.Whoiwin(player.gethandValue1(), player.gethandValue2(), dealer.gethandValue1(), dealer.gethandValue2());
		
		assertEquals("Dealer Win",me);
	}
	
	public void testResultplayer() {
		CalSolver solver = new CalSolver();
		Ai dealer = new Ai();
		Ai player = new Ai();
		player.addtohandValue(7);
		player.increasenumberOfCard();
		player.addtohandValue(7);
		player.increasenumberOfCard();
		player.addtohandValue(7);
		player.increasenumberOfCard();
		dealer.addtohandValue(10);
		dealer.increasenumberOfCard();
		dealer.addtohandValue(10);
		dealer.increasenumberOfCard();
		dealer.calValue();
		player.calValue();
		assertEquals(21, player.gethandValue1());
		assertEquals(21, player.gethandValue2());
		assertEquals(20, dealer.gethandValue1());
		assertEquals(20, dealer.gethandValue2());
		String me = solver.Whoiwin(player.gethandValue1(), player.gethandValue2(), dealer.gethandValue1(), dealer.gethandValue2());
		
		assertEquals("Player Win",me);
	}
	public void testResultBoom() {
		CalSolver solver = new CalSolver();
		Ai dealer = new Ai();
		Ai player = new Ai();
		player.addtohandValue(5);
		player.increasenumberOfCard();
		player.addtohandValue(4);
		player.increasenumberOfCard();
		player.addtohandValue(3);
		player.increasenumberOfCard();
		dealer.addtohandValue(10);
		dealer.increasenumberOfCard();
		dealer.addtohandValue(10);
		dealer.increasenumberOfCard();
		dealer.calValue();
		player.calValue();
		assertEquals(12, player.gethandValue1());
		assertEquals(12, player.gethandValue2());
		assertEquals(20, dealer.gethandValue1());
		assertEquals(20, dealer.gethandValue2());
		String me = solver.Whoiwin(player.gethandValue1(), player.gethandValue2(), dealer.gethandValue1(), dealer.gethandValue2());
		
		assertEquals("Dealer Win",me);
	}
	
	public void testreadFile() {
		CalSolver solver = new CalSolver();
		String name = "1";
		String outputshouldbe = "SK HA HQ CA";
		String output = solver.readFile(name);
		assertEquals(outputshouldbe,output);
	}
	public void testspliteString(){
		CalSolver solver = new CalSolver();
		String name = "1";
		String output = solver.readFile(name);
		String outputshould1 = "SK";
		String outputshould2 = "HA";
		String outputshould3 = "HQ";
		String outputshould4 = "CA";
		String[] outputlast = solver.spliteString(output);
		int i =0;
		for(i = 0;i < outputlast.length;i++) {
			if(i == 0) {assertEquals(outputshould1,outputlast[i]);}
			if(i == 1) {assertEquals(outputshould2,outputlast[i]);}
			if(i == 2) {assertEquals(outputshould3,outputlast[i]);}
			if(i == 3) {assertEquals(outputshould4,outputlast[i]);}
		}
	}
	public void testinputCardname() {
		CalSolver solver = new CalSolver();
		int answer = solver.findCardValue("SK");
		assertEquals(10,answer);
		answer = solver.findCardValue("DA");
		assertEquals(1,answer);
		answer = solver.findCardValue("C10");
		assertEquals(10,answer);
	}
	
}


