import java.awt.event.*;

public class Stop implements ActionListener{

	Connect azione_connetti;
	
	public Stop(Connect azione_connetti) {
		
		this.azione_connetti = azione_connetti;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		azione_connetti.pw.println("stop");
		azione_connetti.pw.flush();
		azione_connetti.stopButton.setEnabled(false);
		azione_connetti.startButton.setEnabled(true);
		azione_connetti.disconnectButton.setEnabled(true);
		azione_connetti.connectButton.setEnabled(false);
	}

}
