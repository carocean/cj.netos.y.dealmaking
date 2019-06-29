package cj.netos.y.dealmaking.plugin.YEngine;

import java.util.List;

import cj.netos.y.dealmaking.bs.ICBankContractQueueBS;
import cj.netos.y.dealmaking.bs.ICBankInitializer;
import cj.studio.ecm.IChip;
import cj.studio.ecm.IEntryPointActivator;
import cj.studio.ecm.IServiceSite;
import cj.studio.ecm.context.IElement;

public class DealmakingEngineEntrypointActivitor implements IEntryPointActivator {
	ICBankEngine engine;
	
	@Override
	public void activate(IServiceSite site, IElement args) {
		engine=new CBankEngine(site);
		ICBankContractQueueBS cbankContractQueueBS = (ICBankContractQueueBS) site.getService("cbankContractQueueBS");
		cbankContractQueueBS.onevent(engine.contractQueueEvent());
		
		IChip chip = (IChip) site.getService(IChip.class.getName());
		String dealmakingEngineID = chip.info().getId();
		ICBankInitializer bankInitializer = (ICBankInitializer) site.getService("cbankInitializer");
		List<String> cbanksInDB = bankInitializer.pageCBank(dealmakingEngineID);
		for (String cbank : cbanksInDB) {
			engine.runCBank(cbank);
		}
	}

	@Override
	public void inactivate(IServiceSite site) {
		engine.stop();
	}

}
