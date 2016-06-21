package lorann.game;

import java.io.IOException;

import lorann.game.controller.LorannController;
import lorann.game.model.GameBoard;
import lorann.game.model.IGameBoard;
import lorann.game.view.LorannFrame;
/**
 * This class will instantiate the game components. 
 * And will handle the refreshing rate of the game with the if Condition inside the While loop.
 * condition, meaning the whole game updates each 150 milliseconds. ( Can be modified but this value seems more appropriate
 * to match the original game speed. )
 * @author Deqth
 * 
 */
public class Lorann{
	public static long lastTime;
	IGameBoard gameBoard;
	LorannFrame frame;
	
	public Lorann() throws IOException{
	IGameBoard gameBoard = new GameBoard("lvl2");
	LorannFrame frame = new LorannFrame(gameBoard);
	LorannController controller = new LorannController(gameBoard, frame);
	frame.setController(controller);
	
	while (true){
	if(System.currentTimeMillis()-lastTime>=150){
	controller.updateModel();
	controller.colideModel();
	lastTime = System.currentTimeMillis();
	}
	}

}
}
