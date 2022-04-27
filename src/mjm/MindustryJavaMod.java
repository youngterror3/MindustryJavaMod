package mjm;

import arc.*;
import arc.func.*;
import arc.struct.*;
import arc.util.*;
import mindustry.*;
import mindustry.ctype.*;
import mindustry.game.EventType.*;
import mindustry.game.Team;
import mindustry.mod.*;
import mindustry.mod.Mods.*;
import mindustry.net.*;
import mindustry.type.*;
import mindustry.ui.*;
import mindustry.world.*;
import mindustry.world.blocks.*;

import mjm.content.*;

import static java.lang.Float.*;
import static mindustry.Vars.*;

public class MindustryJavaMod extends Mod{

    private final ContentList[] mjmContent = {
            //new MjmLiquids(),
            //new MjmItems(),
            //new MjmBullets(),
            //new MjmUnits(),
            new MjmBlocks(),
            //new MjmSectors(),
            //new MjmPlanets(),
            new MjmTechTree()
    };

    @Override
    public void init(){
        Vars.enableConsole = true;
    }

    @Override
    public void loadContent() {
        for (ContentList list : mjmContent) {
            list.load();
        }
    }
}
