package darkorg.betterpunching.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ToolItem;
import net.minecraftforge.common.ToolType;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Set;

@Mixin(HoeItem.class)
public abstract class MixinHoeItem extends ToolItem {
    public MixinHoeItem(float pAttackDamage, float pAttackSpeed, IItemTier pTier, Set<Block> pBlocks, Properties pProperties) {
        super(pAttackDamage, pAttackSpeed, pTier, pBlocks, pProperties);
    }

    @Override
    public boolean isCorrectToolForDrops(BlockState pBlock) {
        return pBlock.getHarvestTool() == ToolType.HOE;
    }
}
