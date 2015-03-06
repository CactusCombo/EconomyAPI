package io.github.cactuscombo;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by CactusCombo on 06/03/2015.
 */
public class MoneyStorage {

    private MoneyStorage() {
    }

    public static MoneyStorage getInstance()
    {
        return new MoneyStorage();
    }

    public Plugin p;
    public FileConfiguration config;
    public File cfile;

    public void create(Plugin p) {
        this.p = p;

        if (!p.getDataFolder().exists()) p.getDataFolder().mkdir();

        cfile = new File(p.getDataFolder(), "playerbalance.yml");

        if (!cfile.exists()) {
            try {
                cfile.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        config = YamlConfiguration.loadConfiguration(cfile);
    }
    public ArrayList<String> getValues() {
        Map<String, Object> map = config.getValues(true);
        ArrayList<String> lines = new ArrayList<String>();

        for (Map.Entry<String, Object> e : map.entrySet()) {
            lines.add(e.getValue() + " " + e.getKey());
        }

        return lines;
    }

    public void save() {
        try {
            config.save(cfile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Plugin getPlugin() {
        return p;
    }
}