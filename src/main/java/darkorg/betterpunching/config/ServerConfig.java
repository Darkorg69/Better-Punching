package darkorg.betterpunching.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class ServerConfig {
    public static ForgeConfigSpec SERVER_CONFIG;

    public static ForgeConfigSpec.BooleanValue invalidPunchEnabled;
    public static ForgeConfigSpec.BooleanValue punchWoodEnabled;
    public static ForgeConfigSpec.BooleanValue punchGlassEnabled;
    public static ForgeConfigSpec.BooleanValue punchCactusEnabled;

    public static ForgeConfigSpec.DoubleValue invalidPunchDamage;
    public static ForgeConfigSpec.DoubleValue splinterDamage;
    public static ForgeConfigSpec.DoubleValue bleedingDamage;

    public static ForgeConfigSpec.IntValue splinterDuration;
    public static ForgeConfigSpec.IntValue bleedingDuration;
    public static ForgeConfigSpec.IntValue weaknessDuration;

    public static ForgeConfigSpec.IntValue splinterAmplifier;
    public static ForgeConfigSpec.IntValue bleedingAmplifier;
    public static ForgeConfigSpec.IntValue weaknessAmplifier;
    public static ForgeConfigSpec.IntValue miningFatigueAmplifier;
    public static ForgeConfigSpec.IntValue miningFatigueDuration;


    private static void initCommonConfig() {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.push("Welcome to the Better Punching mod server configuration file");

        punchWoodEnabled = builder.comment("Set to false to disable the ''Punching Wood'' feature.").define("punchWoodEnabled", true);
        punchGlassEnabled = builder.comment("Set to false to disable the ''Punching Glass'' feature.").define("punchGlassEnabled", true);
        punchCactusEnabled = builder.comment("Set to false to disable the ''Punching Cactus'' feature.").define("punchCactusEnabled", true);
        invalidPunchEnabled = builder.comment("Set to false to disable the ''Invalid Punching'' feature.").define("invalidPunchEnabled", true);

        splinterDamage = builder.comment("Set how much damage should the player take from the Splinter effect").defineInRange("splinterDamage", 1.0, 0.0, Float.MAX_VALUE);
        bleedingDamage = builder.comment("Set how much damage should the player take from the Bleeding effect").defineInRange("bleedingDamage", 1.0, 0.0, Float.MAX_VALUE);
        invalidPunchDamage = builder.comment("Set how much damage should the player take from punching the wrong block.").defineInRange("invalidPunchDamage", 1.0, 0.0, Float.MAX_VALUE);

        splinterDuration = builder.comment("Set how long should the Splinter effect last in seconds").defineInRange("splinterDuration", 10, 0, 1000000);
        bleedingDuration = builder.comment("Set how long should the Bleeding effect last in seconds").defineInRange("bleedingDuration", 10, 0, 1000000);
        weaknessDuration = builder.comment("Set how long should the Weakness effect last in seconds").defineInRange("weaknessDuration", 10, 0, 1000000);
        miningFatigueDuration = builder.comment("Set how long should the Mining Fatigue effect last in seconds").defineInRange("miningFatigueDuration", 10, 0, 1000000);

        splinterAmplifier = builder.comment("Set the amplifier for the Splinter effect").defineInRange("splinterAmplifier", 0, 0, 255);
        bleedingAmplifier = builder.comment("Set the amplifier for the Bleeding effect").defineInRange("bleedingAmplifier", 0, 0, 255);
        weaknessAmplifier = builder.comment("Set the amplifier for the Weakness effect").defineInRange("weaknessAmplifier", 0, 0, 255);
        miningFatigueAmplifier = builder.comment("Set the amplifier for the Mining Fatigue effect").defineInRange("miningFatigueAmplifier", 0, 0, 255);

        builder.pop();
        SERVER_CONFIG = builder.build();
    }

    public static void init() {
        initCommonConfig();
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, SERVER_CONFIG);
    }
}