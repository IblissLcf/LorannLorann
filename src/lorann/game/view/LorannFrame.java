package lorann.game.view;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import lorann.game.controller.LorannController;
import lorann.game.model.IGameBoard;

public class LorannFrame extends JFrame implements KeyListener {
	
	/**
	 * This class main purpose is to setup a JFrame which will contain the game's grid in a Panel form.
	 * The KeyListener is used as follow : each key pressed will set to true the boolean variable for the action related to that key.
	 * Each key released sets it to false.
	 * Doing so gives us a mean to handling multiples key pressed in the same time.
	 * 
	 * However @see LorannController is the one that times the actions as they aren't performed the moment the keys are pressed.
	 */
	
	private static final long serialVersionUID = 1L;
	private LorannController controller;
	public boolean pressedUp, pressedDown, pressedLeft, pressedRight, pressedSpace, pressedFire;
	
	
	/**
	 * Constructor, setting up a JFrame and the @see GameBoardPanel in the same time
	 * takes a @param IGameBoard as parameter in order to use it to instantiate a gameBoardPanel with the correct 
	 * dimensions, moreover the keyListener is attached here. 
	 */
	public LorannFrame(IGameBoard gameBoard){

		setResizable(false);
		setTitle("Lorann");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(Color.black);
		GameBoardPanel grille = new GameBoardPanel(gameBoard);
		add(grille);
		pack();
		this.addKeyListener(this);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		
		if(keycode == KeyEvent.VK_UP){
			pressedUp = true;
		} else if(keycode == KeyEvent.VK_DOWN){
			pressedDown = true;
		}
		if(keycode == KeyEvent.VK_LEFT){
			pressedLeft = true;
		} else if(keycode == KeyEvent.VK_RIGHT){
			pressedRight = true;
		}
		if (keycode == KeyEvent.VK_SPACE){
			pressedFire = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keycode = e.getKeyCode();
		
		if(keycode == KeyEvent.VK_UP){
			pressedUp = false;
		}		
		if(keycode == KeyEvent.VK_LEFT){
			pressedLeft = false;
		}
		if(keycode == KeyEvent.VK_RIGHT){
			pressedRight = false;
		}
		if(keycode == KeyEvent.VK_DOWN){
			pressedDown = false;
		}
		if (keycode == KeyEvent.VK_SPACE){
			pressedFire = false;
		}
		
	}

	public LorannController getController() {
		return controller;
	}

	public void setController(LorannController controller) {
		this.controller = controller;
	}

}
