import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Convert implements ActionListener {
	
	Connect azione_connetti;
	String hexaValue;
	String binaryValue;
	long decimalValue;
	
	
	public Convert(Connect azione_connetti) {
		this.azione_connetti = azione_connetti;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		hexaValue = azione_connetti.hexadecimalField.getText();
        decimalValue = Long.parseUnsignedLong(hexaValue, 16);
        binaryValue = Long.toBinaryString(decimalValue);
        
        azione_connetti.decimalField.setText(String.valueOf(decimalValue));
        azione_connetti.binaryField.setText(binaryValue);
	}
}
