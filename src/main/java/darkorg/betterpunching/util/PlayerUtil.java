package darkorg.betterpunching.util;

import darkorg.betterpunching.damagesource.DamageSources;
import darkorg.betterpunching.effect.ModEffects;
import darkorg.betterpunching.setup.ConfigHandler;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

public class PlayerUtil {
    public static void applyWrongToolPenalty(Player player) {
        hurtFists(player);
        applyPenaltyEffects(player);
    }

    public static void applySplinterPenalty(Player player) {
        applySplinterEffect(player);
        applyWrongToolPenalty(player);
    }

    public static void applyBleedingPenalty(Player player) {
        applyBleedingEffect(player);
        applyWrongToolPenalty(player);
    }

    private static void hurtFists(@NotNull Player player) {
        player.hurt(DamageSources.INVALID_PUNCHING, ConfigHandler.wrongToolDamage.get().floatValue());
    }

    private static void applySplinterEffect(@NotNull Player player) {
        player.addEffect(new MobEffectInstance(ModEffects.SPLINTER.get(), ConfigHandler.splinterDuration.get() * 20, ConfigHandler.splinterAmplifier.get(), false, false, true));
    }

    private static void applyBleedingEffect(@NotNull Player player) {
        player.addEffect(new MobEffectInstance(ModEffects.BLEEDING.get(), ConfigHandler.bleedingDuration.get() * 20, ConfigHandler.bleedingAmplifier.get(), false, false, true));
    }

    private static void applyPenaltyEffects(@NotNull Player player) {
        player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, ConfigHandler.weaknessDuration.get() * 20, ConfigHandler.weaknessAmplifier.get(), false, false, true));
        player.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, ConfigHandler.miningFatigueDuration.get() * 20, ConfigHandler.miningFatigueAmplifier.get(), false, false, true));
    }
}
