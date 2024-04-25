import java.awt.event.*;

import javax.swing.JOptionPane;


public class Start implements ActionListener{
	
	Connect azione_connetti;
	
	
	public Start(Connect azione_connetti) {
		
		this.azione_connetti = azione_connetti;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		azione_connetti.pw.println("start");
		azione_connetti.pw.flush();
		
		azione_connetti.stopButton.setEnabled(true);
		azione_connetti.startButton.setEnabled(false);
		azione_connetti.disconnectButton.setEnabled(false);
	
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				azione_connetti.campoDiGioco[i][j].reset();
				azione_connetti.campoDiGioco[i][j].setEnabled(false);
			}
		}
		
		JOptionPane.showMessageDialog(null, "Attendere 10 secondi per la formazione del campo di gioco!");
		
		client_server operatore = new client_server(azione_connetti);
		Thread start_thread = new Thread(operatore);
		start_thread.start();
	}
}

