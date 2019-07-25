package com.bubbet.projectbsr;

import com.bubbet.projectbsr.proxy.Common;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;

@Mod(
        modid = "projectbsr",
        name = "ProjectBSR",
        version = "1.0",
        dependencies = "required-after:logisticspipes;" +
                "after:forestry;"
)
public class ProjectBSR {

    @Mod.Instance("ProjectBSR")
    public static ProjectBSR instance;

    @SidedProxy(clientSide = "com.bubbet.projectbsr.proxy.Client",serverSide = "com.bubbet.projectbsr.proxy.Server")
    public static Common proxy;

}
