import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Start implements ActionListener {
	
	Connect azione_connetti;
	int ct = 0;
	
	public Start(Connect azione_connetti) {
		
		this.azione_connetti = azione_connetti;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0; i < 5; i++) {
			if(!azione_connetti.casella[i].getDigit().equals("")) {
				ct++;
			}
		}
		if(ct == 5) {
			
			azione_connetti.pw.println("start");
			azione_connetti.pw.flush();
			
			azione_connetti.startButton.setEnabled(false);
			azione_connetti.clearButton.setEnabled(false);
			azione_connetti.disconnectButton.setEnabled(false);
			
			azione_connetti.stopButton.setEnabled(true);
			
			for(int i = 0; i < 5; i++) {
				azione_connetti.casella[i].setEnabled(false);
				azione_connetti.casella[i].changeColor(Color.LIGHT_GRAY);
			}
			Start_Thread startOperator = new Start_Thread(azione_connetti);
			Thread startThread = new Thread(startOperator);
			startThread.start();
			ct = 0;
		}
		
	}

}
