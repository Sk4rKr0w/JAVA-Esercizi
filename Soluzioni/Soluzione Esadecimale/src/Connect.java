import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Connect implements ActionListener {
	
	JTextField serverAddressField;
	JTextField portField;
	JTextField hexadecimalField;
	JTextField decimalField;
	JTextField binaryField;
	
	JButton connectButton;
	JButton disconnectButton;
	JButton startButton;
	JButton stopButton;
	JButton convertButton;
	JButton lettersButton ;
	JButton numbersButton ;
	
	Socket client;
	PrintWriter pw;
	Scanner sc;
	
	public Connect(JTextField serverAddressField,
	JTextField portField,
	JTextField hexadecimalField,
	JTextField decimalField,
	JTextField binaryField,
	
	JButton connectButton,
	JButton disconnectButton,
	JButton startButton,
	JButton stopButton,
	JButton convertButton,
	JButton lettersButton ,
	JButton numbersButton ) {
		
		
		this.serverAddressField = serverAddressField;
		this.portField = portField;
		this.hexadecimalField = hexadecimalField;
		this.decimalField = decimalField;
		this.binaryField = binaryField;
		this.connectButton = connectButton;
		this.disconnectButton = disconnectButton;
		this.startButton = startButton;
		this.stopButton = stopButton;
		this.convertButton = convertButton;
		this.lettersButton  = lettersButton ;
		this.numbersButton  = numbersButton ;
		
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
