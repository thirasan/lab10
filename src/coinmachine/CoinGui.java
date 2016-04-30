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
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton button;
	private CoinMachine machine;
	final JProgressBar progressBar;
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
		
		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setBounds(198, 6, 146, 20);
		progressBar.setMaximum((int)machine.getCapacity());
		progressBar.setMinimum(0);
		contentPane.add(progressBar);
		
		JTextPane txtpnInsertMoney = new JTextPane();
		txtpnInsertMoney.setText("Insert Money");
		txtpnInsertMoney.setBounds(6, 35, 81, 16);
		contentPane.add(txtpnInsertMoney);
		
		btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(CoinGui.class.getResource("/images/1baht.png")));
		btnNewButton.setBounds(6, 56, 105, 93);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Coin coin = new Coin(1,"Baht");
				System.out.println("1-Baht inserted");
				machine.insert(coin);
			}
		});
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(CoinGui.class.getResource("/images/5baht.png")));
		btnNewButton_1.setBounds(122, 56, 105, 93);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Coin coin = new Coin(5,"Baht");
				System.out.println("5-Baht inserted");
				machine.insert(coin);
			}
		});
		contentPane.add(btnNewButton_1);
		
		button = new JButton("");
		button.setIcon(new ImageIcon(CoinGui.class.getResource("/images/10baht.png")));
		button.setBounds(239, 56, 105, 93);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Coin coin = new Coin(10,"Baht");
				machine.insert(coin);
				System.out.println("10-Baht inserted");
			}
		});
		contentPane.add(button);
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
		progressBar.setValue(machine.getCount());
	}
}
