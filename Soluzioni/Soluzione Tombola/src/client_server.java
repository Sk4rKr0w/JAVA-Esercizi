
public class client_server implements Runnable {
	
	Connect azione_connetti;
	TicketCell Cartella[];
	
	public client_server(Connect azione_connetti, TicketCell Cartella[]) {
		
		this.azione_connetti = azione_connetti;
		this.Cartella = Cartella;
		
	}


	@Override
	public void run() {
		azione_connetti.pw.println("start");
		azione_connetti.pw.flush();
		while(azione_connetti.sc.hasNextLine()) {
			String s = azione_connetti.sc.nextLine();
			if(s.equals("+")) {
				azione_connetti.logArea.append("---FINE PARTITA---\n");
				azione_connetti.stopButton.setEnabled(false);
				azione_connetti.startButton.setEnabled(true);
				azione_connetti.disconnectButton.setEnabled(true);
				break;
			}
			else{
				azione_connetti.logArea.append("Estratto il numero: "+ s + "\n");
				for(int i = 0; i < 15; i++) {
					if(s.equals(String.valueOf(Cartella[i].getValue()))){
						Cartella[i].setSelected(true);
					}
			}
			
			}
		}
		
	}
	
}
