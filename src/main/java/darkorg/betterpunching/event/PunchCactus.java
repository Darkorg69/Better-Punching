package darkorg.betterpunching.event;

import darkorg.betterpunching.setup.ConfigHandler;
import darkorg.betterpunching.util.PlayerUtil;
import darkorg.betterpunching.util.StateUtil;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PunchCactus {
    @SubscribeEvent
    public void onPunchCactus(PlayerEvent.BreakSpeed event) {
        if (ConfigHandler.punchCactusEnabled.get()) {
            BlockState state = event.getState();
            if (StateUtil.isCactus(state)) {
                PlayerEntity player = event.getPlayer();
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
