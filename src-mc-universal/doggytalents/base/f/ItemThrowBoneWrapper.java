package doggytalents.base.f;

import doggytalents.base.other.ItemThrowBoneBridge;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * 1.12 Code
 */
public class ItemThrowBoneWrapper extends ItemThrowBoneBridge {

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		return this.onItemRightClickGENERAL(worldIn, playerIn, handIn);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
	    if(this.isInCreativeTab(tab)) {
	    	for(int i = 0; i < 4; i++)
				subItems.add(new ItemStack(this, 1, i));
	    }
    }
}
