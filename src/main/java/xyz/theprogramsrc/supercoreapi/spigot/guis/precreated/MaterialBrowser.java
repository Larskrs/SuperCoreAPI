package xyz.theprogramsrc.supercoreapi.spigot.guis.precreated;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import xyz.theprogramsrc.supercoreapi.global.translations.Base;
import xyz.theprogramsrc.supercoreapi.spigot.SpigotPlugin;
import xyz.theprogramsrc.supercoreapi.spigot.guis.BrowserGUI;
import xyz.theprogramsrc.supercoreapi.spigot.guis.GUIButton;
import xyz.theprogramsrc.supercoreapi.spigot.guis.action.ClickAction;
import xyz.theprogramsrc.supercoreapi.spigot.items.SimpleItem;
import xyz.theprogramsrc.supercoreapi.spigot.utils.xseries.XMaterial;

import java.util.Arrays;

public abstract class MaterialBrowser extends BrowserGUI<XMaterial> {

    public MaterialBrowser(SpigotPlugin plugin, Player player) {
        super(plugin, player);
    }

    @Override
    public XMaterial[] getObjects() {
        Inventory inventory = Bukkit.createInventory(null, 9);
        return Arrays.stream(XMaterial.itemsSupported()).filter(m->{
            inventory.setItem(4, m.parseItem());
            if(inventory.getItem(4) != null){
                inventory.clear();
                return true;
            }
            return false;
        }).toArray(XMaterial[]::new);
    }

    @Override
    public GUIButton getButton(XMaterial xMaterial) {
        SimpleItem item = new SimpleItem(xMaterial)
                .setDisplayName(Base.MATERIAL_SELECTOR_ITEM_NAME.options().vars(xMaterial.getHumanName()).toString())
                .setLore(Base.MATERIAL_SELECTOR_ITEM_DESCRIPTION.options().vars(xMaterial.getHumanName()).toString());
        return new GUIButton(item).setAction(a-> this.onSelect(a, xMaterial));
    }

    @Override
    public void onBack(ClickAction clickAction) {

    }

    @Override
    protected String getTitle() {
        return Base.MATERIAL_SELECTOR_TITLE.toString();
    }

    public abstract void onSelect(ClickAction clickAction, XMaterial xMaterial);
}
