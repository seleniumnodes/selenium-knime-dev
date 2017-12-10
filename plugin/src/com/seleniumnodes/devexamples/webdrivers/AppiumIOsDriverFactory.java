package com.seleniumnodes.devexamples.webdrivers;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import ws.palladian.nodes.selenium.factory.IWebDriverFactorySettings;
import ws.palladian.nodes.selenium.webdrivers.AbstractWebDriverFactory;
import ws.palladian.nodes.selenium.webdrivers.WebDriverFactory;

/**
 * {@link WebDriverFactory} which integrates
 * <a href="http://appium.io">Appium</a>. This implementation launches Safari on
 * an iPhone.
 * 
 * @author pk
 *
 */
public class AppiumIOsDriverFactory extends AbstractWebDriverFactory<IOSDriver<?>> {

	private static final String READABLE_NAME = "Appium: Safari on iOS";

	private static final String IDENTIFIER = "io.appium.java_client.ios.IOSDriver.Safari";

	public AppiumIOsDriverFactory() {
		super(true, READABLE_NAME, IDENTIFIER);
	}

	@Override
	public IOSDriver<?> create(IWebDriverFactorySettings settings) {

		DesiredCapabilities defaultCapabilities = createDefaultCapabilities();
		Capabilities driverCapabilities = settings.getSeleniumCapabilities();
		DesiredCapabilities mergedCapabilities = defaultCapabilities.merge(driverCapabilities);

		try {
			return new IOSDriver<>(new URL(settings.getRemoteUrl()), mergedCapabilities);
		} catch (MalformedURLException e) {
			throw new IllegalStateException("Invalid URL: " + settings.getRemoteUrl(), e);
		}
	}

	private static DesiredCapabilities createDefaultCapabilities() {
		// https://github.com/appium/sample-code/blob/master/sample-code/examples/java/junit/src/test/java/com/saucelabs/appium/SafariTest.java
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.3");
		desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.SAFARI);
		desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		return desiredCapabilities;
	}

	@Override
	public boolean isRemote() {
		return true;
	}

}
