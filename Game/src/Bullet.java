import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;

public class Bullet extends GameObject {
	
	private Handler handler;
	private BufferedImage bullet_image;

	public Bullet(int x, int y, ID id, Handler handler, int mx, int my, SpriteSheet  ss) {
		super(x, y, id, ss);
		this.handler = handler;
		
		velX = (mx - x) /15;
		velY = (my - y) /15;
		
		bullet_image = ss.grabImage(5, 2, 16, 16);
		
	}

	public void tick() {
		x += velX;
		y += velY;
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Block)
				if(getBounds().intersects(tempObject.getBounds())) {
					handler.removeObject(this);
				}
		}
	
	}

	public void render(Graphics g) {
		g.drawImage(bullet_image, x, y, null);
	
		
	}

	public Rectangle getBounds() {
		
		return new Rectangle(x, y, 16, 16);
	}
	

}
