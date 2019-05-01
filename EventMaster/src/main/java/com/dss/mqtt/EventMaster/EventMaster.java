package com.dss.mqtt.EventMaster;

import java.util.Observer;

public interface EventMaster extends Observer{
	/**
	 * sends the message through client
	 * @param message
	 */
	public void sendMessage(String message);
	
	public void shutdown();
//	public String messageRecieved();
}
