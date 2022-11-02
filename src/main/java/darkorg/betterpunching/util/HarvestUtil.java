package darkorg.betterpunching.util;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public class HarvestUtil {
    public static boolean isInvalidTool(ItemStack stack, BlockState state) {
        if (StateUtil.isSnow(state)) return false;
        if (state.requiresCorrectToolForDrops()) return !stack.isCorrectToolForDrops(state);
        if (StateUtil.isWood(state)) return !StackUtil.canHarvestWood(stack);
        return false;
    }
}



