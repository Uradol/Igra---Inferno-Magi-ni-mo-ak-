import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;

public class Wizard extends GameObject  {
	
	Handler handler;
	Game game;
	
	private BufferedImage wizard_imageL;
	private BufferedImage wizard_imageR;

	public Wizard(int x, int y, ID id, Handler handler, Game game, SpriteSheet ss) {
		super(x, y, id, ss);
		this.handler = handler;
		this.game = game;
		
		wizard_imageL = ss.grabImage(1, 1, 32, 48);
		wizard_imageR = ss.grabImage(2, 1, 32, 48);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		collision();
		
		death();
		
		if(handler.isUp()) velY = -5;
		else if(!handler.isDown()) velY = 0;
		
		if(handler.isDown()) velY = 5;
		else if(!handler.isUp()) velY = 0;
		
		if(handler.isLeft()) velX = -5;
		else if(!handler.isRight()) velX = 0;
		
		if(handler.isRight()) velX = 5;
		else if(!handler.isLeft()) velX = 0;
	}
	
	private void collision() {
		for(int i = 0; i < handler.object.size();i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.Block) {
				if(getBounds().intersects(tempObject.getBounds())) {
						x += velX*-1;
						y += velY*-1;
					
				}
			}
			
			if(tempObject.getId() == ID.Crate) {
				if(getBounds().intersects(tempObject.getBounds())) {
						game.ammo += 5;
						handler.removeObject(tempObject);	
				}
			}
			
			if(tempObject.getId() == ID.Enemy) {
				if(getBounds().intersects(tempObject.getBounds())) 
						game.hp --;
			}
			
		}
	}
	
	private void death() {
		if(game.hp <= 0)
			game.stop();		
	}

	public void render(Graphics g) {
		if(velX <= 0 )
			g.drawImage(wizard_imageL, x, y, null);
			else
			g.drawImage(wizard_imageR, x, y, null);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 48);
	}

}
