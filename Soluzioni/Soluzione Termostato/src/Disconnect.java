import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

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
			JOptionPane.showMessageDialog(null, "Disconnesso!");
			azione_connetti.connectButton.setEnabled(true);
			azione_connetti.disconnectButton.setEnabled(false);
			azione_connetti.onButton.setEnabled(false);
			azione_connetti.tempButton.getTempLabel().setText("0°C");
			azione_connetti.tempButton.colora("reset");
			azione_connetti.tempButton.repaint(0);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
