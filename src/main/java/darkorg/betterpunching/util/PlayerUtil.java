package darkorg.betterpunching.util;

import darkorg.betterpunching.config.ServerConfig;
import darkorg.betterpunching.registry.ModDamageSources;
import darkorg.betterpunching.registry.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;

public class PlayerUtil {
    public static void applySplinterPenalty(Player player) {
        addSplinterEffect(player);
        applyInvalidPunch(player);
    }

    public static void applyBleedingPenalty(Player player) {
        addBleedingEffect(player);
        applyInvalidPunch(player);
    }

    public static void applyInvalidPunch(Player pPlayer) {
        pPlayer.hurt(ModDamageSources.INVALID_PUNCHING, ServerConfig.invalidPunchDamage.get().floatValue());
        addWeaknessAndMiningFatigue(pPlayer);
    }

    public static void addSplinterEffect(Player pPlayer) {
        pPlayer.addEffect(new MobEffectInstance(ModEffects.SPLINTER.get(), ServerConfig.splinterDuration.get() * 20, ServerConfig.splinterAmplifier.get(), false, false, true));
    }

    public static void addBleedingEffect(Player pPlayer) {
        pPlayer.addEffect(new MobEffectInstance(ModEffects.BLEEDING.get(), ServerConfig.bleedingDuration.get() * 20, ServerConfig.bleedingAmplifier.get(), false, false, true));
    }

    public static void addWeaknessAndMiningFatigue(Player pPlayer) {
        pPlayer.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, ServerConfig.weaknessDuration.get() * 20, ServerConfig.weaknessAmplifier.get(), false, false, true));
        pPlayer.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, ServerConfig.miningFatigueDuration.get() * 20, ServerConfig.miningFatigueAmplifier.get(), false, false, true));
    }
}
