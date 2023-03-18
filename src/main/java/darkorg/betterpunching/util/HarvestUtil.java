package darkorg.betterpunching.util;

import darkorg.betterpunching.config.ModConfig;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class HarvestUtil {
    public static boolean canHarvestBlock(PlayerEntity pPlayer, BlockState pState) {
        ItemStack stack = pPlayer.inventory.getSelected();
        if (StateUtil.isCactus(pState)) {
            if (stack.isEmpty()) {
                return pPlayer.isCrouching();
            }
        }
        return stack.isCorrectToolForDrops(pState) || !requiresCorrectToolForDrops(pState);
    }

    public static boolean requiresCorrectToolForDrops(BlockState pState) {
        //Handle some exceptions present in the vanilla game.
        //Swords
        if (StateUtil.isWeb(pState)) {
            return ModConfig.GAMEPLAY.cobwebRequiresCorrectTool.get();
        }
        //Shovel
        if (StateUtil.isSnow(pState)) {
            return ModConfig.GAMEPLAY.snowRequiresCorrectTool.get();
        }
        //Axe
        if (StateUtil.isWood(pState)) {
            return ModConfig.GAMEPLAY.woodRequiresCorrectTool.get();
        }

        return pState.requiresCorrectToolForDrops();
    }
}