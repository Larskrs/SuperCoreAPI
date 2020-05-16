/*
 * Copyright (c) 2020.
 * Created by TheProgramSrc (https://theprogramsrc.xyz)
 */

package xyz.theprogramsrc.supercoreapi.spigot.guis.action;

import org.bukkit.entity.Player;
import xyz.theprogramsrc.supercoreapi.spigot.SpigotPlugin;
import xyz.theprogramsrc.supercoreapi.spigot.guis.GUI;
import xyz.theprogramsrc.supercoreapi.spigot.guis.GUIButton;

public class ClickAction {

    private final GUI gui;
    private final Player player;
    private final ClickType clickType;
    private final GUIButton button;
    private final int slot;

    public ClickAction(GUI gui, Player player, GUIButton button, ClickType clickType, int slot) {
        this.gui = gui;
        this.player = player;
        this.clickType = clickType;
        this.button = button;
        this.slot = slot;
    }

    public GUI getGui() {
        return gui;
    }

    public Player getPlayer() {
        return player;
    }

    public ClickType getAction() {
        return clickType;
    }

    public GUIButton getButton() {
        return button;
    }

    public int getSlot() {
        return slot;
    }

    public SpigotPlugin getPlugin(){
        return this.gui.getPlugin();
    }
}
