import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Connect implements ActionListener {
	
	JTextField serverAddressField;
	JTextField portField;
	
	JTextArea logArea;
	
	JButton connectButton;
	JButton disconnectButton;
	JButton startButton;
	JButton stopButton;
	
	TicketCell[] caselle;
	
	Socket client;
	PrintWriter pw;
	Scanner sc;
	
	public Connect(JTextField serverAddressField,JTextField portField,JTextArea logArea,
			JButton connectButton,JButton disconnectButton,JButton startButton,
			JButton stopButton,TicketCell[] caselle) {
		
		this.serverAddressField = serverAddressField;
		this.portField = portField;
		this.logArea = logArea;
		this.connectButton = connectButton;
		this.disconnectButton = disconnectButton;
		this.startButton = startButton;
		this.stopButton = stopButton;
		this.caselle = caselle;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			client = new Socket(serverAddressField.getText(), Integer.parseInt(portField.getText()));
			pw = new PrintWriter(client.getOutputStream());
			sc = new Scanner(client.getInputStream());
			
			connectButton.setEnabled(false);
			startButton.setEnabled(true);
			disconnectButton.setEnabled(true);
			
		} catch (NumberFormatException | IOException e1) {
			e1.printStackTrace();
		}
		
	}

}
