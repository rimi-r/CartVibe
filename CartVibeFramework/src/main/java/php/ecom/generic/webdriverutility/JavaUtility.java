package php.ecom.generic.webdriverutility;

import java.util.Random;

public class JavaUtility {
	
	public int randomNumber(int range)
	{
		Random rd=new Random();
		int rand=rd.nextInt(range);
		return rand;
	}

}
