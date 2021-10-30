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

public class BitDuzeyindeHesapMakinesi extends JFrame implements  ActionListener {
	String deger="0";
	JTextArea area;
	JFrame hata;
	JTextArea hataci;
	JButton hataB;
	public BitDuzeyindeHesapMakinesi(String s) {
		area=new JTextArea(s);
		int deger=0;
	  	setSize(330,330);
	  	setTitle("Bit Düzeyinde Hesap Makinasi");
	   	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JPanel panel1=new JPanel();
			JPanel panel2=new JPanel();
			
			JButton ve =new JButton("&");
			ve.addActionListener(this);
			JButton yada =new JButton("|");
			yada.addActionListener(this);
			JButton unlem =new JButton("!");
			unlem.addActionListener(this);
			JButton temizle =new JButton("Temizle");
			temizle.addActionListener(this);
			JButton gelismis =new JButton("Gelismis");
			gelismis.addActionListener(this);
			JButton equal =new JButton("=");
			equal.addActionListener(this); 
			panel1.setLayout(new  GridLayout(1,3));
			panel2.setLayout(new  GridLayout(3,1));
			panel1.setBackground(Color.BLUE);
			panel2.setBackground(Color.BLUE);
			panel1.add(gelismis);
			panel1.add(temizle);
			panel1.add(equal);
			panel2.add(ve);
			panel2.add(yada);
			
			panel2.add(unlem);
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
	public boolean bitwise(String s) {
		int sayac=0;
		for(int i=0;i<s.length();i++) {
			if(s.subSequence(i,i+1).equals("1")|s.subSequence(i,i+1).equals("0")) {
				sayac+=1;
			}
		}
		if(sayac==s.length()) {
			return false;}
		else 
			return true;
		}
		int islem=0;
		String number1="0";
		int kontrol=0;
		public void actionPerformed(ActionEvent e) {
			String action = e.getActionCommand();
			deger=area.getText();
			 area.setText("0");
			
			 if(action.equals("OK")) {
				   hata.dispose();
			   }
			if(action.equals("&")) {
				   islem=1;
				   number1=deger;
				   kontrol+=1;
				  
				   if(bitwise(number1)) {kontrol+=2;}
			   }
			   else if(action.equals("|")) {
				   islem=2;
				   number1=deger;
				   kontrol+=1;
				  
				   if(bitwise(number1)) {kontrol+=2;}
			   }
			   else if(action.equals("!")) {
				   islem=3;
				   number1=deger;
				   kontrol+=1;
				  
				   if(bitwise(number1)) {kontrol+=2;}
			   }
			   else if(action.equals("=")) {
				   kontrol=0;
				   String cikti="";
				  switch(islem) {
				  case 0:area.setText(""+number1);break;
				  case 3: for(int i=0;i<number1.length();i++) {
					 if(number1.substring(i,i+1).equals(deger.substring(i,i+1))) {
						cikti+="0"; 
					 }
					 else {
						 cikti+="1";
					 }
				  } area.setText(cikti);break;
				  case 1: for(int i=0;i<number1.length();i++) {
						 if(number1.substring(i,i+1).equals("1")&deger.substring(i,i+1).equals("1")) {
								cikti+="1"; 
							 }
							 else {
								 cikti+="0";
							 }
						  } area.setText(cikti);break;
				  case 2: for(int i=0;i<number1.length();i++) {
						 if(number1.substring(i,i+1).equals("1")|deger.substring(i,i+1).equals("1")) {
								cikti+="1"; 
							 }
							 else {
								 cikti+="0";
							 }
						  } area.setText(cikti); break;
				  }
			   }		   
			   else if(action.equals("Gelismis")) {
				   dispose();
				   new GelismisHesapMakinesi(""+deger);
			   }
			   else if(action.equals("Temizle")) {
				   kontrol=0;
				   area=new JTextArea("0");
			   }
			if(kontrol>=2) {
				   area.setText("0");
				   hata.setVisible(true);
				   kontrol=0;
			   }
		
		}

}
