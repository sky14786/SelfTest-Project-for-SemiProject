import test.boardmatching.controller.BoardMatchingController;
import test.cartype.model.service.CarTypeService;

public class Run {
	public static void main(String[] args) {
//		ClientController cc = new ClientController();
//		cc.createDummyData();
//		BoardMatchingController bmc = new BoardMatchingController();
//		bmc.createDummyData();

		for (int i = 0; i < 100; i++) {
			int carTypeNo = ((int) (Math.random() * new CarTypeService().selectCountCarType()) + 1);
			System.out.println(carTypeNo);
		}

	}

}
