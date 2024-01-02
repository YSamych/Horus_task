package horus.pl.task;

public class BlockImpl implements Block {
	
	private String color;
	private String material;
	
	public BlockImpl() {}
	
	BlockImpl(String color, String material){
		this.color = color;
		this.material = material;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setMaterial(String material) {
		this.material = material;
	}

	public String getColor() {
		return color;
	}

	public String getMaterial() {
		return material;
	}

}
