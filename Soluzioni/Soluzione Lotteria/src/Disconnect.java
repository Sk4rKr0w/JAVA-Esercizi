import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Disconnect implements ActionListener {
	
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
			
			azione_connetti.startButton.setEnabled(false);
			azione_connetti.resetButton.setEnabled(false);
			azione_connetti.randomizeButton.setEnabled(false);
			azione_connetti.disconnectButton.setEnabled(false);
			
			azione_connetti.connectButton.setEnabled(true);
			
			for(int i = 0; i < 25; i++) {
				azione_connetti.caselle[i].setReadOnly(true);
			}
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
