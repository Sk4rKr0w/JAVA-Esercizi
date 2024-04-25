import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Connect implements ActionListener {
	
	JButton connectButton;
	JButton disconnectButton;
	JButton startButton;
	JButton stopButton;
	JButton resetButton;
	JButton randomizeButton;
	
	JTextField serverAddressField;
	JTextField portField;
	
	LotteryComboBox[] caselle;
	
	Socket client;
	PrintWriter pw;
	Scanner sc;
	
	LinkedList<Integer> ruota1 = new LinkedList<Integer>();
	LinkedList<Integer> ruota2 = new LinkedList<Integer>();
	LinkedList<Integer> ruota3 = new LinkedList<Integer>();
	LinkedList<Integer> ruota4 = new LinkedList<Integer>();
	LinkedList<Integer> ruota5 = new LinkedList<Integer>();

	public Connect(JButton connectButton, JButton disconnectButton, JButton startButton, JButton stopButton,
			JButton resetButton, JButton randomizeButton, JTextField serverAddressField, JTextField portField,
			LotteryComboBox[] caselle) {
		
		this.connectButton = connectButton;
		this.disconnectButton = disconnectButton;
		this.startButton = startButton;
		this.stopButton = stopButton;
		this.resetButton = resetButton;
		this.randomizeButton = randomizeButton;
		this.serverAddressField = serverAddressField;
		this.portField = portField;
		this.caselle = caselle;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			
			client = new Socket(serverAddressField.getText(), Integer.parseInt(portField.getText()));
			pw = new PrintWriter(client.getOutputStream());
			sc = new Scanner(client.getInputStream());
			
			connectButton.setEnabled(false);
			
			disconnectButton.setEnabled(true);
			startButton.setEnabled(true);
			resetButton.setEnabled(true);
			randomizeButton.setEnabled(true);
			
			for(int i = 0; i < 25; i++) {
				caselle[i].setReadOnly(false);
			}
			
		} catch (NumberFormatException | IOException e1) {
			e1.printStackTrace();
		}
		
		
	}

}
