
package com.example.addon.modules;

import com.example.addon.AddonTemplate;
import meteordevelopment.meteorclient.events.render.Render3DEvent;
import meteordevelopment.meteorclient.renderer.ShapeMode;
import meteordevelopment.meteorclient.settings.ColorSetting;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.SettingGroup;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.utils.render.color.Color;
import meteordevelopment.meteorclient.utils.render.color.SettingColor;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.AABB;

public class ModuleExample extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();

    private final Setting<SettingColor> color = sgGeneral.add(
        new ColorSetting.Builder()
            .name("color")
            .description("CHILI marker color.")
            .defaultValue(Color.MAGENTA)
            .build()
    );

    public ModuleExample() {
        super(
            AddonTemplate.CATEGORY,
            "chili-marker",
            "Displays a customizable CHILI marker at world origin."
        );
    }

    @EventHandler
    private void onRender3D(Render3DEvent event) {
        AABB marker = new AABB(BlockPos.ZERO);

        event.renderer.box(
            marker,
            color.get(),
            color.get(),
            ShapeMode.Both,
            0
        );
    }
}
