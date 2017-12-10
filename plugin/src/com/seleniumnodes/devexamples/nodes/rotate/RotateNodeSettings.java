package com.seleniumnodes.devexamples.nodes.rotate;

import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.NodeSettingsRO;
import org.knime.core.node.NodeSettingsWO;
import org.knime.core.node.defaultnodesettings.SettingsModelString;
import org.openqa.selenium.ScreenOrientation;

class RotateNodeSettings {

	private final SettingsModelString inputColumn = new SettingsModelString("inputColumn", null);

	private final SettingsModelString screenOrientation = new SettingsModelString("screenOrientation",
			ScreenOrientation.PORTRAIT.name());

	public void saveSettingsTo(NodeSettingsWO settings) {
		inputColumn.saveSettingsTo(settings);
		screenOrientation.saveSettingsTo(settings);
	}

	public void validateSettings(NodeSettingsRO settings) throws InvalidSettingsException {
		inputColumn.validateSettings(settings);
		screenOrientation.validateSettings(settings);
	}

	public void loadValidatedSettingsFrom(NodeSettingsRO settings) throws InvalidSettingsException {
		inputColumn.loadSettingsFrom(settings);
		screenOrientation.loadSettingsFrom(settings);
	}

	public SettingsModelString getInputColumn() {
		return inputColumn;
	}

	public SettingsModelString getScreenOrientation() {
		return screenOrientation;
	}

}
