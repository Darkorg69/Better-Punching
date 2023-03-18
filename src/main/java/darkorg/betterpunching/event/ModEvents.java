package darkorg.betterpunching.event;

import darkorg.betterpunching.BetterPunching;
import darkorg.betterpunching.data.ModItemModelProvider;
import darkorg.betterpunching.data.ModLanguageProvider;
import darkorg.betterpunching.data.ModRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = BetterPunching.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void gatherDataEvent(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        ModLanguageProvider en_us = new ModLanguageProvider(generator);
        ModRecipeProvider modRecipeProvider = new ModRecipeProvider(generator);
        ModItemModelProvider modItemModelProvider = new ModItemModelProvider(generator, existingFileHelper);

        generator.addProvider(en_us);
        generator.addProvider(modRecipeProvider);
        generator.addProvider(modItemModelProvider);
    }
}
