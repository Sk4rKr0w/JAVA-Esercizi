import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class Main {
	public static void main(String[] args) {
		
		JFrame frame;
		
		JPanel nPan;
		JPanel sPan;
		JPanel mPan;
		
		JLabel serverAddressLabel;
		JLabel portLabel;
		JLabel commandLabel;
		
		JScrollPane consoleScroll;
		
		JTextField serverAddressField;
		JTextField portField;
		JTextField commandField;
		
		JTextArea consoleArea;
		
		JButton connectButton;
		JButton disconnectButton;
		JButton executeButton;
		JButton interruptButton;
		
		//-------------NORD PANEL--------------
		
		nPan = new JPanel(new FlowLayout());
		
		serverAddressLabel = new JLabel("Server Address");
		serverAddressField = new JTextField(10);
		
		portLabel = new JLabel("Port");
		portField = new JTextField(5);
		
		connectButton = new JButton("Connect");
		
		disconnectButton = new JButton("Disconnect");
		disconnectButton.setEnabled(false);
		
		nPan.add(serverAddressLabel);
		nPan.add(serverAddressField);
		nPan.add(portLabel);
		nPan.add(portField);
		nPan.add(connectButton);
		nPan.add(disconnectButton);
		
		//-------------SUD PANEL---------------
		
		sPan = new JPanel(new FlowLayout());
		
		commandLabel = new JLabel("Command");
		commandField = new JTextField(20);
		
		executeButton = new JButton("Execute");
		executeButton.setEnabled(false);
		
		interruptButton = new JButton("Interrupt");
		interruptButton.setEnabled(false);
		
		sPan.add(commandLabel);
		sPan.add(commandField);
		sPan.add(executeButton);
		sPan.add(interruptButton);
		
		//--------------MID PANEL---------------
		
		TitledBorder mPanTitle = new TitledBorder("Console");
		mPan = new JPanel();
		
		consoleArea = new JTextArea(25,80);
		consoleArea.setEditable(false);
		consoleScroll = new JScrollPane(consoleArea);
		consoleScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		consoleScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		mPan.add(consoleScroll);
		mPan.setBorder(mPanTitle);
		
		//--------------FRAME FINALE------------
		
		frame = new JFrame("Kevin Forte 1940058");
		
		frame.add(nPan, BorderLayout.NORTH);
		frame.add(sPan, BorderLayout.SOUTH);
		frame.add(mPan, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		Connect azione_connetti = new Connect(serverAddressField, portField, commandField, consoleArea, connectButton, disconnectButton, executeButton, interruptButton);
		connectButton.addActionListener(azione_connetti);
		
		Disconnect azione_disconnetti = new Disconnect(azione_connetti);
		disconnectButton.addActionListener(azione_disconnetti);
		
		Execute azione_execute = new Execute(azione_connetti);
		executeButton.addActionListener(azione_execute);
		
		Interrupt azione_interrupt = new Interrupt(azione_connetti);
		interruptButton.addActionListener(azione_interrupt);
		frame.pack();
	}
}
