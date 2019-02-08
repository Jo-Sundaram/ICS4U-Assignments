
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class GUI extends JFrame implements ActionListener {
    private JPanel panel;
    JFrame frame;
    private JTextField one, two, three;
    private JButton button;
    static JTextArea sum;
    static int firstNum, secondNum,thirdNum;
    static int u;

    public GUI() {

        this.setSize(600,400);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setBackground(new Color(0,150,50));
        //GridLayout grid = new GridLayout(1,0,5,0);
        BoxLayout box = new BoxLayout(c,BoxLayout.Y_AXIS);
        this.setLayout(box);

        one = new JTextField();
        one.setFont(new Font("Georgia", Font.PLAIN, 20));// FONT
        one.setAlignmentX(Component.CENTER_ALIGNMENT);
        c.add(one);

        two = new JTextField();
        two.setFont(new Font("Georgia", Font.PLAIN, 20));// FONT
        two.setAlignmentX(Component.CENTER_ALIGNMENT);
        c.add(two);

        three = new JTextField();
        three.setFont(new Font("Georgia", Font.PLAIN, 20));// FONT
        three.setAlignmentX(Component.CENTER_ALIGNMENT);
        c.add(three);

        button = new JButton("Sum");
        button.setOpaque(false);
        button.addActionListener(this);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        c.add(button);

        sum = new JTextArea();
        sum.setFont(new Font("Georgia", Font.PLAIN, 20));// FONT
        sum.setEditable(false);
        sum.setAlignmentX(Component.CENTER_ALIGNMENT);
        c.add(sum);

        setLocationRelativeTo(null);
        setVisible(true);


    }


    public void getNumbers(){
        if(one.getText() !=null ){
            firstNum = Integer.parseInt(one.getText());
            secondNum = Integer.parseInt(two.getText());
            thirdNum = Integer.parseInt(three.getText());
        }
        Suminator bob = new Suminator();
        u = bob.n(firstNum,secondNum, thirdNum);
        sum.setText(Integer.toString(u));
    }


    public void actionPerformed(ActionEvent e){
        if(e.getSource() ==button){
            getNumbers();
        }
    }


static String str;
    public static void main(String[] args) {
        GUI gui = new GUI();
        Suminator bob = new Suminator();
        bob.lol();



    }


}
