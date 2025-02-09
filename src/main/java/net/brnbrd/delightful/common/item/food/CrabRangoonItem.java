package net.brnbrd.delightful.common.item.food;

import net.brnbrd.delightful.common.item.DItem;
import net.brnbrd.delightful.data.tags.DelightfulItemTags;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.List;

public class CrabRangoonItem extends DItem {
	public CrabRangoonItem(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public boolean enabled() {
		return this.isTag() && super.enabled();
	}

	public boolean isTag() {
		var tags = ForgeRegistries.ITEMS.tags();
		return tags.isKnownTagName(DelightfulItemTags.CRAB_MEAT) &&
			!tags.getTag(DelightfulItemTags.CRAB_MEAT).isEmpty();
	}

	@Override
	public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> comps, @NotNull TooltipFlag pIsAdvanced) {
		if (!this.isTag()) {
			comps.add(Component.translatable("tooltip.requires_tag"));
			comps.add(Component.literal(DelightfulItemTags.CRAB_MEAT.location().toString()).withStyle(ChatFormatting.UNDERLINE));
		} else {
			super.appendHoverText(stack, level, comps, pIsAdvanced);
		}
	}
}
