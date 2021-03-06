package WayofTime.bloodmagic.item;

import WayofTime.bloodmagic.api.Constants;
import WayofTime.bloodmagic.client.IVariantProvider;
import WayofTime.bloodmagic.util.helper.TextHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public class ItemActivationCrystal extends ItemBindableBase implements IVariantProvider
{
    public static String[] names = { "weak", "awakened", "creative" };

    public ItemActivationCrystal()
    {
        super();

        setUnlocalizedName(Constants.Mod.MODID + ".activationCrystal.");
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return super.getUnlocalizedName(stack) + names[stack.getItemDamage()];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item id, CreativeTabs creativeTab, List<ItemStack> list)
    {
        for (int i = 0; i < names.length; i++)
            list.add(new ItemStack(id, 1, i));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced)
    {
        tooltip.add(TextHelper.localize("tooltip.BloodMagic.activationCrystal." + names[stack.getItemDamage()]));

        super.addInformation(stack, player, tooltip, advanced);
    }

    @Override
    public List<Pair<Integer, String>> getVariants()
    {
        List<Pair<Integer, String>> ret = new ArrayList<Pair<Integer, String>>();
        ret.add(new ImmutablePair<Integer, String>(0, "type=weak"));
        ret.add(new ImmutablePair<Integer, String>(1, "type=demonic"));
        ret.add(new ImmutablePair<Integer, String>(2, "type=creative"));
        return ret;
    }

    public int getCrystalLevel(ItemStack stack)
    {
        return stack.getItemDamage() > 1 ? Integer.MAX_VALUE : stack.getItemDamage() + 1;
    }
}
