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

import mjm.world.blocks.*;
import mjm.world.draw.*;

import static mindustry.content.Items.*;
import static mindustry.content.Liquids.*;
import static mindustry.type.ItemStack.with;

public class MjmBlocks implements ContentList {
	
    public static Block
	
	
	
	//sandbox

    //defense
    hugeCopperWall, giganticCopperWall, hugeTitaniumWall, giganticTitaniumWall, hugePlastaniumWall, giganticPlastaniumWall,
    hugeThoriumWall, giganticThoriumWall, hugePhaseWall, giganticPhaseWall, hugeSurgeWall, giganticSurgeWall,
	
	
	//crafting
	furnace;
	
	
	
	
    @Override
    public void load() {
	//defense
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
		
        hugeTitaniumWall = new Wall("huge-titanium-wall"){{
            requirements(Category.defense, with(Items.titanium, 96));
            health = 110 * wallHealthMultiplier * 16;
            size = 3;
        }};

        giganticTitaniumWall = new Wall("gigantic-titanium-wall"){{
            requirements(Category.defense, with(Items.titanium, 384));
            health = 110 * wallHealthMultiplier * 64;
            size = 4;
        }};

        hugeThoriumWall = new Wall("huge-thorium-wall"){{
            requirements(Category.defense, with(Items.thorium, 96));
            health = 200 * wallHealthMultiplier * 16;
            size = 3;
        }};

        giganticThoriumWall = new Wall("gigantic-thorium-wall"){{
            requirements(Category.defense, with(Items.thorium, 384));
            health = 200 * wallHealthMultiplier * 64;
            size = 4;
        }};

        hugePlastaniumWall = new Wall("huge-plastanium-wall"){{
            requirements(Category.defense, with(Items.plastanium, 96));
            health = 130 * wallHealthMultiplier * 16;
            size = 3;
            insulated = true;
            absorbLasers = true;
        }};

        giganticPlastaniumWall = new Wall("gigantic-plastanium-wall"){{
            requirements(Category.defense, with(Items.plastanium, 384));
            health = 130 * wallHealthMultiplier * 64;
            size = 4;
            insulated = true;
            absorbLasers = true;
        }};

        hugePhaseWall = new Wall("huge-phase-wall"){{
            requirements(Category.defense, with(Items.phaseFabric, 96));
            health = 150 * wallHealthMultiplier * 16;
            size = 3;
            chanceDeflect = 14f;
            flashHit = true;
        }};

        giganticPhaseWall = new Wall("gigantic-phase-wall"){{
            requirements(Category.defense, with(Items.phaseFabric, 384));
            health = 150 * wallHealthMultiplier * 64;
            size = 4;
            chanceDeflect = 19f;
            flashHit = true;
        }};

        hugeSurgeWall = new Wall("huge-surge-wall"){{
            requirements(Category.defense, with(Items.surgeAlloy, 96));
            health = 230 * wallHealthMultiplier * 16;
            size = 3;
            lightningChance = 0.07f;
        }};

        giganticSurgeWall = new Wall("gigantic-surge-wall"){{
            requirements(Category.defense, with(Items.surgeAlloy, 384));
            health = 230 * wallHealthMultiplier * 64;
            size = 4;
            lightningChance = 0.09f;
        }};
		
		//crafting
		furnace = new AttributeCrafter("furnace"){{
            requirements(Category.crafting, with(titanium, 120, metaglass, 80, plastanium, 35, graphite, 200));
            outputItem = new ItemStack(metaglass, 8);
            craftTime = 65f;
            size = 3;
            itemCapacity = 30;
            boostScale = 0.15f;
            drawer = new DrawSmelter();
            craftEffect = Fx.smeltsmoke;

            consumes.items(with(sand, 3, lead, 3, pyratite, 1));
            consumes.power(5f);
        }};
        
		
    }
}
