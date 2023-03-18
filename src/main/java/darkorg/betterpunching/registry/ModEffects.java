package darkorg.betterpunching.registry;

import darkorg.betterpunching.BetterPunching;
import darkorg.betterpunching.effect.BleedingEffect;
import darkorg.betterpunching.effect.SplinterEffect;
import net.minecraft.potion.Effect;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEffects {
    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, BetterPunching.MOD_ID);

    public static final RegistryObject<Effect> BLEEDING = EFFECTS.register("bleeding", BleedingEffect::new);
    public static final RegistryObject<Effect> SPLINTER = EFFECTS.register("splinter", SplinterEffect::new);

    public static void init() {
        EFFECTS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}