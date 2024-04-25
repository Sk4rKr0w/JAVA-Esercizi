import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JOptionPane;

public class Start implements ActionListener {
	
	Connect azione_connetti;
	
	public Start(Connect azione_connetti) {
		
		this.azione_connetti = azione_connetti;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		azione_connetti.coloreUtente = "";
		azione_connetti.coloreServer = "";
		
		// Scelgo squadra
		while(!azione_connetti.coloreUtente.equalsIgnoreCase("yellow") && !azione_connetti.coloreUtente.equalsIgnoreCase("cyan") ) {
			azione_connetti.coloreUtente = JOptionPane.showInputDialog("Scegliere un colore tra \"Yellow\" e \"Cyan\"");
		}
		
		// Imposto squadra nemico
		if(azione_connetti.coloreUtente.equalsIgnoreCase("cyan")) {
			azione_connetti.coloreUtente = "cyan";
			azione_connetti.coloreServer = "yellow";
		}
		else if(azione_connetti.coloreUtente.equalsIgnoreCase("yellow")) {
			azione_connetti.coloreServer = "cyan";
			azione_connetti.coloreUtente = "yellow";
		}
		
		// Stampo a console
		System.out.println("Colore Utente: " + azione_connetti.coloreUtente);
		System.out.println("Colore Server: " + azione_connetti.coloreServer);

		// Invio stringa start
		azione_connetti.pw.println("start");
		azione_connetti.pw.flush();
		
		// Disattivo i pulsanti
		azione_connetti.startButton.setEnabled(false);
		azione_connetti.stopButton.setEnabled(true);
		azione_connetti.disconnectButton.setEnabled(false);
		azione_connetti.clearButton.setEnabled(false);
		
		for(int i = 0; i < 16; i++) {
			azione_connetti.pedinaButton[i].setBackground(Color.LIGHT_GRAY);
		}
		
		// Parte il Thread
		Ricevitore operatore = new Ricevitore(azione_connetti);
		Thread game_thread = new Thread(operatore);
		game_thread.start();
		
		
	}

}
