package core;

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
	
	
	
	
	
	
}
