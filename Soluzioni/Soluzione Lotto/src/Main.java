
import javax.swing.*;
import java.awt.*;

public class Main {
	public static void main(String[] args) {
		
		JFrame frame;
		
		JPanel nPan;
		JPanel mPan;
		JPanel sPan;
		
		JButton connectButton;
		JButton disconnectButton;
		JButton startButton;
		JButton stopButton;
		JButton clearButton;
		
		JLabel serverAddressLabel;
		JLabel portLabel;
		
		JTextField serverAddressField;
		JTextField portField;
		
		ColoredButton[] casella = new ColoredButton[5];
		
		//------------------PANNELLO NORD---------
		nPan = new JPanel(new FlowLayout());
		
		startButton = new JButton("Start");
		startButton.setEnabled(false);
		
		serverAddressLabel = new JLabel("IP Address");
		
		serverAddressField = new JTextField(10);
		serverAddressField.setText("127.0.0.1");
		serverAddressField.setEditable(false);
		
		portLabel = new JLabel("Port");
		
		portField = new JTextField(5);
		portField.setText("4400");
		portField.setEditable(false);
		
		stopButton = new JButton("Stop");
		stopButton.setEnabled(false);
		
		nPan.add(startButton);
		nPan.add(serverAddressLabel);
		nPan.add(serverAddressField);
		nPan.add(portLabel);
		nPan.add(portField);
		nPan.add(stopButton);
		
		//-----------------PANNELLO SUD-----------
		
		sPan = new JPanel(new FlowLayout());
		
		connectButton = new JButton("Connect");
		
		disconnectButton = new JButton("Disconnect");
		disconnectButton.setEnabled(false);
		
		clearButton = new JButton("Clear");
		clearButton.setEnabled(true);
		
		sPan.add(connectButton);
		sPan.add(disconnectButton);
		sPan.add(clearButton);
		
		//-------------------PANNELLO MID------
		
		mPan = new JPanel(new GridLayout(1,5,3,3));
		
		for(int i = 0; i < 5; i++) {
			casella[i] = new ColoredButton(null, Color.LIGHT_GRAY);
			mPan.add(casella[i]);
		}
		//--------------FRAME FINALE----------------
		
		frame = new JFrame("Kevin Forte 1940058");
		
		frame.add(mPan, BorderLayout.CENTER);
		frame.add(sPan, BorderLayout.SOUTH);
		frame.add(nPan, BorderLayout.NORTH);
		
		frame.setSize(700,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		Connect azione_connetti = new Connect(connectButton, disconnectButton, startButton, stopButton, clearButton, serverAddressField, portField, casella);
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
