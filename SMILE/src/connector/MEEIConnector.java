package connector;

import javax.swing.JPanel;

import message.Message;
import message.MessageListener;
import smile.SMILEView;
import view.container.MEEIContainer;
import view.image.ImageHolder;

public class MEEIConnector implements MessageListener {

	private final InstrumentsConnector instrumentConnector;
	private final ImageHolder image;

	private final MEEIContainer meeiContainer;

	public MEEIConnector() {

		org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application
				.getInstance(smile.SMILEApp.class).getContext().getResourceMap(
						SMILEView.class);

		this.image = new ImageHolder(resourceMap.getImageIcon("image.icon"),
				500);
		this.instrumentConnector = new InstrumentsConnector(image);

		this.meeiContainer = new MEEIContainer(this.image,
				this.instrumentConnector.getContainer());
	}

	public JPanel getContainer() {
		return this.meeiContainer;
	}

	public void handleMessage(Message e) {
		// TODO Auto-generated method stub
		// No messages to handle
	}

}
