
public class client_server implements Runnable {
	
	Connect azione_connetti;
	
	public client_server(Connect azione_connetti) {
		this.azione_connetti = azione_connetti;
	}

	@Override
	public void run() {
		while(azione_connetti.sc.hasNextLine()) {
			String s = azione_connetti.sc.nextLine();
			System.out.println(s);
			if(s.equals("END")) {
				azione_connetti.consoleArea.append("====== Downdload Completato ======\n");
				azione_connetti.interruptButton.setEnabled(false);
				azione_connetti.executeButton.setEnabled(true);
				azione_connetti.disconnectButton.setEnabled(true);
				break;
			}
			else if(s.equals("INTERRUPTED")){
				azione_connetti.consoleArea.append("====== Download Interrotto ======");
				azione_connetti.interruptButton.setEnabled(false);
				azione_connetti.executeButton.setEnabled(true);
				azione_connetti.disconnectButton.setEnabled(true);
				break;
			}
			else if(s.equals("ERROR")) {
				azione_connetti.consoleArea.append("Comando Errato");
				azione_connetti.interruptButton.setEnabled(false);
				azione_connetti.executeButton.setEnabled(true);
				azione_connetti.disconnectButton.setEnabled(true);
				break;
			}
			else {	
				azione_connetti.consoleArea.append(s + "\n");
			}
		}
	}

}
