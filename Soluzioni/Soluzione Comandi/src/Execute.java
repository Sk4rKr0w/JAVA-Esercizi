import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Execute implements ActionListener {
	
	Connect azione_connetti;
	
	public Execute(Connect azione_connetti) {
		this.azione_connetti = azione_connetti;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		azione_connetti.pw.println(azione_connetti.commandField.getText());
		azione_connetti.pw.flush();
		
		azione_connetti.interruptButton.setEnabled(true);
		azione_connetti.executeButton.setEnabled(false);
		azione_connetti.disconnectButton.setEnabled(false);
		
		client_server operatore = new client_server(azione_connetti);
		Thread t1 = new Thread(operatore);
		t1.start();
	}

}
