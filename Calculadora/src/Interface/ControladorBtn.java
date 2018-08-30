package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorBtn implements ActionListener {

	private Calculadora c;
	
	public ControladorBtn(Calculadora c) {
		this.c = c;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	
	
	String comando = e.getActionCommand();
	
	double op1 = Double.parseDouble(c.getOperador1().getText());
	double op2 = Double.parseDouble(c.getOperador2().getText());
	double res = 0;
	switch(comando) {
		case "Suma":
			res = op1 + op2;
			break;
		case "Resta":
			res = op1-op2;
			break;
		case "Multiplicar":
			res = op1*op2;
			break;
		case "Dividir":
			res = op1/op2;
			break;
	
	}

	c.getResultado().setText(String.valueOf(res));
	
	}
}
