import javax.swing.*;
import java.awt.*;

public class Main {

	public static void main(String[] args) {	
		
		JFrame frame;
		
		JPanel nPan;
		JPanel mPan;
		JPanel sPan;
		
		JLabel serverAddressLabel;
		JLabel portLabel;
		
		JTextField serverAddressField;
		JTextField portField;
		
		JButton connectButton;
		JButton disconnectButton;
		JButton onButton;
		JButton offButton;
		JButton plusButton;
		JButton minusButton;

		TermostatoPanel tempButton;
		
		//-----------PANNELLO NORD----------
		
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
		
		//----------SUD PANEL--------------
		
		sPan = new JPanel(new FlowLayout());
		
		onButton = new JButton("Accendi");
		onButton.setEnabled(false);
		
		offButton = new JButton("Spegni");
		offButton.setEnabled(false);
		
		sPan.add(onButton);
		sPan.add(offButton);
		
		//---------PANNELLO MID-----------------
		
		mPan = new JPanel(new FlowLayout());
		
		plusButton = new JButton("+");
		plusButton.setEnabled(false);
		
		minusButton = new JButton("-");
		minusButton.setEnabled(false);
		
		tempButton = new TermostatoPanel();
		tempButton.setEnabled(false);
		tempButton.setBackground(Color.LIGHT_GRAY);
		
		mPan.add(tempButton);
		mPan.add(plusButton);
		mPan.add(minusButton);
		
		//----------FRAME FINALE---------------
		frame = new JFrame("Kevin Forte 1940058");
		
		frame.add(nPan, BorderLayout.NORTH);
		frame.add(sPan, BorderLayout.SOUTH);
		frame.add(mPan, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		Connect azione_connetti = new Connect(serverAddressField, portField, connectButton, disconnectButton, onButton, offButton, plusButton, minusButton, tempButton);
		connectButton.addActionListener(azione_connetti);
		
		Disconnect azione_disconnetti = new Disconnect(azione_connetti);
		disconnectButton.addActionListener(azione_disconnetti);
		
		Stop azione_stop = new Stop(azione_connetti);
		offButton.addActionListener(azione_stop);
		
		Start azione_start = new Start(azione_connetti);
		onButton.addActionListener(azione_start);
		
		Plus azione_plus = new Plus(azione_connetti);
		plusButton.addActionListener(azione_plus);
		
		Minus azione_minus = new Minus(azione_connetti);
		minusButton.addActionListener(azione_minus);
		
		frame.pack();
	}

}
