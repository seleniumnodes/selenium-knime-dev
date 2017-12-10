package com.seleniumnodes.devexamples.nodes.rotate;

import java.io.File;
import java.io.IOException;

import org.knime.core.data.DataCell;
import org.knime.core.data.DataRow;
import org.knime.core.data.DataTableSpec;
import org.knime.core.node.BufferedDataTable;
import org.knime.core.node.CanceledExecutionException;
import org.knime.core.node.ExecutionContext;
import org.knime.core.node.ExecutionMonitor;
import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.NodeLogger;
import org.knime.core.node.NodeModel;
import org.knime.core.node.NodeSettingsRO;
import org.knime.core.node.NodeSettingsWO;
import org.openqa.selenium.Rotatable;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;

import ws.palladian.nodes.selenium.types.WebDriverValue;

class RotateNodeModel extends NodeModel {

	/** The logger instance. */
	private static final NodeLogger LOGGER = NodeLogger.getLogger(RotateNodeModel.class);

	static final int INPUT_TABLE_IDX = 0;

	private final RotateNodeSettings nodeSettings = new RotateNodeSettings();

	RotateNodeModel() {
		super(1, 1);
	}

	@Override
	protected BufferedDataTable[] execute(BufferedDataTable[] inData, ExecutionContext exec) throws Exception {
		BufferedDataTable inputTable = inData[INPUT_TABLE_IDX];
		int inputIdx = inputTable.getDataTableSpec().findColumnIndex(nodeSettings.getInputColumn().getStringValue());
		for (DataRow row : inputTable) {
			DataCell inCell = row.getCell(inputIdx);
			if (inCell.isMissing()) {
				continue;
			}
			WebDriverValue webDriverValue = (WebDriverValue) inCell;
			WebDriver webDriver = webDriverValue.getWebDriver();
			if (!(webDriver instanceof Rotatable)) {
				LOGGER.warnWithFormat("%s does not implement %s", webDriver.getClass().getName(),
						Rotatable.class.getName());
				continue;
			}
			Rotatable rotatable = (Rotatable) webDriver;
			ScreenOrientation orientation = ScreenOrientation
					.valueOf(nodeSettings.getScreenOrientation().getStringValue());
			rotatable.rotate(orientation);
		}
		return new BufferedDataTable[] { inputTable };
	}

	@Override
	protected DataTableSpec[] configure(DataTableSpec[] inSpecs) throws InvalidSettingsException {
		return inSpecs;
	}

	@Override
	protected void loadInternals(File nodeInternDir, ExecutionMonitor exec)
			throws IOException, CanceledExecutionException {
		// no op.
	}

	@Override
	protected void saveInternals(File nodeInternDir, ExecutionMonitor exec)
			throws IOException, CanceledExecutionException {
		// no op.
	}

	@Override
	protected void saveSettingsTo(NodeSettingsWO settings) {
		nodeSettings.saveSettingsTo(settings);
	}

	@Override
	protected void validateSettings(NodeSettingsRO settings) throws InvalidSettingsException {
		nodeSettings.validateSettings(settings);
	}

	@Override
	protected void loadValidatedSettingsFrom(NodeSettingsRO settings) throws InvalidSettingsException {
		nodeSettings.loadValidatedSettingsFrom(settings);
	}

	@Override
	protected void reset() {
		// no op.
	}

}
