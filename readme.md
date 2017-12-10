Selenium Nodes for KNIME: Extension Development Guide
=====================================================

These examples show how developers can use the [Selenium Nodes’](https://seleniumnodes.com) extension points to add new functionality.

As a showcase it provides a very rudimentary sample integration of <a href="http://appium.io">Appium</a>, “an open source test automation framework for use with native, hybrid and mobile web apps. It drives iOS, Android, and Windows apps using the WebDriver protocol.”

Please note, that this repository does **not** contain the source code of the Selenium Nodes, which is not open sourced.

Extension points
----------------

The following extension points are currently provided by the Selenium Nodes:

* `ws.palladian.nodes.selenium.plugin.WebDriverFactory` — Allows to register new `WebDriver` implementations which can be selected in the **WebDriver Factory** node.

* `ws.palladian.nodes.selenium.plugin.LocatorFactory` — Allows to add additional locators for the **Find Elements** node. See `/plugin/src/com/seleniumnodes/devexamples/locators/ContainsTextLocatorFactory.java` for an example implementation.

* Besides these, there’s also an example for a node implementation using KNIME’s `org.knime.workbench.repository.nodes` extension point in `/plugin/src/com/seleniumnodes/devexamples/nodes`. It makes use of the `ws.palladian.nodes.selenium.types.WebDriverValue` data value to interact with a mobile browser.

Development and build prerequisites
-----------------------------------

* [Eclipse](https://www.eclipse.org/downloads/eclipse-packages/) (preferably use **Eclipse IDE for Java Developers**)
    * [M2Eclipse](https://www.eclipse.org/m2e/) (already included if you use the Eclipse IDE for Java Developers)
* [Maven](https://maven.apache.org)

Directory structure
-------------------

* `feature/` — the feature definition
* `plugin/` — the code for extensions
* `pom.xml` — parent and aggregation `pom.xml` for triggering the entire Tycho build
* `targetplatform/` — the target platform definition for building and development
* `testflowrunner/` — runs the test workflows; this requires to put an .epf file with a valid Selenium Nodes license in `/testflowrunner/license.epf`
* `update/` — generates the update site for distribution

Setting up the development environment
--------------------------------------

1. Run the following command which downloads the required dependencies (Appium libraries and transitive dependencies) and puts them into `plugin/lib`:

    ```
    $ mvn clean initialize
    ```

2. In Eclipse, go to **Import … → Existing Maven Projects**, select the project’s root folder and import all subprojects. When you’re asked to install “m2e connectors”, do so. The projects will still show compile errors, as the dependencies cannot be resolved.

3. Set the target platform in Eclipse. Open the `.target` file in the `targetplatform` directory, wait until the progress bar for resolving the target platform has disappeared and click **Set as Target Platform**. After the progress has completed (takes some time depending on the internet connection), all compile errors should have disappeared.

4. Create a new launch configuration for an **Eclipse Application** and specify `org.knime.product.KNIME_PRODUCT` under **Program to Run**. Save, click **Run** and KNIME should start.

Building
--------

The following command builds the entire project, creates an update site, runs unit tests and test workflows using Tycho:

```
$ mvn clean verify
```

The generated P2 update site can be found in `/update/target/repository`.

Running test workflows
----------------------

For running test workflows, a valid Selenium Nodes license needs to be present. It is supplied to the testflow run as an exported Eclipse preferences file. To create this file, export your preferences from the KNIME application through **File → Export Preferences…** and put it in `/testflowrunner/license.epf`

- - -

Selenium Nodes for KNIME were created by Philipp Katz, 2015 — 2017.
