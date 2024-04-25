import java.awt.Color;
import java.awt.event.*;
import java.io.IOException;

public class Disconnect implements ActionListener{
	
	Connect azione_connetti;
	
	public Disconnect(Connect azione_connetti) {
		
		this.azione_connetti = azione_connetti;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			azione_connetti.pw.println("disconnect");
			azione_connetti.pw.flush();
			azione_connetti.client.close();
			azione_connetti.connectButton.setEnabled(true);
			azione_connetti.disconnectButton.setEnabled(false);
			azione_connetti.startButton.setEnabled(false);
			azione_connetti.stopButton.setEnabled(false);
			azione_connetti.mCPan.setBackground(Color.LIGHT_GRAY);
			azione_connetti.mEPan.setBackground(Color.LIGHT_GRAY);
			azione_connetti.mWPan.setBackground(Color.LIGHT_GRAY);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}

}
