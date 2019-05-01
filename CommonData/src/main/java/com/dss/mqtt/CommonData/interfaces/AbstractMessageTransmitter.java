package com.dss.mqtt.CommonData.interfaces;

import java.util.Observable;
import java.util.Observer;
import java.util.UUID;

import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

import com.dss.mqtt.CommonData.constants.ConnectionParams;
import com.dss.mqtt.CommonData.constants.MessageParams;
import com.dss.mqtt.CommonData.data.MessagePersitence;

/**
 * Message Transmitter
 * @author dss-02
 */
public abstract class AbstractMessageTransmitter  implements ConnectionParams, MessageParams {
	protected MqttAsyncClient client = null;
	protected String uniqueId = UUID.randomUUID().toString();
	protected MqttConnectOptions connectOptions = null;

	/**
	 * Connect to broker
	 * @param serverURI
	 * @throws MqttException
	 */
	public void connect(String serverURI) throws MqttException {
		client = new MqttAsyncClient(serverURI, uniqueId, new MessagePersitence());

		connectOptions = new MqttConnectOptions();
		connectOptions.setAutomaticReconnect(AUTO_RECONNECT);
		connectOptions.setConnectionTimeout(CONNECTION_TIMEOUT);
		connectOptions.setCleanSession(CLEAN_SESSION);

		client.connect(connectOptions);
	}

	/**
	 * publish message to broker
	 * @param payload
	 */
	public abstract void publishMessage(String payload); 

	/**
	 * disconnect the connection and close it.
	 * @throws MqttException
	 */
	public void closeConnection() throws MqttException {
		client.disconnect();
		client.close(true);
	}

	public boolean isConnected() {
		return client.isConnected();
	}
}
