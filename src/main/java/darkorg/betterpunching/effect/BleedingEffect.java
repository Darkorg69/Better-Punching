package darkorg.betterpunching.effect;

import darkorg.betterpunching.config.ModConfig;
import darkorg.betterpunching.registry.DamageSources;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class BleedingEffect extends Effect {
    public BleedingEffect() {
        super(EffectType.HARMFUL, 0x8A0303);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        pLivingEntity.hurt(DamageSources.BLEEDING, ModConfig.EFFECTS.bleedingDamage.get().floatValue() * (ModConfig.EFFECTS.bleedingAmplifier.get() + 1));
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        int tickRate = ModConfig.EFFECTS.bleedingTickRate.get() >> pAmplifier;
        return tickRate == 0 || pDuration % tickRate == 0;
    }
}
