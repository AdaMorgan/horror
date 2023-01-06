package core;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.impl.client.rendering.ArmorRendererRegistryImpl;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.BakedModelManager;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.math.Vec3f;
import net.minecraft.util.registry.Registry;

public class Client implements ClientModInitializer {
    public static ItemConvertible[] armors = new ItemConvertible[] {
            Main.JASON,
            Main.KRUEGER,
            Main.SCREAM,
            Main.MYERS
    };

    @Override
    public void onInitializeClient() {
        ArmorRendererRegistryImpl.register((matrixStack, vertexConsumers, stack, entity, slot, light, contextModel) -> {
            matrixStack.push();
            contextModel.getHead().rotate(matrixStack);

            matrixStack.translate(0.0D, -0.25D, 0.0D);
            matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(180.0F));
            matrixStack.scale(0.625F, -0.625F, -0.625F);

            BakedModelManager modelManager = MinecraftClient.getInstance().getItemRenderer().getModels().getModelManager();
            BakedModel model = modelManager.getModel(new ModelIdentifier(Registry.ITEM.getId(stack.getItem()) + "2#inventory"));
            BakedModel model2 = model.getOverrides().apply(model, stack, (ClientWorld) entity.world, entity, entity.getId());
            ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
            itemRenderer.renderItem(stack, ModelTransformation.Mode.HEAD, false, matrixStack, vertexConsumers, light, LivingEntityRenderer.getOverlay(entity, 0.0F), model2);
            matrixStack.pop();
        }, armors);
    }
}