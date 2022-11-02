package darkorg.betterpunching.util;

import darkorg.betterpunching.config.ServerConfig;
import darkorg.betterpunching.registry.ModDamageSources;
import darkorg.betterpunching.registry.ModEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class PlayerUtil {
    public static void applySplinterPenalty(PlayerEntity player) {
        addSplinterEffect(player);
        applyInvalidPunch(player);
    }

    public static void applyBleedingPenalty(PlayerEntity player) {
        addBleedingEffect(player);
        applyInvalidPunch(player);
    }


    public static void applyInvalidPunch(PlayerEntity pPlayer) {
        pPlayer.hurt(ModDamageSources.INVALID_PUNCHING, ServerConfig.invalidPunchDamage.get().floatValue());
        addWeaknessAndMiningFatigue(pPlayer);
    }

    public static void addSplinterEffect(PlayerEntity pPlayer) {
        pPlayer.addEffect(new EffectInstance(ModEffects.SPLINTER.get(), ServerConfig.splinterDuration.get() * 20, ServerConfig.splinterAmplifier.get(), false, false, true));
    }

    public static void addBleedingEffect(PlayerEntity pPlayer) {
        pPlayer.addEffect(new EffectInstance(ModEffects.BLEEDING.get(), ServerConfig.bleedingDuration.get() * 20, ServerConfig.bleedingAmplifier.get(), false, false, true));
    }

    public static void addWeaknessAndMiningFatigue(PlayerEntity pPlayer) {
        pPlayer.addEffect(new EffectInstance(Effects.WEAKNESS, ServerConfig.weaknessDuration.get() * 20, ServerConfig.weaknessAmplifier.get(), false, false, true));
        pPlayer.addEffect(new EffectInstance(Effects.DIG_SLOWDOWN, ServerConfig.miningFatigueDuration.get() * 20, ServerConfig.miningFatigueAmplifier.get(), false, false, true));
    }
}
