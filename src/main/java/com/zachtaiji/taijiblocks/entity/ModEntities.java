package com.zachtaiji.taijiblocks.entity;

import com.zachtaiji.taijiblocks.TaijiBlocks;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {

    public static final EntityType<FlamingoEntity> FLAMINGO = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(TaijiBlocks.MOD_ID, "flamingo"),
            EntityType.Builder.create(FlamingoEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.6f, 1.4f)
                    .build()
    );

    public static void registerModEntities() {
        TaijiBlocks.LOGGER.info("Registering mod entities for " + TaijiBlocks.MOD_ID);
        FabricDefaultAttributeRegistry.register(FLAMINGO, FlamingoEntity.createFlamingoAttributes());
    }
}
