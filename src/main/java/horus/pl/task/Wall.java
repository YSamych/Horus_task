package horus.pl.task;

import java.util.List;
import java.util.Optional;

public class Wall implements Structure {
	
	private List<Block> blocks;
	
	public void setBlocks(List<Block> blocks) {
		this.blocks = blocks;
	}

	public Optional<Block> findBlockByColor(String color) {
		
		for(Block b : blocks) {
			if(b.getColor().equals(color)) {
				return Optional.of(b);
			}
		}		
		return Optional.empty();
	}

	public List<Block> findBlocksByMaterial(String material) {
		
		return blocks.stream().filter(block -> material.equals(block.getMaterial())).toList();
	}

	public int count() {
		return blocks.size();
	}

}
