package kdr.fig;

import java.awt.*;

public class KRightTriangle extends KTwoPointFigure {
	protected boolean fillFlag;

	public KRightTriangle(Color color) {
		this(color, 0, 0);
	}

	public KRightTriangle(Color color, int x, int y) {
		this(color, x, y, x, y);
	}

	public KRightTriangle(Color color, int x1, int y1, int x2, int y2) {
		this(color, 1, x1, y1, x2, y2);
	}

	public KRightTriangle(Color color, int thickness, int x1, int y1, int x2, int y2) {
		super(color, thickness, x1, y1, x2, y2);
		fillFlag = false;
	}

	public void setFill() {
		fillFlag = !fillFlag;
	}

	protected void drawEx(Graphics g) {
		super.drawEx(g);

		g.drawLine(x1, y1, x1, y2);
		g.drawLine(x1, y2, x2, y1);
		g.drawLine(x2, y1, x1, y1);

		if (fillFlag) {
			int[] xpoints = new int[3];
			int[] ypoints = new int[3];
			xpoints[0] = x1;	ypoints[0] = y1;
			xpoints[1] = x1;	ypoints[1] = y2;
			xpoints[2] = x2;	ypoints[2] = y1;
			g.fillPolygon(xpoints, ypoints, 3);
		}
	}

	protected void drawDotEx(Graphics g) {
		if(x1 < x2 && y1 > y2){//1
			g.fillRect(x1 - DOTSIZE, y1, DOTSIZE, DOTSIZE);
			g.fillRect(x1 - DOTSIZE, y2 - DOTSIZE, DOTSIZE, DOTSIZE);
			g.fillRect(x2, y1 , DOTSIZE, DOTSIZE);
		}else if (x1 < x2 && y1 < y2) {//2
			g.fillRect(x1 - DOTSIZE, y1 - DOTSIZE, DOTSIZE, DOTSIZE);
			g.fillRect(x1 - DOTSIZE, y2, DOTSIZE, DOTSIZE);
			g.fillRect(x2, y1 - DOTSIZE, DOTSIZE, DOTSIZE);
		}else if (x1 > x2 && y1 < y2) {//3
			g.fillRect(x1, y1 - DOTSIZE, DOTSIZE, DOTSIZE);
			g.fillRect(x1, y2, DOTSIZE, DOTSIZE);
			g.fillRect(x2 - DOTSIZE, y1 - DOTSIZE, DOTSIZE, DOTSIZE);
		}else if (x1 > x2 && y1 > y2) {//4
			g.fillRect(x1, y1, DOTSIZE, DOTSIZE);
			g.fillRect(x1, y2 - DOTSIZE, DOTSIZE, DOTSIZE);
			g.fillRect(x2 - DOTSIZE , y1, DOTSIZE, DOTSIZE);
		}
	}

	public void makeRegion() {
		int[] xpoints = new int[3];
		int[] ypoints = new int[3];

		xpoints[0] = x1;	ypoints[0] = y1;
		xpoints[1] = x1;	ypoints[1] = y2;
		xpoints[2] = x2;	ypoints[2] = y1;
		region = new Polygon(xpoints, ypoints, 3);
	}

	public KFigure copy() {
		KRightTriangle newRightTriangle = new KRightTriangle(color, thickness, x1, y1, x2, y2);
		newRightTriangle.popup = popup;
		newRightTriangle.fillFlag = fillFlag;
		return newRightTriangle;
	}
}
