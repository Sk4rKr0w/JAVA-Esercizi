import java.awt.*;
import javax.swing.JOptionPane;

public class Ricevitore implements Runnable {
    Connect azione_connetti;
    
    public Ricevitore(Connect azione_connetti) {
    	this.azione_connetti = azione_connetti;
    }
	@Override
	public void run() {
		while(azione_connetti.sc.hasNextLine()) {
			String t = azione_connetti.sc.nextLine();
			System.out.println(t);
			if(t.equals("*")) {
				int puntiUtente = 0;
				int puntiServer = 0;
				if (azione_connetti.coloreUtente.equalsIgnoreCase("yellow")) {
					for(int i = 0; i < 16; i+=4) {
						if(String.valueOf(azione_connetti.pedinaButton[i].getBackground()).equals(String.valueOf(Color.YELLOW)) && String.valueOf(azione_connetti.pedinaButton[i+1].getBackground()).equals(String.valueOf(Color.YELLOW)) && String.valueOf(azione_connetti.pedinaButton[i+2].getBackground()).equals(String.valueOf(Color.YELLOW)) && String.valueOf(azione_connetti.pedinaButton[i+3].getBackground()).equals(String.valueOf(Color.YELLOW)))
						    puntiUtente++;
					}
					for (int i = 0; i < 4; i++) {
						if(String.valueOf(azione_connetti.pedinaButton[i].getBackground()).equals(String.valueOf(Color.YELLOW)) && String.valueOf(azione_connetti.pedinaButton[i+4].getBackground()).equals(String.valueOf(Color.YELLOW)) && String.valueOf(azione_connetti.pedinaButton[i+8].getBackground()).equals(String.valueOf(Color.YELLOW)) && String.valueOf(azione_connetti.pedinaButton[i+12].getBackground()).equals(String.valueOf(Color.YELLOW)))
						    puntiUtente++;
					}
					if(String.valueOf(azione_connetti.pedinaButton[0].getBackground()).equals(String.valueOf(Color.YELLOW)) && String.valueOf(azione_connetti.pedinaButton[5].getBackground()).equals(String.valueOf(Color.YELLOW)) && String.valueOf(azione_connetti.pedinaButton[10].getBackground()).equals(String.valueOf(Color.YELLOW)) && String.valueOf(azione_connetti.pedinaButton[15].getBackground()).equals(String.valueOf(Color.YELLOW)))
					    puntiUtente++;
					if(String.valueOf(azione_connetti.pedinaButton[3].getBackground()).equals(String.valueOf(Color.YELLOW)) && String.valueOf(azione_connetti.pedinaButton[6].getBackground()).equals(String.valueOf(Color.YELLOW)) && String.valueOf(azione_connetti.pedinaButton[9].getBackground()).equals(String.valueOf(Color.YELLOW)) && String.valueOf(azione_connetti.pedinaButton[12].getBackground()).equals(String.valueOf(Color.YELLOW)))
					    puntiUtente++;
					
					for(int i = 0; i < 16; i+=4) {
						if(String.valueOf(azione_connetti.pedinaButton[i].getBackground()).equals(String.valueOf(Color.CYAN)) && String.valueOf(azione_connetti.pedinaButton[i+1].getBackground()).equals(String.valueOf(Color.CYAN)) && String.valueOf(azione_connetti.pedinaButton[i+2].getBackground()).equals(String.valueOf(Color.CYAN)) && String.valueOf(azione_connetti.pedinaButton[i+3].getBackground()).equals(String.valueOf(Color.CYAN)))
						    puntiServer++;
					}
					for (int i = 0; i < 4; i++) {
						if(String.valueOf(azione_connetti.pedinaButton[i].getBackground()).equals(String.valueOf(Color.CYAN)) && String.valueOf(azione_connetti.pedinaButton[i+4].getBackground()).equals(String.valueOf(Color.CYAN)) && String.valueOf(azione_connetti.pedinaButton[i+8].getBackground()).equals(String.valueOf(Color.CYAN)) && String.valueOf(azione_connetti.pedinaButton[i+12].getBackground()).equals(String.valueOf(Color.CYAN)))
						    puntiServer++;
					}
					if(String.valueOf(azione_connetti.pedinaButton[0].getBackground()).equals(String.valueOf(Color.CYAN)) && String.valueOf(azione_connetti.pedinaButton[5].getBackground()).equals(String.valueOf(Color.CYAN)) && String.valueOf(azione_connetti.pedinaButton[10].getBackground()).equals(String.valueOf(Color.CYAN)) && String.valueOf(azione_connetti.pedinaButton[15].getBackground()).equals(String.valueOf(Color.CYAN)))
					    puntiServer++;
					if(String.valueOf(azione_connetti.pedinaButton[3].getBackground()).equals(String.valueOf(Color.CYAN)) && String.valueOf(azione_connetti.pedinaButton[6].getBackground()).equals(String.valueOf(Color.CYAN)) && String.valueOf(azione_connetti.pedinaButton[9].getBackground()).equals(String.valueOf(Color.CYAN)) && String.valueOf(azione_connetti.pedinaButton[12].getBackground()).equals(String.valueOf(Color.CYAN)))
					    puntiServer++;
				}
				else if (azione_connetti.coloreUtente.equalsIgnoreCase("cyan")) {
					for(int i = 0; i < 16; i+=4) {
						if(String.valueOf(azione_connetti.pedinaButton[i].getBackground()).equals(String.valueOf(Color.YELLOW)) && String.valueOf(azione_connetti.pedinaButton[i+1].getBackground()).equals(String.valueOf(Color.YELLOW)) && String.valueOf(azione_connetti.pedinaButton[i+2].getBackground()).equals(String.valueOf(Color.YELLOW)) && String.valueOf(azione_connetti.pedinaButton[i+3].getBackground()).equals(String.valueOf(Color.YELLOW)))
						    puntiServer++;
					}
					for (int i = 0; i < 4; i++) {
						if(String.valueOf(azione_connetti.pedinaButton[i].getBackground()).equals(String.valueOf(Color.YELLOW)) && String.valueOf(azione_connetti.pedinaButton[i+4].getBackground()).equals(String.valueOf(Color.YELLOW)) && String.valueOf(azione_connetti.pedinaButton[i+8].getBackground()).equals(String.valueOf(Color.YELLOW)) && String.valueOf(azione_connetti.pedinaButton[i+12].getBackground()).equals(String.valueOf(Color.YELLOW)))
						    puntiServer++;
					}
					if(String.valueOf(azione_connetti.pedinaButton[0].getBackground()).equals(String.valueOf(Color.YELLOW)) && String.valueOf(azione_connetti.pedinaButton[5].getBackground()).equals(String.valueOf(Color.YELLOW)) && String.valueOf(azione_connetti.pedinaButton[10].getBackground()).equals(String.valueOf(Color.YELLOW)) && String.valueOf(azione_connetti.pedinaButton[15].getBackground()).equals(String.valueOf(Color.YELLOW)))
					    puntiServer++;
					if(String.valueOf(azione_connetti.pedinaButton[3].getBackground()).equals(String.valueOf(Color.YELLOW)) && String.valueOf(azione_connetti.pedinaButton[6].getBackground()).equals(String.valueOf(Color.YELLOW)) && String.valueOf(azione_connetti.pedinaButton[9].getBackground()).equals(String.valueOf(Color.YELLOW)) && String.valueOf(azione_connetti.pedinaButton[12].getBackground()).equals(String.valueOf(Color.YELLOW)))
					    puntiServer++;
					
					for(int i = 0; i < 16; i+=4) {
						if(String.valueOf(azione_connetti.pedinaButton[i].getBackground()).equals(String.valueOf(Color.CYAN)) && String.valueOf(azione_connetti.pedinaButton[i+1].getBackground()).equals(String.valueOf(Color.CYAN)) && String.valueOf(azione_connetti.pedinaButton[i+2].getBackground()).equals(String.valueOf(Color.CYAN)) && String.valueOf(azione_connetti.pedinaButton[i+3].getBackground()).equals(String.valueOf(Color.CYAN)))
						    puntiUtente++;
					}
					for (int i = 0; i < 4; i++) {
						if(String.valueOf(azione_connetti.pedinaButton[i].getBackground()).equals(String.valueOf(Color.CYAN)) && String.valueOf(azione_connetti.pedinaButton[i+4].getBackground()).equals(String.valueOf(Color.CYAN)) && String.valueOf(azione_connetti.pedinaButton[i+8].getBackground()).equals(String.valueOf(Color.CYAN)) && String.valueOf(azione_connetti.pedinaButton[i+12].getBackground()).equals(String.valueOf(Color.CYAN)))
						    puntiUtente++;
					}
					if(String.valueOf(azione_connetti.pedinaButton[0].getBackground()).equals(String.valueOf(Color.CYAN)) && String.valueOf(azione_connetti.pedinaButton[5].getBackground()).equals(String.valueOf(Color.CYAN)) && String.valueOf(azione_connetti.pedinaButton[10].getBackground()).equals(String.valueOf(Color.CYAN)) && String.valueOf(azione_connetti.pedinaButton[15].getBackground()).equals(String.valueOf(Color.CYAN)))
					    puntiUtente++;
					if(String.valueOf(azione_connetti.pedinaButton[3].getBackground()).equals(String.valueOf(Color.CYAN)) && String.valueOf(azione_connetti.pedinaButton[6].getBackground()).equals(String.valueOf(Color.CYAN)) && String.valueOf(azione_connetti.pedinaButton[9].getBackground()).equals(String.valueOf(Color.CYAN)) && String.valueOf(azione_connetti.pedinaButton[12].getBackground()).equals(String.valueOf(Color.CYAN)))
					    puntiUtente++;
				}
				if (puntiUtente > 0 && puntiServer == 0) {
					JOptionPane.showMessageDialog(null, "hai vinto");
				}
				else if (puntiUtente == 0 && puntiServer > 0) {
					JOptionPane.showMessageDialog(null, "hai perso");
				}
				else {
					JOptionPane.showMessageDialog(null, "pareggio");
				}
				azione_connetti.stopButton.setEnabled(false);
				azione_connetti.clearButton.setEnabled(true);
				azione_connetti.startButton.setEnabled(true);
				azione_connetti.disconnectButton.setEnabled(true);
				break;
			}
			else if (t.equals("-1")) {
				azione_connetti.stopButton.setEnabled(false);
				azione_connetti.clearButton.setEnabled(true);
				azione_connetti.startButton.setEnabled(true);
				azione_connetti.disconnectButton.setEnabled(true);
			}
			else {
				String parts[] = t.split(";");
				int pos = Integer.parseInt(parts[0]);
				if (parts[1].equals("cyan")) {
					azione_connetti.pedinaButton[pos].setBackground(Color.CYAN);
				}
				else {
					azione_connetti.pedinaButton[pos].setBackground(Color.YELLOW);
				}
			}
		}
	}
}
