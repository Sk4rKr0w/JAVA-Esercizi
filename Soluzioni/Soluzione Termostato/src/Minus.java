import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Minus implements ActionListener {

	Connect azione_connetti;
	
	public Minus(Connect azione_connetti){
		this.azione_connetti = azione_connetti;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		azione_connetti.pw.println("diminuisci");
		azione_connetti.pw.flush();
		
	}


}
