import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Start implements ActionListener {
	
	Connect azione_connetti;
	int ct_caselle = 0;
	int checked = 0;
	
	public Start(Connect azione_connetti) {
		
		this.azione_connetti = azione_connetti;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//---------CREO LISTE----------
		
		azione_connetti.ruota1 = new LinkedList<Integer>();
		azione_connetti.ruota2 = new LinkedList<Integer>();
		azione_connetti.ruota3 = new LinkedList<Integer>();
		azione_connetti.ruota4 = new LinkedList<Integer>();
		azione_connetti.ruota5 = new LinkedList<Integer>();
		
		//-------------PRIMA RUOTA-----
		for(int i = 0; i < 5; i++) {
			if (!(azione_connetti.ruota1.contains(azione_connetti.caselle[ct_caselle].getSelectedIndex()))) {
				if(azione_connetti.caselle[ct_caselle].isNumberSelected()) {
					azione_connetti.ruota1.add(azione_connetti.caselle[ct_caselle].getSelectedIndex());
					ct_caselle++;
					checked++;
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Valore doppio o nullo in Ruota 1");
				break;
			}
		}
		for(int i = 0; i < 5; i++) {
			if (!(azione_connetti.ruota2.contains(azione_connetti.caselle[ct_caselle].getSelectedIndex()))) {
				if(azione_connetti.caselle[ct_caselle].isNumberSelected()) {
					azione_connetti.ruota2.add(azione_connetti.caselle[ct_caselle].getSelectedIndex());
					ct_caselle++;
					checked++;
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Valore doppio o nullo in Ruota 2");
				break;
			}
		}
		for(int i = 0; i < 5; i++) {
			if (!(azione_connetti.ruota3.contains(azione_connetti.caselle[ct_caselle].getSelectedIndex()))) {
				if(azione_connetti.caselle[ct_caselle].isNumberSelected()) {
					azione_connetti.ruota3.add(azione_connetti.caselle[ct_caselle].getSelectedIndex());
					ct_caselle++;
					checked++;

				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Valore doppio o nullo in Ruota 3");
				break;
			}
		}
		for(int i = 0; i < 5; i++) {
			if (!(azione_connetti.ruota4.contains(azione_connetti.caselle[ct_caselle].getSelectedIndex()))) {
				if(azione_connetti.caselle[ct_caselle].isNumberSelected()) {
					azione_connetti.ruota4.add(azione_connetti.caselle[ct_caselle].getSelectedIndex());
					ct_caselle++;
					checked++;

				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Valore doppio o nullo in Ruota 4");
				break;
			}
		}
		for(int i = 0; i < 5; i++) {
			if (!(azione_connetti.ruota5.contains(azione_connetti.caselle[ct_caselle].getSelectedIndex()))) {
				if(azione_connetti.caselle[ct_caselle].isNumberSelected()) {
					azione_connetti.ruota5.add(azione_connetti.caselle[ct_caselle].getSelectedIndex());
					ct_caselle++;
					checked++;

				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Valore doppio o nullo in Ruota 5");
				break;
			}
		}
		ct_caselle = 0;
		
		if(checked == 25) {
			
			checked = 0;
			
			azione_connetti.pw.println("start");
			azione_connetti.pw.flush();
			
			azione_connetti.stopButton.setEnabled(true);
			
			azione_connetti.startButton.setEnabled(false);
			azione_connetti.resetButton.setEnabled(false);
			azione_connetti.randomizeButton.setEnabled(false);
			azione_connetti.disconnectButton.setEnabled(false);
			
			for(int i = 0; i < 25; i++) {
				azione_connetti.caselle[i].setChecked(false);
				azione_connetti.caselle[i].setReadOnly(true);
			}
			
			Start_Thread startOperatore = new Start_Thread(azione_connetti);
			Thread startThread = new Thread(startOperatore);
			startThread.start();
		}
	}
}