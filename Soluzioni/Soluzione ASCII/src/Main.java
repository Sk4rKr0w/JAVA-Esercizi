import javax.swing.*;
import java.awt.*;

public class Main {

	public static void main(String[] args) {
		
		JFrame frame;
		
		JPanel nPan;
		JPanel sPan;
		JPanel mPan;
		
		JLabel serverAddressLabel;
		JLabel portLabel;
		
		JTextField serverAddressField;
		JTextField portField;
		
		JTextArea imageArea;
		JScrollPane imageAreaScroll;
		
		JButton connectButton;
		JButton disconnectButton;
		JButton stopButton;
		JButton image1;
		JButton image2;
		JButton image3;
		JButton image4;
		JButton image5;
		
		//----------NORD PANEL-------------
		
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
		
		//----------SUD PANEL---------------//
		
		sPan = new JPanel(new FlowLayout());
		
		image1 = new JButton("Image 1");
		image1.setEnabled(false);
		
		image2 = new JButton("Image 2");
		image2.setEnabled(false);
		
		image3 = new JButton("Image 3");
		image3.setEnabled(false);
		
		image4 = new JButton("Image 4");
		image4.setEnabled(false);
		
		image5 = new JButton("Image 5");
		image5.setEnabled(false);

		stopButton = new JButton("Stop");
		stopButton.setEnabled(false);
		
		sPan.add(image1);
		sPan.add(image2);
		sPan.add(image3);
		sPan.add(image4);
		sPan.add(image5);
		sPan.add(stopButton);
		
		//-----------MID PANEL------------------//
		
		mPan = new JPanel();
		
		imageArea = new JTextArea(25,80);
		imageAreaScroll = new JScrollPane(imageArea);
		imageAreaScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		imageAreaScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		mPan.add(imageAreaScroll);
		//---------FRAME FINALE---------------//
		frame = new JFrame("Kevin Forte 1940058");
		
		frame.add(mPan, BorderLayout.CENTER);
		frame.add(sPan, BorderLayout.SOUTH);
		frame.add(nPan, BorderLayout.NORTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		Connect azione_connetti = new Connect(serverAddressField, portField, imageArea, connectButton, disconnectButton, stopButton, image1, image2, image3, image4, image5);
		connectButton.addActionListener(azione_connetti);
		
		Disconnect azione_disconnect = new Disconnect(azione_connetti);
		disconnectButton.addActionListener(azione_disconnect);
		
		Stop azione_stop = new Stop(azione_connetti);
		stopButton.addActionListener(azione_stop);
		
		Image azione_image = new Image(azione_connetti);
		image1.addActionListener(azione_image);
		image2.addActionListener(azione_image);
		image3.addActionListener(azione_image);
		image4.addActionListener(azione_image);
		image5.addActionListener(azione_image);

		frame.pack();
	}

}
