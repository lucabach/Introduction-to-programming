
public class RPlayer {
	
	public int balance;
	public int luckynumber;
	public boolean seteven;
	public boolean setodd;
	public int betlucky;
	public int beteven;
	public int betodd;
	
	public RPlayer(int start) {
		// TODO
		this.balance = start;
		seteven = false;
		setodd = false;
	}
	
	boolean setNumber(int number, int bet) {
		// TODO
		if(bet>this.balance) {
			return false;
		}
		else {
		this.luckynumber=number;
		this.betlucky = bet;
		this.balance -= bet;
		return true;
		}
	}
	
	boolean setEven(int bet) {
		// TODO
		if(bet>balance) {
			return false;
		}
		this.balance-=bet;
		this.beteven = bet;
		this.seteven = true;
		return true;
	}
	
	boolean setOdd(int bet) {
		// TODO
		if(bet>balance) {
			return false;
		}
		this.balance-=bet;
		this.betodd = bet;
		this.setodd = true;
		return true;
	}
	
	int getBalance() {
		// TODO
		return this.balance;
	}
}
