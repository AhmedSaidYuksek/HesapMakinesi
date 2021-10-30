import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GelismisHesapMakinesi extends JFrame implements  ActionListener {
	int deger=0;
	JFrame hata;   
	JTextArea area;
	JTextArea hataci;
	JButton hataB;
	public long factorial(int deger) {
	    if (deger <= 2) {
	        return deger;
	    }
	    return deger* factorial(deger - 1);
	}
	public GelismisHesapMakinesi(String s) {
		area=new JTextArea(s);
		setSize(330,330);
		setTitle("Gelismis Hesap Makinasi");
		JPanel panel1=new JPanel();
		JPanel panel2=new JPanel();
		JPanel panel4=new JPanel();
		JButton mux =new JButton("*");			
		JButton ext =new JButton("-");
		 ext.addActionListener(this);
		JButton plus =new JButton("+");
		plus.addActionListener(this);
		JButton div =new JButton("/");	
		 div.addActionListener(this);
		JButton facto =new JButton("x!");
		 facto.addActionListener(this);
		JButton ln =new JButton("ln");	
		 ln.addActionListener(this);
		JButton ust =new JButton("x^y");	
		 ust.addActionListener(this);
		JButton kok =new JButton("x^1/2");	
		 kok.addActionListener(this);
		JButton temizle =new JButton("Temizle");
		 temizle.addActionListener(this);
		JButton basit =new JButton("Basit");
		 basit.addActionListener(this);
		JButton bitwise =new JButton("Bitwise");
		 bitwise.addActionListener(this);
		JButton equal =new JButton("=");
		 equal.addActionListener(this);		
			
		panel1.setLayout(new  GridLayout(1,4));
		panel2.setLayout(new  GridLayout(4,2));
		
		panel4.setLayout(new  GridLayout());
		panel1.setBackground(Color.BLUE);
		panel2.setBackground(Color.BLUE);			
			
		panel1.add(basit);
		panel1.add(bitwise);
		panel1.add(temizle);
		panel1.add(equal);
		panel2.add(plus);
		panel2.add(facto);
		panel2.add(ext);
		panel2.add(ln);			
		panel2.add(mux);
		panel2.add(ust);
		panel2.add(div);
		panel2.add(kok);		

   			hata=new JFrame();
   			hata.setSize(110,110);
   			hataci=new JTextArea("Hatali icerik");
   			hataci.setFont(new Font("Hatali icerik", Font.BOLD, 16));
   			hataB =new JButton("OK");
   			hataB.addActionListener(this);
   			hata.add(hataci,BorderLayout.CENTER);
   			hata.add(hataB,BorderLayout.SOUTH);
			
			
			panel4.add(area);
			add(panel4,BorderLayout.CENTER);
			add(panel1,BorderLayout.SOUTH);
			add(panel2,BorderLayout.EAST);
			setVisible(true);
	}	
	   int islem=0;
	   int number1=0;
	   int kontrol=0;
	   
	public void actionPerformed(ActionEvent e) {
		 String action = e.getActionCommand();
		 deger=Integer.valueOf(area.getText());
		 //area=new JTextArea("0");
		   area.setText("0");
		 if(action.equals("OK")) {
			   hata.dispose();
		   }
		  if(action.equals("*")) {
			 
			   islem=1;
			   number1=deger;
			   kontrol+=1;
			   //area.setText("0");
		   }
		   else if(action.equals("/")) {
			   islem=2;
			   number1=deger;
			   kontrol+=1;
			   //area.setText("0");
		   }
		   else if(action.equals("+")) {
			   islem=3;
			   number1=deger;
			   kontrol+=1;
			   //area.setText("0");
		   }
		   else if(action.equals("-")) {
			   islem=4;
			   number1=deger;
			   kontrol+=1;
			   //area.setText("0");
		   }		   
		   
		   else if(action.equals("x!")) {
			   area.setText(""+factorial(deger));
			   islem=5;
			   number1=deger;
			   kontrol=0;
		   }
		   else if(action.equals("x^y")) {
			   islem=6;
			   number1=deger;
			   kontrol+=1;
			   //area.setText("0");
		   }
		   else if(action.equals("√x")) {
			   area.setText(""+(Math.pow(deger,0.5)));
			   number1=deger;
			   kontrol+=1;
		   }
		   else if(action.equals("ln")) {
			   area.setText(""+Math.log((double)deger));
			    number1=deger;
			   kontrol+=1;
			   //area.setText("0");
		   }
		   else if(action.equals("Bitwise")) {
			   new BitDuzeyindeHesapMakinesi(""+deger);			   
			  dispose();
			   
		   }
		   else if(action.equals("Basit")) {
			      dispose();
				  new BasitHesapMakinasi(""+deger);
		   }			   
		   else if(action.equals("Temizle")) {
			   kontrol=0;
			   area.setText("0");
			  		 
			  		   }
		   else if(action.equals("=")) {
			   kontrol=0;
			   switch(islem) {
			   case 0:area.setText(""+number1);break;
			   case 1: double number3=number1,deger3=deger;
				   area.setText(""+(number3*deger3));break;
			   case 2:
				   if(deger==0) {kontrol=2;break;}				   
				   else {double number2=number1,deger2=deger;
					   area.setText(""+(number2/deger2));break;}
			   case 3: area.setText(""+(number1+deger));break;
			   case 4: area.setText(""+(number1-deger));break;
			   case 6: area.setText(""+(Math.pow(number1,deger)));break;
			
			   
			   }
		   }
		  if(kontrol>=2) {
			   area.setText("0");
			   hata.setVisible(true);
			   kontrol=0;
		   }
		
	}
	
	
}
