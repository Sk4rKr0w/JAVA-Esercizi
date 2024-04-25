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
		JButton startButton;
		JButton stopButton;
		JButton revealButton;
		
		BoardButton campoDiGioco[][];
		
		// Pannello Nord
		
		nPan = new JPanel(new FlowLayout());
		
		serverAddressLabel = new JLabel("Server Address");
		serverAddressField = new JTextField(20);
		serverAddressField.setText("127.0.0.1");
		serverAddressField.setEditable(false);
		portLabel = new JLabel ("Port");
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
		
		// Pannello Sud
		
		sPan = new JPanel(new FlowLayout());
		startButton = new JButton("Start");
		startButton.setEnabled(false);
		stopButton = new JButton("Stop");
		stopButton.setEnabled(false);
		revealButton = new JButton("Rivela");
		revealButton.setEnabled(false);
		
		sPan.add(startButton);
		sPan.add(stopButton);
		sPan.add(revealButton);
		
		// Pannello Centrale
		
		mPan = new JPanel(new GridLayout(10,10));
		campoDiGioco = new BoardButton[10][10];
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				campoDiGioco[i][j] = new BoardButton();
				campoDiGioco[i][j].setEnabled(false);
				mPan.add(campoDiGioco[i][j]);
			}
		}
		//--------------------------FRAME FINALE-------------
		
		frame = new JFrame("Kevin Forte 1940058");
		
		frame.add(nPan, BorderLayout.NORTH);
		frame.add(mPan, BorderLayout.CENTER);
		frame.add(sPan, BorderLayout.SOUTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		Connect azione_connetti = new Connect(serverAddressField, portField, connectButton, disconnectButton, startButton, stopButton, revealButton, campoDiGioco);
		connectButton.addActionListener(azione_connetti);
		
		Disconnect azione_disconnetti = new Disconnect(azione_connetti);
		disconnectButton.addActionListener(azione_disconnetti);
		
		Start azione_start = new Start(azione_connetti);
		startButton.addActionListener(azione_start);
		
		Stop azione_stop = new Stop(azione_connetti);
		stopButton.addActionListener(azione_stop);
		
		Reveal azione_reveal = new Reveal(azione_connetti);
		revealButton.addActionListener(azione_reveal);
		
		Pedina azione_pedina = new Pedina(azione_connetti);
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++){
				campoDiGioco[i][j].addActionListener(azione_pedina);
			}
		}
		
		frame.pack();
		
	}
}
