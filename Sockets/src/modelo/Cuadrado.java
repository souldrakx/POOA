package modelo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;

import vista.paneles.PanelJuego;
import vista.paneles.PanelMundo;

public class Cuadrado implements Runnable,Serializable{
	private int x;
	private int y;
	private Color color;
	private int size;
	private int dx;
	private int dy;
	private Component pnlDibujo;
	private boolean isRunning;
	
	
	
	@Override
	public String toString() {
		return "Cuadrado [x=" + x + ", y=" + y + ", color=" + color + ", size=" + size + ", dx=" + dx + ", dy=" + dy
				+ "]";
	}

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
		this.pnlDibujo =  pnlDibujo;
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
	
	
	
	

	public Component getPnlDibujo() {
		return pnlDibujo;
	}

	public void setPnlDibujo(Component pnlDibujo) {
		this.pnlDibujo = pnlDibujo;
	}

	public boolean isRunning() {
		return isRunning;
	}


	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}


	public synchronized void mover() {
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
		isRunning=true;
		while(isRunning) {
			mover();
			pnlDibujo.repaint();
			try {
				Thread.sleep(30);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, size, size);
	}
	
}
