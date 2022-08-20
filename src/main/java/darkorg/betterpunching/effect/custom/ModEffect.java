package darkorg.betterpunching.effect.custom;

import darkorg.betterpunching.damagesource.DamageSources;
import darkorg.betterpunching.effect.ModEffects;
import darkorg.betterpunching.setup.ConfigHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class ModEffect extends Effect {
    public ModEffect(EffectType pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (this == ModEffects.SPLINTER.get()) {
            pLivingEntity.hurt(DamageSources.SPLINTER, ConfigHandler.splinterDamage.get().floatValue() * (pAmplifier + 1));
        }
        if (this == ModEffects.BLEEDING.get()) {
            pLivingEntity.hurt(DamageSources.BLEEDING, ConfigHandler.splinterDamage.get().floatValue() * (pAmplifier + 1));
        }
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        if (this == ModEffects.SPLINTER.get()) {
            int i = 40 >> pAmplifier;
            if (i > 0) {
                return pDuration % i == 0;
            }
            return true;
        }
        if (this == ModEffects.BLEEDING.get()) {
            int i = 25 >> pAmplifier;
            if (i > 0) {
                return pDuration % i == 0;
            }
            return true;
        }
        return super.isDurationEffectTick(pDuration, pAmplifier);
    }
}
