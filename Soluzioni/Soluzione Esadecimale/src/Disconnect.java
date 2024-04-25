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
			
			azione_connetti.connectButton.setEnabled(true);
			azione_connetti.disconnectButton.setEnabled(false);
			azione_connetti.startButton.setEnabled(false);
			
			azione_connetti.hexadecimalField.setText("");
			azione_connetti.decimalField.setText("");
			azione_connetti.binaryField.setText("");

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}

}
