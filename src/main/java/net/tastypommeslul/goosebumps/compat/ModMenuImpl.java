package net.tastypommeslul.goosebumps.compat;

import com.terraformersmc.modmenu.api.*;
import net.tastypommeslul.goosebumps.client.GoosebumpsClient;

public class ModMenuImpl implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return GoosebumpsClient::createConfigScreen;
    }
}
