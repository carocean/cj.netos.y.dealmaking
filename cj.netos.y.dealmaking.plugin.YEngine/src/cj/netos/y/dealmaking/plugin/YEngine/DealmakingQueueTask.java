package cj.netos.y.dealmaking.plugin.YEngine;

import cj.studio.ecm.IServiceSite;

//撮合一个银行的任务，撮合完则任务退出
public class DealmakingQueueTask implements IDealmakingQueueTask {
	String cbank;
	IServiceSite site;
	

	public DealmakingQueueTask(String bank, IServiceSite site) {
		this.cbank = bank;
		this.site = site;
	}

	@Override
	public void run() {
		System.out.println("....DealmakingQueueTask");
	}
}
