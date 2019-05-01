package com.dss.mqtt.CommonData.data;

import java.util.Observable;
import java.util.Observer;

import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * Message Listener
 * @author dss-02
 */
public class MessageActionListener extends Observable implements IMqttMessageListener{
	
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		// TODO Auto-generated method stub
		int id = message.getId();
		byte[] msg = message.getPayload();
		int qos = message.getQos();
		
//		System.out.println("Got Message -"
//				+ "\n ID - " + id
//				+ "\n message - " + new String(msg)
//				+ "\n QualityOfService - " + qos);
		
		MessageData messageData = new MessageData();
		messageData.setId(id);
		messageData.setQos(qos);
		messageData.setMsg(msg);
		
		this.setChanged();
		this.notifyObservers(messageData);
	}
}
