package layouts;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class LayoutDescription {
	
	public static interface ILayoutComponent {
		
	}
	
	public static class LayoutButton implements ILayoutComponent {
		public String label;
		public Runnable onPress;
	}

	public static class LayoutComicTile implements ILayoutComponent {
		public String label;
		public Runnable onPress;
		public LayoutComicTileColor color;
		
		public enum LayoutComicTileColor {
			white,
			gray
		}
	}
	
	public static class LayoutComicTileList implements ILayoutComponent {
		public List<LayoutComicTile> list = new ArrayList<LayoutComicTile>();
		public Runnable updateEvent;
	}
	
	public static class LayoutLabel implements ILayoutComponent {
		public String contents;
	}
	
	public static class LayoutTextBox implements ILayoutComponent {
		public String contents;
		public Runnable onReturn;
	}
	
	public static class LayoutImage implements ILayoutComponent {
		public Image image;
	}
		
	public LayoutDescription(int width, int height, int gridWidth, int gridHeight) {
		this.width = width;
		this.height = height;
		this.gridWidth = gridWidth;
		this.gridHeight = gridHeight;
		
		componentsList = new ArrayList<ComponentListing>();
	}
	
	public void addComponent(ILayoutComponent component, 
			int gridX, int gridY, int gridWidth, int gridHeight) {
		ComponentListing listing = new ComponentListing();
		
		listing.component = component;
		listing.gridX = gridX;
		listing.gridY = gridY;
		listing.gridWidth = gridWidth;
		listing.gridHeight = gridHeight;
		
		componentsList.add(listing);
	}
	
	private List<ComponentListing> componentsList;
	
	private class ComponentListing {
		public ILayoutComponent component;
		public int gridX;
		public int gridY;
		public int gridWidth;
		public int gridHeight;
	}
	
	public int getGridWidth() {
		return gridWidth;
	}
	
	public int getGridHeight() {
		return gridHeight;
	}
	
	public int getCount() {
		return componentsList.size();
	}
	
	public ILayoutComponent getComponent(int index) {
		return componentsList.get(index).component;
	}
	
	public int getComponentWidth(int index) {
		return (this.width / this.gridWidth) * componentsList.get(index).gridWidth;
	}
	
	public int getComponentHeight(int index) {
		return (this.height / this.gridHeight) * componentsList.get(index).gridHeight;
	}
	
	public int getComponentXPosition(int index) {
		return (this.width / this.gridWidth) * componentsList.get(index).gridX;
	}

	public int getComponentYPosition(int index) {
		return (this.height / this.gridHeight) * componentsList.get(index).gridY;
	}
	
	private int width;
	private int height;
	private int gridWidth;
	private int gridHeight;
}
