package coinmachine;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

public class ObserverGui extends JFrame implements Observer {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtAcceptingCoins;
	private CoinMachine machine;

	/**
	 * set gui
	 * @param machine
	 */
	public ObserverGui(CoinMachine machine) {
		this.machine = machine;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 130);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpncoins = new JTextPane();
		txtpncoins.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		txtpncoins.setText("#Coins: ");
		txtpncoins.setBounds(6, 6, 119, 36);
		txtpncoins.setEditable(false);
		contentPane.add(txtpncoins);
		
		textField = new JTextField();
		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		textField.setText("0");
		textField.setBounds(137, 6, 94, 36);
		
		contentPane.add(textField);
		textField.setColumns(10);
		
		txtAcceptingCoins = new JTextField();
		txtAcceptingCoins.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		txtAcceptingCoins.setText("Accepting Coins");
		txtAcceptingCoins.setBounds(6, 54, 225, 36);
		contentPane.add(txtAcceptingCoins);
		txtAcceptingCoins.setEditable(false);
		txtAcceptingCoins.setColumns(10);
		setVisible(true);
	}
	/**
	 * set new count coin
	 */
	@Override
	public void update(Observable o, Object arg) {
		textField.setText("" + machine.getCount());
		
	}

}
