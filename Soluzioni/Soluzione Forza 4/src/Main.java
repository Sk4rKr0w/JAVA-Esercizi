import javax.swing.*;
import java.awt.*;

public class Main {

	public static void main(String[] args) {
		
		JFrame frame;
		
		JPanel nPan;
		JPanel mPan;
		JPanel sPan;
		
		JLabel ipAddressLabel;
		JLabel portLabel;
		
		JTextField ipAddressField;
		JTextField portField;
		
		JButton connectButton;
		JButton disconnectButton;
		JButton clearButton;
		JButton startButton;
		JButton stopButton;
		JButton[] pedinaButton = new JButton[16];
		//---------------PANNELLO NORD--------------
		
		nPan = new JPanel(new FlowLayout());
		
		startButton = new JButton("Start");
		startButton.setEnabled(false);
		
		ipAddressLabel = new JLabel("IP Address");
		
		ipAddressField = new JTextField(10);
		ipAddressField.setText("127.0.0.1");
		ipAddressField.setEnabled(false);
		
		portLabel = new JLabel("Port");
		
		portField = new JTextField(10);
		portField.setText("4400");
		portField.setEnabled(false);
		
		stopButton = new JButton("Stop");
		stopButton.setEnabled(false);
		
		nPan.add(startButton);
		nPan.add(ipAddressLabel);
		nPan.add(ipAddressField);
		nPan.add(portLabel);
		nPan.add(portField);
		nPan.add(stopButton);
		
		//----------------PANNELLO SUD-------------
		
		sPan = new JPanel(new FlowLayout());
		
		connectButton = new JButton("Connect");
		
		disconnectButton = new JButton("Disconnect");
		disconnectButton.setEnabled(false);
		
		clearButton = new JButton("Clear");
		clearButton.setEnabled(true);
		
		sPan.add(connectButton);
		sPan.add(disconnectButton);
		sPan.add(clearButton);
		
		//-------------PANNELLO CENTRALE----------
		
		mPan = new JPanel(new GridLayout(4,4,2,2));
		
		for(int i = 0; i < 16; i++) {
			pedinaButton[i] = new JButton();
			pedinaButton[i].setBackground(Color.LIGHT_GRAY);
			pedinaButton[i].setEnabled(false);
			mPan.add(pedinaButton[i]);
		}
		
		//------------FRAME FINALE-----------------
		
		frame = new JFrame("Kevin Forte 1940058");
		
		frame.add(nPan, BorderLayout.NORTH);
		frame.add(sPan, BorderLayout.SOUTH);
		frame.add(mPan, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(new Dimension(800,600));
		
		Connect azione_connetti = new Connect(ipAddressField, portField, connectButton, disconnectButton, clearButton, startButton, stopButton, pedinaButton);
		connectButton.addActionListener(azione_connetti);
	
		Disconnect azione_disconnetti = new Disconnect(azione_connetti);
		disconnectButton.addActionListener(azione_disconnetti);
		
		Start azione_start = new Start(azione_connetti);
		startButton.addActionListener(azione_start);
		
		Stop azione_stop = new Stop(azione_connetti);
		stopButton.addActionListener(azione_stop);
		
		Clear azione_clear = new Clear(azione_connetti);
		clearButton.addActionListener(azione_clear);
		
	}

}
