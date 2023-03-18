package darkorg.betterpunching.util;

import net.minecraft.block.material.Material;

public class MaterialUtil {
    public static boolean isWood(Material pMaterial) {
        return pMaterial == Material.WOOD || pMaterial == Material.NETHER_WOOD;
    }
}
