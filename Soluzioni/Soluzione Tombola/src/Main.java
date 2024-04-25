import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;

public class Main {

	public static void main(String[] args) {
		
		JFrame frame;
		
		JPanel ePan;
		JPanel nPan;
		JPanel mPan;
		JPanel sPan;
		
		JLabel serverAddressLabel;
		JLabel portLabel;
		
		JTextField serverAddressField;
		JTextField portField;
		
		JTextArea logArea;
		JScrollPane logAreaScrollPane;
		
		JButton connectButton;
		JButton disconnectButton;
		JButton startButton;
		JButton stopButton;
		
		TicketCell Cartella[] = new TicketCell[15];
		
		//--------------------------------------------PANNELLO SUD-------------------------------------
		
		sPan = new JPanel(new FlowLayout());		
		
		startButton = new JButton("Start");
		startButton.setEnabled(false);
		
		stopButton = new JButton("Stop");
		stopButton.setEnabled(false);
		
		sPan.add(startButton);
		sPan.add(stopButton);
		
		//-------------------------------------------PANNELLO DESTRA-----------------------------------
		
		TitledBorder ePanTitle = new TitledBorder("Log");
		ePan = new JPanel();
		
		logArea = new JTextArea(20,30);
		logArea.setEditable(false);
		
		logAreaScrollPane = new JScrollPane(logArea);
		logAreaScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		logAreaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		ePan.add(logAreaScrollPane);
		ePan.setBorder(ePanTitle);
		//-------------------------------------------PANNELLO NORD----------------------------------------
		
		nPan = new JPanel(new FlowLayout());
		
		serverAddressLabel = new JLabel("Server Address");
		serverAddressField = new JTextField(20);
		
		portLabel = new JLabel("Port");
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
		
		//---------------------------------------------PANNELLO CENTRALE----------------------------------
		
		TitledBorder mPanTitle = new TitledBorder("Cartella");
		mPan = new JPanel(new GridLayout(3,5,3,3));
		
		for(int i = 0; i < 15; i++) {
			Cartella[i] = new TicketCell();
			mPan.add(Cartella[i]);
		}
		
		mPan.setBorder(mPanTitle);
		
		//---------------------------------------PANNELLO FINALE------------------------------------------
		frame = new JFrame("Kevin Forte 1940058");
		
		frame.add(sPan, BorderLayout.SOUTH);
		frame.add(ePan, BorderLayout.EAST);
		frame.add(mPan,BorderLayout.CENTER);
		frame.add(nPan, BorderLayout.NORTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		Connect azione_connetti = new Connect(serverAddressField, portField, logArea, connectButton, disconnectButton, startButton, stopButton);
		connectButton.addActionListener(azione_connetti);
		
		Disconnect azione_disconnetti = new Disconnect(azione_connetti);
		disconnectButton.addActionListener(azione_disconnetti);
		
		Start azione_start = new Start(azione_connetti, Cartella);
		startButton.addActionListener(azione_start);
		
		Stop azione_stop = new Stop(azione_connetti);
		stopButton.addActionListener(azione_stop);
		
		frame.pack();
		

	}

}
