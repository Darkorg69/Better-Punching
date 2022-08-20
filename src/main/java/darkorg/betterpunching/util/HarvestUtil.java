package darkorg.betterpunching.util;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;

public class HarvestUtil {
    public static boolean isCorrectTool(ItemStack stack, BlockState state) {
        if (StateUtil.isSnowLayer(state)) return true;
        if (state.requiresCorrectToolForDrops()) return stack.isCorrectToolForDrops(state);
        if (StateUtil.isWood(state)) return StackUtil.canChopWood(stack);
        return true;
    }
}



