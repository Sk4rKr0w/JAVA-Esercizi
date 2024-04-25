import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lettere implements ActionListener {
	
	Connect azione_connetti;
	
	public Lettere(Connect azione_connetti) {
		this.azione_connetti = azione_connetti;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		azione_connetti.pw.println("lettere");
		azione_connetti.pw.flush();
		
	}

}
