package darkorg.betterpunching.event;

import darkorg.betterpunching.setup.ConfigHandler;
import darkorg.betterpunching.util.HarvestUtil;
import darkorg.betterpunching.util.PlayerUtil;
import darkorg.betterpunching.util.StateUtil;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PunchWood {
    @SubscribeEvent
    public void breakSpeed(PlayerEvent.BreakSpeed event) {
        if (ConfigHandler.punchWoodEnabled.get()) {
            BlockState state = event.getState();
            if (StateUtil.isWood(state)) {
                PlayerEntity player = event.getPlayer();
                ItemStack stack = player.getMainHandItem();
                if (!HarvestUtil.isCorrectTool(stack, state)) {
                    if (stack.isEmpty()) PlayerUtil.applySplinterPenalty(player);
                    event.setNewSpeed(-1.0F);
                }
            }
        }
    }

}