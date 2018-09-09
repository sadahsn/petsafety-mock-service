package com.daimler.hack.petsafety.request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PushNotificationRequestNotNoop {

	private String notificationMessage;

	private List<String> deviceTokens;

	private Map<String, String> customFields = new HashMap<>();

	public String getNotificationMessage() {
		return notificationMessage;
	}

	public void setNotificationMessage(String notificationMessage) {
		this.notificationMessage = notificationMessage;
	}

	public List<String> getDeviceTokens() {
		return deviceTokens;
	}

	public void setDeviceTokens(List<String> deviceTokens) {
		this.deviceTokens = deviceTokens;
	}

	public Map<String, String> getCustomFields() {
		return customFields;
	}

	public void setCustomFields(Map<String, String> customFields) {
		this.customFields = customFields;
	}

}
