import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interrupt implements ActionListener {
	
	Connect azione_connetti;
	
	public Interrupt(Connect azione_connetti) {
		this.azione_connetti = azione_connetti;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		azione_connetti.pw.println("INTERRUPT");
		azione_connetti.pw.flush();
	}

}
