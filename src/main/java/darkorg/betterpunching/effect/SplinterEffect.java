package darkorg.betterpunching.effect;

import darkorg.betterpunching.config.ModConfig;
import darkorg.betterpunching.registry.DamageSources;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class SplinterEffect extends Effect {
    public SplinterEffect() {
        super(EffectType.HARMFUL, 0xA3713F);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        pLivingEntity.hurt(DamageSources.SPLINTER, ModConfig.EFFECTS.splinterDamage.get().floatValue() * (pAmplifier + 1));
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        int tickRate = ModConfig.EFFECTS.splinterTickRate.get() >> pAmplifier;
        return tickRate == 0 || pDuration % tickRate == 0;
    }
}
