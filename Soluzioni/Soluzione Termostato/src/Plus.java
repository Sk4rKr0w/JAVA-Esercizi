import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Plus implements ActionListener {
	
	Connect azione_connetti;
	
	public Plus(Connect azione_connetti){
		this.azione_connetti = azione_connetti;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		azione_connetti.pw.println("aumenta");
		azione_connetti.pw.flush();
		
	}

	

}
