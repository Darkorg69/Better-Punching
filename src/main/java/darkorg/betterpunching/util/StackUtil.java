package darkorg.betterpunching.util;

import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ToolType;

public class StackUtil {
    public static boolean canChopWood(ItemStack stack) {
        return stack.getItem() instanceof AxeItem || stack.getToolTypes().contains(ToolType.AXE);
    }
}
