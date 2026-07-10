package de.trc.trcenderchest.command;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import org.jetbrains.annotations.NotNull;

public class CommandEC implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(Component.text("This Command is only for Players!").color(TextColor.color(255, 0, 0)));
            return true;
        }

        if (args.length == 0 && sender.hasPermission("trc_enderchest:see_own")) {
            player.openInventory(player.getEnderChest());
            player.playSound(player, Sound.BLOCK_ENDER_CHEST_OPEN, 1, 1);
            return true;
        }

        if (args.length == 1) {
            if (!sender.hasPermission("trc_enderchest:see_other")) {
                sender.sendMessage(Component.text("No Permission").color(TextColor.color(255, 0, 0)));
                return true;
            }

            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                sender.sendMessage(Component.text("Please provide a valid Player").color(TextColor.color(255, 0, 0)));
                return true;
            }

            player.openInventory(target.getEnderChest());
            player.playSound(player, Sound.BLOCK_ENDER_CHEST_OPEN, 1, 1);
            return true;
        }

        sender.sendMessage(Component.text("No Permission").color(TextColor.color(255, 0, 0)));
        return false;
    }
}
