package model;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import message.Message;
import message.MessageListener;
import model.templates.MouseModel;
import util.graphics.Drawer;
import util.math.Line;
import view.FocusablePanel;
import view.image.ImageHolder;
import view.panel.LipOnMidlinePanel;

public class LipOnMidlineModel extends MouseModel {

	private Line midline;
	private Point2D.Double bottomLipEdge;
	private static final FocusablePanel panel = new LipOnMidlinePanel();

	public LipOnMidlineModel(ImageHolder image, MessageListener listener) {
		super(image, listener, LipOnMidlineModel.panel);

	}

	protected void handleMouseClick(Point2D.Double click) {

		Point2D.Double bottomLipEdge = this.midline
				.getClosestPointOnLine(click);

		BufferedImage updatedImage = Drawer.drawDot(this.image
				.getScaledBufferedImage(), bottomLipEdge,
				LipOnMidlinePanel.dotColor);
		this.image.paintBufferedImage(updatedImage);
		this.bottomLipEdge = bottomLipEdge;

		notifyListeners(new Message(this, Message.BOTTOM_LIP_LOCATED));
		deactivate();
	}

	public Point2D.Double getBottomLipEdge() {
		return this.bottomLipEdge;
	}

	public void focus(Line midline) {
		super.focus();
		this.midline = midline;
	}

}
