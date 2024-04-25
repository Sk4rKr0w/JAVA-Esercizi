import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stop implements ActionListener {
	
	Connect azione_connetti;
	
	public Stop(Connect azione_connetti) {
		
		this.azione_connetti = azione_connetti;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		azione_connetti.pw.println("interrompi");
		azione_connetti.pw.flush();
		
		azione_connetti.stopButton.setEnabled(false);
		azione_connetti.startButton.setEnabled(true);
		azione_connetti.disconnectButton.setEnabled(true);
		azione_connetti.clearButton.setEnabled(true);
				
	}

}
