import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class guiDemo extends JFrame implements ActionListener{
	private JButton button;
	private JTextArea area;
	
	
	public guiDemo() {
		
		this.setSize(600,400);
		this.setResizable(false);
		this.setLayout(null);
		this.setTitle("GUI DEMO");
		
		Container c = getContentPane();
		c.setBackground(new Color(0,150,50));
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JLabel  titleLabel = new JLabel("Demo-ing Gui's");
		// X, Y, WIDTH AND HEIGHT OF LABEL
		titleLabel.setBounds(0,10,getWidth(), 40);
		// FONT
		titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		// COLOR
		titleLabel.setForeground(Color.pink);
		// ALIGNMENT
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		c.add(titleLabel);
		
		area = new JTextArea();
		area.setBounds(360,70,215,100);
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		area.setFont(new Font("Georgia", Font.PLAIN, 15));
		c.add(area);
		
		button = new JButton("CLICK ME");
		button.setBounds(10,100,340,200);
		button.setOpaque(false);
		button.addActionListener(this);
		c.add(button);
		
	
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button)
			area.setText("Hello");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	// DISPLAYS THE GUI
		guiDemo gui = new guiDemo();
		
	}

}


