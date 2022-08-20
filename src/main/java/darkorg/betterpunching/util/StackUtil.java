package darkorg.betterpunching.util;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ToolActions;

public class StackUtil {
    public static boolean canChopWood(ItemStack stack) {
        return stack.getItem() instanceof AxeItem || stack.canPerformAction(ToolActions.AXE_DIG);
    }
}
