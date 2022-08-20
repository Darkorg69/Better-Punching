package darkorg.betterpunching.util;

import darkorg.betterpunching.damagesource.DamageSources;
import darkorg.betterpunching.effect.ModEffects;
import darkorg.betterpunching.setup.ConfigHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import org.antlr.v4.runtime.misc.NotNull;

public class PlayerUtil {
    public static void applyWrongToolPenalty(PlayerEntity player) {
        hurtFists(player);
        applyPenaltyEffects(player);
    }

    public static void applySplinterPenalty(PlayerEntity player) {
        applySplinterEffect(player);
        applyWrongToolPenalty(player);
    }

    public static void applyBleedingPenalty(PlayerEntity player) {
        applyBleedingEffect(player);
        applyWrongToolPenalty(player);
    }

    private static void hurtFists(PlayerEntity player) {
        player.hurt(DamageSources.INVALID_PUNCHING, ConfigHandler.wrongToolDamage.get().floatValue());
    }

    private static void applySplinterEffect(@NotNull PlayerEntity player) {
        player.addEffect(new EffectInstance(ModEffects.SPLINTER.get(), ConfigHandler.splinterDuration.get() * 20, ConfigHandler.splinterAmplifier.get(), false, false, true));
    }

    private static void applyBleedingEffect(@NotNull PlayerEntity player) {
        player.addEffect(new EffectInstance(ModEffects.BLEEDING.get(), ConfigHandler.bleedingDuration.get() * 20, ConfigHandler.bleedingAmplifier.get(), false, false, true));
    }

    private static void applyPenaltyEffects(@NotNull PlayerEntity player) {
        player.addEffect(new EffectInstance(Effects.WEAKNESS, ConfigHandler.weaknessDuration.get() * 20, ConfigHandler.weaknessAmplifier.get(), false, false, true));
        player.addEffect(new EffectInstance(Effects.DIG_SLOWDOWN, ConfigHandler.miningFatigueDuration.get() * 20, ConfigHandler.miningFatigueAmplifier.get(), false, false, true));
    }
}
