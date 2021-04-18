package gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

import entity.Direction;
import gameMap.BlockType;
import item.FoodType;
import item.Texturable;
import item.SeedType;
import entity.AnimalType;

public class Resources {
	private static final String RES_FOLDER = "res";

	private static Map<Texturable, BufferedImage> textures = new HashMap<>();
	private static File mainTheme;
	private static int animationDelay = 0;
	private static final int ANIMATION_SPEED = 500;

	public void load() {
		try {
			//seed
			textures.put(SeedType.CARROT_SEED, ImageIO.read(getClass().getResourceAsStream("/carrot2.png")));
			textures.put(SeedType.WHEAT_SEED, ImageIO.read(getClass().getResourceAsStream("/weat.png")));
			textures.put(SeedType.POTATO_SEED, ImageIO.read(getClass().getResourceAsStream("/potato2.png")));
			textures.put(SeedType.TOMATO_SEED, ImageIO.read(getClass().getResourceAsStream("/tomato2.png")));
			textures.put(SeedType.ORANGE_SEED, ImageIO.read(getClass().getResourceAsStream("/orange.png")));
			textures.put(SeedType.CHERRY_SEED, ImageIO.read(getClass().getResourceAsStream("/cherry.png")));
			textures.put(SeedType.APPLE_SEED, ImageIO.read(getClass().getResourceAsStream("/apple.png")));
			
			//food

			textures.put(FoodType.PORK_MEAT, ImageIO.read(getClass().getResourceAsStream("/carrot.png")));
			textures.put(FoodType.EGG, ImageIO.read(getClass().getResourceAsStream("/carrot.png")));
			textures.put(FoodType.MILK, ImageIO.read(getClass().getResourceAsStream("/carrot.png")));
			textures.put(FoodType.CARROT, ImageIO.read(getClass().getResourceAsStream("/carrot2.png")));
			textures.put(FoodType.POTATO, ImageIO.read(getClass().getResourceAsStream("/potato2.png")));
			textures.put(FoodType.TOMATO, ImageIO.read(getClass().getResourceAsStream("/tomato2.png")));
			textures.put(FoodType.APPLE, ImageIO.read(getClass().getResourceAsStream("/appletree.png")));
			textures.put(FoodType.ORANGE, ImageIO.read(getClass().getResourceAsStream("/orangetree.png")));
			textures.put(FoodType.CHERRY, ImageIO.read(getClass().getResourceAsStream("/cherrytree.png")));
			textures.put(FoodType.WHEAT, ImageIO.read(getClass().getResourceAsStream("/weat.png")));

			//block
			textures.put(BlockType.TERRAIN, ImageIO.read(getClass().getResourceAsStream("/grass.png")));
			textures.put(BlockType.FIELD, ImageIO.read(getClass().getResourceAsStream("/farmland.png")));
			textures.put(BlockType.WALL, ImageIO.read(getClass().getResourceAsStream("/wall.png")));
			textures.put(BlockType.LOCKED, ImageIO.read(getClass().getResourceAsStream("/lock3.png")));
			textures.put(BlockType.WATER, ImageIO.read(getClass().getResourceAsStream("/water.png")));
			textures.put(BlockType.STALL, ImageIO.read(getClass().getResourceAsStream("/stall.png")));
			
			textures.put(texture.LOCK, ImageIO.read(getClass().getResourceAsStream("/lucchetto.png")));
			textures.put(texture.TREE, ImageIO.read(getClass().getResourceAsStream("/tree.png")));
			//textures.put(texture.LABELHUD, ImageIO.read(getClass().getResourceAsStream("/labelHUD.png")));

			textures.put(texture.MONEY, ImageIO.read(getClass().getResourceAsStream("/moneyIcon.png")));
			textures.put(texture.SEED, ImageIO.read(getClass().getResourceAsStream("/pianta.png")));
			textures.put(texture.TIME, ImageIO.read(getClass().getResourceAsStream("/timeIcon.png")));
			textures.put(texture.INFO, ImageIO.read(getClass().getResourceAsStream("/infoIcon.png")));
			textures.put(texture.EMPTY, ImageIO.read(getClass().getResourceAsStream("/empty.png")));

			
			//player
			textures.put(texture.PLAYER_RIGHT, ImageIO.read(getClass().getResourceAsStream("/right0.png")));
			textures.put(texture.PLAYER_RIGHT2, ImageIO.read(getClass().getResourceAsStream("/right1.png")));
			textures.put(texture.PLAYER_LEFT, ImageIO.read(getClass().getResourceAsStream("/left0.png")));
			textures.put(texture.PLAYER_LEFT2, ImageIO.read(getClass().getResourceAsStream("/left1.png")));
			textures.put(texture.PLAYER_DOWN, ImageIO.read(getClass().getResourceAsStream("/down0.png")));
			textures.put(texture.PLAYER_DOWN2, ImageIO.read(getClass().getResourceAsStream("/down1.png")));
			textures.put(texture.PLAYER_UP, ImageIO.read(getClass().getResourceAsStream("/up0.png")));
			textures.put(texture.PLAYER_UP2, ImageIO.read(getClass().getResourceAsStream("/up1.png")));
			textures.put(texture.PLAYER, ImageIO.read(getClass().getResourceAsStream("/stop.png")));


			//animals
			textures.put(AnimalType.COW, ImageIO.read(getClass().getResourceAsStream("/cow.png")));

			
			//keyboard commands
			textures.put(texture.WASD, ImageIO.read(getClass().getResourceAsStream("/wasd.png")));
			textures.put(texture.E_KEY, ImageIO.read(getClass().getResourceAsStream("/e.png")));
			textures.put(texture.F_KEY, ImageIO.read(getClass().getResourceAsStream("/f.png")));
			textures.put(texture.MOUSE_WHEEL, ImageIO.read(getClass().getResourceAsStream("/mouse.png")));

			
			mainTheme = new File(RES_FOLDER + File.separator + "hd.wav");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static BufferedImage getPlayerInDirection(Direction dir) {
		animationDelay++;
		animationDelay %= ANIMATION_SPEED;
		boolean isFirstFrame = animationDelay > (ANIMATION_SPEED / 2);

		if (dir.isRight()) {
			if (isFirstFrame) {
				return textures.get(texture.PLAYER_RIGHT);
			} else {
				return textures.get(texture.PLAYER_RIGHT2);
			}
		} else if (dir.isLeft()) {
			if (isFirstFrame) {
				return textures.get(texture.PLAYER_LEFT);
			} else {
				return textures.get(texture.PLAYER_LEFT2);
			}
		} else if (dir.isDown()) {
			if (isFirstFrame) {
				return textures.get(texture.PLAYER_DOWN);
			} else {
				return textures.get(texture.PLAYER_DOWN2);
			}
		} else if (dir.isUp()) {
			if (isFirstFrame) {
				return textures.get(texture.PLAYER_UP);
			} else {
				return textures.get(texture.PLAYER_UP2);
			}
		} else {
			return textures.get(texture.PLAYER);
		}
	}

	public static BufferedImage getTextures(Texturable item) {
		return Resources.textures.get(item);
	}


	public static enum texture implements Texturable {
		PLAYER, PLAYER_LEFT, PLAYER_LEFT2, PLAYER_RIGHT, PLAYER_RIGHT2, PLAYER_UP, PLAYER_UP2, PLAYER_DOWN,
		PLAYER_DOWN2,
		
		WASD, E_KEY,F_KEY, MOUSE_WHEEL,

		LABELHUD, MONEY, SEED, TIME, INFO, EMPTY, LOCK, TREE;

	}

	public static File getMainTheme() {
		return mainTheme;
	}
}
