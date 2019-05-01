package com.dss.mqtt.MessageResponder;

import java.util.Observable;
import java.util.Observer;

import com.dss.mqtt.CommonData.interfaces.AbstractMessageResponder;
/**
 * this message Reciever class acts a wrapper and 
 * in super implementation it creates a mqtt client and connects to 
 * the broker, upon success it subscribes
 * @author dss-02
 *
 */
public class MessageRecieverImpl extends AbstractMessageResponder implements Observer {

	public MessageRecieverImpl() {
		// TODO Auto-generated constructor stub
		msgActionListener.addObserver(this);
	}
	
	public void update(Observable sender, Object data) {
		this.setChanged();
		this.notifyObservers(data);
	}
	
	
}
