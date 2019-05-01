package com.dss.mqtt.CommonData.constants;

/**
 * Message parameters
 * @author dss-02
 */
public interface MessageParams {
	boolean MESSAGE_RETAIN = true;
	// exactly once QoS
	int MESSAGE_QOS = 2;
	String MESSAGE_TOPIC = "testIMQTT/messaging";
}
