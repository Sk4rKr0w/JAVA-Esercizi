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
	JTextField commandField;
	
	JTextArea consoleArea;
	
	JButton connectButton;
	JButton disconnectButton;
	JButton executeButton;
	JButton interruptButton;
	
	Socket client;
	PrintWriter pw;
	Scanner sc;
	
	public Connect(JTextField serverAddressField, JTextField portField,
			JTextField commandField, JTextArea consoleArea, JButton connectButton,
			JButton disconnectButton,JButton executeButton, JButton interruptButton) {
		
		this.serverAddressField = serverAddressField;
		this.portField = portField;
		this.commandField = commandField;
		this.consoleArea = consoleArea;
		this.connectButton = connectButton;
		this.disconnectButton = disconnectButton;
		this.executeButton = executeButton;
		this.interruptButton = interruptButton;
				
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			client = new Socket(serverAddressField.getText(), Integer.parseInt(portField.getText()));
			pw = new PrintWriter(client.getOutputStream());
			sc = new Scanner(client.getInputStream());
			
			connectButton.setEnabled(false);
			disconnectButton.setEnabled(true);
			executeButton.setEnabled(true);
			interruptButton.setEnabled(false);
			
			consoleArea.setText("");
		} catch (NumberFormatException | IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
}
