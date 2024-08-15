package _08_LeagueSnake;

import java.util.ArrayList;
import java.util.Random;

import processing.core.PApplet;
import processing.core.PImage;

public class LeagueSnake extends PApplet {
	static final int WIDTH = 800;
	static final int HEIGHT = 800;

	/*
	 * Game variables
	 * 
	 * Put all the game variables here.
	 */
	Segment head;
	int foodX;
	int foodY;
	int score;
	ArrayList<Segment> tail = new ArrayList<Segment>();
		PImage image;
	Random r = new Random();

	int direction = UP;

	/*
	 * Setup methods
	 * 
	 * These methods are called at the start of the game.
	 */
	@Override
	public void settings() {
		size(WIDTH, HEIGHT);
		
	}

	@Override
	public void setup() {
		head = new Segment(240, 260);
		dropFood();
		frameRate(10);
	image = loadImage("src/_08_LeagueSnake/rainbows.png");
	image.resize(WIDTH, HEIGHT);
		
	}

	void dropFood() {
		// Set the food in a new random location
		foodX = ((int) random(WIDTH/20) * 20);
		foodY = ((int) random(HEIGHT/20) * 20);
	}

	/*
	 * Draw Methods
	 * 
	 * These methods are used to draw the snake and its food
	 */

	@Override
	public void draw() {
		background(image);
		move();
		drawFood();
		drawSnake();
		checkBoundaries();
		eat();
		
	}

	void drawFood() {
		// Draw the food
		fill(r.nextInt(255), r.nextInt(255), r.nextInt(255));
		rect(foodX, foodY, 20, 20);

	}

	void drawSnake() {
		// Draw the head of the snake followed by its tail
		fill(29, 100, 200);
		fill(r.nextInt(255), r.nextInt(255), r.nextInt(255));
		rect(head.x, head.y, 20, 20);
		text("not for people with epilepsy", 10, 20);
		manageTail();
	}

	void drawTail() {
for(int i = 0; i<tail.size(); i++) {
	fill(r.nextInt(255), r.nextInt(255), r.nextInt(255));
	rect(tail.get(i).x, tail.get(i).y, 20, 20);
	
}
	}

	/*
	 * Tail Management methods
	 * 
	 * These methods make sure the tail is the correct length.
	 */

	void manageTail() {
		// After drawing the tail, add a new segment at the "start" of the tail and
		// remove the one at the "end"
		// This produces the illusion of the snake tail moving.
checkTailCollision();
drawTail();
tail.add(new Segment(head.x, head.y));
tail.remove(0);
	}

	void checkTailCollision() {
		// If the snake crosses its own tail, shrink the tail back to one segment
for(int i = 1; i<tail.size(); i++) {
	if(head.x == tail.get(i).x && head.y == tail.get(i).y) {
		tail = new ArrayList<Segment>();
		score = 0;
		tail.add(new Segment(head.x, head.y));
		}

}
		
	}

	/*
	 * Control methods
	 * 
	 * These methods are used to change what is happening to the snake
	 */

	@Override
	public void keyPressed() {
		// Set the direction of the snake according to the arrow keys pressed
		if (keyCode == 38) {
			direction = UP;
		}
		if (keyCode == 39) {
			direction = RIGHT;
		}
		if (keyCode == 37) {
			direction = LEFT;
		}
		if (keyCode == 40) {
			direction = DOWN;
		}
	}

	void move() {
		// Change the location of the Snake head based on the direction it is moving.

		if (direction == UP) {
			head.y -= 20;

		} else if (direction == DOWN) {
			// Move head down

			head.y += 20;
		} else if (direction == LEFT) {

			head.x -= 20;
		} else if (direction == RIGHT) {
			head.x += 20;
		}
	}

	void checkBoundaries() {
		// If the snake leaves the frame, make it reappear on the other side
		if (head.x > 780) {
			head.x = 0;
		}
		if (head.x < 0) {
			head.x = 780;
		}
		if (head.y > 780) {
			head.y = 0;
		}
		if (head.y < 0) {
			head.y = 780;
		}
	}

	void eat() {
		// When the snake eats the food, its tail should grow and more
		// food appear
		if (head.x == foodX && head.y == foodY) {
			score++;
			foodX = ((int) random(WIDTH/20) * 20);
			foodY = ((int) random(HEIGHT/20) * 20);
			tail.add(new Segment(head.x, head.y));

		}

	}

	static public void main(String[] passedArgs) {
		PApplet.main(LeagueSnake.class.getName());
	}
}
