import java.awt.event.*;

public class Start implements ActionListener {
	
	Connect azione_connetti;
	
	public Start(Connect azione_connetti) {
		
		this.azione_connetti = azione_connetti;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		client_server operatore = new client_server(azione_connetti);
		Thread t1 = new Thread(operatore);
		
		azione_connetti.startButton.setEnabled(false);
		azione_connetti.stopButton.setEnabled(true);
		azione_connetti.connectButton.setEnabled(false);
		azione_connetti.disconnectButton.setEnabled(false);
		
		if(azione_connetti.vm1Button.isSelected()) {
			azione_connetti.pw.println("start:vm1");
			azione_connetti.pw.flush();
			t1.start();
		}
		else if(azione_connetti.vm2Button.isSelected()) {
			azione_connetti.pw.println("start:vm2");
			azione_connetti.pw.flush();
			t1.start();
		}
		else if(azione_connetti.vm3Button.isSelected()) {
			azione_connetti.pw.println("start:vm3");
			azione_connetti.pw.flush();
			t1.start();
		}
	}

}
