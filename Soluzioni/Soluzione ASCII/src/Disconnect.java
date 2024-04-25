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
			azione_connetti.stopButton.setEnabled(false);
			azione_connetti.image1.setEnabled(false);
			azione_connetti.image2.setEnabled(false);
			azione_connetti.image3.setEnabled(false);
			azione_connetti.image4.setEnabled(false);
			azione_connetti.image5.setEnabled(false);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}

}
