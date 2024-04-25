import java.awt.event.*;

import javax.swing.JOptionPane;

public class Start implements ActionListener{

	Connect azione_connetti;
	
	public Start(Connect azione_connetti) {
		
		this.azione_connetti = azione_connetti;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (azione_connetti.enterTextField.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "La stringa da codificare NON deve essere vuota");
		}
		else {
			azione_connetti.pw.println("start:" + azione_connetti.enterTextField.getText());
			azione_connetti.pw.flush();
			azione_connetti.enterTextField.setText("");
			azione_connetti.qrCodeArea.setText("");
			azione_connetti.qrCodeArea.append("Codifica QR in corso...\n");
			azione_connetti.stopButton.setEnabled(true);
			azione_connetti.disconnectButton.setEnabled(false);
			azione_connetti.startButton.setEnabled(false);
			
			client_server operatore = new client_server(azione_connetti);
			Thread t1 = new Thread(operatore);
			t1.start();
		}
	}
		
}
