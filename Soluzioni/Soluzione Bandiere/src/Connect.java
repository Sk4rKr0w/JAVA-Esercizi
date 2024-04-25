import java.awt.event.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Connect implements ActionListener{
	
	JPanel mWPan;
	JPanel mCPan;
	JPanel mEPan;
	
	JTextField ipAddressField;
	JTextField portField;
	
	JButton connectButton;
	JButton disconnectButton;
	JButton startButton;
	JButton stopButton;
	
	PrintWriter pw;
	Socket client;
	Scanner sc;
	public Connect(JTextField ipAddressField, JTextField portField, 
			JButton connectButton, JButton disconnectButton, JButton startButton, 
			JButton stopButton, JPanel mWPan, JPanel mCPan, JPanel mEPan) {
		
		this.ipAddressField = ipAddressField;
		this.portField = portField;
		this.connectButton = connectButton;
		this.disconnectButton = disconnectButton;
		this.startButton = startButton;
		this.stopButton = stopButton;
		this.mWPan = mWPan;
		this.mCPan = mCPan;
		this.mEPan = mEPan;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			client = new Socket(ipAddressField.getText(), Integer.parseInt(portField.getText()));
			pw = new PrintWriter(client.getOutputStream());
			sc = new Scanner(client.getInputStream());
			connectButton.setEnabled(false);
			disconnectButton.setEnabled(true);
			startButton.setEnabled(true);
			stopButton.setEnabled(false);	
		} catch (NumberFormatException | IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	
}
