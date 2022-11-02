package darkorg.betterpunching.effect;

import darkorg.betterpunching.config.ServerConfig;
import darkorg.betterpunching.registry.ModDamageSources;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class BleedingEffect extends Effect {
    public BleedingEffect(EffectType pEffectType, int pColor) {
        super(pEffectType, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        pLivingEntity.hurt(ModDamageSources.BLEEDING, ServerConfig.splinterDamage.get().floatValue() * (pAmplifier + 1));
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        int i = 40 >> pAmplifier;
        if (i > 0) {
            return pDuration % i == 0;
        }
        return true;
    }
}
