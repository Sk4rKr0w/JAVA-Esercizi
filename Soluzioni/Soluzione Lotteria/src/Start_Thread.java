import javax.swing.JOptionPane;

public class Start_Thread implements Runnable {
	
	Connect azione_connetti;
	int ct_ruota1 = 0;
	int ct_ruota2 = 0;
	int ct_ruota3 = 0;
	int ct_ruota4 = 0;
	int ct_ruota5 = 0;

	public Start_Thread(Connect azione_connetti) {
		
		this.azione_connetti = azione_connetti;
		
	}

	@Override
	public void run() {
		
		while(azione_connetti.sc.hasNextLine()) {
			String s = azione_connetti.sc.nextLine();
			System.out.println(s);
			if(s.equals("done")) {
				break;
			}
			else if (s.equals("interrupted")) {
				JOptionPane.showMessageDialog(null, "Estrazione interrotta dall'utente!");
				break;
			}
			else {
				String[] parts = s.split(":");
				if(parts[0].equals("1")) {
					for(int i = 0; i < 5; i++) {
						if(String.valueOf(azione_connetti.caselle[i].getSelectedIndex()).equals(parts[1])){
							azione_connetti.caselle[i].setChecked(true);
						}
					}
				}
				else if(parts[0].equals("2")) {
					for(int i = 5; i < 10; i++) {
						if(String.valueOf(azione_connetti.caselle[i].getSelectedIndex()).equals(parts[1])){
							azione_connetti.caselle[i].setChecked(true);
						}
					}
				}
				else if(parts[0].equals("3")) {
					for(int i = 10; i < 15; i++) {
						if(String.valueOf(azione_connetti.caselle[i].getSelectedIndex()).equals(parts[1])){
							azione_connetti.caselle[i].setChecked(true);
						}
					}
				}
				else if(parts[0].equals("4")) {
					for(int i = 15; i < 20; i++) {
						if(String.valueOf(azione_connetti.caselle[i].getSelectedIndex()).equals(parts[1])){
							azione_connetti.caselle[i].setChecked(true);
						}
					}
				}
				else if(parts[0].equals("5")) {
					for(int i = 20; i < 25; i++) {
						if(String.valueOf(azione_connetti.caselle[i].getSelectedIndex()).equals(parts[1])){
							azione_connetti.caselle[i].setChecked(true);
						}

					}
				}
			}
		}
		
		azione_connetti.stopButton.setEnabled(false);
		
		azione_connetti.startButton.setEnabled(true);
		azione_connetti.resetButton.setEnabled(true);
		azione_connetti.randomizeButton.setEnabled(true);
		azione_connetti.disconnectButton.setEnabled(true);
		
		for(int i = 0; i < 25; i++) {
			azione_connetti.caselle[i].setReadOnly(false);
		}
		
		for(int i = 0; i < 5; i++) {
			if(azione_connetti.caselle[i].isChecked()) {
				ct_ruota1++;
			}
		}
		for(int i = 5; i < 10; i++) {
			if(azione_connetti.caselle[i].isChecked()) {
				ct_ruota2++;
			}
		}
		for(int i = 10; i < 15; i++) {
			if(azione_connetti.caselle[i].isChecked()) {
				ct_ruota3++;
			}
		}
		for(int i = 15; i < 20; i++) {
			if(azione_connetti.caselle[i].isChecked()) {
				ct_ruota4++;
			}
		}
		for(int i = 20; i < 25; i++) {
			if(azione_connetti.caselle[i].isChecked()) {
				ct_ruota5++;
			}
		}
		JOptionPane.showInternalMessageDialog(null, "Numeri Estratti nella: \nRuota 1: " + ct_ruota1 +
				"\nRuota 2: " + ct_ruota2 + 
				"\nRuota 3: " + ct_ruota3 + 
				"\nRuota 4: " + ct_ruota4 + 
				"\nRuota 5: " + ct_ruota5);

	}

}
