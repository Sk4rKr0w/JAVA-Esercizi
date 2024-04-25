import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;

public class Main {

	public static void main(String[] args) {
		
		JFrame frame;
		
		JPanel nPan;
		JPanel mPan;
		JPanel ePan;
		JPanel sPan;
		
		JLabel serverAddressLabel;
		JLabel portLabel;
		
		JTextField serverAddressField;
		JTextField portField;
		
		JTextArea logArea;
		JScrollPane logAreaScroll;
		
		JButton connectButton;
		JButton disconnectButton;
		JButton startButton;
		JButton stopButton;
		
		TicketCell[] caselle = new TicketCell[15];
		//-----------NORD PANEL------------
		
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
		
		//---------SUD PANEL----------------
		
		sPan = new JPanel(new FlowLayout());
		
		startButton = new JButton("Start");
		startButton.setEnabled(false);
		
		stopButton = new JButton("Stop");
		stopButton.setEnabled(false);
		
		sPan.add(startButton);
		sPan.add(stopButton);
		
		//-----------EAST PANEL-------------
		TitledBorder ePanTitle = new TitledBorder("Log");
		ePan = new JPanel();
		
		logArea = new JTextArea(20,30);
		logAreaScroll = new JScrollPane(logArea);
		logAreaScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		logAreaScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		ePan.add(logAreaScroll);
		ePan.setBorder(ePanTitle);
		//-----------MID PANEL-------------
		TitledBorder mPanTitle = new TitledBorder("Cartella");
		mPan = new JPanel(new GridLayout(3,5,2,2));
		
		for(int i = 0; i < 15; i++) {
			caselle[i] = new TicketCell();
			mPan.add(caselle[i]);
		}
		
		mPan.setBorder(mPanTitle);
		//----------FRAME FINALE------------
		frame = new JFrame("Kevin Forte 1940058");
		
		frame.add(nPan, BorderLayout.NORTH);
		frame.add(sPan, BorderLayout.SOUTH);
		frame.add(mPan, BorderLayout.CENTER);
		frame.add(ePan, BorderLayout.EAST);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		Connect azione_connetti = new Connect(serverAddressField, portField, logArea, connectButton, disconnectButton, startButton, stopButton, caselle);
		connectButton.addActionListener(azione_connetti);
		
		Stop azione_stop = new Stop(azione_connetti);
		stopButton.addActionListener(azione_stop);
		
		Start azione_start = new Start(azione_connetti);
		startButton.addActionListener(azione_start);
		
		Disconnect azione_disconnect = new Disconnect(azione_connetti);
		disconnectButton.addActionListener(azione_disconnect);
		frame.pack();
		
	}

}
