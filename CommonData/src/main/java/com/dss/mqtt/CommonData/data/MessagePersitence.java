package com.dss.mqtt.CommonData.data;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.paho.client.mqttv3.MqttClientPersistence;
import org.eclipse.paho.client.mqttv3.MqttPersistable;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

/**
 * @author dss-02
 */
public class MessagePersitence implements MqttClientPersistence{
	private Map<String, MqttPersistable> dataStore = null;
	
	public MessagePersitence() {
		// TODO Auto-generated constructor stub
		dataStore = new HashMap<String, MqttPersistable>();
	}
	
	public void open(String clientId, String serverURI) throws MqttPersistenceException {
		// TODO Auto-generated method stub
		System.out.println("MQTT - PERSISTENCE Connection opened");
	}

	public void close() throws MqttPersistenceException {
		// TODO Auto-generated method stub
		System.out.println("MQTT - PERSISTENCE Connection closed");
	}

	public void put(String key, MqttPersistable persistable) throws MqttPersistenceException {
		// TODO Auto-generated method stub
		dataStore.put(key, persistable);
	}

	public MqttPersistable get(String key) throws MqttPersistenceException {
		// TODO Auto-generated method stub
		return dataStore.get(key);
	}

	public void remove(String key) throws MqttPersistenceException {
		// TODO Auto-generated method stub
		dataStore.remove(key);
	}

	public Enumeration keys() throws MqttPersistenceException {
		// TODO Auto-generated method stub
		Enumeration<String> keyEnum = Collections.enumeration(dataStore.keySet());
		return keyEnum;
	}

	public void clear() throws MqttPersistenceException {
		// TODO Clear all the data from the datastore along with the folders and temporary files generated
		
	}

	public boolean containsKey(String key) throws MqttPersistenceException {
		// TODO Auto-generated method stub
		return dataStore.containsKey(key);
	}

}
