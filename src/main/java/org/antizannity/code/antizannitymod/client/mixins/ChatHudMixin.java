package org.antizannity.code.antizannitymod.client.mixins;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChatHud.class)
public abstract class ChatHudMixin {
    @Shadow @Final private MinecraftClient client;

    @Shadow public abstract void addMessage(Text message);

    @Inject(method = "addMessage(Lnet/minecraft/text/Text;)V", at = @At("HEAD"))
    public void wewillnevercallthisfunction(Text message, CallbackInfo info) {
        String rawMessage = message.getString();
        //discord
        if (rawMessage.contains("[Discord] [Nitro Booster] z4nityy")){
            return;
        }
    }
}