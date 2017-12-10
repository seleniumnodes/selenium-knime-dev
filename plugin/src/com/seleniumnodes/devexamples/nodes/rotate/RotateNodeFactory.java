package com.seleniumnodes.devexamples.nodes.rotate;

import org.knime.core.node.NodeDialogPane;
import org.knime.core.node.NodeFactory;
import org.knime.core.node.NodeView;

public class RotateNodeFactory extends NodeFactory<RotateNodeModel> {

	@Override
	public RotateNodeModel createNodeModel() {
		return new RotateNodeModel();
	}

	@Override
	protected int getNrNodeViews() {
		return 0;
	}

	@Override
	public NodeView<RotateNodeModel> createNodeView(int viewIndex, RotateNodeModel nodeModel) {
		throw new UnsupportedOperationException();
	}

	@Override
	protected boolean hasDialog() {
		return true;
	}

	@Override
	protected NodeDialogPane createNodeDialogPane() {
		return new RotateNodeDialog();
	}

}
