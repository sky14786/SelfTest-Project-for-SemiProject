import test.boardqna.q.controller.BoardQnaQController;

public class Run {
	public static void main(String[] args) {
//		ClientController cc = new ClientController();
//		cc.createDummyData();
//		BoardMatchingController bmc = new BoardMatchingController();
//		bmc.createDummyData();
		BoardQnaQController bqqc = new BoardQnaQController();
		bqqc.createDummy();
//		for (int i = 0; i < 100; i++) {
//			int carTypeNo = ((int) (Math.random() * new CarTypeService().selectCountCarType()) + 1);
//			System.out.println(carTypeNo);
//		}

	}

}
