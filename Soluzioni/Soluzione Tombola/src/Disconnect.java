import java.awt.event.*;
import java.io.IOException;

public class Disconnect implements ActionListener {

	Connect azione_connetti;
	
	public Disconnect(Connect azione_connetti) {
		
		this.azione_connetti = azione_connetti;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (azione_connetti.client.isConnected()) {
			try {
				azione_connetti.connectButton.setEnabled(true);
				azione_connetti.disconnectButton.setEnabled(false);
				azione_connetti.startButton.setEnabled(false);
				azione_connetti.stopButton.setEnabled(false);
				
				azione_connetti.serverAddressField.setEditable(true);
				azione_connetti.portField.setEditable(true);
				
				azione_connetti.pw.println("disconnect");
				azione_connetti.pw.flush();
				azione_connetti.client.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
