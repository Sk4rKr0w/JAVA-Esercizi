import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Connect implements ActionListener{
		
	JTextField serverAddressField;
	JTextField portField;
	
	JButton connectButton;
	JButton disconnectButton;
	JButton startButton;
	JButton stopButton;
	JButton revealButton;
	
	PrintWriter pw;
	Socket client;
	Scanner sc;
	BoardButton campoDiGioco[][];
	
	public Connect(JTextField serverAddressField, JTextField portField, JButton connectButton, JButton disconnectButton,
			JButton startButton, JButton stopButton, JButton revealButton, BoardButton[][] campoDiGioco) {
		
		this.serverAddressField = serverAddressField;
		this.portField = portField;
		this.connectButton = connectButton;
		this.disconnectButton = disconnectButton;
		this.startButton = startButton;
		this.stopButton = stopButton;
		this.revealButton = revealButton;
		this.campoDiGioco = campoDiGioco;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			client = new Socket(serverAddressField.getText(), Integer.parseInt(portField.getText()));
			pw = new PrintWriter(this.client.getOutputStream());
			sc = new Scanner(this.client.getInputStream());
			connectButton.setEnabled(false);
			disconnectButton.setEnabled(true);
			startButton.setEnabled(true);
			revealButton.setEnabled(false);
			
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
	}
}
