package com.applause.auto.pageframework.helpers;

import org.openqa.selenium.WebDriver;

import com.applause.auto.framework.pageframework.util.drivers.DriverWrapperManager;
import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.pageframework.chunks.MenuChunk;
import com.applause.auto.pageframework.views.AgendaListView;
import com.applause.auto.pageframework.views.LoginView;

public class TemplateTestHelper {

	private final static LogController LOGGER = new LogController(TemplateTestHelper.class);
	private WebDriver driver = (WebDriver) DriverWrapperManager.getInstance().getPrimaryDriverWrapper().getDriver();

	/**
	 * Logs into the account with the given credentials
	 * 
	 * @param username
	 * @param password
	 * @param agendaView
	 * @return
	 */
	public AgendaListView loginToAccountWithCredentials(String username, String password, AgendaListView agendaView) {
		MenuChunk menuChunk = agendaView.clickMenuButton();
		LoginView loginView = menuChunk.clickLoginButton();

		loginView.enterUsername("test");
		loginView.enterPassword("test");
		agendaView = loginView.clickLogin();

		return agendaView;
	}

}