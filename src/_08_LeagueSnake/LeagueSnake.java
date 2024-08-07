package _08_LeagueSnake;

import java.util.Random;

import processing.core.PApplet;

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
    int direction = UP;
    Random r = new Random();

    
    /*
     * Setup methods
     * 
     * These methods are called at the start of the game.
     */
    @Override
    public void settings() {
       size(500, 500);
    }

    @Override
    public void setup() {
        head = new Segment(240, 260);
        frameRate(20);
        dropFood();
    }

    void dropFood() {
        // Set the food in a new random location
        foodX = ((int)random(50)*10);
        foodY = ((int)random(50)*10);
    }

    /*
     * Draw Methods
     * 
     * These methods are used to draw the snake and its food
     */

    @Override
    public void draw() {
        background(0);
        move();
        drawFood();
        drawSnake();
    }

    void drawFood() {
        // Draw the food
    	fill(r.nextInt(255), r.nextInt(255), r.nextInt(255));
    	rect(foodX, foodY, 10, 10);
        
    }

    void drawSnake() {
        // Draw the head of the snake followed by its tail
    	fill(29, 100, 200);
    	rect(head.x, head.y, 10, 10);
    	fill(255, 255, 255, 120);
    	text("not for people with epilepsy", 10, 20);
    }

    void drawTail() {
        // Draw each segment of the tail
        
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

    }

    void checkTailCollision() {
        // If the snake crosses its own tail, shrink the tail back to one segment
        
    }

    /*
     * Control methods
     * 
     * These methods are used to change what is happening to the snake
     */

    @Override
    public void keyPressed() {
        // Set the direction of the snake according to the arrow keys pressed
    	print(keyCode);
        
    }

    void move() {
        // Change the location of the Snake head based on the direction it is moving.

       
        if (direction == UP) {
            head.y -= 10;
          
        } else if (direction == DOWN) {
            // Move head down
        	direction = DOWN;
        	head.y += 10;
        } else if (direction == LEFT) {
        	
        	head.x -= 10;
        } else if (direction == RIGHT) {
        	head.x += 10;
        }
    }

    void checkBoundaries() {
        // If the snake leaves the frame, make it reappear on the other side
        
    }

    void eat() {
        // When the snake eats the food, its tail should grow and more
        // food appear
        
    }

    static public void main(String[] passedArgs) {
        PApplet.main(LeagueSnake.class.getName());
    }
}
