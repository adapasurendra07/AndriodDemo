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

/**
 * This is a sample test that verifies the project is setup correctly and can
 * execute a simple test.
 */
public class LaunchAppTest extends BaseTest {

	private LogController LOGGER = new LogController(LaunchAppTest.class);

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
	 * <li>Launch the app
	 * </ul>
	 * <li>Expected Results</li>
	 * <ul>
	 * <li>Verify the app is launched</li>
	 * </ul>
	 * </ul>
	 * <li>Postconditions</li>
	 * <ul>
	 * <li>none</li>
	 * </ul>
	 */
	@Test(groups = { TestConstants.TestNGGroups.LAUNCH }, description = "TEMP-1")
	public void debugTest() {

		LOGGER.info("Precondition: skip the tutorial and arrive at Agenda List view");
		landingView = DeviceViewFactory.create(LandingView.class);
		Assert.assertNotNull(landingView, "Landing view does not exist at app launch");
	}
}
