import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reset implements ActionListener {
	
	Connect azione_connetti;
	
	public Reset(Connect azione_connetti) {
		
		this.azione_connetti = azione_connetti;
				
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0; i < 25; i++) {
			azione_connetti.caselle[i].setSelectedIndex(0);
			azione_connetti.caselle[i].setChecked(false);
		}
		
	}

}
