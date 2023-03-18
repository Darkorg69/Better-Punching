package darkorg.betterpunching.util;

import darkorg.betterpunching.BetterPunching;
import darkorg.betterpunching.config.ModConfig;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class ConfigUtil {
    public static List<Block> getBlacklist() {
        List<Block> blacklist = new ArrayList<>();

        String config = ModConfig.GAMEPLAY.blockBlacklist.get();

        if (!config.isEmpty()) {
            if (config.matches("^(\\w+:\\w+,)*(\\w+:\\w+)$")) {
                for (String entry : config.split(",")) {
                    String[] modName = entry.split(":");
                    ResourceLocation location = new ResourceLocation(modName[0], modName[1]);
                    Block block = ForgeRegistries.BLOCKS.getValue(location);
                    if (block != null) {
                        blacklist.add(block);
                    }
                }
            } else {
                BetterPunching.LOGGER.warn("Malformed blacklist value! " + "Cannot parse string `" + config + "`");
            }
        }

        return blacklist;
    }
}
