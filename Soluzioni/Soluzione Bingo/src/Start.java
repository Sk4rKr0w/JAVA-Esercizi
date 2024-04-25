import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedList;

public class Start implements ActionListener {
	
	Connect azione_connetti;
	LinkedList<Integer> lista = new LinkedList<Integer>();
	int[][] matrice = new int[3][5];
	
	public Start(Connect azione_connetti) {
		this.azione_connetti = azione_connetti;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		azione_connetti.pw.println("start");
		azione_connetti.pw.flush();
		azione_connetti.stopButton.setEnabled(true);
		azione_connetti.disconnectButton.setEnabled(false);
		azione_connetti.startButton.setEnabled(false);
		
		while(lista.size()!= 15) {
			double x = Math.random();
			int value = (int)(x*100);
			if ((!lista.contains(value)) && (value >= 1 && value <= 90)){
				lista.add(value);
			}
		}
		
		Collections.sort(lista);
		System.out.println(lista);
		
		int ct = 0;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 3; j++) {
				matrice[j][i] = lista.get(ct);
				System.out.print(matrice[j][i] + " ");
				ct++;
			}
			System.out.println();
		}
		
		ct = 0;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 5; j++) {
				azione_connetti.caselle[ct].setValue(matrice[i][j]);
				azione_connetti.caselle[ct].setSelected(false);
				ct++;
			}
		}
		
		for(int i = 0; i < 15; i++) {
			lista.remove(0);
		}
		
		start_thread operatore = new start_thread(azione_connetti);
		Thread t1 = new Thread(operatore);
		t1.start();
	}

}
