import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

//import com.sun.tools.jdi.IntegerValueImpl;

public class BasitHesapMakinasi extends JFrame implements  ActionListener{
	 	int deger=0;
	 	JTextArea area;
	 	JFrame hata;
		JTextArea hataci;
		JButton hataB;
		public BasitHesapMakinasi(String s){    
			area=new JTextArea(s);
    	   	setSize(330,330);
    	   	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	    setTitle("Basit Hesap Makinasi");
    	    JPanel panel1=new JPanel();
    		JPanel panel2=new JPanel();
   			JButton mux =new JButton("*");
   			JButton ext =new JButton("-");
   			JButton plus =new JButton("+");
   			JButton div =new JButton("/");
   			JButton temizle =new JButton("Temizle");
   			JButton gelismis =new JButton("Gelismis");
   			JButton equal =new JButton("=");
   			panel1.setLayout(new  GridLayout(1,3));
   			panel2.setLayout(new  GridLayout(4,1));
   			//mux.setPreferredSize(new Dimension(11,11));
   			panel1.setBackground(Color.BLUE);
   			panel2.setBackground(Color.BLUE);
   			mux.addActionListener(this);
   			ext.addActionListener(this);
   			plus.addActionListener(this);
   			div.addActionListener(this);
   			temizle.addActionListener(this);
   			gelismis.addActionListener(this);   			
   			equal.addActionListener(this); 
   			panel1.add(temizle);
   			panel1.add(gelismis);
   			panel1.add(equal);
   			panel2.add(plus);
   			panel2.add(ext);
   			panel2.add(mux);
   			panel2.add(div);
   			
   			add(area,BorderLayout.CENTER);
   			add(panel1,BorderLayout.SOUTH);
   			add(panel2,BorderLayout.EAST);
   			setVisible(true);
   			
   			
   			hata=new JFrame();
   			hata.setSize(110,110);
   			hataci=new JTextArea("Hatali icerik");
   			hataci.setFont(new Font("Hatali icerik", Font.BOLD, 16));
   			hataB =new JButton("OK");
   			hataB.addActionListener(this);
   			hata.add(hataci,BorderLayout.CENTER);
   			hata.add(hataB,BorderLayout.SOUTH);
   			
       }      
	   int islem=0;
	   int number1=0;
	   int kontrol=0; 

	   public void actionPerformed(ActionEvent e) {
		   String action = e.getActionCommand();
		   deger=Integer.valueOf(area.getText());
		   area.setText("0");
		   if(action.equals("OK")) {
			   hata.dispose();
		   }
		   if(action.equals("*")) {
			   islem=1;
			   number1=deger;
			   kontrol+=1;
		   }
		   else if(action.equals("/")) {
			   islem=2;
			   number1=deger;
			   kontrol+=1;
		   }
		   else if(action.equals("+")) {
			   islem=3;
			   number1=deger;
			   kontrol+=1;
		   }
		   else if(action.equals("-")) {
			   islem=4;
			   number1=deger;
			   kontrol+=1;
		   }		   
		   else if(action.equals("Gelismis")) {
			   dispose();
			   GelismisHesapMakinesi news=  new GelismisHesapMakinesi(""+deger);
			  
			   kontrol=0;
		   }
		   else if(action.equals("Temizle")) {
			   area.setText("0");
			   kontrol=0;
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
			   }
		   }
		   if(kontrol>=2) {
			   area.setText("0");
			   hata.setVisible(true);
			   kontrol=0;
		   }
		
	}
	
 
}
