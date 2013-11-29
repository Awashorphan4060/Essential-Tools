
package awashorphan4060.essentialtools.common; //The package your mod is in

import net.minecraft.item.Item;
import awashorphan4060.essentialtools.common.handlers.EssentialToolsClientPacketHandler;
import awashorphan4060.essentialtools.common.handlers.EssentialToolsServerPacketHandler;
import awashorphan4060.essentialtools.common.items.ItemSheathe;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

@NetworkMod(clientSideRequired=true,serverSideRequired=true, //Whether client side and server side are needed
clientPacketHandlerSpec = @SidedPacketHandler(channels = {"EssentialTools"}, packetHandler = EssentialToolsClientPacketHandler.class), //For clientside packet handling
serverPacketHandlerSpec = @SidedPacketHandler(channels = {"EssentialTools"}, packetHandler = EssentialToolsServerPacketHandler.class)) //For serverside packet handling

//MOD BASICS
@Mod(modid="EssentialTools",name="Tutorial Mod",version="1.0.0")

public class EssentialTools {

@Instance("EssentialTools") //The instance, this is very important later on
public static EssentialTools instance = new EssentialTools();

@SidedProxy(clientSide = "awashorphan4060.essentialtools.client.EssentialToolsClientProxy", serverSide = "awashorphan4060.essentialtools.common.EssentialToolsCommonProxy") //Tells Forge the location of your proxies
public static EssentialToolsCommonProxy proxy;

//Items
public static Item Sheathe;

@PreInit
public void PreInit(FMLPreInitializationEvent e){
	//ITEMS
	Sheathe = new ItemSheathe(5000).setUnlocalizedName("Sheathe");
}

@Init
public void InitEssentialTools(FMLInitializationEvent event){ //Your main initialization method
	//ITEMS (METHOD)
	proxy.registerItems();

//MULTIPLAYER ABILITY
NetworkRegistry.instance().registerGuiHandler(this, proxy); //Registers the class that deals with GUI data

}
}