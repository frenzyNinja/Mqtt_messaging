package com.dss.mqtt.Desktop_Client.view;

import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class LookAndFeelUtil {
	
	public static void setLookAndFeel(String laf) {
		UIManager manager = new UIManager();
		LookAndFeelInfo[] lafs = manager.getInstalledLookAndFeels();
		
		for(LookAndFeelInfo info : lafs) {
			if(info.getName().equals(laf)) {
				try {
					UIManager.setLookAndFeel(info.getClassName());
				
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
