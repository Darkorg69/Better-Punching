package darkorg.betterpunching.effect;

import darkorg.betterpunching.config.ServerConfig;
import darkorg.betterpunching.registry.ModDamageSources;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class BleedingEffect extends MobEffect {
    public BleedingEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
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
