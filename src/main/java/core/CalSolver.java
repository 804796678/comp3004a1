package core;

import java.util.Random;

public class CalSolver {
	public int add(int FirstCard, int SecondCard) {
		return FirstCard + SecondCard;
	}
	
	public int CheckAce(int NumberofCard,int Total) {
		//case
		//1 not reach 21
		//2 blackjeck
		//3 reach 21 but more than 2 card
		//-1 not enough card
		//0 greater than 21
		if(NumberofCard <= 1) {
			return -1;
		}
		else if(NumberofCard == 2) {
			if(Total == 21) {
				return 2;
			}
			else {
				return 1;
			}
		}
		else {
			if(Total == 21) {
				return 3;
			}
			else if(Total < 21) {
				return 1;
			}
			else {
				return 0;
			}
		}
	}
	
	public int getSimpleOfCard() {
		Random rand = new Random();
		int  n = rand.nextInt(13) + 1;
		return n;
	}
	public int getValueOfCard(int n) {
		if(n >=10 ) {
			return 10;
		}else {
			return n;
		}
	}
	
	public String getCard(int n) {
		String cardname = "";
		Random rand = new Random();
		int kindOfcard = rand.nextInt(4) + 1;
		
		switch (kindOfcard) {
			case 1:
				cardname = "C";
				break;
			case 2:
				cardname = "D";
				break;
			case 3:
				cardname = "H";
				break;
			case 4:
				cardname = "S";
				break;
			default:
				break;
		}
		
		switch (n) {
			case 1:
				cardname += "A";
				break;
			case 2:
				cardname += "2";
				break;
			case 3:
				cardname += "3";
				break;
			case 4:
				cardname += "4";
				break;
			case 5:
				cardname += "5";
				break;
			case 6:
				cardname += "6";
				break;
			case 7:
				cardname += "7";
				break;
			case 8:
				cardname += "8";
				break;
			case 9:
				cardname += "9";
				break;
			case 10:
				cardname += "10";
				break;
			case 11:
				cardname += "J";
				break;
			case 12:
				cardname += "Q";
				break;
			case 13:
				cardname += "K";
				break;
			default:
				break;
		}
		return cardname;
	}
	
	
	
	
	
	
}
