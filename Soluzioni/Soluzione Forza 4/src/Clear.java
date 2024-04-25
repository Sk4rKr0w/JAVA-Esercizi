import java.awt.event.*;
import java.awt.Color;

public class Clear implements ActionListener{

	Connect azione_connetti;
	
	public Clear(Connect azione_connetti) {
		
		this.azione_connetti = azione_connetti;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0; i < 16; i++) {
			azione_connetti.pedinaButton[i].setBackground(Color.LIGHT_GRAY);
		}
	}
}
