import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class Randomize implements ActionListener {
	
	Connect azione_connetti;
	double x;
	int value;
	int ct_ruota = 0;
	int ct_casella = 0;
	
	public Randomize(Connect azione_connetti) {
		
		this.azione_connetti = azione_connetti;
				
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//---------------CREO LISTE---------------
		
		azione_connetti.ruota1 = new LinkedList<Integer>();
		azione_connetti.ruota2 = new LinkedList<Integer>();
		azione_connetti.ruota3 = new LinkedList<Integer>();
		azione_connetti.ruota4 = new LinkedList<Integer>();
		azione_connetti.ruota5 = new LinkedList<Integer>();

		//-------PRIMA RUOTA---------
		while(azione_connetti.ruota1.size() != 5) {
			x = Math.random();
			value = (int)(x*100);
			if((value >= 1 && value <= 90) && !azione_connetti.ruota1.contains(value)) {
				azione_connetti.ruota1.add(value);
				azione_connetti.caselle[ct_casella].setSelectedIndex(azione_connetti.ruota1.get(ct_ruota));
				ct_ruota++;
				ct_casella++;
			}
		}
		
		System.out.println("Prima ruota:\n" + azione_connetti.ruota1);
		
		ct_ruota = 0;
	
		//--------SECONDA RUOTA------------
		while(azione_connetti.ruota2.size() != 5) {
			x = Math.random();
			value = (int)(x*100);
			if((value >= 1 && value <= 90) && !azione_connetti.ruota2.contains(value)) {
				azione_connetti.ruota2.add(value);
				azione_connetti.caselle[ct_casella].setSelectedIndex(azione_connetti.ruota2.get(ct_ruota));
				ct_ruota++;
				ct_casella++;
			}
		}
		System.out.println("Seconda ruota:\n" + azione_connetti.ruota2);
		
		ct_ruota = 0;

		//----------TERZA RUOTA---------
		while(azione_connetti.ruota3.size() != 5) {
			x = Math.random();
			value = (int)(x*100);
			if((value >= 1 && value <= 90) && !azione_connetti.ruota3.contains(value)){
				azione_connetti.ruota3.add(value);
				azione_connetti.caselle[ct_casella].setSelectedIndex(azione_connetti.ruota3.get(ct_ruota));
				ct_ruota++;
				ct_casella++;
			}
		}
		System.out.println("Terza ruota:\n" + azione_connetti.ruota3);

		ct_ruota = 0;

		//------------QUARTA RUOTA---------
		while(azione_connetti.ruota4.size() != 5) {
			x = Math.random();
			value = (int)(x*100);
			if((value >= 1 && value <= 90) && !azione_connetti.ruota4.contains(value)){
				azione_connetti.ruota4.add(value);
				azione_connetti.caselle[ct_casella].setSelectedIndex(azione_connetti.ruota4.get(ct_ruota));
				ct_ruota++;
				ct_casella++;
			}
		}
		System.out.println("Quarta ruota:\n" + azione_connetti.ruota4);
		
		ct_ruota = 0;
		
		//---------QUINTA RUOTA------------
		while(azione_connetti.ruota5.size() != 5) {
			x = Math.random();
			value = (int)(x*100);
			if((value >= 1 && value <= 90) && !azione_connetti.ruota5.contains(value)){
				azione_connetti.ruota5.add(value);
				azione_connetti.caselle[ct_casella].setSelectedIndex(azione_connetti.ruota5.get(ct_ruota));
				ct_ruota++;
				ct_casella++;
			}
		}
		System.out.println("Quinta ruota:\n" + azione_connetti.ruota5);
		
		ct_casella = 0;
		ct_ruota = 0;
		
		
		
	}

}
