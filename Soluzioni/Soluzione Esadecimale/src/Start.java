import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start implements ActionListener {
	
	Connect azione_connetti;
	
	public Start(Connect azione_connetti) {
		this.azione_connetti = azione_connetti;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		azione_connetti.hexadecimalField.setText("");
		azione_connetti.decimalField.setText("");
		azione_connetti.binaryField.setText("");
		
		azione_connetti.stopButton.setEnabled(true);
		azione_connetti.startButton.setEnabled(false);
		azione_connetti.disconnectButton.setEnabled(false);
		azione_connetti.lettersButton.setEnabled(true);
		azione_connetti.numbersButton.setEnabled(true);
		azione_connetti.convertButton.setEnabled(false);
		
		azione_connetti.pw.println("start");
		azione_connetti.pw.flush();
				
		client_server operatore = new client_server(azione_connetti);
		Thread start_Thread = new Thread(operatore);
		start_Thread.start();
	}

}
