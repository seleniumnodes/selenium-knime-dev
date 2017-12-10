package com.seleniumnodes.devexamples.locators;

import io.appium.java_client.MobileBy;
import ws.palladian.nodes.selenium.locators.AbstractLocatorFactory;

public class AppiumLocatorFactories {

	public static final class AccessibilityIdLocatorFactory extends AbstractLocatorFactory {
		public AccessibilityIdLocatorFactory() {
			super(MobileBy.ByAccessibilityId.class.getName(), "Appium: Accessibility ID", MobileBy::AccessibilityId);
		}
	}

	public static final class AndroidUIAutomatorLocatorFactory extends AbstractLocatorFactory {
		public AndroidUIAutomatorLocatorFactory() {
			super(MobileBy.ByAndroidUIAutomator.class.getName(), "Appium: Android UI Automator",
					MobileBy::AndroidUIAutomator);
		}
	}

	public static final class IOsUiAutomationLocatorFactory extends AbstractLocatorFactory {
		public IOsUiAutomationLocatorFactory() {
			super(MobileBy.ByIosUIAutomation.class.getName(), "Appium: iOS UI Automation", MobileBy::IosUIAutomation);
		}
	}

}
