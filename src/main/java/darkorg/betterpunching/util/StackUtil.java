package darkorg.betterpunching.util;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ToolActions;

public class StackUtil {
    public static boolean canHarvestWood(ItemStack pItemStack) {
        return pItemStack.getItem() instanceof AxeItem || ToolActions.DEFAULT_AXE_ACTIONS.stream().anyMatch(pItemStack::canPerformAction);
    }
}
