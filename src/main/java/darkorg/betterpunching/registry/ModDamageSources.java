package darkorg.betterpunching.registry;

import net.minecraft.world.damagesource.DamageSource;

public class ModDamageSources {
    public static final DamageSource SPLINTER = new DamageSource("splinter").setScalesWithDifficulty();
    public static final DamageSource BLEEDING = new DamageSource("bleeding").setScalesWithDifficulty().bypassArmor();
    public static final DamageSource INVALID_PUNCHING = new DamageSource("invalid_punching").setScalesWithDifficulty();
}
