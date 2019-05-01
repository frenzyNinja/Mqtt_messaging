package com.dss.mqtt.CommonData.interfaces;

import java.util.Observable;
import java.util.UUID;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

import com.dss.mqtt.CommonData.constants.ConnectionParams;
import com.dss.mqtt.CommonData.constants.MessageParams;
import com.dss.mqtt.CommonData.data.MessageActionListener;
import com.dss.mqtt.CommonData.data.MessagePersitence;

/**
 * Message Responder
 * @author dss-02
 */
public abstract class AbstractMessageResponder extends Observable
implements ConnectionParams, MessageParams, IMqttActionListener{

	protected MqttAsyncClient client = null;
	protected String uniqueId = UUID.randomUUID().toString();
	protected MqttConnectOptions connectOptions = null;
	protected IMqttToken connectToken = null;
	protected MessageActionListener msgActionListener = new MessageActionListener();

	/**
	 * Connect to broker
	 * @param serverURI
	 * @throws MqttException
	 */
	public void connect(String serverURI) throws MqttException {
		client = new MqttAsyncClient(serverURI, uniqueId, new MessagePersitence());

		//connection options
		connectOptions = new MqttConnectOptions();
		connectOptions.setAutomaticReconnect(AUTO_RECONNECT);
		connectOptions.setConnectionTimeout(CONNECTION_TIMEOUT);
		connectOptions.setCleanSession(CLEAN_SESSION);

		connectToken = client.connect(null, connectOptions, this);
	}

	/**
	 * disconnect the connection and close it.
	 * @throws MqttException
	 */
	public void closeConnection() throws MqttException {
		client.disconnect();
		client.close(true);
	}

	private void subscribe() {
		try {
			client.subscribe(MESSAGE_TOPIC, MESSAGE_QOS, msgActionListener);
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * on success listener
	 */
	public void onSuccess(IMqttToken asyncActionToken) {
		// TODO Auto-generated method stub
		if(asyncActionToken != null) {
			if(asyncActionToken.equals(connectToken)) {
				System.err.println("Connected to Broker - "
						+ "\n Token Recieved - " + asyncActionToken.toString());
				subscribe();
			}
		}
	}

	/**
	 * on Failure handle
	 */
	public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
		// TODO Auto-generated method stub
		System.err.println("ERROR OCCURED - "
				+ " Token Recieved - " + asyncActionToken.toString()
				+ " Error Message - " + exception.getMessage());
	}

	/**
	 * is connected??
	 * @return
	 */
	public boolean isConnected() {
		return client.isConnected();
	}


}
