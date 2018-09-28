package com.seleniumnodes.devexamples.webdrivers;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;

import org.knime.core.node.util.ViewUtils;

import io.appium.java_client.ios.IOSDriver;
import ws.palladian.nodes.selenium.factory.IWebDriverFactorySettings;
import ws.palladian.nodes.selenium.webdrivers.AbstractWebDriverFactory;
import ws.palladian.nodes.selenium.webdrivers.WebDriverFactory;

/**
 * {@link WebDriverFactory} which integrates
 * <a href="http://appium.io">Appium</a>.
 * 
 * @author pk
 *
 */
public class AppiumIOsDriverFactory extends AbstractWebDriverFactory<IOSDriver<?>> {

	private static final String READABLE_NAME = "Appium: iOS";

	private static final String IDENTIFIER = "io.appium.java_client.ios.IOSDriver.Safari";

	private static final Icon ICON = ViewUtils.loadIcon(AppiumIOsDriverFactory.class, "appium.png");

	public AppiumIOsDriverFactory() {
		super(true, READABLE_NAME, IDENTIFIER);
	}

	@Override
	public IOSDriver<?> create(IWebDriverFactorySettings settings) {
		try {
			return new IOSDriver<>(new URL(settings.getRemoteUrl()), settings.getSeleniumCapabilities());
		} catch (MalformedURLException e) {
			throw new IllegalStateException("Invalid URL: " + settings.getRemoteUrl(), e);
		}
	}

	@Override
	public boolean isRemote() {
		return true;
	}

	@Override
	public Icon getIcon() {
		return ICON;
	}

}
