package darkorg.betterpunching.event;

import darkorg.betterpunching.BetterPunching;
import darkorg.betterpunching.config.ServerConfig;
import darkorg.betterpunching.util.HarvestUtil;
import darkorg.betterpunching.util.PlayerUtil;
import darkorg.betterpunching.util.StateUtil;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BetterPunching.MOD_ID)
public class ForgeEvents {
    @SubscribeEvent
    public static void onPunchCactus(PlayerEvent.BreakSpeed event) {
        if (ServerConfig.punchCactusEnabled.get()) {
            if (StateUtil.isCactus(event.getState())) {
                Player player = event.getEntity();
                if (player.getMainHandItem().isEmpty()) {
                    if (!player.isCrouching()) {
                        PlayerUtil.applySplinterPenalty(player);
                        event.setNewSpeed(-1.0F);
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onPunchGlass(PlayerEvent.BreakSpeed event) {
        if (ServerConfig.punchGlassEnabled.get()) {
            if (StateUtil.isGlass(event.getState())) {
                Player player = event.getEntity();
                if (player.getMainHandItem().isEmpty()) PlayerUtil.applyBleedingPenalty(player);
                event.setNewSpeed(Float.MAX_VALUE);
            }
        }
    }

    @SubscribeEvent
    public static void onPunchWood(PlayerEvent.BreakSpeed event) {
        if (ServerConfig.punchWoodEnabled.get()) {
            BlockState state = event.getState();
            if (StateUtil.isWood(state)) {
                Player player = event.getEntity();
                ItemStack stack = player.getMainHandItem();
                if (HarvestUtil.isInvalidTool(stack, state)) {
                    if (stack.isEmpty()) PlayerUtil.applySplinterPenalty(player);
                    event.setNewSpeed(-1.0F);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onInvalidPunch(PlayerEvent.BreakSpeed event) {
        if (ServerConfig.invalidPunchEnabled.get()) {
            BlockState state = event.getState();
            if (StateUtil.isInstantBreak(state)) {
                Player player = event.getEntity();
                ItemStack stack = player.getMainHandItem();
                if (HarvestUtil.isInvalidTool(stack, state)) {
                    if (!state.canHarvestBlock(event.getEntity().level, event.getPos(), player)) {
                        if (stack.isEmpty()) PlayerUtil.applyInvalidPunch(player);
                        event.setNewSpeed(-1.0F);
                    }
                }
            }
        }
    }
}
