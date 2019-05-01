package com.dss.mqtt.Desktop_Client.view.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.dss.mqtt.Desktop_Client.constants.ViewBorders;
import com.dss.mqtt.Desktop_Client.constants.ViewColors;
import com.dss.mqtt.Desktop_Client.constants.ViewDimensions;
/**
 * @author dss-02
 */
public class TextDisplay extends JPanel 
		implements ViewBorders, ViewDimensions, ViewColors{
	
	private JTextArea displayArea = null;
	
	public TextDisplay() {
		// TODO Auto-generated constructor stub
		createUI();
	}
	
	private void createUI() {
		this.setSize(msgDisplayAreaDim);
		this.setPreferredSize(msgDisplayAreaDim);
		this.setMinimumSize(msgDisplayAreaDim);
		
		//display properties
		this.setBorder(textDisplayBorder);
		this.setBackground(textDisplayBg);

		//layout properties
		this.setLayout(new BorderLayout(3, 3));
		
		//component init
		displayArea = new JTextArea();
		displayArea.setEditable(false);
		displayArea.setForeground(Color.RED);
		displayArea.setAutoscrolls(true);
		
		//adding to panel
		this.add(displayArea, BorderLayout.CENTER);
	}
	
	/**
	 * set Text to display
	 * @param message
	 */
	public void setText(String message) {
		this.displayArea.append(" \n" + message);
	}
}
