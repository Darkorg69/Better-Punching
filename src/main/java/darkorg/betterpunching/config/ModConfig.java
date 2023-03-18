package darkorg.betterpunching.config;


import darkorg.betterpunching.BetterPunching;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.*;
import net.minecraftforge.fml.ModLoadingContext;
import org.apache.commons.lang3.tuple.Pair;

import static net.minecraftforge.fml.config.ModConfig.Type;

public class ModConfig {
    public static final Gameplay GAMEPLAY;
    public static final Effects EFFECTS;
    public static final Penalties PENALTIES;

    static final ForgeConfigSpec gameplaySpec;
    static final ForgeConfigSpec effectsSpec;
    static final ForgeConfigSpec penaltiesSpec;

    static {
        final Pair<Gameplay, ForgeConfigSpec> specPair = new Builder().configure(Gameplay::new);
        gameplaySpec = specPair.getRight();
        GAMEPLAY = specPair.getLeft();
    }

    static {
        final Pair<Effects, ForgeConfigSpec> specPair = new Builder().configure(Effects::new);
        effectsSpec = specPair.getRight();
        EFFECTS = specPair.getLeft();
    }

    static {
        final Pair<Penalties, ForgeConfigSpec> specPair = new Builder().configure(Penalties::new);
        penaltiesSpec = specPair.getRight();
        PENALTIES = specPair.getLeft();
    }

    public static void init() {
        ModLoadingContext.get().registerConfig(Type.SERVER, gameplaySpec, BetterPunching.MOD_ID + "-gameplay.toml");
        ModLoadingContext.get().registerConfig(Type.SERVER, effectsSpec, BetterPunching.MOD_ID + "-effects.toml");
        ModLoadingContext.get().registerConfig(Type.SERVER, penaltiesSpec, BetterPunching.MOD_ID + "-penalties.toml");
    }

    public static class Gameplay {
        public final BooleanValue glassBreaksInstanly;
        public final BooleanValue cactusRequiresSneaking;
        public final BooleanValue woodRequiresCorrectTool;
        public final BooleanValue snowRequiresCorrectTool;
        public final BooleanValue cobwebRequiresCorrectTool;

        public final ConfigValue<String> blockBlacklist;

        Gameplay(Builder pBuilder) {
            pBuilder.comment("Settings related to gameplay").push("gameplay");
            glassBreaksInstanly = pBuilder.comment("If set to true, all glass blocks will break instanly").define("glassBreaksInstanly", true);
            cactusRequiresSneaking = pBuilder.comment("If set to true, when bare-handed, you will be able to harvest cactus blocks, only if you are sneaking").define("cactusRequiresSneaking", true);
            woodRequiresCorrectTool = pBuilder.comment("If set to true, all wooden blocks will require an axe to be harvested").define("woodRequiresCorrectTool", true);
            snowRequiresCorrectTool = pBuilder.comment("If set to true, all snow blocks will require a shovel to be harvested").define("snowRequiresCorrectTool", false);
            cobwebRequiresCorrectTool = pBuilder.comment("If set to true, cobweb will require a sword or shears to be harvested").define("cobwebRequiresTool", false);
            blockBlacklist = pBuilder.comment("List of blocks which will be excluded and will follow the vanilla logic").define("blockBlacklist", "examplemod:example_item,anothermod:another_item");
            pBuilder.pop();
        }
    }

    public static class Effects {
        public final IntValue splinterTickRate;
        public final IntValue splinterDuration;
        public final IntValue splinterAmplifier;
        public final DoubleValue splinterDamage;

        public final IntValue bleedingTickRate;
        public final IntValue bleedingDuration;
        public final IntValue bleedingAmplifier;
        public final DoubleValue bleedingDamage;

        Effects(Builder pBuilder) {
            pBuilder.comment("Splinter Effect - Given to players when they punch wood or cactus bare-handed").push("splinter");
            splinterTickRate = pBuilder.comment("Define how often should the effect deal damage to the player in ticks").defineInRange("tickRate", 300, 1, 72000);
            splinterDuration = pBuilder.comment("Define how long should the effect last in ticks").defineInRange("duration", 1200, 0, 72000);
            splinterAmplifier = pBuilder.comment("Define the amplifier for the effect").defineInRange("amplifier", 0, 0, 255);
            splinterDamage = pBuilder.comment("Define how much damage the player will take from the effect when it ticks in half-hearts").defineInRange("damage", 1.0D, 0.0, Float.MAX_VALUE);
            pBuilder.pop();

            pBuilder.comment("Bleeding Effect - Given to players when they punch glass bare-handed").push("bleeding");
            bleedingTickRate = pBuilder.comment("Define how often should the effect deal damage to the player in ticks").defineInRange("tickRate", 150, 1, 72000);
            bleedingDuration = pBuilder.comment("Define how long should the effect last in ticks").defineInRange("duration", 1200, 0, 72000);
            bleedingAmplifier = pBuilder.comment("Define the amplifier for the effect").defineInRange("amplifier", 0, 0, 255);
            bleedingDamage = pBuilder.comment("Define how much damage the player will take from the effect when it ticks in half-hearts").defineInRange("damage", 1.0D, 0.0, Float.MAX_VALUE);
            pBuilder.pop();
        }
    }

    public static class Penalties {
        public final DoubleValue punchingBlocksDamage;
        public final DoubleValue punchingGlassDamage;

        Penalties(Builder pBuilder) {
            pBuilder.comment("Settings related to penalties").push("penalties");
            punchingBlocksDamage = pBuilder.comment("Define the amount of damage dealt to the player when punching a non-harvestable block").defineInRange("punchingBlocksDamage", 2.0D, 0.0, Double.MAX_VALUE);
            punchingGlassDamage = pBuilder.comment("Define the amount of damage dealt to the player if they break a glass block with hands").defineInRange("punchingGlassDamage", 4.0D, 0.0, Double.MAX_VALUE);
            pBuilder.pop();
        }
    }
}