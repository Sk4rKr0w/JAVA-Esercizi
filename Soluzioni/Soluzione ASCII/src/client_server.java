
public class client_server implements Runnable {
	
	Connect azione_connetti;
	
	public client_server(Connect azione_connetti) {
		this.azione_connetti = azione_connetti;	
	}

	@Override
	public void run() {
		while(azione_connetti.sc.hasNextLine()) {
			String s = azione_connetti.sc.nextLine();
			if(s.equals("END")) {
				azione_connetti.imageArea.append("===== Download Completato =====\n");
				azione_connetti.image1.setEnabled(true);
				azione_connetti.image2.setEnabled(true);
				azione_connetti.image3.setEnabled(true);
				azione_connetti.image4.setEnabled(true);
				azione_connetti.image5.setEnabled(true);
				azione_connetti.stopButton.setEnabled(false);
				azione_connetti.disconnectButton.setEnabled(true);
				break;
			}
			else if(s.equals("INTERRUPTED")) {
				azione_connetti.imageArea.append("===== Download Interrotto =====\n");
				azione_connetti.image1.setEnabled(true);
				azione_connetti.image2.setEnabled(true);
				azione_connetti.image3.setEnabled(true);
				azione_connetti.image4.setEnabled(true);
				azione_connetti.image5.setEnabled(true);
				azione_connetti.stopButton.setEnabled(false);
				azione_connetti.disconnectButton.setEnabled(true);
				break;
			}
			else if(s.equals("ERROR")) {
				azione_connetti.imageArea.append("===== Errore =====\n");
				azione_connetti.image1.setEnabled(true);
				azione_connetti.image2.setEnabled(true);
				azione_connetti.image3.setEnabled(true);
				azione_connetti.image4.setEnabled(true);
				azione_connetti.image5.setEnabled(true);
				azione_connetti.stopButton.setEnabled(false);
				azione_connetti.disconnectButton.setEnabled(true);
				break;
			}
			else{
				azione_connetti.imageArea.append(s + "\n");
			}
		}
		
	}

}
