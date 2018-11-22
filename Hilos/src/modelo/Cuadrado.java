package modelo;

import java.awt.Color;
import java.awt.Component;

public class Cuadrado implements Runnable{
	private int x;
	private int y;
	private Color color;
	private int size;
	private int dx;
	private int dy;
	private Component pnlDibujo;
	
	public Cuadrado(int x, int y, Color color, int size, int dx, int dy) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
		this.size = size;
		this.dx = dx;
		this.dy = dy;
	}
	

	public Cuadrado(int x, int y, Color color, int size, int dx, int dy, Component pnlDibujo) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
		this.size = size;
		this.dx = dx;
		this.dy = dy;
		this.pnlDibujo = pnlDibujo;
	}




	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
	
	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public void mover() {
		x+=dx;
		y+=dy;
		if(x+size>=pnlDibujo.getWidth()) {
			dx=-dx;
			x=pnlDibujo.getWidth()-size;
		}
		if(x<=0) {
			dx=-dx;
			x=0;
		}
		if(y+size>=pnlDibujo.getHeight()) {
			dy=-dy;
			y=pnlDibujo.getHeight()-size;
		}
		if(y<=0) {
			dy=-dy;
			y=0;
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			mover();
			pnlDibujo.repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	
}
