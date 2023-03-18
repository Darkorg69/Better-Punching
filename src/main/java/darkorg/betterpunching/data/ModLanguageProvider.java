package darkorg.betterpunching.data;

import darkorg.betterpunching.BetterPunching;
import darkorg.betterpunching.registry.DamageSources;
import darkorg.betterpunching.registry.ModEffects;
import darkorg.betterpunching.registry.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(DataGenerator dataGenerator) {
        super(dataGenerator, BetterPunching.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(ModEffects.BLEEDING.get(), "Bleeding");
        add(ModEffects.SPLINTER.get(), "Splinter");
        add(ModItems.FLINT_DAGGER.get(), "Flint Dagger");
        add(ModItems.FLINT_HATCHET.get(), "Flint Hatchet");
        add(ModItems.FLINT_PICK.get(), "Flint Pick");
        add(ModItems.FLINT_SPADE.get(), "Flint Spade");
        add(DamageSources.BLEEDING, "%1$s bled to death");
        add(DamageSources.SPLINTER, "%1$s died from a splinter in their hand");
        add(DamageSources.PUNCHING_BLOCKS, "%1$s punched a block too hard");
    }

    private <T extends DamageSource> void add(T pDamageSource, String pTranslation) {
        add("death.attack." + pDamageSource.msgId, pTranslation);
    }
}
