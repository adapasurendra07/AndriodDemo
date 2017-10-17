package com.applause.auto.pageframework.views;

import java.lang.invoke.MethodHandles;

import com.applause.auto.framework.pageframework.device.AbstractDeviceView;
import com.applause.auto.framework.pageframework.device.DeviceChunkFactory;
import com.applause.auto.framework.pageframework.device.MobileElementLocator;
import com.applause.auto.framework.pageframework.device.factory.AndroidImplementation;
import com.applause.auto.framework.pageframework.device.factory.IosImplementation;
import com.applause.auto.framework.pageframework.devicecontrols.Button;
import com.applause.auto.framework.pageframework.devicecontrols.TextBox;
import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.pageframework.chunks.MenuChunk;

@AndroidImplementation(AgendaListView.class)
@IosImplementation(AgendaListView.class)
public class AgendaListView extends AbstractDeviceView {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	public AgendaListView() {
		super();
	}

	@Override
	protected void waitUntilVisible() {
		syncHelper.waitForElementToAppear(getLocator(this, "getSearchField"));
	}

	
	@MobileElementLocator(android = "//android.view.View[1]/android.view.View[2]", iOS = "//XCUIElementTypeOther[3]/XCUIElementTypeOther[1]")
	public MenuChunk clickMenuButton() {
		LOGGER.info("Clicking Menu button");
		getMenuButton().pressButton();
		return DeviceChunkFactory.create(MenuChunk.class, getLocator(this, "clickMenuButton"));
	}

	/*
	 * Protected Getters
	 */

	@MobileElementLocator(android = "//android.widget.Button[@content-desc='menu ']", iOS = "//XCUIElementTypeButton[@name='menu']")
	protected Button getMenuButton() {
		return new Button(getLocator(this, "getMenuButton"));
	}

	@MobileElementLocator(android = "//android.widget.EditText[1]", iOS = "$XCUIElementTypeSearchField")
	protected TextBox getSearchField() {
		return new TextBox(getLocator(this, "getSearchField"));
	}
}
