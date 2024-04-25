
public class client_server implements Runnable {

	Connect azione_connetti;
	
	public client_server (Connect azione_connetti){
		
		this.azione_connetti = azione_connetti;
		
	}
	
	@Override
	public void run() {
	
		while (azione_connetti.sc.hasNextLine()) {
			String s = azione_connetti.sc.nextLine();
			System.out.println(s);
			String[] parts = s.split(":");
			if (s.equals("*")) {
				azione_connetti.stopButton.setEnabled(false);
				azione_connetti.startButton.setEnabled(true);
				azione_connetti.disconnectButton.setEnabled(true);
				azione_connetti.vm1Button.setEnabled(true);
				azione_connetti.vm2Button.setEnabled(true);
				azione_connetti.vm3Button.setEnabled(true);
				break;
			}
			else {
				azione_connetti.cpuBar.setValue(Integer.parseInt(parts[0]));
				azione_connetti.memoryBar.setValue(Integer.parseInt(parts[1]));
				azione_connetti.diskBar.setValue(Integer.parseInt(parts[2]));
				azione_connetti.networkBar.setValue(Integer.parseInt(parts[3]));
			}
		}
	}

}
