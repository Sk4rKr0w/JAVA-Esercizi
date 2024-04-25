
public class start_thread implements Runnable {
	
	Connect azione_connetti;
	
	public start_thread(Connect azione_connetti) {
		this.azione_connetti = azione_connetti;
	}

	@Override
	public void run() {
		while(azione_connetti.sc.hasNextLine()) {
			String s = azione_connetti.sc.nextLine();
			if(s.equals("+")) {
				azione_connetti.logArea.append("===== FINE PARTITA =====\n");
				azione_connetti.startButton.setEnabled(true);
				azione_connetti.disconnectButton.setEnabled(true);
				azione_connetti.stopButton.setEnabled(false);
				break;
			}
			else{
				azione_connetti.logArea.append("Estratto il numero: " + s + "\n");
				for(int i = 0; i < 15; i++) {
					if(String.valueOf(azione_connetti.caselle[i].getValue()).equals(s)) {
						azione_connetti.caselle[i].setSelected(true);
					}
				}
			}
		}
	}

}
