package com.dss.mqtt.CommonData.data;

/**
 * POJO data for message
 * @author dss-02
 */
public class MessageData {
	byte[] msg;
	int qos;
	int id;
	
	/**
	 * @return the msg
	 */
	public byte[] getMsg() {
		return msg;
	}
	
	/**
	 * @param msg the msg to set
	 */
	public void setMsg(byte[] msg) {
		this.msg = msg;
	}
	
	/**
	 * @return the qos
	 */
	public int getQos() {
		return qos;
	}
	
	/**
	 * @param qos the qos to set
	 */
	public void setQos(int qos) {
		this.qos = qos;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
