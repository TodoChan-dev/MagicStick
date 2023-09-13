package jp.tproject.magicstick.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class Setting implements CommandExecutor, TabCompleter {
    public static boolean ban = false;
    public static boolean kill = false;
    public static boolean sky = false;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 0) {
            if (args[0].equalsIgnoreCase("ban")) {
                ban = true;
                kill = false;
                sky = false;
                sender.sendMessage("§8[§cMS§8]§r モード：§cBAN");
            }
            if (args[0].equalsIgnoreCase("kill")) {
                ban = false;
                kill = true;
                sky = false;
                sender.sendMessage("§8[§cMS§8]§r モード：§aKILL");
            }
            if (args[0].equalsIgnoreCase("sky")) {
                ban = false;
                kill = false;
                sky = true;
                sender.sendMessage("§8[§cMS§8]§r モード：§bSKY");
            }
            if (args[0].equalsIgnoreCase("off")) {
                ban = false;
                kill = false;
                sky = false;
                sender.sendMessage("§8[§cMS§8]§r モード：§eただの棒");

            }


        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> completions = new ArrayList<>();
        if (args.length == 1) {
            completions.add("ban");
            completions.add("kill");
            completions.add("sky");
            completions.add("off");
        }
        return completions;
    }
}
