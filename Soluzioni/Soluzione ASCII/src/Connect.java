import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Connect implements ActionListener {
	
	JTextField serverAddressField;
	JTextField portField;
	
	JTextArea imageArea;
	
	JButton connectButton;
	JButton disconnectButton;
	JButton stopButton;
	JButton image1;
	JButton image2;
	JButton image3;
	JButton image4;
	JButton image5;
	
	Socket client;
	PrintWriter pw;
	Scanner sc;
	
	public Connect(JTextField serverAddressField,JTextField portField,JTextArea imageArea,
			JButton connectButton,JButton disconnectButton,JButton stopButton,
			JButton image1,JButton image2,JButton image3,JButton image4,JButton image5) {
		
		this.serverAddressField= serverAddressField;
		this.portField = portField;
		this.imageArea = imageArea;
		this.connectButton = connectButton;
		this.disconnectButton = disconnectButton;
		this.stopButton = stopButton;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.image4 = image4;
		this.image5 = image5;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			client = new Socket(serverAddressField.getText(),Integer.parseInt(portField.getText()));
			pw = new PrintWriter(client.getOutputStream());
			sc = new Scanner(client.getInputStream());
			
			connectButton.setEnabled(false);
			disconnectButton.setEnabled(true);
			stopButton.setEnabled(false);
			image1.setEnabled(true);
			image2.setEnabled(true);
			image3.setEnabled(true);
			image4.setEnabled(true);
			image5.setEnabled(true);
		} catch (NumberFormatException | IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
}
