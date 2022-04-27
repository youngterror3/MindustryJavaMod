package mjm.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.struct.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.ctype.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.meta.*;

import static mindustry.type.ItemStack.with;

public class MjmBlocks implements ContentList {
	
    public static Block
	
	hugeCopperWall, giganticCopperWall;
	
	
	
    @Override
    public void load() {
		
	int wallHealthMultiplier = 4;
	
        hugeCopperWall = new Wall("huge-copper-wall"){{
            requirements(Category.defense, with(Items.copper, 96));
            health = 80 * wallHealthMultiplier * 16;
            size = 3;
        }};

        giganticCopperWall = new Wall("gigantic-copper-wall"){{
            requirements(Category.defense, with(Items.copper, 384));
            health = 80 * wallHealthMultiplier * 64;
            size = 4;
        }};
		
    }
}
