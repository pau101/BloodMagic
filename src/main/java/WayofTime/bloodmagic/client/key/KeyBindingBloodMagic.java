package WayofTime.bloodmagic.client.key;

import WayofTime.bloodmagic.api.Constants;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class KeyBindingBloodMagic extends KeyBinding
{
    public KeyBindingBloodMagic(KeyBindings key)
    {
        super(key.getDescription(), key.getKeyConflictContext(), key.getKeyModifier(), key.getKeyCode(), Constants.Mod.NAME);

        ClientRegistry.registerKeyBinding(this);
    }
}
