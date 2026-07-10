package de.trc.trcenderchest;

import de.trc.trcenderchest.command.CommandEC;
import de.trc.trcenderchest.command.tabcompleter.TabCompleterEC;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class TRCEnderchest extends JavaPlugin {
    @Override
    public void onEnable() {
        Constants.LOGGER.info("TRC Enderchest enabled");
        Objects.requireNonNull(getCommand("ec")).setExecutor(new CommandEC());
        Objects.requireNonNull(getCommand("enderchest")).setExecutor(new CommandEC());
        Objects.requireNonNull(getCommand("ec")).setTabCompleter(new TabCompleterEC());
        Objects.requireNonNull(getCommand("enderchest")).setTabCompleter(new TabCompleterEC());
        Constants.LOGGER.info("Commands registered as /ec and /enderchest");
    }

    @Override
    public void onDisable() {
        Constants.LOGGER.info("TRC Enderchest disabled");
    }
}
