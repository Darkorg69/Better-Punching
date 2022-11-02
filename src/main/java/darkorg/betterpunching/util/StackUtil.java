package darkorg.betterpunching.util;

import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ToolType;

public class StackUtil {
    public static boolean canHarvestWood(ItemStack pItemStack) {
        return pItemStack.getItem() instanceof AxeItem || pItemStack.getToolTypes().contains(ToolType.AXE);
    }
}
