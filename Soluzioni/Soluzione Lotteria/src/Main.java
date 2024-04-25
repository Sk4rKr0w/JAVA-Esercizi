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
		JLabel ruota1;
		JLabel ruota2;
		JLabel ruota3;
		JLabel ruota4;
		JLabel ruota5;
		
		JTextField serverAddressField;
		JTextField portField;
		
		JButton connectButton;
		JButton disconnectButton;
		JButton startButton;
		JButton stopButton;
		JButton resetButton;
		JButton randomizeButton;
				
		LotteryComboBox[] caselle = new LotteryComboBox[25];
		
		//------------------NORD PANEL-------------------------
		
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
		
		//-------------------SUD PANEL----------------------------
		
		sPan = new JPanel(new FlowLayout());
		
		startButton = new JButton("Start");
		startButton.setEnabled(false);
		
		stopButton = new JButton("Stop");
		stopButton.setEnabled(false);
		
		resetButton = new JButton("Reset");
		resetButton.setEnabled(false);
		
		randomizeButton = new JButton("Randomize");
		randomizeButton.setEnabled(false);
		
		sPan.add(startButton);
		sPan.add(stopButton);
		sPan.add(resetButton);
		sPan.add(randomizeButton);
		
		//------------------PANNELLO CENTRALE-------------------
		
		TitledBorder mPanTitle = new TitledBorder("Lotteria");
		mPan = new JPanel(new GridLayout(5,6,5,5));
		
		ruota1 = new JLabel("Ruota 1");
		ruota2 = new JLabel("Ruota 2");
		ruota3 = new JLabel("Ruota 3");
		ruota4 = new JLabel("Ruota 4");
		ruota5 = new JLabel("Ruota 5");
		
		mPan.add(ruota1);
		for(int i = 0; i < 5; i++) {
			caselle[i] = new LotteryComboBox();
			caselle[i].setReadOnly(true);
			mPan.add(caselle[i]);
		}
		
		mPan.add(ruota2);
		for(int i = 5; i < 10; i++) {
			caselle[i] = new LotteryComboBox();
			caselle[i].setReadOnly(true);
			mPan.add(caselle[i]);
		}
		
		mPan.add(ruota3);
		for(int i = 10; i < 15; i++) {
			caselle[i] = new LotteryComboBox();
			caselle[i].setReadOnly(true);
			mPan.add(caselle[i]);
		}
		
		mPan.add(ruota4);
		for(int i = 15; i < 20; i++) {
			caselle[i] = new LotteryComboBox();
			caselle[i].setReadOnly(true);
			mPan.add(caselle[i]);
		}
		mPan.add(ruota5);
		for(int i = 20; i < 25; i++) {
			caselle[i] = new LotteryComboBox();
			caselle[i].setReadOnly(true);
			mPan.add(caselle[i]);
		}
		mPan.setBorder(mPanTitle);
		//------------------FRAME FINALE------------------------
		frame = new JFrame("Kevin Forte 1940058");
		
		frame.add(nPan, BorderLayout.NORTH);
		frame.add(sPan, BorderLayout.SOUTH);
		frame.add(mPan, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
				
		Connect azione_connetti = new Connect(connectButton, disconnectButton, startButton, stopButton, resetButton, randomizeButton, serverAddressField, portField, caselle);
		connectButton.addActionListener(azione_connetti);

		Disconnect azione_disconnetti = new Disconnect(azione_connetti);
		disconnectButton.addActionListener(azione_disconnetti);
		
		Start azione_start = new Start(azione_connetti);
		startButton.addActionListener(azione_start);
		
		Stop azione_stop = new Stop(azione_connetti);
		stopButton.addActionListener(azione_stop);
		
		Reset azione_reset = new Reset(azione_connetti);
		resetButton.addActionListener(azione_reset);
		
		Randomize azione_randomize = new Randomize(azione_connetti);
		randomizeButton.addActionListener(azione_randomize);
		
		frame.pack();
	}
}