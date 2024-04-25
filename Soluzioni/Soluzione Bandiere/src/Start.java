import java.awt.event.*;
import java.awt.*;
public class Start implements ActionListener{

	Connect azione_connetti;
	
	public Start (Connect azione_connetti) {
		
		this.azione_connetti = azione_connetti;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		azione_connetti.mCPan.setBackground(Color.LIGHT_GRAY);
		azione_connetti.mEPan.setBackground(Color.LIGHT_GRAY);
		azione_connetti.mWPan.setBackground(Color.LIGHT_GRAY);
		azione_connetti.connectButton.setEnabled(false);
		azione_connetti.disconnectButton.setEnabled(false);
		azione_connetti.startButton.setEnabled(false);
		azione_connetti.stopButton.setEnabled(true);
		azione_connetti.pw.println("start");
		azione_connetti.pw.flush();
		
		client_server operatore = new client_server(azione_connetti);
		Thread t1 = new Thread(operatore);
		t1.start();
		
	}

}
