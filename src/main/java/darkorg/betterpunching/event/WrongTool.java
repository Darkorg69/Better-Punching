package darkorg.betterpunching.event;

import darkorg.betterpunching.setup.ConfigHandler;
import darkorg.betterpunching.util.HarvestUtil;
import darkorg.betterpunching.util.PlayerUtil;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class WrongTool {
    @SubscribeEvent
    public void breakSpeed(PlayerEvent.BreakSpeed event) {
        if (ConfigHandler.wrongToolEnabled.get()) {
            BlockState state = event.getState();
            if (state.getBlock().getSpeedFactor() != 0.0F) {
                PlayerEntity player = event.getPlayer();
                ItemStack stack = player.getMainHandItem();
                if (!HarvestUtil.isCorrectTool(stack, state)) {
                    BlockPos pos = event.getPos();
                    World world = player.getCommandSenderWorld();
                    if (!state.canHarvestBlock(world, pos, player)) {
                        if (stack.isEmpty()) PlayerUtil.applyWrongToolPenalty(player);
                        event.setNewSpeed(-1.0F);
                    }
                }
            }
        }
    }
}
