import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start implements ActionListener {
	
	Connect azione_connetti;
	
	public Start(Connect azione_connetti) {
		this.azione_connetti = azione_connetti;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		azione_connetti.pw.println("accendi");
		azione_connetti.pw.flush();
		azione_connetti.offButton.setEnabled(true);
		azione_connetti.onButton.setEnabled(false);
		azione_connetti.disconnectButton.setEnabled(false);
		azione_connetti.plusButton.setEnabled(true);
		azione_connetti.minusButton.setEnabled(true);
		
		client_server operatore = new client_server(azione_connetti);
		Thread t1 = new Thread(operatore);
		t1.start();
	}

}
