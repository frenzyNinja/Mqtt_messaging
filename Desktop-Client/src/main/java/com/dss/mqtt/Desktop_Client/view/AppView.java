package com.dss.mqtt.Desktop_Client.view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.dss.mqtt.CommonData.data.MessageData;
import com.dss.mqtt.Desktop_Client.constants.ViewBorders;
import com.dss.mqtt.Desktop_Client.constants.ViewColors;
import com.dss.mqtt.Desktop_Client.constants.ViewDimensions;
import com.dss.mqtt.Desktop_Client.constants.ViewProperties;
import com.dss.mqtt.Desktop_Client.view.components.MessageSendingArea;
import com.dss.mqtt.Desktop_Client.view.components.TextDisplay;
import com.dss.mqtt.EventMaster.implementation.EventMasterImpl;
/**
 * @author dss-02
 */
public class AppView extends JFrame 
implements ViewDimensions, ViewColors, ViewBorders, ViewProperties, Observer , WindowListener{

	private MessageSendingArea msgSendArea = null;
	private TextDisplay display = null;

	public AppView() {
		EventMasterImpl.getInstance().addObserver(this);

		//create UI
		createUI();
		LookAndFeelUtil.setLookAndFeel("Nimbus");
	}

	private void createUI() {
		this.setTitle("MQTT client App");

		//size properties
		this.setSize(frameDimension.width, frameDimension.width);
		this.setMinimumSize(frameDimension);
		this.setPreferredSize(frameDimension);

		//color properties
		this.setBackground(frameBg);

		//actions
		this.setResizable(resizable);
		this.setDefaultCloseOperation(exitAction);
		this.addWindowListener(this);

		//message area
		msgSendArea = new MessageSendingArea();
		display  = new TextDisplay();
		
		//adding to panel
		this.setLayout(new BorderLayout(5, 5));
		this.add(display, BorderLayout.CENTER);
		this.add(msgSendArea, BorderLayout.SOUTH);
	}

	public void update(Observable sender, Object data) {
		// TODO Auto-generated method stub
		if(data instanceof MessageData) {
			MessageData msg = (MessageData) data;
			display.setText(new String(msg.getMsg()));
			
//			try {
//				FileOutputStream fos = new FileOutputStream("res/output.jpg");
//				fos.write(msg.getMsg());
//				fos.close();
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
		}
	}
	
	public void windowActivated(WindowEvent e) {}

	public void windowClosed(WindowEvent e) {}

	public void windowClosing(WindowEvent e) {
		EventMasterImpl.getInstance().shutdown();
		this.setVisible(false);
		this.dispose();
		
		try {
			Thread.currentThread().sleep(500);
		}catch (InterruptedException ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		System.exit(0);
	}

	public void windowDeactivated(WindowEvent e) {}

	public void windowDeiconified(WindowEvent e) {}

	public void windowIconified(WindowEvent e) {}

	public void windowOpened(WindowEvent e) {}
	
	

}
