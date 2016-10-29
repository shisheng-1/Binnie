package binnie.genetics.api;

import forestry.api.genetics.ISpeciesRoot;
import net.minecraft.item.ItemStack;

public interface IItemChargable {
	int getCharges(ItemStack itemStack);

	int getMaxCharges(ItemStack itemStack);

	ISpeciesRoot getSpeciesRoot(ItemStack itemStack);
}
