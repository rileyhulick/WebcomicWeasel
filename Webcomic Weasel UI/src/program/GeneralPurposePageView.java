package program;

import java.awt.Button;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.*;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import interfaces.IGeneralPurposePageView;
import layouts.LayoutDescription;

public class GeneralPurposePageView extends PageViewBase implements IGeneralPurposePageView {
	
	
	protected void onPresenterSet() {
		implementLayout();
	}
	
	protected void implementLayout() {
		LayoutDescription layoutDescription = presenter.getLayout();
		
		if (layoutDescription == null)
			throw new RuntimeException("Expected layout description but none was given.");
		
		for (int i = 0; i < layoutDescription.getCount(); i++) {
			
			LayoutDescription.ILayoutComponent layoutComponent = layoutDescription.getComponent(i);
			
			Component frameComponent;
			
			
			if (layoutComponent instanceof LayoutDescription.LayoutButton) {
				frameComponent = createButton((LayoutDescription.LayoutButton) layoutComponent);
			} else if (layoutComponent instanceof LayoutDescription.LayoutLabel) {
				frameComponent = createLabel((LayoutDescription.LayoutLabel) layoutComponent);
			} else if (layoutComponent instanceof LayoutDescription.LayoutComicTileList) {	
				frameComponent = createComicTileList((LayoutDescription.LayoutComicTileList) layoutComponent);
			} else if (layoutComponent instanceof LayoutDescription.LayoutImage) {
				frameComponent = createImage((LayoutDescription.LayoutImage) layoutComponent);
			//} else if (layoutComponent instanceof LayoutDescription.LayoutTextBox) {
			} else {
				throw new RuntimeException("implementLayout was given an unexpected layout compoment.");
			}
			
			frameComponent.setSize(layoutDescription.getComponentWidth(i), layoutDescription.getComponentHeight(i));
			frameComponent.setLocation(layoutDescription.getComponentXPosition(i), layoutDescription.getComponentYPosition(i));
			if (frameComponent instanceof JComponent)
				((JComponent) frameComponent).setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
			
			frame.add(frameComponent);
			
		}
	}
	
	private static Component createButton(final LayoutDescription.LayoutButton layoutButton) {
		
		Button newButton = new Button();
		newButton.setLabel(layoutButton.label);
		newButton.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				layoutButton.onPress.run();
			}
		});
		
		return newButton;
	}
	
	private static Component createImage(final LayoutDescription.LayoutImage layoutImage) {
		JLabel newLabel = new JLabel();
		newLabel.setIcon(new ImageIcon(layoutImage.image));
	
		return newLabel;
	}
	
	private static Component createLabel(final LayoutDescription.LayoutLabel layoutLabel) {
		JLabel newLabel = new JLabel();
		newLabel.setText(layoutLabel.contents);
		
		return newLabel;
	}
	
	private static Component createComicTileList(final LayoutDescription.LayoutComicTileList layoutComicTileList) {
		JPanel newPanel = new JPanel();
		BoxLayout layout = new BoxLayout(newPanel, BoxLayout.Y_AXIS);
		newPanel.setLayout(layout);
		
		for (Iterator<LayoutDescription.LayoutComicTile> i = layoutComicTileList.list.iterator(); i.hasNext();)
		{
			newPanel.add(createComicTile(i.next()));
		}
		
		JScrollPane newScrollPane = new JScrollPane(newPanel);
		return newScrollPane;
	}
	
	private static Component createComicTile(final LayoutDescription.LayoutComicTile layoutTile) {
		Button newButton = new Button();
		newButton.setLabel(layoutTile.label);
		newButton.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				layoutTile.onPress.run();
			}
		});
		
		return newButton;
	}
}
