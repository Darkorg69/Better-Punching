package darkorg.betterpunching.util;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public class HarvestUtil {
    public static boolean isCorrectTool(ItemStack stack, BlockState state) {
        if (!StateUtil.isWood(state)) {
            if (state.requiresCorrectToolForDrops()) return stack.isCorrectToolForDrops(state);
            return true;
        }
        if (stack.getItem() instanceof AxeItem) return true;
        return stack.isCorrectToolForDrops(state);
    }
}



