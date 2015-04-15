package techreborn.config;

import cpw.mods.fml.client.config.DummyConfigElement;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.GuiConfigEntries;
import cpw.mods.fml.client.config.GuiConfigEntries.CategoryEntry;
import cpw.mods.fml.client.config.IConfigElement;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

import java.util.ArrayList;
import java.util.List;

public class TechRebornConfigGui extends GuiConfig {
    public TechRebornConfigGui(GuiScreen top) {
        super(top, getConfigCategories(), "TechReborn", false, false,
                GuiConfig.getAbridgedConfigPath(ConfigTechReborn.config
                        .toString()));
    }

    private static List<IConfigElement> getConfigCategories() {
        List<IConfigElement> list = new ArrayList<IConfigElement>();
        list.add(new DummyConfigElement.DummyCategoryElement("General",
                "tr.configgui.category.trGeneral", TRGeneral.class));
        list.add(new DummyConfigElement.DummyCategoryElement("World Gen",
                "tr.configgui.category.trWorld", TRWORLD.class));
        list.add(new DummyConfigElement.DummyCategoryElement("Power",
                "tr.configgui.category.trPower", TRPOWER.class));
        list.add(new DummyConfigElement.DummyCategoryElement("Crafting",
                "tr.configgui.category.trCrafting", TRCRAFTING.class));

        return list;
    }

    public static class TRGeneral extends CategoryEntry {

        public TRGeneral(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement configElement) {
            super(owningScreen, owningEntryList, configElement);
        }

        @Override
        protected GuiScreen buildChildScreen() {
            return new GuiConfig(this.owningScreen,
                    (new ConfigElement(ConfigTechReborn.config
                            .getCategory(Configuration.CATEGORY_GENERAL)))
                            .getChildElements(), this.owningScreen.modID,
                    Configuration.CATEGORY_GENERAL,
                    this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart,
                    this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart,
                    GuiConfig.getAbridgedConfigPath(ConfigTechReborn.config.toString()));
        }
    }

    // World
    public static class TRWORLD extends CategoryEntry {
        public TRWORLD(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement configElement) {
            super(owningScreen, owningEntryList, configElement);
        }

        @Override
        protected GuiScreen buildChildScreen() {
            return new GuiConfig(this.owningScreen,
                    (new ConfigElement(ConfigTechReborn.config
                            .getCategory(ConfigTechReborn.CATEGORY_WORLD)))
                            .getChildElements(), this.owningScreen.modID,
                    Configuration.CATEGORY_GENERAL,
                    this.configElement.requiresWorldRestart()
                            || this.owningScreen.allRequireWorldRestart,
                    this.configElement.requiresMcRestart()
                            || this.owningScreen.allRequireMcRestart,
                    GuiConfig.getAbridgedConfigPath(ConfigTechReborn.config
                            .toString()));
        }
    }

    // Power
    public static class TRPOWER extends CategoryEntry {
        public TRPOWER(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement configElement) {
            super(owningScreen, owningEntryList, configElement);
        }

        @Override
        protected GuiScreen buildChildScreen() {
            return new GuiConfig(this.owningScreen,
                    (new ConfigElement(ConfigTechReborn.config
                            .getCategory(ConfigTechReborn.CATEGORY_POWER)))
                            .getChildElements(), this.owningScreen.modID,
                    Configuration.CATEGORY_GENERAL,
                    this.configElement.requiresWorldRestart()
                            || this.owningScreen.allRequireWorldRestart,
                    this.configElement.requiresMcRestart()
                            || this.owningScreen.allRequireMcRestart,
                    GuiConfig.getAbridgedConfigPath(ConfigTechReborn.config
                            .toString()));
        }
    }

    // Crafting
    public static class TRCRAFTING extends CategoryEntry {
        public TRCRAFTING(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement configElement) {
            super(owningScreen, owningEntryList, configElement);
        }

        @Override
        protected GuiScreen buildChildScreen() {
            return new GuiConfig(this.owningScreen,
                    (new ConfigElement(ConfigTechReborn.config
                            .getCategory(ConfigTechReborn.CATEGORY_CRAFTING)))
                            .getChildElements(), this.owningScreen.modID,
                    Configuration.CATEGORY_GENERAL,
                    this.configElement.requiresWorldRestart()
                            || this.owningScreen.allRequireWorldRestart,
                    this.configElement.requiresMcRestart()
                            || this.owningScreen.allRequireMcRestart,
                    GuiConfig.getAbridgedConfigPath(ConfigTechReborn.config
                            .toString()));
        }
    }
}
