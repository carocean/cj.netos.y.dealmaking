package cj.netos.y.dealmaking.plugin.YEngine;

import cj.netos.y.dealmaking.bs.IQueueEvent;

public interface ICBankEngine {

	IQueueEvent contractQueueEvent();

	void runCBank(String bank);

	void stop();

}
