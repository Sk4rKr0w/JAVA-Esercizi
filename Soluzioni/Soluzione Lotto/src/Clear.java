import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Clear implements ActionListener {

	Connect azione_connetti;
	
	public Clear(Connect azione_connetti) {
		
		this.azione_connetti = azione_connetti;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0; i < 5; i++) {
			azione_connetti.casella[i].changeColor(Color.LIGHT_GRAY);
			azione_connetti.casella[i].setTextDigit("");
		}
		
	}

}
