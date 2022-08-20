package darkorg.betterpunching.damagesource;

import net.minecraft.util.DamageSource;

public class DamageSources {
    public static final DamageSource SPLINTER = new DamageSource("splinter").setScalesWithDifficulty();
    public static final DamageSource BLEEDING = new DamageSource("bleeding").setScalesWithDifficulty().bypassArmor();
    public static final DamageSource INVALID_PUNCHING = new DamageSource("invalid_punching").setScalesWithDifficulty();
}
