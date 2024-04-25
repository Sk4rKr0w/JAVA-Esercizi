import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Connect implements ActionListener {
	
	JTextField serverAddressField;
	JTextField portField;
	
	JButton connectButton;
	JButton disconnectButton;
	JButton startButton;
	JButton stopButton;
	
	JRadioButton vm1Button;
	JRadioButton vm2Button;
	JRadioButton vm3Button;
	ButtonGroup vmButtonGroup;
	
	JProgressBar cpuBar;
	JProgressBar memoryBar;
	JProgressBar diskBar;
	JProgressBar networkBar;
	
	Socket client;
	PrintWriter pw;
	Scanner sc;
	
	public Connect(JTextField serverAddressField, JTextField portField, JButton connectButton, JButton disconnectButton,
			JButton startButton, JButton stopButton, JRadioButton vm1Button, JRadioButton vm2Button, JRadioButton vm3Button,
			ButtonGroup vmButtonGroup, JProgressBar cpuBar, JProgressBar memoryBar, JProgressBar diskBar, JProgressBar networkBar) {
		
		this.serverAddressField = serverAddressField;
		this.portField = portField;
		this.connectButton = connectButton;
		this.disconnectButton = disconnectButton;
		this.startButton = startButton;
		this.stopButton = stopButton;
		this.vm1Button = vm1Button;
		this.vm2Button = vm2Button;
		this.vm3Button = vm3Button;
		this.vmButtonGroup = vmButtonGroup;
		this.cpuBar = cpuBar;
		this.memoryBar = memoryBar;
		this.diskBar = diskBar;
		this.networkBar = networkBar;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			client = new Socket(serverAddressField.getText(), Integer.parseInt(portField.getText()));
			pw  = new PrintWriter(client.getOutputStream());
			sc = new Scanner(client.getInputStream());
			connectButton.setEnabled(false);
			disconnectButton.setEnabled(true);
			startButton.setEnabled(true);
			vm1Button.setEnabled(true);
			vm2Button.setEnabled(true);
			vm3Button.setEnabled(true);
		} catch (NumberFormatException | IOException e1) {
			JOptionPane.showMessageDialog(null, "Non Connesso");
			System.out.println(e1.getMessage());
		}
		
	}
}
