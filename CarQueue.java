/**
 * This is the car queue class
 * @author Shenabeth Jenkins
 * 
 */

import java.util.Queue;
import java.util.Random;
import java.util.ArrayDeque;

/**
 * This is the car queue class
 * @author Shenabeth Jenkins
 *
 */
public class CarQueue {
	//fields
	//directions
	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int RIGHT = 2;
	public static final int LEFT = 3;

	//random event
	private Random rand = new Random();

	//integer queue
	Queue<Integer> queue;

	//output
	public int output;

	//constructors
	/**
	 * place 5 or 6 numbers in the queue so that when the animation starts –
	 * there will be something to retrieve from the queue
	 */
	public CarQueue() {
		//create a queue
		queue = new ArrayDeque<Integer>();

		//create random event
		for (int i = 0; i < 5; i++) {
			//add a random event to the queue (up to 3)
			queue.add(rand.nextInt(4));
		}
	}


	//methods
	/**
	 * There is an addToQueue method that has a class that implements runnable, define the run method
	 * (add random directions into the queue and then sleep), creates an instance of the runnable object,
	 * creates a thread and starts the thread
	 */
	public void addToQueue() {
		//must implement runnable
		class RunnableQueue implements Runnable {
			//run
			@Override
			public void run() {
				//try block
				try {
					//add to queue
					if(queue.size() <= 2){
						queue.add(rand.nextInt(4));
						queue.add(rand.nextInt(4));
						queue.add(rand.nextInt(4));
						queue.add(rand.nextInt(4));
					}

					//remove head of queue
					else if (!queue.isEmpty()){ queue.remove(); }

					//sleep
					Thread.sleep(500);
				}

				//catch and throw exception
				catch (InterruptedException e) {e.printStackTrace();} //catch block
				
				//finally
				finally {}
				
			} //end of run block

		} //end of runnable block

		//create thread
		RunnableQueue q = new RunnableQueue();
		Thread threadQueue = new Thread(q);

		//start thread
		threadQueue.start();
	}


	/**
	 * runs an Integer
	 * @return 
	 */
	public int deleteQueue() {
		//queue is empty
		if (queue.isEmpty()) { return 0; }

		//remove if there is something in the queue
		return queue.remove(); 
	}
}
