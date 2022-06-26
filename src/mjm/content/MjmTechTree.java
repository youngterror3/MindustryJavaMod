package mjm.content;

import arc.struct.*;
import mindustry.content.*;
import mindustry.ctype.*;
import mindustry.game.Objectives.*;
import mindustry.type.*;

import static mindustry.content.Items.*;
import static mindustry.content.Blocks.*;
import static mindustry.content.TechTree.*;
import static mjm.content.MjmBlocks.*;

public class MjmTechTree implements ContentList{
    static TechTree.TechNode context = null;

    @Override
    public void load(){

        mergeNode(copperWallLarge, () -> {
            node(hugeCopperWall, () -> {
                node(giganticCopperWall);
            });
        });
		
		mergeNode(titaniumWallLarge, () -> {
            node(hugeTitaniumWall, () -> {
                node(giganticTitaniumWall);
            });
        });
		
		mergeNode(plastaniumWallLarge, () -> {
            node(hugePlastaniumWall, () -> {
                node(giganticPlastaniumWall);
            });
        });

        mergeNode(thoriumWallLarge, () -> {
            node(hugeThoriumWall, () -> {
                node(giganticThoriumWall);
            });
        });

        mergeNode(phaseWallLarge, () -> {
            node(hugePhaseWall, () -> {
                node(giganticPhaseWall);
            });
        });

        mergeNode(surgeWallLarge, () -> {
            node(hugeSurgeWall, () -> {
                node(giganticSurgeWall);
            });
        });
        
    mergeNode(kiln, () -> {
        node(furnace);
        });

    mergeNode(plastaniumCompressor, () -> {
        node(plastaniumCompressor);
        });

    mergeNode(phaseWeaver, () -> {
        node(phaseSpinner);
        });

    mergeNode(surgeSmelter, () -> {
        node(alloyCrucible);
        });

    mergeNode(pyratiteMixer, () -> {
        node(pyratiteBlender);
        });

    mergeNode(blastMixer, () -> {
        node(blastBlender);
        });

    mergeNode(cryofluidMixer, () -> {
        node(cryofluidBlender);
        });

    mergeNode(kiln, () -> {
        node(liquefier);
        });

    mergeNode(melter, () -> {
        node(furnace);
        });

    mergeNode(sporePress, () -> {
        node(sporeCompactor);
        });

    mergeNode(pulverizer, () -> {
        node(crusher);
        });

    mergeNode(coalCentrifuge, () -> {
        node(coalSynthesizer);
        });

    mergeNode(waterExtractor, () -> {
        node(waterExtorter);
        });

    mergeNode(cultivator, () -> {
        node(nurturer);
        });

    mergeNode(oilExtractor, () -> {
        node(oilExtorter);
        });

    }
    private static void mergeNode(UnlockableContent parent, Runnable children){
        context = TechTree.all.find(t -> t.content == parent);
        children.run();
    }

    private static void node(UnlockableContent content, ItemStack[] requirements, Seq<Objective> objectives, Runnable children){
        TechNode node = new TechNode(context, content, requirements);
        if(objectives != null) node.objectives = objectives;

        TechNode prev = context;
        context = node;
        children.run();
        context = prev;
    }

    private static void node(UnlockableContent content, ItemStack[] requirements, Runnable children){
        node(content, requirements, null, children);
    }

    private static void node(UnlockableContent content, Seq<Objective> objectives, Runnable children){
        node(content, content.researchRequirements(), objectives, children);
    }

	
    private static void node(UnlockableContent content, Runnable children){
        node(content, content.researchRequirements(), children);
    }

    private static void node(UnlockableContent block){
        node(block, () -> {});
    }

    private static void nodeProduce(UnlockableContent content, Seq<Objective> objectives, Runnable children){
        node(content, content.researchRequirements(), objectives.and(new Produce(content)), children);
    }

    private static void nodeProduce(UnlockableContent content, Runnable children){
        nodeProduce(content, Seq.with(), children);
    }

    private static void nodeProduce(UnlockableContent content){
        nodeProduce(content, Seq.with(), () -> {});
    }
}
