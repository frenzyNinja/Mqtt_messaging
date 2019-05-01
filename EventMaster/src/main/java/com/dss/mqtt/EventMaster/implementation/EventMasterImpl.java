package com.dss.mqtt.EventMaster.implementation;

import java.util.Observable;
import java.util.concurrent.Flow.Publisher;

import org.eclipse.paho.client.mqttv3.MqttException;

import com.dss.mqtt.EventMaster.EventMaster;
import com.dss.mqtt.MessageResponder.MessageRecieverImpl;
import com.dss.mqtt.MessageTransmitter.MessageSender;

public class EventMasterImpl extends Observable implements EventMaster {
	public static final String SERVER_URI = "tcp://test.mosquitto.org:1883";
	private Thread instantiatorThread = null;

	private MessageSender sender;
	private MessageRecieverImpl reciever;

	private static EventMasterImpl uniqueInstance = null;
	public static EventMasterImpl  getInstance() {
		if(uniqueInstance == null) {
			synchronized (EventMasterImpl.class) {
				uniqueInstance = new EventMasterImpl();
			}
		}
		return uniqueInstance;
	}
	private EventMasterImpl() {
		sender = new MessageSender();
		reciever = new MessageRecieverImpl();
		reciever.addObserver(this);

		//trying to connect to server for reciever

		this.instantiatorThread = new Thread(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				try {
					reciever.connect(SERVER_URI);
					sender.connect(SERVER_URI);
				} catch (MqttException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	
		try {
			this.instantiatorThread.start();
			this.instantiatorThread.join();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void update(Observable sender, Object data) {
		// TODO Auto-generated method stub
		this.setChanged();
		this.notifyObservers(data);
	}

	/**
	 * sends the message
	 */
	public void sendMessage(String message) {
		sender.publishMessage(message);
	}
	
	/**
	 * shutdown the eventmaster
	 */
	public void shutdown() {
		// TODO Auto-generated method stub
		if(sender != null) {
			try {
				sender.closeConnection();
			} catch (MqttException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(reciever != null) {
			try {
				reciever.closeConnection();
			} catch (MqttException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


}
