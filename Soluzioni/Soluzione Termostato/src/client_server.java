
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
			if(s.equals("off")) {
				azione_connetti.offButton.setEnabled(false);
				azione_connetti.plusButton.setEnabled(false);
				azione_connetti.minusButton.setEnabled(false);
				azione_connetti.onButton.setEnabled(true);
				azione_connetti.disconnectButton.setEnabled(true);
				break;
			}
			else{
				if(!(Integer.parseInt(s) > 100 && Integer.parseInt(s) < 0)){
					azione_connetti.tempButton.colora(s);
					azione_connetti.tempButton.getTempLabel().setText(s + "°C");
					azione_connetti.tempButton.repaint(azione_connetti.tempButton.temperaturaCorrente);
				}
			}
		}
	}
}