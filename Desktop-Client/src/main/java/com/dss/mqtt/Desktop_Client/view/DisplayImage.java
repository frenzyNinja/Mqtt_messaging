package com.dss.mqtt.Desktop_Client.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import com.dss.mqtt.Desktop_Client.constants.ViewDimensions;
/**
 * For testing to check if images can be sent over MQTT
 * @author dss-02
 *
 */
public class DisplayImage extends JPanel implements ViewDimensions{
	BufferedImage img = null;
	
	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		if(img != null) {
			g.drawImage(img, 0, 0, frameDimension.width, frameDimension.height, null);
		}
	}
	
	/**
	 * set Image
	 * @param image
	 */
	public void setBufferedImage(BufferedImage image) {
		this.img = image;
		this.repaint();
	}
}
