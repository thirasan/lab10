package coinmachine;

import java.util.Observable;
import java.util.Observer;


public class ObserverTest implements Observer{
	public static void main(String[] args){
		Coin a = new Coin(12, "Baht");
		Coin b = new Coin(5, "dollar");
		CoinMachine mac = new CoinMachine(2);
		mac.addObserver(new ObserverTest());
		mac.insert(a);
		mac.insert(b);
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println(arg);
	}
}
