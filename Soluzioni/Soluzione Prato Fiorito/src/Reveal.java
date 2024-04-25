import java.awt.event.*;

import javax.swing.JOptionPane;

public class Reveal implements ActionListener {
	
	Connect azione_connetti;
	
	public Reveal(Connect azione_connetti) {
		this.azione_connetti = azione_connetti;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		azione_connetti.revealButton.setEnabled(false);
		azione_connetti.startButton.setEnabled(true);
		azione_connetti.stopButton.setEnabled(false);
		azione_connetti.disconnectButton.setEnabled(true);
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				azione_connetti.campoDiGioco[i][j].setSelected(true);
				azione_connetti.campoDiGioco[i][j].setEnabled(false);
			}
		}
		JOptionPane.showMessageDialog(null, "Partita abbandonata dal giocatore!");
	}
}
