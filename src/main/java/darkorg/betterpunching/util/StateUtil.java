package darkorg.betterpunching.util;

import net.minecraft.block.BlockState;
import net.minecraft.block.HugeMushroomBlock;
import net.minecraft.block.material.Material;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;

public class StateUtil {
    public static boolean isBlacklisted(BlockState pState) {
        return ConfigUtil.getBlacklist().contains(pState.getBlock());
    }

    public static boolean isInstantBreak(BlockState pState) {
        return pState.getBlock().getSpeedFactor() == 0.0F;
    }

    public static boolean isGlass(BlockState pState) {
        return pState.is(Tags.Blocks.GLASS) || pState.is(Tags.Blocks.GLASS_PANES);
    }

    public static boolean isCactus(BlockState pState) {
        return pState.getMaterial() == Material.CACTUS;
    }

    public static boolean isWeb(BlockState pState) {
        return pState.getMaterial() == Material.WEB;
    }

    public static boolean isSnow(BlockState pState) {
        Material material = pState.getMaterial();
        return material == Material.SNOW || material == Material.TOP_SNOW;
    }

    public static boolean isWood(BlockState pState) {
        return MaterialUtil.isWood(pState.getMaterial()) && isActuallyWood(pState);
    }

    private static boolean isActuallyWood(BlockState pState) {
        return !(pState.getBlock() instanceof HugeMushroomBlock || pState.is(BlockTags.BANNERS));
    }
}
