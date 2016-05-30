package presenters;

import layouts.LayoutDescription;

public class MainPagePresenter extends PagePresenterBase {
	
	public void onMainButtonPressed() {
		view.close();
	}

	@Override
	public LayoutDescription getLayout() {
		LayoutDescription description = new LayoutDescription(this.getWidth(), this.getHeight(), 1, 2);
		
		LayoutDescription.LayoutLabel label = new LayoutDescription.LayoutLabel();
		label.contents = "Welcome to Webcomic Weasel! :)";
		description.addComponent(label, 0, 0, 1, 1);
		
		LayoutDescription.LayoutComicTileList list = new LayoutDescription.LayoutComicTileList();
		for (int i = 0; i < 100; i++)
		{
			LayoutDescription.LayoutComicTile tile = new LayoutDescription.LayoutComicTile();
			tile.label = "Sample comic tile #" + Integer.toString(i + 1);
			list.list.add(tile);
		}
		description.addComponent(list, 0, 1, 1, 1);
		
		return description;
	}

	public String getTitle() {
		return "Main Page";
	}
}
