import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Tablep extends JFrame implements ActionListener {

    // JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20;
    //JLabel l2;

    JButton b[] = new JButton[20];
    JTextArea tarea;
    int d;
    
    public Tablep(String s){
        
        super(s);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(5,4));

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(2,1));

        for(int i=0;i<20;i++){
            b[i]= new JButton(String.valueOf(i+1));
            b[i].setToolTipText("Display");
            b[i].addActionListener(this);
            p1.add(b[i]);
        }

        // b1 = new JButton("1");
        // b1.setToolTipText("Display");
        // b1.addActionListener(this);

        // b2 = new JButton("2");
        // b2.setToolTipText("Display");
        // b2.addActionListener(this);

        // b3 = new JButton("3");
        // b3.setToolTipText("Display");
        // b3.addActionListener(this);
        
        // b4 = new JButton("4");
        // b4.setToolTipText("Display");
        // b4.addActionListener(this);

        // b5 = new JButton("5");
        // b5.setToolTipText("Display");
        // b5.addActionListener(this);

        // b6 = new JButton("6");
        // b6.setToolTipText("Display");
        // b6.addActionListener(this);

        // b7 = new JButton("7");
        // b7.setToolTipText("Display");
        // b7.addActionListener(this);

        // b8 = new JButton("8");
        // b8.setToolTipText("Display");
        // b8.addActionListener(this);

        // b9 = new JButton("9");
        // b9.setToolTipText("Display");
        // b9.addActionListener(this);

        // b10 = new JButton("10");
        // b10.setToolTipText("Display");
        // b10.addActionListener(this);

        // b11 = new JButton("11");
        // b11.setToolTipText("Display");
        // b11.addActionListener(this);

        // b12 = new JButton("12");
        // b12.setToolTipText("Display");
        // b12.addActionListener(this);

        // b13 = new JButton("13");
        // b13.setToolTipText("Display");
        // b13.addActionListener(this);

        // b14 = new JButton("14");
        // b14.setToolTipText("Display");
        // b14.addActionListener(this);

        // b15 = new JButton("15");
        // b15.setToolTipText("Display");
        // b15.addActionListener(this);

        // b16 = new JButton("16");
        // b16.setToolTipText("Display");
        // b16.addActionListener(this);

        // b17 = new JButton("17");
        // b17.setToolTipText("Display");
        // b17.addActionListener(this);
        
        // b18 = new JButton("18");
        // b18.setToolTipText("Display");
        // b18.addActionListener(this);

        // b19 = new JButton("19");
        // b19.setToolTipText("Display");
        // b19.addActionListener(this);

        // b20 = new JButton("20");
        // b20.setToolTipText("Display");
        // b20.addActionListener(this);

        // p1.add(b1);
        // p1.add(b2);
        // p1.add(b3);
        // p1.add(b4);
        // p1.add(b5);
        // p1.add(b6);
        // p1.add(b7);
        // p1.add(b8);
        // p1.add(b9);
        // p1.add(b10);
        // p1.add(b11);
        // p1.add(b12);
        // p1.add(b13);
        // p1.add(b14);
        // p1.add(b15);
        // p1.add(b16);
        // p1.add(b17);
        // p1.add(b18);
        // p1.add(b19);
        // p1.add(b20);

        tarea = new JTextArea();
        tarea.setEditable(false);
        p2.add(tarea);

        c.add(p1,BorderLayout.WEST); 
        c.add(p2,BorderLayout.CENTER);  
    }

    // Corrected generateTable method
    public void generateTable(int a) {
        String s = "";
        for (int i = 1; i <= 10; i++) {
            s+=a+"*"+i+"+"+(a*i)+"\n";
        }
        tarea.setText(s);
    }

    public void actionPerformed(ActionEvent ae) {
        {
            String command = ae.getActionCommand(); // Get the button text value
            int num = Integer.parseInt(command);
            generateTable(num); 

            
            // if(ae.getSource()==b1)
            // {
            //     generateTable(d);
            // }
            // else if(ae.getSource()==b2)
            // {
            //     generateTable(d);
            // }
            // else if(ae.getSource()==b3)
            // {
            //     generateTable(d);
            // }
            // else if(ae.getSource()==b4)
            // {
            //     generateTable(d);
            // }
            // else if(ae.getSource()==b5)
            // {
            //     generateTable(d);
            // }
            // else if(ae.getSource()==b6)
            // {
            //     generateTable(d);
            // }
            // else if(ae.getSource()==b7)
            // {
            //     generateTable(d);
            // }
            // else if(ae.getSource()==b8)
            // {
            //     generateTable(d);
            // }
            // else if(ae.getSource()==b9)
            // {
            //     generateTable(d);
            // }
            // else if(ae.getSource()==b10)
            // {
            //     generateTable(d);
            // }
            // else if(ae.getSource()==b11)
            // {
            //     generateTable(d);
            // }
            // else if(ae.getSource()==b12)
            // {
            //     generateTable(d);
            // }
            // else if(ae.getSource()==b13)
            // {
            //     generateTable(d);
            // }
            // else if(ae.getSource()==b14)
            // {
            //     generateTable(d);
            // }
            // else if(ae.getSource()==b15)
            // {
            //     generateTable(d);
            // }
            // else if(ae.getSource()==b16)
            // {
            //     generateTable(d);
            // }
            // else if(ae.getSource()==b17)
            // {
            //     generateTable(d);
            // }
            // else if(ae.getSource()==b18)
            // {
            //     generateTable(d);
            // }
            // else if(ae.getSource()==b19)
            // {
            //     generateTable(d);
            // }
            // else if(ae.getSource()==b20)
            // {
            //     generateTable(d);
            // }
        }
    }
    

    public static void main(String args[]){

        Tablep t1 = new Tablep("Print Table ");
        t1.setSize(300,250);
        t1.setVisible(true);
        
    }

}

