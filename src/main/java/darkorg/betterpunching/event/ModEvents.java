package darkorg.betterpunching.event;

import darkorg.betterpunching.BetterPunching;
import darkorg.betterpunching.data.ModItemModelProvider;
import darkorg.betterpunching.data.ModLanguageProvider;
import darkorg.betterpunching.data.ModRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = BetterPunching.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void gatherDataEvent(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();

        generator.addProvider(new ModRecipeProvider(generator));

        generator.addProvider(new ModLanguageProvider(generator, BetterPunching.MOD_ID, "en_us"));

        generator.addProvider(new ModItemModelProvider(generator, BetterPunching.MOD_ID, event.getExistingFileHelper()));
    }
}
