package cj.netos.y.dealmaking.bs;

import java.util.List;

public interface ICBankContractQueueBS {
	void offer(String bank, DeliverContract stock);
	void onevent(IQueueEvent e);
	DeliverContract peek(String bank);

	void remove(String bank);

	void remove(String bank, String stockno);

	void updateQuantities(String bank, String stockno, long quantities);

	List<DeliverContract> listFivePuttingWindow(String bank);
}
