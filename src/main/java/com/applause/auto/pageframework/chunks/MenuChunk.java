package com.applause.auto.pageframework.chunks;

import com.applause.auto.framework.pageframework.device.AbstractDeviceChunk;
import com.applause.auto.framework.pageframework.device.DeviceViewFactory;
import com.applause.auto.framework.pageframework.device.MobileElementLocator;
import com.applause.auto.framework.pageframework.device.factory.AndroidImplementation;
import com.applause.auto.framework.pageframework.device.factory.IosImplementation;
import com.applause.auto.framework.pageframework.devicecontrols.Button;
import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.pageframework.views.AccountView;
import com.applause.auto.pageframework.views.LoginView;

@AndroidImplementation(MenuChunk.class)
@IosImplementation(MenuChunk.class)
public class MenuChunk extends AbstractDeviceChunk {

	public MenuChunk(String selector) {
		super(selector);
	}

	protected final static LogController LOGGER = new LogController(MenuChunk.class);

	@Override
	protected void waitUntilVisible() {
		syncHelper.waitForElementToAppear(getLocator(this, "getShowTutorialButton"));
	}

	/*
	 * Public Actions
	 */
	public LoginView clickLoginButton() {
		LOGGER.info("Clicking login button from menu chunk");
		getLoginButton().pressButton();
		return DeviceViewFactory.create(LoginView.class);
	}

	public AccountView clickAccountButton() {
		LOGGER.info("Clicking account button from menu chunk");
		getAccountButton().pressButton();
		return DeviceViewFactory.create(AccountView.class);
	}

	

	@MobileElementLocator(android = "//android.widget.Button[@content-desc='log in Login ']", iOS = "//XCUIElementTypeButton[@name='log in Login']")
	protected Button getLoginButton() {
		return new Button(getLocator(this, "getLoginButton"));
	}

	@MobileElementLocator(android = "//android.widget.Button[@content-desc='person Account ']", iOS = "//XCUIElementTypeButton[@name='person Account']")
	protected Button getAccountButton() {
		return new Button(getLocator(this, "getAccountButton"));
	}

	
}
