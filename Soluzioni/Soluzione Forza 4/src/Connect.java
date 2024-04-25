import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Connect implements ActionListener{
	
	JTextField ipAddressField;
	JTextField portField;
	
	JButton connectButton;
	JButton disconnectButton;
	JButton clearButton;
	JButton startButton;
	JButton stopButton;
	JButton[] pedinaButton;
	
	String coloreUtente = "";
	String coloreServer = "";
	
	Socket client;
	PrintWriter pw;
	Scanner sc;
	
	public Connect(JTextField ipAddressField, JTextField portField, 
			JButton connectButton, JButton disconnectButton, 
			JButton clearButton, JButton startButton, JButton stopButton,
			JButton[] pedinaButton) {
		
		this.ipAddressField = ipAddressField;
		this.portField = portField;
		this.connectButton = connectButton;
		this.disconnectButton = disconnectButton;
		this.clearButton = clearButton;
		this.startButton = startButton;
		this.stopButton = stopButton;
		this.pedinaButton = pedinaButton;
				
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
		} catch (NumberFormatException | IOException e1) {
			e1.printStackTrace();
		}
		
		
	}
	
}
