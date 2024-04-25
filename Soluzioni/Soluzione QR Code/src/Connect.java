import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Connect implements ActionListener {
	
	JTextField serverAddressField;
	JTextField portField;
	JTextField enterTextField;
	
	JTextArea qrCodeArea;
	
	JButton connectButton;
	JButton disconnectButton;
	JButton startButton;
	JButton stopButton;
	
	PrintWriter pw;
	Socket client;
	Scanner sc;
	
	public Connect(JTextField serverAddressField, JTextField portField, JTextField enterTextField, JTextArea qrCodeArea,
			JButton connectButton, JButton disconnectButton, JButton startButton, JButton stopButton) {
		
		this.serverAddressField = serverAddressField;
		this.portField = portField;
		this.enterTextField = enterTextField;
		this.qrCodeArea = qrCodeArea;
		this.connectButton = connectButton;
		this.disconnectButton = disconnectButton;
		this.startButton = startButton;
		this.stopButton = stopButton;

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
			enterTextField.setEditable(true);
			
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
	}
	
	
}
