package com.applause.auto.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.applause.auto.framework.pageframework.device.DeviceViewFactory;
import com.applause.auto.pageframework.testdata.TestConstants;
import com.applause.auto.pageframework.views.LandingView;

/**
 * This is a sample test that verifies the project is setup correctly and can
 * execute a simple test.
 */
public class DebugTest extends BaseTest {

	@Test(enabled = false, groups = { TestConstants.TestNGGroups.DEBUG }, description = "TEMP-1")
	public void debugTest() {

		LandingView landingView = DeviceViewFactory.create(LandingView.class);

		Assert.assertNotNull(landingView);
	}
}
