package darkorg.betterpunching.util;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public class HarvestUtil {
    public static boolean isCorrectTool(ItemStack stack, BlockState state) {
        if (StateUtil.isSnowLayer(state)) return true;
        if (state.requiresCorrectToolForDrops()) return stack.isCorrectToolForDrops(state);
        if (StateUtil.isWood(state)) return StackUtil.canChopWood(stack);
        return true;
    }
}



