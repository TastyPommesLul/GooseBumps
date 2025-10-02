package net.tastypommeslul.goosebumps.compat;

import com.moulberry.lattice.annotation.LatticeOption;
import com.moulberry.lattice.annotation.widget.LatticeWidgetButton;

public class GoosebumpsConfig {
    public GoosebumpsConfig() {}

    @LatticeOption(title = "Placeholder", translate = false)
    @LatticeWidgetButton
    public boolean placeholder = false;
}
