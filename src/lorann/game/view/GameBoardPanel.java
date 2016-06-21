package lorann.game.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import lorann.game.model.IGameBoard;
import lorann.game.model.element.motion.Mobile;
/**
 * this is the JPanel that we will use to represent the gameBoard in our JFrame
 * @author Game
 *
 */
public class GameBoardPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	IGameBoard gameBoard;
	
	
	/**
	 *  
	 * @param GB Actual gameBoard used to create a JPanel of an appropriate dimension by doing
	 * nbCols*cellSize, nbLine*cellsize ( cellsize is the actual height and width of the cells on screen 32pixels) 
	 */
	GameBoardPanel(IGameBoard GB){
		super();
		gameBoard = GB;
		setPreferredSize(new Dimension(gameBoard.getNbCol()*IGameBoard.cellSize, gameBoard.getNbLine()*IGameBoard.cellSize));
	}
	
	
	/**
	 * This override paint will use a double for loop in order to navigate trough the entire Element[][] of the GameBoard class
	 * while constantly making new Buffered images of size 32*32
	 * then drawing the image of each element inside them.
	 * and then positionning it in the Panel at a distance of cellsize * nbCols for the lenght ( left to right )
	 * and cellsize*nbline for the height ( up to down )
	 * 
	 * 
	 * Once it's done a for each mobile in mobileList of the Gameboard is called. and for each One, draws according to the say
	 * approach used in the double for loop used just above
	 * 
	 */
	  public void paint(Graphics g)
      {		  
		  for(int i=0 ; i<gameBoard.getNbCol() ; i++){
			  for(int j=0 ; j<gameBoard.getNbLine() ; j++){
				  if (gameBoard.getElement(i,j)!=null){
					  BufferedImage buffImage = new BufferedImage(IGameBoard.cellSize, IGameBoard.cellSize, BufferedImage.TYPE_INT_ARGB);
					  Graphics imageGraph = buffImage.getGraphics();
					  imageGraph.drawImage(gameBoard.getElement(i,j).getImage(), 0, 0, IGameBoard.cellSize, IGameBoard.cellSize, null);
					  g.drawImage(buffImage, i*IGameBoard.cellSize, j*IGameBoard.cellSize, null);
				  }
			  }
		  }
		  
			for(Mobile mobile : gameBoard.getMobileList()){
				BufferedImage buffImage = new BufferedImage(IGameBoard.cellSize, IGameBoard.cellSize, BufferedImage.TYPE_INT_ARGB);
				Graphics imageGraph = buffImage.getGraphics();
				imageGraph.drawImage(mobile.getImage(), 0, 0, IGameBoard.cellSize, IGameBoard.cellSize, null);
				g.drawImage(buffImage, mobile.getX()*IGameBoard.cellSize, mobile.getY()*IGameBoard.cellSize, null);
			}
		  
      }
}
