package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import engine.Game;
import entity.Direction;
import gameMap.Block;
import gameMap.BlockType;
import gui.Resources.textures;

public class MainScreenDrawer extends GameDrawer {
	private static final int ANIMATION_SPEED = 20;
	private static final long serialVersionUID = -8051528011999726915L;
	private int animationDelay = 0;
	private int frame = 0;
	private Resources res = new Resources();
	
	public MainScreenDrawer(Game game, Dimension screenSize) {
		super(game,screenSize);
		res.load();
		HUD(game,screenSize);
	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		drawMap(g);
		drawPg(g);
		drawHUD(g);
	}

	private void drawHUD(Graphics g) {
		
		
	}

	private void HUD(Game g,Dimension screenSize) {
		final int iconHeight=(int) (screenSize.height*0.0001);
		final int iconWidth=(int) (screenSize.width*0.0001);
		
		/*Panel Money*/
		
		/* da modificare, creare HUDpanel*/
		
		JPanel moneyPanel=new JPanel() {

			  private Image img;

			  protected void paintComponent(Graphics g) {
			    setOpaque(false);
			    g.drawImage(Resources.getAtIndx(textures.FARMLAND.getIndx() ),0,0, null);
			    super.paintComponent(g);
			  }
			  
			};
		moneyPanel.setBounds(0, 0, iconWidth, iconHeight);
		JLabel moneyLabel=new JLabel();

		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(Resources.getAtIndx(textures.MONEY.getIndx())).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		moneyLabel.setIcon(imageIcon);
		moneyLabel.setText("50000");
		moneyLabel.setFont(new Font("Serif", Font.BOLD, 20));
		
		//moneyIcon.setIcon(new ImageIcon(Resources.getAtIndx(textures.MONEY.getIndx())));
		//moneyIcon.setSize(10,10);
		//moneyPanel.setBackground(Color.YELLOW);
		 
		moneyPanel.add(moneyLabel);
		moneyPanel.setOpaque(false);
		/*fine panel money*/
		
		/*Panel Time*/
		JPanel timePanel=new JPanel();
		/*Fine panel time*/
		
		/*Panel info*/
		JPanel infoPanel=new JPanel();
		/*fine panel info*/
		
		add(moneyPanel);
		add(timePanel);
		add(infoPanel);
	}

	private void drawMap(Graphics g) {

		for(int i = 0; i < 30; i++) {
			for(int j = 0; j < 30; j++) {
				Block block = game.getMap().getBlock(i, j);
				if(block.getType() == BlockType.TERRAIN) {
					g.drawImage(Resources.getAtIndx(textures.GRASS.getIndx()), i * 50 ,j * 50, 50, 50, null);
				}else if( block.getType() == BlockType.FIELD){
					g.drawImage(Resources.getAtIndx(textures.FARMLAND.getIndx()), i * 50 ,j * 50, 50, 50, null);
				}else if(block.getType() == BlockType.OBSTACLE) {
					g.drawImage(Resources.getAtIndx(textures.WALL.getIndx()), i * 50 ,j * 50, 50, 50, null);
				}
			}
		}
	}

	private void drawPg(Graphics g) {
		
		animationDelay += 1;
		animationDelay %= ANIMATION_SPEED;
		frame =(int) animationDelay / (ANIMATION_SPEED / 2);

		Direction dir = game.getPlayer().getDirection();
		
		
		if(dir.isRight()) {
			g.drawImage(Resources.getAtIndx(textures.PLAYER_RIGHT.getIndx() + frame), game.getPlayer().getPosX(),game.getPlayer().getPosY(), 40, 70, null);
		}else if(dir.isLeft()) {
			g.drawImage(Resources.getAtIndx(textures.PLAYER_LEFT.getIndx() + frame), game.getPlayer().getPosX(),game.getPlayer().getPosY(), 40, 70, null);
		}else if(dir.isDown()) {
			g.drawImage(Resources.getAtIndx(textures.PLAYER_DOWN.getIndx() + frame), game.getPlayer().getPosX(),game.getPlayer().getPosY(), 40, 70, null);
		}else if(dir.isUp()) {
			g.drawImage(Resources.getAtIndx(textures.PLAYER_UP.getIndx() + frame), game.getPlayer().getPosX(),game.getPlayer().getPosY(), 40, 70, null);
		}else {
			g.drawImage(Resources.getAtIndx(textures.PLAYER.getIndx()), game.getPlayer().getPosX(),game.getPlayer().getPosY(), 40, 70, null);
		}

	}
}