package darkorg.betterpunching.util;

import darkorg.betterpunching.config.ModConfig;
import darkorg.betterpunching.registry.DamageSources;
import darkorg.betterpunching.registry.ModEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;

public class PlayerUtil {
    public static void applyPunchingPenalty(PlayerEntity pPlayer) {
        pPlayer.hurt(DamageSources.PUNCHING_BLOCKS, ModConfig.PENALTIES.punchingBlocksDamage.get().floatValue());
    }

    public static void applyGlassPenalty(PlayerEntity pPlayer) {
        pPlayer.hurt(DamageSources.PUNCHING_BLOCKS, ModConfig.PENALTIES.punchingBlocksDamage.get().floatValue());
    }

    public static void addSplinter(PlayerEntity pPlayer) {
        pPlayer.addEffect(new EffectInstance(ModEffects.SPLINTER.get(), ModConfig.EFFECTS.splinterDuration.get(), ModConfig.EFFECTS.splinterAmplifier.get(), false, false, true));
    }

    public static void addBleeding(PlayerEntity pPlayer) {
        pPlayer.addEffect(new EffectInstance(ModEffects.BLEEDING.get(), ModConfig.EFFECTS.bleedingDuration.get(), ModConfig.EFFECTS.bleedingAmplifier.get(), false, false, true));
    }
}
