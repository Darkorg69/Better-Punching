package darkorg.betterpunching.registry;

import darkorg.betterpunching.BetterPunching;
import darkorg.betterpunching.effect.BleedingEffect;
import darkorg.betterpunching.effect.SplinterEffect;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEffects {
    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, BetterPunching.MOD_ID);

    public static final RegistryObject<Effect> BLEEDING = EFFECTS.register("bleeding", () -> new BleedingEffect(EffectType.HARMFUL, 0x8A0303));
    public static final RegistryObject<Effect> SPLINTER = EFFECTS.register("splinter", () -> new SplinterEffect(EffectType.HARMFUL, 0xA3713F));

    public static void init(IEventBus pModBus) {
        EFFECTS.register(pModBus);
    }
}