package com.dss.mqtt.CommonData.constants;

/**
 * This represents MQTT connection options
 * @author dss-02
 */
public interface ConnectionParams {
	int KEEP_ALIVE = 10;
	int CONNECTION_TIMEOUT = 10;
	
	boolean CLEAN_SESSION = true;
	boolean AUTO_RECONNECT = true;
	
}
