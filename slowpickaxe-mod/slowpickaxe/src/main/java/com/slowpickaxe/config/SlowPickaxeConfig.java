package com.slowpickaxe.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

@Config(name = "slowpickaxe")
public class SlowPickaxeConfig implements ConfigData {

    // Multiplicateur de vitesse d'animation (1.0 = normal, 2.0 = 2x plus lent, 0.5 = 2x plus rapide)
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.BoundedDiscrete(min = 1, max = 10)
    public int swingSpeedMultiplier = 3;

    public static SlowPickaxeConfig load() {
        AutoConfig.register(SlowPickaxeConfig.class, GsonConfigSerializer::new);
        return AutoConfig.getConfigHolder(SlowPickaxeConfig.class).getConfig();
    }

    public static SlowPickaxeConfig get() {
        return AutoConfig.getConfigHolder(SlowPickaxeConfig.class).getConfig();
    }
}
