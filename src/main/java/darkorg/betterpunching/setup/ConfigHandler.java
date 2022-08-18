package darkorg.betterpunching.setup;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class ConfigHandler {
    public static ForgeConfigSpec COMMON_CONFIG;

    public static ForgeConfigSpec.BooleanValue wrongToolEnabled;
    public static ForgeConfigSpec.BooleanValue punchWoodEnabled;
    public static ForgeConfigSpec.BooleanValue punchGlassEnabled;
    public static ForgeConfigSpec.BooleanValue punchCactusEnabled;

    public static ForgeConfigSpec.DoubleValue wrongToolDamage;
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

        wrongToolEnabled = builder.comment("Set to false to disable the WrongTool feature.").define("wrongtool_enabled", true);
        punchWoodEnabled = builder.comment("Set to false to disable the PunchingWood feature.").define("punchingwood_enabled", true);
        punchGlassEnabled = builder.comment("Set to false to disable the PunchingGlass feature.").define("punchingglass_enabled", true);
        punchCactusEnabled = builder.comment("Set to false to disable the PunchingCactus feature.").define("punchingcactus_enabled", true);

        splinterDamage = builder.comment("Set how much damage should the player take from the Splinter effect").defineInRange("splinter_damage", 1.0, 0.0, Float.MAX_VALUE);
        bleedingDamage = builder.comment("Set how much damage should the player take from the Bleeding effect").defineInRange("bleeding_damage", 1.0, 0.0, Float.MAX_VALUE);
        wrongToolDamage = builder.comment("Set how much damage should the player take from punching the wrong block.").defineInRange("wrongtool_damage", 1.0, 0.0, Float.MAX_VALUE);

        splinterDuration = builder.comment("Set how long should the Splinter effect last in seconds").defineInRange("splinter_duration", 10, 0, Integer.MAX_VALUE);
        bleedingDuration = builder.comment("Set how long should the Bleeding effect last in seconds").defineInRange("bleeding_duration", 10, 0, Integer.MAX_VALUE);
        weaknessDuration = builder.comment("Set how long should the Weakness effect last in seconds").defineInRange("weakness_duration", 10, 0, Integer.MAX_VALUE);
        miningFatigueDuration = builder.comment("Set how long should the Mining Fatigue effect last in seconds").defineInRange("mining_fatigue_duration", 10, 0, Integer.MAX_VALUE);

        splinterAmplifier = builder.comment("Set the amplifier for the Splinter effect").defineInRange("splinter_amplifier", 0, 0, Integer.MAX_VALUE);
        bleedingAmplifier = builder.comment("Set the amplifier for the Bleeding effect").defineInRange("bleeding_amplifier", 0, 0, Integer.MAX_VALUE);
        weaknessAmplifier = builder.comment("Set the amplifier for the Weakness effect").defineInRange("weakness_amplifier", 0, 0, Integer.MAX_VALUE);
        miningFatigueAmplifier = builder.comment("Set the amplifier for the Mining Fatigue effect").defineInRange("mining_fatigue_amplifier", 0, 0, Integer.MAX_VALUE);

        builder.pop();
        COMMON_CONFIG = builder.build();
    }

    public static void init() {
        initCommonConfig();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, COMMON_CONFIG);
    }
}

