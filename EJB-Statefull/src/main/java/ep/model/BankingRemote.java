package ep.model;

import javax.ejb.Remote;

@Remote
public interface BankingRemote 
{
	public void withDraw(int amt);
	public void deposit(int amt);
	public int getBlance();
}
