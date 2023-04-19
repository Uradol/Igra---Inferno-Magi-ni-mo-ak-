import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import java.awt.image.BufferedImage;

public class Enemy extends GameObject {

	private Handler handler;
	int hp = 100;
	int choose = 0;
	Random r = new Random();
	static int enemy = 21;
	
	private BufferedImage enemy_imageL;
	private BufferedImage enemy_imageR;
	
	public Enemy(int x, int y, ID id, Handler handler, SpriteSheet ss) {
		super(x, y, id, ss);
		this.handler = handler;
		
		enemy_imageL = ss.grabImage(3, 1, 32, 32);
		enemy_imageR = ss.grabImage(4, 1, 32, 32);
	}

	
	public void tick() {
		x += velX;
		y += velY;
		
		choose = r.nextInt(20);
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
				if(tempObject.getId() == ID.Block) {
					if(getBoundsBig().intersects(tempObject.getBounds())) {
						x += (velX)* -2;
						y += (velY)* -2;
						velX *= -1;
						velY *= -1;
						}
					else {
						if(choose == 0) {
							velX =(r.nextInt(4 - -4) - 4);
							velY =(r.nextInt(4 - -4) - 4);}
						}
					}
				
			if(tempObject.getId() == ID.Bullet) {
				if(getBounds().intersects(tempObject.getBounds())) {
					hp -=50;
					handler.removeObject(tempObject);
				}
				
			}
		
			
		}
		if(hp <= 0) {
			handler.removeObject(this);
			--enemy;
			if(Enemy.enemy == 0)
				new winScreen();
		}
		
	}
	
	public void render(Graphics g) {
		if(velX < 0 && velX != 0)
		g.drawImage(enemy_imageL, x, y, null);
		else
		g.drawImage(enemy_imageR, x, y, null);
	}


	public Rectangle getBounds() {
		
		return new Rectangle(x, y, 32, 32);
	}
	
public Rectangle getBoundsBig() {
		
		return new Rectangle(x-16, y-16, 64, 64);
	}

}
