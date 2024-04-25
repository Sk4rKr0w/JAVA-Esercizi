import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stop implements ActionListener {

	Connect azione_connetti;
	
	public Stop(Connect azione_connetti) {
		this.azione_connetti = azione_connetti;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		azione_connetti.pw.println("stop");
		azione_connetti.pw.flush();
		
	}

}
