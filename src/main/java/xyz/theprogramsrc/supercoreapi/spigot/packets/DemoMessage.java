/*
 * Copyright (c) 2020.
 * Created by TheProgramSrc (https://theprogramsrc.xyz)
 */

package xyz.theprogramsrc.supercoreapi.spigot.packets;


import org.bukkit.entity.Player;
import xyz.theprogramsrc.supercoreapi.spigot.utils.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.util.Objects;

@SuppressWarnings("unused")
public class DemoMessage {

    public static void send(Player player) {
        try {
            Class<?> gameStateChange = ReflectionUtils.getNMSClass("PacketPlayOutGameStateChange");
            Constructor<?> playOutConstructor = ReflectionUtils.getConstructor(gameStateChange, Integer.TYPE, Float.TYPE);
            Object packet = Objects.requireNonNull(playOutConstructor).newInstance(5, 0);
            ReflectionUtils.sendPacket(player, packet);
        } catch (Exception var5) {
            var5.printStackTrace();
        }
    }
}

