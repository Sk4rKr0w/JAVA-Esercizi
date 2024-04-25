import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;

public class Main {

	public static void main(String[] args) {
		
		JFrame frame;
		
		JPanel nPan;
		JPanel mPan;
		JPanel sPan;
		
		JLabel serverAddressLabel;
		JLabel portLabel;
		JLabel enterTextLabel;
		
		JTextField serverAddressField;
		JTextField portField;
		JTextField enterTextField;
		
		JTextArea qrCodeArea;
		
		JButton connectButton;
		JButton disconnectButton;
		JButton startButton;
		JButton stopButton;
		
		//-----------------------------------PANNELLO SUD------------------
		
		TitledBorder sPanTitle = new TitledBorder("QR Code");
		
		sPan = new JPanel();
		
		qrCodeArea = new JTextArea(25,80);
		qrCodeArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
		qrCodeArea.setEditable(false);
		
		sPan.add(qrCodeArea);
		sPan.setBorder(sPanTitle);
		
		//-----------------------------------PANNELLO CENTRALE-----------
		
		TitledBorder mPanTitle = new TitledBorder("QR Code Generator");
		mPan = new JPanel(new FlowLayout());
		enterTextLabel = new JLabel("Enter Text");
		enterTextField = new JTextField(50);
		enterTextField.setEditable(false);
		
		startButton = new JButton("Start");
		stopButton = new JButton("Stop");
		startButton.setEnabled(false);
		stopButton.setEnabled(false);
		
		mPan.add(enterTextLabel);
		mPan.add(enterTextField);
		mPan.add(startButton);
		mPan.add(stopButton);
		
		mPan.setBorder(mPanTitle);
		
		//-----------------------------------PANNELLO NORD-----------------
		
		nPan = new JPanel(new FlowLayout());
		serverAddressLabel = new JLabel("Server Address");
		serverAddressField = new JTextField(15);
		
		portLabel = new JLabel ("Port");
		portField = new JTextField(10);
		
		connectButton = new JButton("Connect");
		disconnectButton = new JButton("Disconnect");
		disconnectButton.setEnabled(false);
		
		nPan.add(serverAddressLabel);
		nPan.add(serverAddressField);
		nPan.add(portLabel);
		nPan.add(portField);
		nPan.add(connectButton);
		nPan.add(disconnectButton);
		
		//------------------------------------FRAME FINALE----------------
		
		frame = new JFrame("Kevin Forte 1940058");
		
		frame.add(sPan, BorderLayout.SOUTH);
		frame.add(mPan, BorderLayout.CENTER);
		frame.add(nPan, BorderLayout.NORTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		Connect azione_connetti = new Connect(serverAddressField, portField, enterTextField, qrCodeArea, connectButton, disconnectButton, startButton, stopButton);
		connectButton.addActionListener(azione_connetti);
		frame.pack();
		
		Disconnect azione_disconnetti = new Disconnect(azione_connetti);
		disconnectButton.addActionListener(azione_disconnetti);
		
		Stop azione_stop = new Stop(azione_connetti);
		stopButton.addActionListener(azione_stop);
		
		Start azione_start = new Start(azione_connetti);
		startButton.addActionListener(azione_start);
		
	}

}
