import javax.swing.*;
import java.awt.*;

public class Main {

	public static void main(String[] args) {

		JFrame frame;
		
		JPanel nPan;
		JPanel mPan;
		JPanel sPan;
		
		JPanel mWPan;
		JPanel mCPan;
		JPanel mEPan;
		
		
		JLabel ipAddressLabel;
		JLabel portLabel;
		
		JTextField ipAddressField;
		JTextField portField;
		
		JButton connectButton;
		JButton disconnectButton;
		JButton startButton;
		JButton stopButton;
		
		//------PANNELLO MID-----------
		
		mPan = new JPanel(new FlowLayout(0,2,1));
		mCPan = new JPanel();
		mCPan.setPreferredSize(new Dimension(200,500));
		mCPan.setBackground(Color.LIGHT_GRAY);
		mWPan = new JPanel();
		mWPan.setPreferredSize(new Dimension(200,500));
		mWPan.setBackground(Color.LIGHT_GRAY);
		mEPan = new JPanel();
		mEPan.setPreferredSize(new Dimension(200,500));
		mEPan.setBackground(Color.LIGHT_GRAY);
		
		mPan.add(mWPan);
		mPan.add(mCPan);
		mPan.add(mEPan);
		mPan.setBackground(Color.BLACK);
		//--------------PANNELLO NORD--
		
		nPan = new JPanel(new FlowLayout());
		ipAddressLabel = new JLabel("IP Address");
		ipAddressField = new JTextField(15);
		ipAddressField.setText("127.0.0.1");
		ipAddressField.setEditable(false);
		portLabel = new JLabel("Port");
		portField = new JTextField(10);
		portField.setText("4400");
		portField.setEditable(false);
		connectButton = new JButton("Connect");
		disconnectButton = new JButton("Disconnect");
		disconnectButton.setEnabled(false);
		
		nPan.add(ipAddressLabel);
		nPan.add(ipAddressField);
		nPan.add(portLabel);
		nPan.add(portField);
		nPan.add(connectButton);
		nPan.add(disconnectButton);
		
		// -----PANNELLO SUD-----------
		sPan = new JPanel(new FlowLayout());
		startButton = new JButton("Start");
		startButton.setEnabled(false);
		stopButton = new JButton("Stop");
		stopButton.setEnabled(false);
		
		startButton.setEnabled(false);
		stopButton.setEnabled(false);
		
		sPan.add(startButton);
		sPan.add(stopButton);
		
		//----FRAME FINALE-------
		frame = new JFrame("Kevin Forte 1940058");
		
		frame.add(mPan, BorderLayout.CENTER);
		frame.add(nPan, BorderLayout.NORTH);
		frame.add(sPan, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		Connect azione_connetti = new Connect(ipAddressField, portField, connectButton, disconnectButton, startButton, stopButton, mWPan, mCPan, mEPan);
		connectButton.addActionListener(azione_connetti);
		
		Disconnect azione_disconnect = new Disconnect(azione_connetti);
		disconnectButton.addActionListener(azione_disconnect);
		
		Start azione_start = new Start(azione_connetti);
		startButton.addActionListener(azione_start);
		
		Stop azione_stop = new Stop(azione_connetti);
		stopButton.addActionListener(azione_stop);
		frame.pack();
		
	}
}