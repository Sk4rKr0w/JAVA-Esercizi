import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Connect implements ActionListener {

	JLabel temp;
	
	JTextField serverAddressField;
	JTextField portField;
	
	JButton connectButton;
	JButton disconnectButton;
	JButton onButton;
	JButton offButton;
	JButton plusButton;
	JButton minusButton;
	TermostatoPanel tempButton;
	
	Socket client;
	Scanner sc;
	PrintWriter pw;
	
	public Connect(JTextField serverAddressField,
	JTextField portField,	
	JButton connectButton,
	JButton disconnectButton,
	JButton onButton,
	JButton offButton,
	JButton plusButton,
	JButton minusButton,
	TermostatoPanel tempButton) {
		
		this.serverAddressField = serverAddressField;
		this.portField = portField;
		this.connectButton = connectButton;
		this.disconnectButton = disconnectButton;
		this.onButton = onButton;
		this.offButton = offButton;
		this.plusButton = plusButton;
		this.minusButton = minusButton;
		this.tempButton = tempButton;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			client = new Socket(serverAddressField.getText(),Integer.parseInt(portField.getText()));
			pw = new PrintWriter(client.getOutputStream());
			sc = new Scanner(client.getInputStream());
			
			connectButton.setEnabled(false);
			disconnectButton.setEnabled(true);
			onButton.setEnabled(true);
			
			JOptionPane.showMessageDialog(null, "Client Connesso");
		} catch (NumberFormatException | IOException e1) {
			JOptionPane.showMessageDialog(null, "Non Connesso");
			System.out.println(e1.getMessage());
		}
		
	}

}
