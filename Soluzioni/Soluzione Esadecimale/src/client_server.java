
public class client_server implements Runnable {
	
	Connect azione_connetti;
	String value = "";
	
	public client_server(Connect azione_connetti) {
		this.azione_connetti = azione_connetti;
	}

	@Override
	public void run() {
		while(azione_connetti.sc.hasNextLine()) {
			String s = azione_connetti.sc.nextLine();
			if(s.equals("+")) {
				azione_connetti.stopButton.setEnabled(false);
				azione_connetti.startButton.setEnabled(true);
				azione_connetti.disconnectButton.setEnabled(true);
				azione_connetti.convertButton.setEnabled(true);
				break;
			}
			else {
				value += s;
				azione_connetti.hexadecimalField.setText(value);
				System.out.print(s);
			}
			
		}
		
	}

}
