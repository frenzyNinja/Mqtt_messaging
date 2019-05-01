package com.dss.mqtt.Desktop_Client;

import com.dss.mqtt.Desktop_Client.view.AppView;
import com.dss.mqtt.EventMaster.EventMaster;
import com.dss.mqtt.EventMaster.implementation.EventMasterImpl;

/**
 * Hello world!
 *
 */
public class App 
{
	private AppView mainUI = null;
	
	public App() {
		// TODO Auto-generated constructor stub
		mainUI = new AppView();
		mainUI.setVisible(true);
	}
	
    public static void main( String[] args ) {
    	App application = new App();
    }
}
