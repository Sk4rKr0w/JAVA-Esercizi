import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;

public class Main {
	public static void main(String[] args) {
		
		JFrame frame;
		
		JPanel nPan;
		JPanel mPan;
		JPanel mNPan;
		JPanel mSPan;
		JPanel sPan;
		
		JLabel serverAddressLabel;
		JLabel portLabel;
		JLabel cpuLabel;
		JLabel memoryLabel;
		JLabel diskLabel;
		JLabel networkLabel;
		
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
		
		nPan = new JPanel(new FlowLayout());
		
		serverAddressLabel = new JLabel("Server Address");
		portLabel = new JLabel("Port");
		serverAddressField = new JTextField(20);
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
		
		//-----------------PANNELLO MID --------
		TitledBorder mNPanTitle = new TitledBorder("VM Status");
		mPan = new JPanel(new BorderLayout());
		
		//---------PANNELLO MID-NORD---------------------
		mNPan = new JPanel(new GridLayout(4,1,5,5));
		cpuLabel = new JLabel("CPU Usage");
		memoryLabel = new JLabel("Memory Usage");
		diskLabel = new JLabel ("Disk Usage");
		networkLabel = new JLabel("Network Usage");
		
		cpuBar = new JProgressBar(0,100);
		cpuBar.setStringPainted(true);
		memoryBar = new JProgressBar(0,100);
		memoryBar.setStringPainted(true);
		diskBar = new JProgressBar(0,100);
		diskBar.setStringPainted(true);
		networkBar = new JProgressBar(0,100);
		networkBar.setStringPainted(true);
		
		mNPan.add(cpuLabel);
		mNPan.add(cpuBar);
		mNPan.add(memoryLabel);
		mNPan.add(memoryBar);
		mNPan.add(diskLabel);
		mNPan.add(diskBar);
		mNPan.add(networkLabel);
		mNPan.add(networkBar);
		mNPan.setBorder(mNPanTitle);
		
		//------------------PANNELLO MID-SUD-----------------------
		TitledBorder mSPanTitle = new TitledBorder ("VM");
		mSPan = new JPanel(new FlowLayout());
		
		vm1Button = new JRadioButton("VM 1");
		vm2Button = new JRadioButton("VM 2");
		vm3Button = new JRadioButton("VM 3");
		
		vmButtonGroup = new ButtonGroup();
		vmButtonGroup.add(vm1Button);
		vmButtonGroup.add(vm2Button);
		vmButtonGroup.add(vm3Button);
		
		vm1Button.setEnabled(false);
		vm2Button.setEnabled(false);
		vm3Button.setEnabled(false);
		
		mSPan.add(vm1Button);
		mSPan.add(vm2Button);
		mSPan.add(vm3Button);
		mSPan.setBorder(mSPanTitle);
		
		//----------------PANNELLO MID FINALE--------------------
		mPan.add(mNPan, BorderLayout.NORTH);
		mPan.add(mSPan, BorderLayout.SOUTH);
		
		// ---------------------FRAME SUD----------
		
		sPan = new JPanel(new FlowLayout());
		
		startButton = new JButton("Start");
		startButton.setEnabled(false);
		
		stopButton = new JButton("Stop");
		stopButton.setEnabled(false);
		
		sPan.add(startButton);
		sPan.add(stopButton);
		
		//--------------FRAME FINALE---------------
		frame = new JFrame("Kevin Forte 1940058");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(sPan, BorderLayout.SOUTH);
		frame.add(nPan, BorderLayout.NORTH);
		frame.add(mPan, BorderLayout.CENTER);
		
		frame.setVisible(true);
		
		Connect azione_connetti = new Connect(serverAddressField, portField, connectButton, disconnectButton, startButton, stopButton, vm1Button, vm2Button, vm3Button, vmButtonGroup, cpuBar, memoryBar, diskBar, networkBar);
		connectButton.addActionListener(azione_connetti);
		
		Disconnect azione_disconnetti = new Disconnect(azione_connetti);
		disconnectButton.addActionListener(azione_disconnetti);
		
		Start azione_start = new Start(azione_connetti);
		startButton.addActionListener(azione_start);
		
		Stop azione_stop = new Stop(azione_connetti);
		stopButton.addActionListener(azione_stop);
		
		frame.pack();
	}
}
