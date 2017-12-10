package com.seleniumnodes.devexamples.nodes.rotate;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.knime.core.node.defaultnodesettings.DefaultNodeSettingsPane;
import org.knime.core.node.defaultnodesettings.DialogComponentColumnNameSelection;
import org.knime.core.node.defaultnodesettings.DialogComponentStringSelection;
import org.openqa.selenium.ScreenOrientation;

import ws.palladian.nodes.selenium.types.WebDriverValue;

class RotateNodeDialog extends DefaultNodeSettingsPane {

	private final RotateNodeSettings nodeSettings = new RotateNodeSettings();

	@SuppressWarnings("unchecked")
	RotateNodeDialog() {
		addDialogComponent(new DialogComponentColumnNameSelection(nodeSettings.getInputColumn(), "Input column",
				RotateNodeModel.INPUT_TABLE_IDX, WebDriverValue.class));
		addDialogComponent(new DialogComponentStringSelection(nodeSettings.getScreenOrientation(), "Screen orientation",
				Arrays.stream(ScreenOrientation.values()).map(o -> o.name()).collect(Collectors.toList())));
	}

}
