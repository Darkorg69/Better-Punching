package darkorg.betterpunching.util;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;

public class HarvestUtil {
    public static boolean isInvalidTool(ItemStack stack, BlockState state) {
        if (StateUtil.isSnow(state)) return false;
        if (state.requiresCorrectToolForDrops()) return !stack.isCorrectToolForDrops(state);
        if (StateUtil.isWood(state)) return !StackUtil.canHarvestWood(stack);
        return false;
    }
}



