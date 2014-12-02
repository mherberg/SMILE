package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import message.Message;
import message.MessageListener;
import model.templates.Model;
import view.image.ImageHolder;
import view.panel.LoadImagePanel;
/**
 * A LoadModel is used to load images into an ImageHolder
 * @author Luke
 *
 */
public class LoadModel extends Model implements ActionListener {

	private static final LoadImagePanel panel = new LoadImagePanel();
	private final JButton browse;

	public LoadModel(ImageHolder image, MessageListener listener) {
		super(image, listener, LoadModel.panel);

		this.browse = LoadModel.panel.getBrowseButton();
		this.browse.addActionListener(this);

	}

	/**
	 * When the browse button is pushed, load the image. If successful, notify
	 * all higher ups and display image on the image panel
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource().equals(this.browse)) {

			JFileChooser fc = new JFileChooser();
			fc.showOpenDialog(LoadModel.panel);

			BufferedImage bufferedImage = null;

			try {
				bufferedImage = ImageIO.read(fc.getSelectedFile());
			} catch (IOException e1) {
				// Do nothing if wrong type is imported
				System.out.println("Wrong File Format");
			}

			if (bufferedImage != null) {

				this.image.loadBufferedImage(bufferedImage);
				String fileName = fc.getSelectedFile().getName();
				LoadModel.panel.setText(fileName);
				notifyListeners(new Message(this, Message.LOAD));
			}
		}
	}

}
