package mjm;

import mjm.content.*;
import mindustry.ctype.*;
import mindustry.mod.*;

import static mindustry.Vars.*;

public class Main extends Mod{
    public final ContentList[] mjmContent = {
		new MjmBlocks(),
		new MjmTechTree()
	};

    @Override
    public void init(){
    }

    @Override
    public void loadContent(){
        for(ContentList list : mjmContent){
            list.load();
        }
    }
}
