import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class MultiButton extends JFrame implements ActionListener
{
	JTextField tf1;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,ze,ad,subt,mult,div,per,dot,clear,bs;
	String number,newNumber;
	char[] newA;
	int l;

	public MultiButton(String s)
	{
		super(s);
	
		Container c=getContentPane();
		c.setLayout(new BorderLayout());

		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(6,3));

		b1=new JButton("1");
		b1.setToolTipText("Display");
		b1.addActionListener(this);

		b2=new JButton("2");
		b2.setToolTipText("Display");
		b2.addActionListener(this);

		b3=new JButton("3");
		b3.setToolTipText("Display");
		b3.addActionListener(this);

		b4=new JButton("4");
		b4.setToolTipText("Display");
		b4.addActionListener(this);

		b5=new JButton("5");
		b5.setToolTipText("Display");
		b5.addActionListener(this);

		b6=new JButton("6");
		b6.setToolTipText("Display");
		b6.addActionListener(this);

		b7=new JButton("7");
		b7.setToolTipText("Display");
		b7.addActionListener(this);

		b8=new JButton("8");
		b8.setToolTipText("Display");
		b8.addActionListener(this);

		b9=new JButton("9");
		b9.setToolTipText("Display");
		b9.addActionListener(this);

		ze=new JButton("0");
		ze.setToolTipText("Display");
		ze.addActionListener(this);

		ad=new JButton("+");
		ad.setToolTipText("Display");
		ad.addActionListener(this);

		subt=new JButton("-");
		subt.setToolTipText("Display");
		subt.addActionListener(this);

		mult=new JButton("*");
		mult.setToolTipText("Display");
		mult.addActionListener(this);

		div=new JButton("/");
		div.setToolTipText("Display");
		div.addActionListener(this);

		per=new JButton("%");
		per.setToolTipText("Display");
		per.addActionListener(this);

		dot=new JButton(".");
		dot.setToolTipText("Display");
		dot.addActionListener(this);

		clear=new JButton("C");
		clear.setToolTipText("Display");
		clear.addActionListener(this);

		bs=new JButton("BK");
		bs.setToolTipText("Display");
		bs.addActionListener(this);

		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p1.add(b5);
		p1.add(b6);
		p1.add(b7);
		p1.add(b8);
		p1.add(b9);
		p1.add(ze);

		p1.add(ad);
		p1.add(subt);
		p1.add(mult);
		p1.add(div);
		p1.add(per);

		p1.add(dot);
		p1.add(clear);
		p1.add(bs);		
		
		JPanel p2=new JPanel();	
		p2.setLayout(new GridLayout(1,1));
 
		tf1=new JTextField();
		tf1.setEditable(false);
		p2.add(tf1);		

		c.add(p1,BorderLayout.NORTH);
		c.add(p2,BorderLayout.SOUTH);
	}

	public void backspace(){
		 number = tf1.getText();
		 newA = number.toCharArray();
		 //System.out.println(newA);
		 System.out.println(newA.length);
		 newNumber="";
		 l=newA.length;
		 for(int a=0;a<=l-2;a++){
			newNumber+=newA[a];
			System.out.println(newA[a]);
		 }
		 System.out.println(newNumber);
		 tf1.setText(newNumber);	 
	}

	public void add(){

	}

	public void sub(){

	}

	public void mul(){

	}

	public void divide(){

	}

	public void percent(){

	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			tf1.setText(tf1.getText()+"1");
		}
		else if(ae.getSource()==b2)
		{
			tf1.setText(tf1.getText()+"2");			
		}
		else if(ae.getSource()==b3)
		{
			tf1.setText(tf1.getText()+"3");
		}
		else if(ae.getSource()==b4)
		{
			tf1.setText(tf1.getText()+"4");
		}
		else if(ae.getSource()==b5)
		{
			tf1.setText(tf1.getText()+"5");
		}
		else if(ae.getSource()==b6)
		{
			tf1.setText(tf1.getText()+"6");
		}
		else if(ae.getSource()==b7)
		{
			tf1.setText(tf1.getText()+"7");
		}
		else if(ae.getSource()==b8)
		{
			tf1.setText(tf1.getText()+"8");
		}
		else if(ae.getSource()==b9)
		{
			tf1.setText(tf1.getText()+"9");
		}
		if(ae.getSource()==ze)
		{
			tf1.setText(tf1.getText()+"0");
		}
		else if(ae.getSource()==ad)
		{
			add();
		}
		else if(ae.getSource()==subt)
		{
			sub();
		}
		else if(ae.getSource()==mult)
		{
			mul();
		}
		if(ae.getSource()==div)
		{
			divide();
		}
		else if(ae.getSource()==per)
		{
			percent();
		}
		else if(ae.getSource()==dot)
		{
			tf1.setText(tf1.getText()+".");
		}
		if(ae.getSource()==clear)
		{
			tf1.setText("");
		}
		else if(ae.getSource()==bs)
		{
			backspace();
		}
	}
	
	public static void main(String args[])
	{
		MultiButton ob=new MultiButton("Multi Button Table");

		ob.setSize(350,250);
		ob.setVisible(true);
	}
}
	
