import lt.itakademija.exam.TruckManager;
import lt.itakademija.exam.test.BaseTest;

public class ManagerTest extends BaseTest{

	@Override
	protected TruckManager createTransportManager() {
		
		return new TrManager();
	}

}
