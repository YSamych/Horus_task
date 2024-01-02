package horus.pl.task;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class WallTest {
	
	private final Wall wall = new Wall();
	private final List<Block> blocks = new ArrayList<>();
	 
	@BeforeEach
	void setup() {
		blocks.add(new BlockImpl("Red", "Wood"));
		blocks.add(new BlockImpl("Green", "Steel"));
		blocks.add(new BlockImpl("Orange", "Steel"));
		blocks.add(new BlockImpl("Red", "Wood"));
		blocks.add(new BlockImpl("Green", "Wood"));
		
		wall.setBlocks(blocks);
	}

	@Nested
	class FindBlockByColorTest{
		
		@Test
		void receiveColorNameAsString_shouldReturnOptionalBlock() {
			
			Optional<Block> expectedBlock = Optional.of(blocks.get(0));
			Optional<Block> actualBlock = wall.findBlockByColor("Red");
			
			assertEquals(expectedBlock.get().getColor(), actualBlock.get().getColor());
		}
		
		@Test
		void receiveNotExistedColorNameAsString_shouldReturnEmptyOptional() {
			
			Optional<Block> actualBlock = wall.findBlockByColor("Black");
			
			assertTrue(actualBlock.isEmpty());
		}
	}
	
	@Nested
	class FindBlocksByMaterialTest {
		
		@Test
		void receiveMaterialNameAsString_shouldReturnListOfBlocks() {
			List<Block> expectedBlocks = new ArrayList<>();
			expectedBlocks.add(new BlockImpl("Green", "Wood"));
			expectedBlocks.add(new BlockImpl("Green", "Wood"));
			expectedBlocks.add(new BlockImpl("Green", "Wood"));
			
			List<Block> actualBlocks = wall.findBlocksByMaterial("Wood");
			
			assertEquals(expectedBlocks.size(), actualBlocks.size());
		}
		
		@Test
		void receiveNotExistingMaterialNameAsString_shouldReturnEmpltyList() {
			List<Block> expectedBlocks = new ArrayList<>();
			
			List<Block> actualBlocks = wall.findBlocksByMaterial("Gold");
			
			assertEquals(expectedBlocks.size(), actualBlocks.size());
		}
	}
	
	@Nested
	class Count {
		
		@Test
		void shoudReturnAmountOfAllBlocksInTheWall() {
			assertEquals(5, wall.count());
		}
	}

}
