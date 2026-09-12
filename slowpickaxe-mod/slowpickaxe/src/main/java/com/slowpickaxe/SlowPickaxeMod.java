package com.slowpickaxe;

import com.slowpickaxe.config.SlowPickaxeConfig;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SlowPickaxeMod implements ClientModInitializer {

    public static final String MOD_ID = "slowpickaxe";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static SlowPickaxeConfig CONFIG;

    @Override
    public void onInitializeClient() {
        CONFIG = SlowPickaxeConfig.load();
        LOGGER.info("Slow Pickaxe Animation chargé !");
    }
}
