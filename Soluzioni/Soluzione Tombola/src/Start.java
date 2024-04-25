import java.awt.event.*;
import java.util.Collections;
import java.util.LinkedList;

public class Start implements ActionListener {

	Connect azione_connetti;
	LinkedList<Integer> lista;
	int[][] matrice;
	TicketCell Cartella[] = new TicketCell[15];
	
	public Start(Connect azione_connetti, TicketCell Cartella[]) {
		
		this.azione_connetti = azione_connetti;
		this.Cartella = Cartella;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		azione_connetti.connectButton.setEnabled(false);
		azione_connetti.disconnectButton.setEnabled(false);
		azione_connetti.startButton.setEnabled(false);
		azione_connetti.stopButton.setEnabled(true);
		
		lista = new LinkedList<Integer>();
		matrice = new int[3][5];
		
		while(lista.size() != 15) {
			double x = Math.random();
			int z = (int)(x*100);
			if(((z >= 1) && (z <= 90)) && !lista.contains(z) ) {
				lista.add(z);
			}
		}
		Collections.sort(lista);
		System.out.println(lista);
				
		int ct = 0;
		for(int j = 0; j < 5; j++) {
			for(int i = 0; i < 3; i++) {
				matrice[i][j] = lista.get(ct);
				ct++;
			}
		}
		
		System.out.println("Matrice completa:");
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print(matrice[i][j] + " ");
			}
			System.out.println();
		}
		
		ct = 0;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 5; j++) {
				Cartella[ct].setValue(matrice[i][j]);
				Cartella[ct].setSelected(false);
				ct++;
			}
		}
		
		for(int i = 0; i < 15; i++) {
			lista.remove();
		}
		
		client_server operatore = new client_server(azione_connetti, Cartella);
		Thread t1 = new Thread(operatore);
		t1.start();
	}
	
}
