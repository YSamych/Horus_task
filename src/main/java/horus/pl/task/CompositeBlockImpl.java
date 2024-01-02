package horus.pl.task;

import java.util.List;

public class CompositeBlockImpl implements CompositeBlock {
	
	private List<Block> blocks;
	private Block block = new BlockImpl();
	

	public void setBlocks(List<Block> blocks){
		this.blocks = blocks;
	}

	public List<Block> getBlocks() {
		return blocks;
	}

	public String getColor() {
		
		return block.getColor();
	}

	public String getMaterial() {
		return block.getMaterial();
	}
}
