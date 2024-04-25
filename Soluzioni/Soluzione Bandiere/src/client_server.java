import java.awt.Color;

public class client_server implements Runnable {
	
	Connect azione_connetti;
	
	public client_server(Connect azione_connetti) {
		
		this.azione_connetti = azione_connetti;
		
	}
	@Override
	public void run() {
		while (azione_connetti.sc.hasNextLine()) {
			String s = azione_connetti.sc.nextLine();
			String[] parts = s.split(";");
			if(Integer.parseInt(parts[0]) == -1) {
				azione_connetti.stopButton.setEnabled(false);
				azione_connetti.startButton.setEnabled(true);
				azione_connetti.disconnectButton.setEnabled(true);
				break;
			}
			else {
				if(Integer.parseInt(parts[0]) == 0) {
					if(parts[1].equals("SX")) {
						azione_connetti.mWPan.setBackground(Color.WHITE);
					}
					else if (parts[1].equals("CX")) {
						azione_connetti.mCPan.setBackground(Color.WHITE);
					}
					else if(parts[1].equals("DX")) {
						azione_connetti.mEPan.setBackground(Color.WHITE);
					}
				}
				else if(Integer.parseInt(parts[0]) == 1) {
					if(parts[1].equals("SX")) {
						azione_connetti.mWPan.setBackground(Color.BLACK);
					}
					else if (parts[1].equals("CX")) {
						azione_connetti.mCPan.setBackground(Color.BLACK);
					}
					else if(parts[1].equals("DX")) {
						azione_connetti.mEPan.setBackground(Color.BLACK);
					}
				}
				else if(Integer.parseInt(parts[0]) == 2) {
					if(parts[1].equals("SX")) {
						azione_connetti.mWPan.setBackground(Color.GREEN);
					}
					else if (parts[1].equals("CX")) {
						azione_connetti.mCPan.setBackground(Color.GREEN);
					}
					else if(parts[1].equals("DX")) {
						azione_connetti.mEPan.setBackground(Color.GREEN);
					}
				}
				else if(Integer.parseInt(parts[0]) == 3) {
					if(parts[1].equals("SX")) {
						azione_connetti.mWPan.setBackground(Color.RED);
					}
					else if (parts[1].equals("CX")) {
						azione_connetti.mCPan.setBackground(Color.RED);
					}
					else if(parts[1].equals("DX")) {
						azione_connetti.mEPan.setBackground(Color.RED);
					}
				}
				else if(Integer.parseInt(parts[0]) == 4) {
					if(parts[1].equals("SX")) {
						azione_connetti.mWPan.setBackground(Color.YELLOW);
					}
					else if (parts[1].equals("CX")) {
						azione_connetti.mCPan.setBackground(Color.YELLOW);
					}
					else if(parts[1].equals("DX")) {
						azione_connetti.mEPan.setBackground(Color.YELLOW);
					}
				}
				else if(Integer.parseInt(parts[0]) == 5) {
					if(parts[1].equals("SX")) {
						azione_connetti.mWPan.setBackground(Color.BLUE);
					}
					else if (parts[1].equals("CX")) {
						azione_connetti.mCPan.setBackground(Color.BLUE);
					}
					else if(parts[1].equals("DX")) {
						azione_connetti.mEPan.setBackground(Color.BLUE);
					}
				}
				else if(Integer.parseInt(parts[0]) == 6) {
					if(parts[1].equals("SX")) {
						azione_connetti.mWPan.setBackground(Color.ORANGE);
					}
					else if (parts[1].equals("CX")) {
						azione_connetti.mCPan.setBackground(Color.ORANGE);
					}
					else if(parts[1].equals("DX")) {
						azione_connetti.mEPan.setBackground(Color.ORANGE);
					}
				}			
				
			}
		}
		
	}

}
