package ep.model;

import javax.ejb.Stateful;

@Stateful
public class Banking implements BankingRemote
{
	int balance=0;
	@Override
	public void withDraw(int amt)
	{
		balance =balance -  amt;
		
	}

	@Override
	public void deposit(int amt) 
	{
		balance += amt;
	}

	@Override
	public int getBlance() 
	{
		return balance;
		
	}

}
