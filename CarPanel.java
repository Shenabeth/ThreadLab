import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
   This component draws two car shapes.
 */
public class CarPanel extends JComponent
{  
	private Car car1;
	private int x,y, delay;
	private CarQueue carQueue;
	private int direction;

	CarPanel(int x1, int y1, int d, CarQueue queue)
	{
		delay = d;
		x=x1;
		y=y1;
		car1 = new Car(x, y, this);
		carQueue = queue;
	}
	public void startAnimation()
	{
		class AnimationRunnable implements Runnable
		{
			public void run()
			{
				try
				{
					for(int i = 0; i < 10; i++)
					{
						direction = carQueue.deleteQueue();
						
						//frame size is (300,400)
						
						//x = x+10;
						
						//change direction
						if (direction == CarQueue.UP) { 
							//bounce
							if ((y-10) <= 0) { y += 10; }
							
							//up
							else { y -= 10; }
						}
						
						else if (direction == CarQueue.DOWN) { 
							//bounce
							if ((y+10) >= 400) { y -= 10; }
							
							//down
							else { y += 10; }
						}
						
						else if (direction == CarQueue.RIGHT) { 
							//bounce
							if ((x+10) >= 300) { x -= 10; }
							
							//right
							else { x += 10; }
						}
						
						else if (direction == CarQueue.LEFT) { 
							//bounce
							if ((x-10) <= 0) { x += 10; }
							
							//left
							else { x -= 10; }
						}

						repaint();
						Thread.sleep(delay*1000);

					}
				}
				catch (InterruptedException exception)
				{

				}
				finally
				{

				}
			}
		}

		Runnable r = new AnimationRunnable();
		Thread t = new Thread(r);
		t.start();
	}

	public void paintComponent(Graphics g)
	{  
		Graphics2D g2 = (Graphics2D) g;

		car1.draw(g2,x,y);    
	}
}