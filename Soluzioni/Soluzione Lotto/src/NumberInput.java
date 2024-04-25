import javax.swing.JOptionPane;

public class NumberInput implements Reader {

	@Override
	public String read() {
		
		String number = "";
		boolean x = false;
		
		while (!x) {
			
			number = JOptionPane.showInputDialog("Inserire un numero compreso tra 0 e 9");
			if(Integer.parseInt(number) >= 0 && Integer.parseInt(number) <= 9) {
				x = true;
			}
			else {
				x = false;
			}
		}
		return number;
		
	}

}
