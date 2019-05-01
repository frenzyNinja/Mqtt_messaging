package com.dss.mqtt.MessageTransmitter;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

import com.dss.mqtt.CommonData.interfaces.AbstractMessageTransmitter;

public class MessageSender extends AbstractMessageTransmitter{
	
	public MessageSender() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void publishMessage(String payload) {
		// TODO Auto-generated method stub
		MqttMessage message = new MqttMessage();
		message.setQos(MESSAGE_QOS);
		message.setRetained(MESSAGE_RETAIN);
		message.setPayload(payload.getBytes());

//		try {
//			DataInputStream dis = new DataInputStream(
//					new BufferedInputStream(new FileInputStream("res/sample.jpg")));
//			byte[] data = dis.readAllBytes();
//			System.out.println("Data Size -" + data.length);
//			message.setPayload(data);
//			dis.close();
//		}catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		
		
		try {
			//while the client is not connected sleep for 200ms
			while(!client.isConnected()) { 
				try{
					Thread.currentThread().sleep(200);
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
			//client is connected now.. ready to send message
			client.publish(MESSAGE_TOPIC, message);
		} catch (MqttPersistenceException e) {
			e.printStackTrace();
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

}
