package com.huby;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public final class HubyP4Free extends JavaPlugin {

    @Override
    public void onEnable() {
        getPackages(getFile(), "com.huby").stream().filter(c -> {
            try {
                return c.newInstance() instanceof Listener;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }).forEach(c -> {
            try {
                getServer().getPluginManager().registerEvents((Listener) c.newInstance(), this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private Set<Class<?>> getPackages(File file, String name) {
        Set<Class<?>> classes = new HashSet<>();
        try {
            JarFile jar = new JarFile(file);
            for (Enumeration<JarEntry> entry = jar.entries(); entry.hasMoreElements();) {
                JarEntry jarEntry = (JarEntry) entry.nextElement();
                String named = jarEntry.getName().replace("/", ".");
                if ((named.startsWith(name)) && (named.endsWith(".class")) && (!named.contains("$"))) {
                    classes.add(Class.forName(named.substring(0, named.length() - 6)));
                }
            }
            jar.close();
        } catch (Exception localException) {}
        return classes;
    }

}
