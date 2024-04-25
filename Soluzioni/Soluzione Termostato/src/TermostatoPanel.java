import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TermostatoPanel extends JPanel{

  private static final int width = 20;
  private static final int top = 65;
  private static final int left = 83;
  private static final int height = 200;
  
  private static final int MAX_TEMP = 100;
  private static final int MIN_TEMP = 0;
  
  int temperaturaCorrente = 0;
  private Color colore = Color.GREEN;
  
  private JLabel tempLabel;
  
  public TermostatoPanel() {
	tempLabel = new JLabel("0°C");
	tempLabel.setFont(new Font("Arial", Font.BOLD, 50));
	this.setLayout(new FlowLayout());
    setPreferredSize(new Dimension(200, 300));
	this.add(new JPanel().add(tempLabel));
  }
  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.black);
    g.drawRect(left, top, width, height);
    g.setColor(colore);
    g.fillOval(left-width/2, top+height-width/3,width*2, width*2);
    g.setColor(Color.black);
    g.drawOval(left-width/2, top+height-width/3,width*2, width*2);
    g.setColor(Color.white);
    g.fillRect(left+1,top+1, width-1, height-1);
    g.setColor(colore);

    long redtop = height*(temperaturaCorrente-MAX_TEMP)/(MIN_TEMP-MAX_TEMP);
    g.fillRect(left+1, top + (int)redtop, width-1, height-(int)redtop);
  }
  
  public void colora(String temperatura) {
	  if(temperatura.equals("reset")) {
			colore = Color.GREEN;
			tempLabel.setForeground(Color.BLACK);
			temperaturaCorrente = 0;
			
	  }
	  else {
		  if(Integer.parseInt(temperatura) <= 35) {
		  		colore = Color.GREEN;
		  		tempLabel.setForeground(Color.GREEN);
				temperaturaCorrente = Integer.parseInt(temperatura);
		  }
		  else if(Integer.parseInt(temperatura) <= 75) {
			  colore= Color.ORANGE;
			  tempLabel.setForeground(Color.ORANGE);
			  temperaturaCorrente = Integer.parseInt(temperatura);
		  }
		  else if(Integer.parseInt(temperatura) <= 100) {
			  colore = Color.RED;
			  tempLabel.setForeground(Color.RED);
			  temperaturaCorrente = Integer.parseInt(temperatura);
		  }
	  }
  }

  
  public JLabel getTempLabel() {
	  return tempLabel;
  }

}
