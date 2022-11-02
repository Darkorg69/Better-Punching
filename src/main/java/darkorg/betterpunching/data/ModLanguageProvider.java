package darkorg.betterpunching.data;

import darkorg.betterpunching.registry.ModDamageSources;
import darkorg.betterpunching.registry.ModEffects;
import darkorg.betterpunching.registry.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(DataGenerator dataGenerator, String modId, String locale) {
        super(dataGenerator, modId, locale);
    }

    @Override
    protected void addTranslations() {
        add(ModDamageSources.BLEEDING, "%1$s bled to death.");
        add(ModDamageSources.INVALID_PUNCHING, "%1$s punched a block too hard.");
        add(ModDamageSources.SPLINTER, "%1$s died from a splinter in their hand.");
        add(ModEffects.BLEEDING.get(), "Bleeding");
        add(ModEffects.SPLINTER.get(), "Splinter");
        add(ModItems.FLINT_DAGGER.get(), "Flint Dagger");
        add(ModItems.FLINT_HATCHET.get(), "Flint Hatchet");
        add(ModItems.FLINT_PICK.get(), "Flint Pick");
        add(ModItems.FLINT_SPADE.get(), "Flint Spade");
        add("itemGroup.better_punching", "Better Punching");
    }

    private void add(DamageSource pDamageSource, String pTranslation) {
        add("death.attack." + pDamageSource.msgId, pTranslation);
    }
}
