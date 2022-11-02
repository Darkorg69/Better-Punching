package darkorg.betterpunching.event;

import darkorg.betterpunching.BetterPunching;
import darkorg.betterpunching.config.ServerConfig;
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
    public static void onPunchCactus(PlayerEvent.BreakSpeed event) {
        if (ServerConfig.punchCactusEnabled.get()) {
            if (StateUtil.isCactus(event.getState())) {
                PlayerEntity player = event.getPlayer();
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
                PlayerEntity player = event.getPlayer();
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
                PlayerEntity player = event.getPlayer();
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
                PlayerEntity player = event.getPlayer();
                ItemStack stack = player.getMainHandItem();
                if (HarvestUtil.isInvalidTool(stack, state)) {
                    if (!state.canHarvestBlock(event.getPlayer().level, event.getPos(), player)) {
                        if (stack.isEmpty()) PlayerUtil.applyInvalidPunch(player);
                        event.setNewSpeed(-1.0F);
                    }
                }
            }
        }
    }
}
