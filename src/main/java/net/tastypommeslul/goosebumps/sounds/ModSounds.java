package net.tastypommeslul.goosebumps.sounds;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.tastypommeslul.goosebumps.Goosebumps;

public class ModSounds {

    public static final SoundEvent QUACK = registerSoundEvent("quack");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(Goosebumps.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        Goosebumps.LOGGER.info("Registering sounds for " + Goosebumps.MOD_ID);
    }
}
