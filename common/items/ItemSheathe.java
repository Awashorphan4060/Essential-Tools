package awashorphan4060.essentialtools.common.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSheathe extends Item
{
public ItemSheathe(int id)
{
	
super(id);
this.maxStackSize = 1;
this.setCreativeTab(CreativeTabs.tabTools);
}

//@Override
//@SideOnly(Side.CLIENT)
//public void registerIcons(IconRegister iconRegister)
//{
//itemIcon = iconRegister.registerIcon("essentialtools:" + "Lime");
//}
}