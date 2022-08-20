package darkorg.betterpunching.util;

import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;

public class StateUtil {
    public static boolean isSnowLayer(BlockState state) {
        return state.getMaterial() == Material.TOP_SNOW;
    }

    public static boolean isCactus(BlockState state) {
        return state.getMaterial() == Material.CACTUS;
    }

    public static boolean isWood(BlockState state) {
        return state.getMaterial() == Material.WOOD || state.getMaterial() == Material.NETHER_WOOD;
    }

    public static boolean isGlass(BlockState state) {
        return state.getMaterial() == Material.GLASS || state.getMaterial() == Material.BUILDABLE_GLASS;
    }
}
