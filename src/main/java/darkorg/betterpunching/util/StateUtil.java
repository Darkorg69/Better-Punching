package darkorg.betterpunching.util;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class StateUtil {
    public static boolean isCactus(BlockState state) {
        return state.getMaterial() == Material.CACTUS;
    }

    public static boolean isGlass(BlockState state) {
        return state.getMaterial() == Material.GLASS || state.getMaterial() == Material.BUILDABLE_GLASS;
    }

    public static boolean isSnow(BlockState state) {
        return state.getMaterial() == Material.SNOW || state.getMaterial() == Material.TOP_SNOW;
    }

    public static boolean isWood(BlockState state) {
        return state.getMaterial() == Material.WOOD || state.getMaterial() == Material.NETHER_WOOD;
    }

    public static boolean isInstantBreak(BlockState state) {
        return state.getBlock().getSpeedFactor() != 0.0F;
    }
}
