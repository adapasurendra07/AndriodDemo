package com.applause.auto.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.applause.auto.framework.pageframework.device.DeviceViewFactory;
import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.pageframework.chunks.MenuChunk;
import com.applause.auto.pageframework.testdata.TestConstants;
import com.applause.auto.pageframework.views.AccountView;
import com.applause.auto.pageframework.views.AgendaListView;
import com.applause.auto.pageframework.views.LandingView;
import com.applause.auto.pageframework.views.LoginView;


public class LoginToAccountTest extends BaseTest {

	private LogController LOGGER = new LogController(LoginToAccountTest.class);

	private AgendaListView agendaView;
	private MenuChunk menuChunk;
	private LoginView loginView;
	private LandingView landingView;
	private AccountView accountView;

	/**
	 * <li>Preconditions</li>
	 * <ul>
	 * <li>User skips tutorial launched at app opening</li>
	 * </ul>
	 * <li>Steps</li>
	 * <ul>
	 * <li>On the Agenda List View, select the menu button</li>
	 * <li>On the Menu view, select "Login"</li>
	 * <li>In the Username field, enter "test"</li>
	 * <li>In the Password field, enter "test"</li>
	 * <li>Press the "Login" button</li>
	 * <li>On the Agenda List View, select the menu button</li>
	 * <li>On the Menu view, select "Account"</li>
	 * </ul>
	 * <li>Expected Results</li>
	 * <ul>
	 * <li>Verify that the correct username is displayed in the account details
	 * view</li>
	 * </ul>
	 * </ul>
	 * <li>Postconditions</li>
	 * <ul>
	 * <li>none</li>
	 * </ul>
	 */
	@Test(groups = { TestConstants.TestNGGroups.DEBUG }, description = "TEMP-1")
	public void debugTest() {

		LOGGER.info("Precondition: skip the tutorial and arrive at Agenda List view");
		landingView = DeviceViewFactory.create(LandingView.class);
		agendaView = landingView.clickSkipButton();

		LOGGER.info(String.format("Step: log in to account with username %s and password %s",
				TestConstants.TestData.USERNAME, TestConstants.TestData.PASSWORD));
		agendaView = templateTestHelper.loginToAccountWithCredentials(TestConstants.TestData.USERNAME,
				TestConstants.TestData.PASSWORD, agendaView);

		LOGGER.info("On the menu view, select Account");
		menuChunk = agendaView.clickMenuButton();
		accountView = menuChunk.clickAccountButton();

		LOGGER.info("Verify: the correct username is displayed in the account details");
		Assert.assertEquals(accountView.getNameTextValue(), TestConstants.TestData.USERNAME,
				"Username does not match expected value");
	}

	public LoginView getLoginView() {
		return loginView;
	}

	public void setLoginView(LoginView loginView) {
		this.loginView = loginView;
	}
}
