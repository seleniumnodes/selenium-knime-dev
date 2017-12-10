package com.seleniumnodes.devexamples.locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import ws.palladian.nodes.selenium.locators.AbstractLocatorFactory;
import ws.palladian.nodes.selenium.locators.LocatorFactory;

/**
 * {@link LocatorFactory} which allows locating elements by a contained text.
 * 
 * Example:
 * 
 * <pre>
 * &lt;p&gt;This is an example paragraph&lt;/p&gt;
 * &lt;p&gt;And another one&lt;/p&gt;
 * &lt;p&gt;And a third one&lt;/p&gt;
 * </pre>
 * 
 * Using <code>ByContainingText("another")</code> will select the second
 * element.
 * 
 * @author pk
 *
 */
public class ContainsTextLocatorFactory extends AbstractLocatorFactory {

	/**
	 * The locator implementation. It uses a predefined XPath query.
	 * 
	 * @author pk
	 *
	 */
	private static final class ByContainingText extends By {
		private final String query;

		private ByContainingText(String query) {
			this.query = query;
		}

		@Override
		public List<WebElement> findElements(SearchContext context) {
			String xpathExpression = "//*[contains(text(),'" + query + "')]";
			return context.findElements(By.xpath(xpathExpression));
		}

		@Override
		public String toString() {
			return "By.containsText: '" + query + "'";
		}
	}

	public ContainsTextLocatorFactory() {
		super("containsText", "Contains Text", ByContainingText::new);
	}

}
