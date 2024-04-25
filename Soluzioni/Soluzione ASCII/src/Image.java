import java.awt.event.*;

public class Image implements ActionListener {
	
	Connect azione_connetti;
	
	public Image(Connect azione_connetti) {
		this.azione_connetti = azione_connetti;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		azione_connetti.imageArea.setText("");
		client_server operatore = new client_server(azione_connetti);
		Thread image_thread = new Thread(operatore);
		
		azione_connetti.imageArea.append("===== Download Iniziato =====\n");
		azione_connetti.image1.setEnabled(false);
		azione_connetti.image2.setEnabled(false);
		azione_connetti.image3.setEnabled(false);
		azione_connetti.image4.setEnabled(false);
		azione_connetti.image5.setEnabled(false);
		azione_connetti.stopButton.setEnabled(true);
		azione_connetti.disconnectButton.setEnabled(false);
		if(e.getSource() == azione_connetti.image1) {
			azione_connetti.pw.println("start:image1");
			azione_connetti.pw.flush();
			image_thread.start();
		}
		else if(e.getSource() == azione_connetti.image2) {
			azione_connetti.pw.println("start:image2");
			azione_connetti.pw.flush();
			image_thread.start();
		}
		else if(e.getSource() == azione_connetti.image3) {
			azione_connetti.pw.println("start:image3");
			azione_connetti.pw.flush();
			image_thread.start();
		}
		else if(e.getSource() == azione_connetti.image4) {
			azione_connetti.pw.println("start:image4");
			azione_connetti.pw.flush();
			image_thread.start();
		}
		else if(e.getSource() == azione_connetti.image5) {
			azione_connetti.pw.println("start:image5");
			azione_connetti.pw.flush();
			image_thread.start();
		}
		
	}

}
