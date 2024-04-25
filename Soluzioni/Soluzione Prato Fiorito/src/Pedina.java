import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Pedina implements ActionListener {
	
	Connect azione_connetti;
	int errori = 0;
	int caselle_giuste = 0;
	int temp = 0;
	
	public Pedina(Connect azione_connetti) {
		this.azione_connetti = azione_connetti;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(azione_connetti.campoDiGioco[i][j].isSelected() && azione_connetti.campoDiGioco[i][j].hasMine()) {
					errori++;
				}
				else if(azione_connetti.campoDiGioco[i][j].isSelected() && !azione_connetti.campoDiGioco[i][j].hasMine()) {
					caselle_giuste++;
				}
			}
		}
		if(errori == 1) {
			for(int i = 0; i < 10; i++) {
				for(int j = 0; j < 10; j++) {
					azione_connetti.campoDiGioco[i][j].setEnabled(false);
					azione_connetti.campoDiGioco[i][j].setSelected(true);
				}
			}
			azione_connetti.startButton.setEnabled(true);
			azione_connetti.stopButton.setEnabled(false);
			azione_connetti.revealButton.setEnabled(false);
			azione_connetti.disconnectButton.setEnabled(true);
			JOptionPane.showMessageDialog(null, "Hai trovato una mina");
		}
		else if(caselle_giuste == 90) {
			for(int i = 0; i < 10; i++) {
				for(int j = 0; j < 10; j++) {
					azione_connetti.campoDiGioco[i][j].setEnabled(false);
					azione_connetti.campoDiGioco[i][j].setSelected(true);
				}
			}
			azione_connetti.startButton.setEnabled(true);
			azione_connetti.stopButton.setEnabled(false);
			azione_connetti.revealButton.setEnabled(false);
			azione_connetti.disconnectButton.setEnabled(true);
			JOptionPane.showMessageDialog(null, "Hai vinto");
		}
	}

}
