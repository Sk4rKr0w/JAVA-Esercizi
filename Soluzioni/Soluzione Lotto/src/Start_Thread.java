import javax.swing.JOptionPane;
import java.awt.Color;

public class Start_Thread implements Runnable {
	
	Connect azione_connetti;
	int ct =0;
	
	public Start_Thread(Connect azione_connetti) {
		
		this.azione_connetti = azione_connetti;
		
	}

	@Override
	public void run() {

		while(azione_connetti.sc.hasNextLine()) {
			String s = azione_connetti.sc.nextLine();
			String[] parts = s.split(";");
			if(parts[0].equals("-1") && parts[1].equals("-1")) {
				JOptionPane.showMessageDialog(null, "Il giocatore ha perso!");
				break;
			}
			else if(parts[0].equals("*") && parts[1].equals("*")) {
				for(int i = 0; i < 5; i++) {
					azione_connetti.casella[i].setEnabled(true);
				}
				azione_connetti.stopButton.setEnabled(false);
				
				azione_connetti.startButton.setEnabled(true);
				azione_connetti.disconnectButton.setEnabled(true);
				azione_connetti.clearButton.setEnabled(true);
				
				if(ct > 0) {
					JOptionPane.showMessageDialog(null, "Vittoria del giocatore!");
					break;
				}
				else {
					JOptionPane.showMessageDialog(null, "Sconfitta del giocatore!");
					break;
				}
			}
			else if (Integer.parseInt(parts[1]) == Integer.parseInt(azione_connetti.casella[Integer.parseInt(parts[0])].getDigit())) {
				azione_connetti.casella[Integer.parseInt(parts[0])].changeColor(Color.GREEN);
				ct++;
			}
			else {
				azione_connetti.casella[Integer.parseInt(parts[0])].changeColor(Color.RED);
			}
		}
	}

}
