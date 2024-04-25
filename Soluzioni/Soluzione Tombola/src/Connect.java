import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Connect implements ActionListener{
	
	JTextField serverAddressField;
	JTextField portField;
	
	JTextArea logArea;
	
	JButton connectButton;
	JButton disconnectButton;
	JButton startButton;
	JButton stopButton;
	
	Socket client;
	PrintWriter pw;
	Scanner sc;
	
	public Connect(JTextField serverAddressField, JTextField portField, 
			JTextArea logArea, JButton connectButton, JButton disconnectButton,
			JButton startButton,JButton stopButton) 
	
	{
		
		this.serverAddressField = serverAddressField;
		this.portField = portField;
		this.logArea = logArea;
		this.connectButton = connectButton;
		this.disconnectButton = disconnectButton;
		this.startButton = startButton;
		this.stopButton = stopButton;
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (serverAddressField.getText().isBlank() || portField.getText().isBlank()) {
			logArea.append("Inserire indirizzo IP e porta corretti!\n");
		}
		else {			
			try {
				connectButton.setEnabled(false);
				disconnectButton.setEnabled(true);
				startButton.setEnabled(true);
				stopButton.setEnabled(false);
				
				client = new Socket(serverAddressField.getText(), Integer.parseInt(portField.getText()));
				pw = new PrintWriter(client.getOutputStream());
				sc = new Scanner(client.getInputStream());
				
				serverAddressField.setEditable(false);
				portField.setEditable(false);
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				System.err.println("Connessione non riuscita! Prova a ricollegarti a Internet!");
				logArea.append("Connessione non riuscita! Prova a ricollegarti a Internet!\n");
				connectButton.setEnabled(true);
				disconnectButton.setEnabled(false);
				startButton.setEnabled(false);
				stopButton.setEnabled(false);
			}
		}
		
	}
	
	
	
}
