package binnie.genetics.gui.analyst;

import net.minecraft.item.ItemStack;

import forestry.api.genetics.AlleleManager;
import forestry.api.genetics.IIndividual;

import binnie.Binnie;
import binnie.core.genetics.BreedingSystem;
import binnie.core.gui.ITooltip;
import binnie.core.gui.IWidget;
import binnie.core.gui.Tooltip;
import binnie.core.gui.minecraft.control.ControlItemDisplay;

public class ControlIndividualDisplay extends ControlItemDisplay implements ITooltip {
	public ControlIndividualDisplay(IWidget parent, int x, int y, IIndividual ind) {
		this(parent, x, y, 16, ind);
	}

	public ControlIndividualDisplay(IWidget parent, int x, int y, int size, IIndividual ind) {
		super(parent, x, y, size);
		BreedingSystem system = Binnie.GENETICS.getSystem(ind.getGenome().getSpeciesRoot());
		setItemStack(system.getSpeciesRoot().getMemberStack(ind, system.getDefaultType()));
		setTooltip();
	}

	@Override
	public void getTooltip(Tooltip tooltip) {
		ItemStack stack = getItemStack();
		if (stack.isEmpty()) {
			return;
		}
		IIndividual ind = AlleleManager.alleleRegistry.getIndividual(stack);
		if (ind == null) {
			return;
		}
		tooltip.add(ind.getGenome().getPrimary().getAlleleName());
	}
}
