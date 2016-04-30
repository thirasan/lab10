package coinmachine;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;

public class CoinGui extends JFrame implements Observer{

	private JPanel contentPane;
	private JTextField txtBalance;
	private JTextField txtStatus;
	private JButton oneBahtButton;
	private JButton fiveBahtButton;
	private JButton tenBahtButton;
	private CoinMachine machine;
	final JProgressBar valueBar;
	/**
	 * set gui
	 * add coin when click coin picture
	 * @param machine
	 */
	public CoinGui(final CoinMachine machine) {
		this.machine = machine;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtBalance = new JTextField();
		txtBalance.setText("Balance : 0");
		txtBalance.setBounds(6, 6, 105, 28);
		txtBalance.setEditable(false);
		contentPane.add(txtBalance);
		txtBalance.setColumns(10);
		
		txtStatus = new JTextField();
		txtStatus.setText("Status :");
		txtStatus.setBounds(123, 6, 63, 28);
		txtStatus.setEditable(false);
		contentPane.add(txtStatus);
		txtStatus.setColumns(10);
		
		valueBar = new JProgressBar();
		valueBar.setStringPainted(true);
		valueBar.setBounds(198, 6, 146, 20);
		valueBar.setMaximum((int)machine.getCapacity());
		valueBar.setMinimum(0);
		contentPane.add(valueBar);
		
		JTextPane txtpnInsertMoney = new JTextPane();
		txtpnInsertMoney.setText("Insert Money");
		txtpnInsertMoney.setBounds(6, 35, 81, 16);
		contentPane.add(txtpnInsertMoney);
		
		oneBahtButton = new JButton("");
		oneBahtButton.setIcon(new ImageIcon(CoinGui.class.getResource("/images/1baht.png")));
		oneBahtButton.setBounds(6, 56, 105, 93);
		oneBahtButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Coin coin = new Coin(1,"Baht");
				System.out.println("1-Baht inserted");
				machine.insert(coin);
			}
		});
		contentPane.add(oneBahtButton);
		
		fiveBahtButton = new JButton("");
		fiveBahtButton.setIcon(new ImageIcon(CoinGui.class.getResource("/images/5baht.png")));
		fiveBahtButton.setBounds(122, 56, 105, 93);
		fiveBahtButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Coin coin = new Coin(5,"Baht");
				System.out.println("5-Baht inserted");
				machine.insert(coin);
			}
		});
		contentPane.add(fiveBahtButton);
		
		tenBahtButton = new JButton("");
		tenBahtButton.setIcon(new ImageIcon(CoinGui.class.getResource("/images/10baht.png")));
		tenBahtButton.setBounds(239, 56, 105, 93);
		tenBahtButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Coin coin = new Coin(10,"Baht");
				machine.insert(coin);
				System.out.println("10-Baht inserted");
			}
		});
		contentPane.add(tenBahtButton);
		setVisible(true);
		
	}
	/**
	 * set new balance
	 * set valuebar
	 * @param o
	 * @param arg
	 */
	@Override
	public void update(Observable o, Object arg) {
		txtBalance.setText("Balance : " + machine.getBalance());
		valueBar.setValue(machine.getCount());
	}
}
