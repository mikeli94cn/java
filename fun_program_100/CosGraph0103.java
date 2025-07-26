import java.applet.*;
import java.awt.*;

public class CosGraph0103 extends Applet{
	int x;
	int y;

	public void start()
	{
		Graphics g = getGraphics();

		for(x=0;x<=750;x++){
			g.drawString(".",x,200);
		}

		for(x=740;x<=750;x++){
			g.drawString(".",x,950-x);
			g.drawString(".",x,x+550);
		}

		for(y=0;y<=385;y++){
			g.drawString(".",360,y);
		}

		for(y=375;y<=385;y++){
			g.drawString(".",y-385,y);
			g.drawString(".",385-y,y);
		}

		for(x=0;x<=720;x++){
			double a=Math.cos(x*Math.PI/180);
			y=(int)(80*a+200);
			g.drawString(".",x,y);
		}

	}
}
