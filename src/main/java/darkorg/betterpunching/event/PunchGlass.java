package darkorg.betterpunching.event;

import darkorg.betterpunching.setup.ConfigHandler;
import darkorg.betterpunching.util.PlayerUtil;
import darkorg.betterpunching.util.StateUtil;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PunchGlass {
    @SubscribeEvent
    public void breakSpeed(PlayerEvent.BreakSpeed event) {
        if (ConfigHandler.punchGlassEnabled.get()) {
            BlockState state = event.getState();
            if (StateUtil.isGlass(state)) {
                Player player = event.getEntity();
                ItemStack stack = player.getMainHandItem();
                if (stack.isEmpty()) PlayerUtil.applyBleedingPenalty(player);
                event.setNewSpeed(Float.MAX_VALUE);
            }
        }
    }

}