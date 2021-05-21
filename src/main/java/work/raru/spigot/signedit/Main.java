package work.raru.spigot.signedit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		getLogger().info("Enabled!");
		super.onEnable();
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		//editsignコマンド
		if (command.getName().equals("editsign")) {
			//引数の数の確認
			if (args.length < 1 || args.length > 4) {
				return false;
			}
			Block point = ((Player) sender).getTargetBlock(null, 50);
			getLogger().info(point.getType().toString());
			if (!point.getType().equals(Material.SIGN_POST) && !point.getType().equals(Material.WALL_SIGN)) {
				sender.sendMessage("You should point sign.");
//				sender.sendMessage("If you want to set text of item sign, please use /setsign");
				return true;
			}
			Sign sign = (Sign)point.getState();
			for (int i = 0; i < 4; i++) {
				if (args.length > i && !args[i].equals(".")) {
					sign.setLine(i, args[i]);
				} else {
					sign.setLine(i, "");
				}
			}
			sign.update();
			sender.sendMessage("Sucsess.");
			return true;
		}
//		//setsignコマンド(気が向いたら実装)
//		if (command.getName().equals("setsign")) {
//			//引数の数の確認
//			if (args.length < 1 || args.length > 4) {
//				return false;
//			}
//			ItemStack point = ((Player) sender).getInventory().getItemInMainHand();
//			if (!point.getType().equals(Material.SIGN)) {
//				sender.sendMessage("You should have sign in mainhand.");
//				sender.sendMessage("If you want to edit text of block sign, please use /editsign");
//			}
//			Sign sign = point.get
//			for (int i = 0; i < args.length; i++) {
//				sign.setLine(i, args[i]);
//			}
//		}
		return super.onCommand(sender, command, label, args);
	}
}
