package darkorg.betterpunching.event;

import darkorg.betterpunching.setup.ConfigHandler;
import darkorg.betterpunching.util.HarvestUtil;
import darkorg.betterpunching.util.PlayerUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Optional;

public class WrongTool {
    @SubscribeEvent
    public void breakSpeed(PlayerEvent.BreakSpeed event) {
        if (ConfigHandler.wrongToolEnabled.get()) {
            BlockState state = event.getState();
            if (state.getBlock().getSpeedFactor() != 0.0F) {
                Player player = event.getEntity();
                ItemStack stack = player.getMainHandItem();
                if (!HarvestUtil.isCorrectTool(stack, state)) {
                    Optional<BlockPos> posOptional = event.getPosition();
                    Level level = player.getLevel();
                    if (!state.canHarvestBlock(level, posOptional.get(), player)) {
                        if (stack.isEmpty()) PlayerUtil.applyWrongToolPenalty(player);
                        event.setNewSpeed(-1.0F);
                    }
                }
            }
        }
    }
}
