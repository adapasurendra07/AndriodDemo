package com.applause.auto.pageframework.views;

import java.lang.invoke.MethodHandles;

import com.applause.auto.framework.pageframework.device.AbstractDeviceView;
import com.applause.auto.framework.pageframework.device.DeviceViewFactory;
import com.applause.auto.framework.pageframework.device.MobileElementLocator;
import com.applause.auto.framework.pageframework.device.factory.AndroidImplementation;
import com.applause.auto.framework.pageframework.device.factory.IosImplementation;
import com.applause.auto.framework.pageframework.devicecontrols.Button;
import com.applause.auto.framework.pageframework.devicecontrols.TextBox;
import com.applause.auto.framework.pageframework.util.logger.LogController;

@AndroidImplementation(LoginView.class)
@IosImplementation(LoginView.class)
public class LoginView extends AbstractDeviceView {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		syncHelper.waitForElementToAppear(getLocator(this, "getUsernameTextBox"));
	}

	
	public void enterUsername(String username) {
		LOGGER.info(String.format("Entering username %s", username));
		getUsernameTextBox().enterText(username);
	}

	public void enterPassword(String password) {
		LOGGER.info(String.format("Entering password %s", password));
		getPasswordTextBox().enterText(password);
	}

	
	@MobileElementLocator(android = "//android.widget.Button[@content-desc='LOGIN ']", iOS = "//XCUIElementTypeButton[@name='Login']")
	protected Button getLoginButton() {
		return new Button(getLocator(this, "getLoginButton"));
	}

	@MobileElementLocator(android = "//android.widget.EditText[@text='Username']", iOS = "Username")
	protected TextBox getUsernameTextBox() {
		return new TextBox(getLocator(this, "getUsernameTextBox"));
	}

	@MobileElementLocator(android = "//android.widget.EditText[@text='Password']", iOS = "//XCUIElementTypeSecureTextField[@name='Password']")
	protected TextBox getPasswordTextBox() {
		return new TextBox(getLocator(this, "getPasswordTextBox"));
	}


	public AgendaListView clickLogin() {
		// TODO Auto-generated method stub
		return null;
	}
}
