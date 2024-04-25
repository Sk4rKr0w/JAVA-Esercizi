import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Connect implements ActionListener {
	
	JButton connectButton;
	JButton disconnectButton;
	JButton startButton;
	JButton stopButton;
	JButton clearButton;
		
	JTextField serverAddressField;
	JTextField portField;
	
	ColoredButton[] casella;
	
	Socket client;
	PrintWriter pw;
	Scanner sc;
	
	public Connect(JButton connectButton, JButton disconnectButton, JButton startButton, JButton stopButton,
			JButton clearButton, JTextField serverAddressField, JTextField portField, ColoredButton[] casella) {
		
		this.connectButton = connectButton;
		this.disconnectButton = disconnectButton;
		this.startButton = startButton;
		this.stopButton = stopButton;
		this.clearButton = clearButton;
		this.serverAddressField = serverAddressField;
		this.portField = portField;
		this.casella = casella;
		
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
			stopButton.setEnabled(false);
		} catch (NumberFormatException | IOException e1) {
			e1.printStackTrace();
		}
		
	}

}
