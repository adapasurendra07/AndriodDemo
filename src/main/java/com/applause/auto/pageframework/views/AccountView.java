package com.applause.auto.pageframework.views;

import java.lang.invoke.MethodHandles;

import com.applause.auto.framework.pageframework.device.AbstractDeviceView;
import com.applause.auto.framework.pageframework.device.MobileElementLocator;
import com.applause.auto.framework.pageframework.device.factory.AndroidImplementation;
import com.applause.auto.framework.pageframework.device.factory.IosImplementation;
import com.applause.auto.framework.pageframework.devicecontrols.Text;
import com.applause.auto.framework.pageframework.util.logger.LogController;

@AndroidImplementation(AccountView.class)
@IosImplementation(AccountView.class)
public class AccountView extends AbstractDeviceView {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		syncHelper.waitForElementToAppear(getLocator(this, "getAccountHeaderText"));
	}

	/*
	 * Public Actions
	 */

	public String getNameTextValue() {
		if (env.getIsMobileAndroid()) {
			return getNameText().getAttributeValue("contentDescription");
		} else {
			return getNameText().getAttributeValue("name");
		}

	}

	/*
	 * Protected Getters
	 */

	@MobileElementLocator(android = "//android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.view.View[3]", iOS = "//XCUIElementTypeOther[3]/XCUIElementTypeStaticText[1]")
	protected Text getNameText() {
		return new Text(getLocator(this, "getNameText"));
	}

	@MobileElementLocator(android = "//android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.view.View[3]", iOS = "Account")
	protected Text getAccountHeaderText() {
		return new Text(getLocator(this, "getAccountHeaderText"));
	}
}
