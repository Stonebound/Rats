package com.github.alexthe666.rats.server.world.structure;

import com.mojang.datafixers.Dynamic;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.ScatteredStructure;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.function.Function;

public class RatlantisRuinsStructure extends ScatteredStructure<NoFeatureConfig> {
    public RatlantisRuinsStructure(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i51440_1_) {
        super(p_i51440_1_);
        this.setRegistryName("rats:ratlantis_ruins_structure");
    }

    public String getStructureName() {
        return "RatlantisRuins";
    }

    public int getSize() {
        return 4;
    }

    public Structure.IStartFactory getStartFactory() {
        return RatlantisRuinsStructure.Start::new;
    }

    protected int getSeedModifier() {
        return 123456789;
    }

    protected int getBiomeFeatureDistance(ChunkGenerator<?> chunkGenerator) {
        return 3;//16
    }

    protected int getBiomeFeatureSeparation(ChunkGenerator<?> chunkGenerator) {
        return 2;//8
    }

    public static class Start extends StructureStart {
        public Start(Structure<?> p_i225817_1_, int p_i225817_2_, int p_i225817_3_, MutableBoundingBox p_i225817_4_, int p_i225817_5_, long p_i225817_6_) {
            super(p_i225817_1_, p_i225817_2_, p_i225817_3_, p_i225817_4_, p_i225817_5_, p_i225817_6_);
        }

        public void init(ChunkGenerator<?> generator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn) {
            Rotation rotation = Rotation.values()[this.rand.nextInt(Rotation.values().length)];
            BlockPos blockpos = new BlockPos(chunkX * 16, 64, chunkZ * 16);
            RatlantisRuinsPiece.func_204760_a(templateManagerIn, blockpos, rotation, this.components, this.rand);
            this.recalculateStructureSize();
        }
    }

}
