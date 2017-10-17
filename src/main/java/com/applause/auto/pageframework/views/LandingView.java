package com.applause.auto.pageframework.views;

import java.lang.invoke.MethodHandles;

import com.applause.auto.framework.pageframework.device.AbstractDeviceView;
import com.applause.auto.framework.pageframework.device.DeviceViewFactory;
import com.applause.auto.framework.pageframework.device.MobileElementLocator;
import com.applause.auto.framework.pageframework.device.factory.AndroidImplementation;
import com.applause.auto.framework.pageframework.device.factory.IosImplementation;
import com.applause.auto.framework.pageframework.devicecontrols.Button;
import com.applause.auto.framework.pageframework.devicecontrols.Text;
import com.applause.auto.framework.pageframework.util.logger.LogController;

@AndroidImplementation(LandingView.class)
@IosImplementation(LandingView.class)
public class LandingView extends AbstractDeviceView {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		syncHelper.waitForElementToAppear(getLocator(this, "getViewSignature"));
	}

	/*
	 * Public Actions
	 */
	public AgendaListView clickSkipButton() {
		LOGGER.info("Clicking skip button");
		getSkipButton().pressButton();
		return DeviceViewFactory.create(AgendaListView.class);
	}

	/*
	 * Protected Getters
	 */

	@MobileElementLocator(android = "//android.view.View[@content-desc='Welcome to ICA']", iOS = "//XCUIElementTypeStaticText[@name='Welcome to ICA']")
	protected Text getViewSignature() {
		return new Text(getLocator(this, "getViewSignature"));
	}

	@MobileElementLocator(android = "//android.widget.Button[@content-desc='SKIP ']", iOS = "//XCUIElementTypeButton[@name='Skip']")
	protected Button getSkipButton() {
		return new Button(getLocator(this, "getSkipButton"));
	}
}
