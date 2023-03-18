package darkorg.betterpunching.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ToolItem;
import net.minecraftforge.common.ToolType;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Set;

@Mixin(AxeItem.class)
public abstract class MixinAxeItem extends ToolItem {
    public MixinAxeItem(float pAttackDamage, float pAttackSpeed, IItemTier pTier, Set<Block> pBlocks, Properties pProperties) {
        super(pAttackDamage, pAttackSpeed, pTier, pBlocks, pProperties);
    }

    @Override
    public boolean isCorrectToolForDrops(BlockState pState) {
        return pState.getHarvestTool() == ToolType.AXE;
    }
}
