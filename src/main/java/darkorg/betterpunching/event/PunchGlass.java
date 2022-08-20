package darkorg.betterpunching.event;

import darkorg.betterpunching.setup.ConfigHandler;
import darkorg.betterpunching.util.PlayerUtil;
import darkorg.betterpunching.util.StateUtil;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PunchGlass {
    @SubscribeEvent
    public void breakSpeed(PlayerEvent.BreakSpeed event) {
        if (ConfigHandler.punchGlassEnabled.get()) {
            BlockState state = event.getState();
            if (StateUtil.isGlass(state)) {
                PlayerEntity player = event.getPlayer();
                ItemStack stack = player.getMainHandItem();
                if (stack.isEmpty()) PlayerUtil.applyBleedingPenalty(player);
                event.setNewSpeed(Float.MAX_VALUE);
            }
        }
    }

}