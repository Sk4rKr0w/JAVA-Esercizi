
public class client_server implements Runnable {
	
	Connect azione_connetti;
	
	public client_server(Connect azione_connetti) {
		
		this.azione_connetti = azione_connetti;
		
	}
	@Override
	public void run() {
	
		while(azione_connetti.sc.hasNextLine()) {
			String s = azione_connetti.sc.nextLine();
			if(s.equals("*")) {
				azione_connetti.stopButton.setEnabled(false);
				azione_connetti.disconnectButton.setEnabled(true);
				azione_connetti.startButton.setEnabled(true);
				azione_connetti.qrCodeArea.append("\nDownload Completato!\n");
				break;
			}
			else {
				azione_connetti.qrCodeArea.append(s + "\n");
			}
		}
		
	}

}
