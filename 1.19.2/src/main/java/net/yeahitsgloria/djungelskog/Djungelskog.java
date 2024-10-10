// SPDX-FileCopyrightText: Copyright 2024 Gloria G. (yeah-its-gloria)
// SPDX-License-Identifier: BSD-2-Clause

package net.yeahitsgloria.djungelskog;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(Djungelskog.MODID)
public class Djungelskog {
    public static final String MODID = "djungelskog";

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MODID);

    public static final RegistryObject<EntityType<DjungelskogEntity>> DJUNGELSKOG_ENTITY = ENTITIES.register("djungelskog",
        () -> EntityType.Builder.of(DjungelskogEntity::new, MobCategory.CREATURE).sized(1.1F, 1.4F).updateInterval(1).build("djungelskog"));

    public Djungelskog() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ENTITIES.register(modEventBus);
        modEventBus.addListener(this::onEntityAttributeCreation);
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
        event.put(DJUNGELSKOG_ENTITY.get(), DjungelskogEntity.createAttributes().build());
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(DJUNGELSKOG_ENTITY.get(), DjungelskogRenderer::new);
        }
    }
}
