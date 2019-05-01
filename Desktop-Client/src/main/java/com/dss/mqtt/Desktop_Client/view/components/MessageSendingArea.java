package com.dss.mqtt.Desktop_Client.view.components;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.Inet4Address;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.dss.mqtt.Desktop_Client.constants.ViewBorders;
import com.dss.mqtt.Desktop_Client.constants.ViewColors;
import com.dss.mqtt.Desktop_Client.constants.ViewDimensions;
import com.dss.mqtt.EventMaster.EventMaster;
import com.dss.mqtt.EventMaster.implementation.EventMasterImpl;

/**
 * @author dss-02
 */
public class MessageSendingArea extends JPanel 
			implements ViewBorders, ViewDimensions, ViewColors, ActionListener{
	
	private JTextField textfield = null;
	private JButton sendBtn = null;
	
	EventMaster eventMaster = EventMasterImpl.getInstance();
	
	public MessageSendingArea() {
		// TODO Auto-generated constructor stub
		createUI();
	}
	
	private void createUI() {
		this.setSize(msgSendingAreaDim);
		this.setPreferredSize(msgSendingAreaDim);
		this.setMinimumSize(msgDisplayAreaDim);
		
		this.setBackground(textTypeBg);
		this.setBorder(textDisplayBorder);
		
		this.setLayout(new BorderLayout(3, 3));
		JPanel container = new JPanel(new FlowLayout(FlowLayout.CENTER));

		textfield = new JTextField(10);
		sendBtn = new JButton("Send");
		sendBtn.addActionListener(this);
		
		container.add(textfield);
		container.add(sendBtn);
		this.add(container);
		
	}
	
	/**
	 * action handler
	 */
	public void actionPerformed(ActionEvent e) {
		try {
			Inet4Address address = (Inet4Address) Inet4Address.getLocalHost();
			eventMaster.sendMessage(address.getHostName() + " : " +textfield.getText());
			textfield.setText("");
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
}
