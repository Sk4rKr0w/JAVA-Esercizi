import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Numeri implements ActionListener {
	
	Connect azione_connetti;
	
	public Numeri(Connect azione_connetti) {
		this.azione_connetti = azione_connetti;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		azione_connetti.pw.println("cifre");
		azione_connetti.pw.flush();
		
	}

}
