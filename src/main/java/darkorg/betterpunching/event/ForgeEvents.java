package darkorg.betterpunching.event;

import darkorg.betterpunching.BetterPunching;
import darkorg.betterpunching.util.HarvestUtil;
import darkorg.betterpunching.util.PlayerUtil;
import darkorg.betterpunching.util.StateUtil;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BetterPunching.MOD_ID)

public class ForgeEvents {
    @SubscribeEvent
    public static void onHarvestCheck(PlayerEvent.HarvestCheck event) {
        event.setCanHarvest(HarvestUtil.canHarvestBlock(event.getPlayer(), event.getTargetBlock()));
    }

    @SubscribeEvent
    public static void onBreakSpeed(PlayerEvent.BreakSpeed event) {
        BlockState state = event.getState();

        if (StateUtil.isBlacklisted(state) || StateUtil.isInstantBreak(state)) {
            return;
        }

        PlayerEntity player = event.getPlayer();
        ItemStack stack = player.getMainHandItem();

        if (StateUtil.isGlass(state)) {
            if (stack.isEmpty()) {
                PlayerUtil.addBleeding(player);
                PlayerUtil.applyGlassPenalty(player);
            }
            event.setNewSpeed(Float.MAX_VALUE);
            return;
        }

        if (!HarvestUtil.canHarvestBlock(player, state)) {
            if (stack.isEmpty()) {
                if (StateUtil.isWood(state) || StateUtil.isCactus(state)) {
                    PlayerUtil.addSplinter(player);
                }
                PlayerUtil.applyPunchingPenalty(player);
            }
            event.setCanceled(true);
        }
    }
}
