import javax.swing.*;
import java.awt.*;

public class Main {

	public static void main(String[] args) {
		
		JFrame frame;
		
		JPanel nPan;
		JPanel wPan;
		JPanel ePan;
		JPanel sPan;
		
		JLabel serverAddressLabel;
		JLabel portLabel;
		JLabel hexadecimalLabel;
		JLabel decimalLabel;
		JLabel binaryLabel;
		
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
		JButton lettersButton;
		JButton numbersButton;
		
		//----------NORD PANEL----------------
		
		nPan = new JPanel(new FlowLayout());
		
		serverAddressLabel = new JLabel("IP Address");
		serverAddressField = new JTextField(15);
		serverAddressField.setText("127.0.0.1");
		serverAddressField.setEditable(false);
		
		portLabel = new JLabel("Port");
		portField = new JTextField(10);
		portField.setText("4400");
		portField.setEditable(false);
		
		connectButton = new JButton("Connect");
		
		disconnectButton = new JButton("Disconnect");
		disconnectButton.setEnabled(false);
		
		nPan.add(serverAddressLabel);
		nPan.add(serverAddressField);
		nPan.add(portLabel);
		nPan.add(portField);
		nPan.add(connectButton);
		nPan.add(disconnectButton);
		
		//----------SUD PANEL----------------
		
		sPan = new JPanel(new FlowLayout());
		
		startButton = new JButton("Start");
		startButton.setEnabled(false);
		
		stopButton = new JButton("Stop");
		stopButton.setEnabled(false);
		
		convertButton = new JButton("Convert");
		convertButton.setEnabled(false);
		
		sPan.add(startButton);
		sPan.add(stopButton);
		sPan.add(convertButton);
		
		//----------WEST PANEL----------------
		
		wPan = new JPanel(new FlowLayout());
		
		lettersButton = new JButton("A-Z");
		lettersButton .setEnabled(false);
		
		numbersButton  = new JButton("0-9");
		numbersButton .setEnabled(false);
		
		wPan.add(lettersButton);
		wPan.add(numbersButton);
		
		//----------EAST PANEL-----------------
		
		ePan = new JPanel(new GridLayout(3,1));
		
		hexadecimalLabel = new JLabel("Hexadecimal");
		
		hexadecimalField = new JTextField(20);
		hexadecimalField.setEditable(false);
		
		decimalLabel = new JLabel("Decimal");
		
		decimalField = new JTextField(20);
		decimalField.setEditable(false);
		
		binaryLabel = new JLabel("Binary");
		
		binaryField = new JTextField(20);
		binaryField.setEditable(false);
		
		ePan.add(hexadecimalLabel);
		ePan.add(hexadecimalField);
		ePan.add(decimalLabel);
		ePan.add(decimalField);
		ePan.add(binaryLabel);
		ePan.add(binaryField);
		
		//----------FRAME FINALE---------------
		frame = new JFrame("Kevin Forte 1940058");
		
		frame.add(nPan, BorderLayout.NORTH);
		frame.add(ePan, BorderLayout.EAST);
		frame.add(wPan, BorderLayout.WEST);
		frame.add(sPan, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		
		Connect azione_connetti = new Connect(serverAddressField, portField, hexadecimalField, decimalField, binaryField, connectButton, disconnectButton, startButton, stopButton, convertButton, lettersButton, numbersButton);
		connectButton.addActionListener(azione_connetti);
		
		Disconnect azione_disconnetti = new Disconnect(azione_connetti);
		disconnectButton.addActionListener(azione_disconnetti);
		
		Start azione_start = new Start(azione_connetti);
		startButton.addActionListener(azione_start);
			
		Stop azione_stop = new Stop(azione_connetti);
		stopButton.addActionListener(azione_stop);
		
		Lettere azione_lettere = new Lettere(azione_connetti);
		lettersButton.addActionListener(azione_lettere);
		
		Numeri azione_numeri = new Numeri(azione_connetti);
		numbersButton.addActionListener(azione_numeri);
		
		Convert azione_convert = new Convert(azione_connetti);
		convertButton.addActionListener(azione_convert);
		
		frame.pack();
	}

}
