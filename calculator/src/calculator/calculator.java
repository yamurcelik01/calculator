package calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class calculator implements ActionListener {
	
	JFrame frame;
	JTextField textfield;
	JButton[] numbers = new JButton[10];
	JButton[] functions = new JButton[9];
	JButton add,sub,multi,div;
	JButton dec,equ,del,clr,neg;
	JPanel panel;
	
	double num1=0, num2=0, result=0;
	char operator;
	
	
	calculator(){
		
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 550);
		frame.setLayout(null);
		
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setEditable(false);
		
		add = new JButton("+");
		sub = new JButton("-");
		multi= new JButton("x");
		div = new JButton("/");
		dec= new JButton(".");
		equ = new JButton("=");
		del = new JButton("delete");
		clr= new JButton("clear");
		neg = new JButton("(-)");
		
		functions[0]=add;
		functions[1]=sub;
		functions[2]=multi;
		functions[3]=div;
		functions[4]=dec;
		functions[5]=equ;
		functions[6]=del;
		functions[7]=clr;
		functions[8]=neg;
		
		for (int i = 0; i < 8; i++) {
			functions[i].addActionListener(this);
			functions[i].setFocusable(false);
		}
		
		for (int i = 0; i < 10; i++) {
			numbers[i]= new JButton(String.valueOf(i));
			numbers[i].addActionListener(this);
			numbers[i].setFocusable(false);
		}
		
		neg.setBounds(50, 430, 100, 50);
		del.setBounds(150, 430, 100, 50);
		clr.setBounds(250, 430, 100, 50);
		
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));
		panel.setBackground(Color.LIGHT_GRAY);
		
		
		panel.add(numbers[1]);
		panel.add(numbers[2]);
		panel.add(numbers[3]);
		panel.add(add);
		panel.add(numbers[4]);
		panel.add(numbers[5]);
		panel.add(numbers[6]);
		panel.add(sub);
		panel.add(numbers[7]);
		panel.add(numbers[8]);
		panel.add(numbers[9]);
		panel.add(multi);
		panel.add(dec);
		panel.add(numbers[0]);
		panel.add(equ);
		panel.add(div);
		
		
		frame.add(panel);
		frame.add(neg);
		frame.add(del);
		frame.add(clr);
		frame.add(textfield);
		frame.setVisible(true);
		
		
	}

	public static void main(String[] args) {
		
		calculator calc = new calculator();

	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for (int i = 0; i < 10; i++) {
			if(e.getSource()==numbers[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}	
		}
		
		if(e.getSource()== dec) {
			textfield.setText(textfield.getText().concat(String.valueOf(".")));	
		}
		
		if(e.getSource()== add) {
			num1= Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		
		if(e.getSource()== sub) {
			num1= Double.parseDouble(textfield.getText());
			operator='-';
			textfield.setText("");
		}
		
		if(e.getSource()== multi) {
			num1= Double.parseDouble(textfield.getText());
			operator='x';
			textfield.setText("");
		}
		
		if(e.getSource()== div) {
			num1= Double.parseDouble(textfield.getText());
			operator='/';
			textfield.setText("");
		}
		
		if(e.getSource()== equ) {
			num2= Double.parseDouble(textfield.getText());
			
			switch (operator) {
			case '+':
				result = num1+num2;
				break;
			
			case '-':
				result= num1-num2;
				break;
			
			case 'x':
				result = num1*num2;
				break;
			
			case '/':
				result= num1/num2;
				break;
			}
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		
		if(e.getSource()== clr) {
			textfield.setText("");
		}
		
		if(e.getSource()== del) {
			String str = textfield.getText();
			if(str.length()>0) {
				str= str.substring(0, str.length()-1);
				textfield.setText(str);
				
			}
		}
		
		
			
	}

}

