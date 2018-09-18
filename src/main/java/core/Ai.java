package core;

public class Ai {
	private int numberOfCard;
	private int[] handValue= new int[20];
	private String[] cardinhand =new String[20];
	private int AceinHand = 0;
	private int Value1 = 0;
	private int Value2 = 0;

	public void Ai() {
		numberOfCard = 0;
		handValue = new int[20];
		cardinhand = new String[20];
	}
	
	public int getnumberOfCard() {
		return numberOfCard;
	}
	public void increasenumberOfCard() {
		numberOfCard++;
	}
	public int gethandValue1() {
		return Value1;
	}
	public int gethandValue2() {
		return Value2;
	}
	
	public boolean checkgethandValuesame() {
		return Value1 == Value2;
	}
	public void calValue() {
		int i;
		Value1 = 0;
		Value2 = 0;
		for (i = 0 ; i<=numberOfCard ; i++) {
			if(handValue[i] == 1 && AceinHand == 0) {
				Value1 += 1;
				Value2 += 11;
				AceinHand++;
			}
			else {
				Value1 += handValue[i];
				Value2 += handValue[i];
			}
		}
	}
	public void addtohandValue(int n) {
		handValue[numberOfCard] = n;
	}
	
	public void addCard(String n) {
		cardinhand[numberOfCard] = n;
		
	}
	public String getwhichcard(int n) {
		if(n <= numberOfCard) {
			return cardinhand[n];
		}
		else {
			return null;
		}
	}
}
