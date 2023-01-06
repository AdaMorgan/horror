package core;

import core.custom.MaskItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Main implements ModInitializer {
    public static final TagKey<Item> TAG_MASK = TagKey.of(Registry.ITEM_KEY, new Identifier(Main.MOD_ID, "masks"));
    public static final String MOD_ID = "mask";

    public static Item JASON;
    public static Item MYERS;
    public static Item KRUEGER;
    public static Item SCREAM;

    @Override
    public void onInitialize() {
        ItemGroup MASK = FabricItemGroupBuilder.build(new Identifier(Main.MOD_ID, "masks"), () -> new ItemStack(MYERS));

        JASON = Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "jason_mask"), new MaskItem(ArmorMaterials.GOLD, EquipmentSlot.HEAD, new FabricItemSettings().group(MASK)));
        MYERS = Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "myers_mask"), new MaskItem(ArmorMaterials.GOLD, EquipmentSlot.HEAD, new FabricItemSettings().group(MASK)));
        KRUEGER = Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "krueger_mask"), new MaskItem(ArmorMaterials.GOLD, EquipmentSlot.HEAD, new FabricItemSettings().group(MASK)));
        SCREAM = Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "scream_mask"), new MaskItem(ArmorMaterials.GOLD, EquipmentSlot.HEAD, new FabricItemSettings().group(MASK)));
    }
}
