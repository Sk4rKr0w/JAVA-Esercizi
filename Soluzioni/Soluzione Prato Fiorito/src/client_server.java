import javax.swing.*;

public class client_server implements Runnable{
	
	Connect azione_connetti;
		
	public client_server(Connect azione_connetti) {
		
		this.azione_connetti = azione_connetti;
		
	}

	@Override
	public void run() {
		while(azione_connetti.sc.hasNextLine()) {
			String s = azione_connetti.sc.nextLine();
			if(s.equals("done")) {
				System.out.println(s);
				JOptionPane.showMessageDialog(null, "La partita ora può iniziare!");
				azione_connetti.revealButton.setEnabled(true);
				azione_connetti.startButton.setEnabled(true);
				azione_connetti.disconnectButton.setEnabled(true);
				azione_connetti.stopButton.setEnabled(false);
				System.out.println("Il campo ha: 10 mine");
				for(int i = 0; i < 10; i++) {
					for(int j = 0; j < 10; j++) {
						azione_connetti.campoDiGioco[i][j].setEnabled(true);
					}
				}
				break;
				
			}
			else if(s.equals("interrupted")) {
				System.out.println(s);
				break;
			}
			else {
				String parts[] = s.split(":");
				System.out.println("Riga: " + parts[0] + " || Colonna: " + parts[1] + " || Valore: " + parts[2]);
				if(parts[2].equals("-1")) {
					azione_connetti.campoDiGioco[Integer.parseInt(parts[0])][Integer.parseInt(parts[1])].setMine(true);
				}
				else if (Integer.parseInt(parts[2]) >= 0) {
					azione_connetti.campoDiGioco[Integer.parseInt(parts[0])][Integer.parseInt(parts[1])].setAdjacentMinesCount(Integer.parseInt(parts[2]));
				}
			}
		}
	}
}