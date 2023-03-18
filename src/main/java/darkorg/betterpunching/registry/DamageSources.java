package darkorg.betterpunching.registry;

import net.minecraft.util.DamageSource;

public class DamageSources {
    public static final DamageSource SPLINTER = new DamageSource("splinter").setScalesWithDifficulty().bypassArmor();
    public static final DamageSource BLEEDING = new DamageSource("bleeding").setScalesWithDifficulty().bypassArmor();
    public static final DamageSource PUNCHING_BLOCKS = new DamageSource("punching_blocks").setScalesWithDifficulty();
}
