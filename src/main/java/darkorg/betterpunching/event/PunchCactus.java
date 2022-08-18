package darkorg.betterpunching.event;

import darkorg.betterpunching.setup.ConfigHandler;
import darkorg.betterpunching.util.PlayerUtil;
import darkorg.betterpunching.util.StateUtil;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PunchCactus {
    @SubscribeEvent
    public void onPunchCactus(PlayerEvent.BreakSpeed event) {
        if (ConfigHandler.punchCactusEnabled.get()) {
            BlockState state = event.getState();
            if (StateUtil.isCactus(state)) {
                Player player = event.getEntity();
                ItemStack stack = player.getMainHandItem();
                if (stack.isEmpty()) {
                    if (!player.isCrouching()) {
                        PlayerUtil.applySplinterPenalty(player);
                        event.setNewSpeed(-1.0F);
                    }
                }
            }
        }
    }


}
