import java.awt.event.*;

import javax.swing.JOptionPane;

public class Stop implements ActionListener{
	
	Connect azione_connetti;
	
	public Stop(Connect azione_connetti) {
		
		this.azione_connetti = azione_connetti;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		azione_connetti.pw.println("stop");
		azione_connetti.pw.flush();
		JOptionPane.showMessageDialog(null, "Partita Interrotta!");
		azione_connetti.stopButton.setEnabled(false);
		azione_connetti.startButton.setEnabled(true);
		azione_connetti.disconnectButton.setEnabled(true);
		azione_connetti.revealButton.setEnabled(false);
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				azione_connetti.campoDiGioco[i][j].setEnabled(false);
			}
		}
	}
	
}
