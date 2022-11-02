package darkorg.betterpunching.registry;

import darkorg.betterpunching.BetterPunching;
import darkorg.betterpunching.effect.BleedingEffect;
import darkorg.betterpunching.effect.SplinterEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, BetterPunching.MOD_ID);

    public static final RegistryObject<MobEffect> BLEEDING = EFFECTS.register("bleeding", () -> new BleedingEffect(MobEffectCategory.HARMFUL, 0x8A0303));
    public static final RegistryObject<MobEffect> SPLINTER = EFFECTS.register("splinter", () -> new SplinterEffect(MobEffectCategory.HARMFUL, 0xA3713F));

    public static void init(IEventBus pModBus) {
        EFFECTS.register(pModBus);
    }
}