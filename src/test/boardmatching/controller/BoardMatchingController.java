package test.boardmatching.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import test.boardmatching.model.service.BoardMatchingService;
import test.boardmatching.model.vo.BoardMatching;
import test.cartype.model.service.CarTypeService;
import test.client.model.service.ClientService;

public class BoardMatchingController {
	public void createDummyData() {
		ArrayList<String> idList = new ClientService().allSelect();
		for (int i = 0; i < 100; i++) {
			String writer = idList.get((int) (Math.random() * 99));
			String title = randomHangulName();
			String startAddr = randomHangulAddr();
			String endAddr = randomHangulAddr();
			String etc = title + "<br>" + startAddr + "에서 " + endAddr + "로 배송을 희망합니다.";
			int carTypeNo = ((int) (Math.random() * new CarTypeService().selectCountCarType()) + 1);
			BoardMatching bTemp = new BoardMatching(writer, etc, startAddr, endAddr, etc, carTypeNo);
			if (new BoardMatchingService().writeBoardMatching(bTemp) == 1) {
				System.out.println("| LOG | CreateBoardMatching | " + i + " | " + bTemp.toString());
			}

		}
	}

	public String randomHangulName() {
		List<String> firstName = Arrays.asList("김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오", "서", "신",
				"권", "황", "안", "송", "류", "전", "홍", "고", "문", "양", "손", "배", "조", "백", "허", "유", "남", "심", "노", "정", "하",
				"곽", "성", "차", "주", "우", "구", "신", "임", "나", "전", "민", "유", "진", "지", "엄", "채", "원", "천", "방", "공", "강",
				"현", "함", "변", "염", "양", "변", "여", "추", "노", "도", "소", "신", "석", "선", "설", "마", "길", "주", "연", "방", "위",
				"표", "명", "기", "반", "왕", "금", "옥", "육", "인", "맹", "제", "모", "장", "남", "탁", "국", "여", "진", "어", "은", "편",
				"구", "용");
		List<String> lastName = Arrays.asList("가", "강", "건", "경", "고", "관", "광", "구", "규", "근", "기", "길", "나", "남", "노",
				"누", "다", "단", "달", "담", "대", "덕", "도", "동", "두", "라", "래", "로", "루", "리", "마", "만", "명", "무", "문", "미",
				"민", "바", "박", "백", "범", "별", "병", "보", "빛", "사", "산", "상", "새", "서", "석", "선", "설", "섭", "성", "세", "소",
				"솔", "수", "숙", "순", "숭", "슬", "승", "시", "신", "아", "안", "애", "엄", "여", "연", "영", "예", "오", "옥", "완", "요",
				"용", "우", "원", "월", "위", "유", "윤", "율", "으", "은", "의", "이", "익", "인", "일", "잎", "자", "잔", "장", "재", "전",
				"정", "제", "조", "종", "주", "준", "중", "지", "진", "찬", "창", "채", "천", "철", "초", "춘", "충", "치", "탐", "태", "택",
				"판", "하", "한", "해", "혁", "현", "형", "혜", "호", "홍", "화", "환", "회", "효", "훈", "휘", "희", "운", "모", "배", "부",
				"림", "봉", "혼", "황", "량", "린", "을", "비", "솜", "공", "면", "탁", "온", "디", "항", "후", "려", "균", "묵", "송", "욱",
				"휴", "언", "령", "섬", "들", "견", "추", "걸", "삼", "열", "웅", "분", "변", "양", "출", "타", "흥", "겸", "곤", "번", "식",
				"란", "더", "손", "술", "훔", "반", "빈", "실", "직", "흠", "흔", "악", "람", "뜸", "권", "복", "심", "헌", "엽", "학", "개",
				"롱", "평", "늘", "늬", "랑", "얀", "향", "울", "련");
		Collections.shuffle(firstName);
		Collections.shuffle(lastName);
		return firstName.get(0) + lastName.get(0) + lastName.get(1) + firstName.get(1) + lastName.get(2)
				+ firstName.get(2);
	}

	public String randomHangulAddr() {
		List<String> addr = Arrays.asList("서울툭별시", "인천광역시", "군산시", "목포시", "대구광역시", "부산광역시", "창원시", "대전광역시", "전주시",
				"광주광역시", "진주시", "청주시", "춘천시", "익산시", "수원시", "순천시", "여수시", "포항시", "김천시", "제주시", "강릉시", "경주시", "통영시",
				"원주시", "창원시", "충주시", "사천시", "울산광역시", "의정부시", "천안시", "안동시", "속초시", "안양시", "성남시", "부천시", "구미시", "동해시",
				"제천시", "광명시", "평택시", "동두천시", "태백시", "영천시", "김해시", "서귀포시", "구리시", "과천시", "안산시", "여수시", "오산시", "의왕시",
				"군포시", "시흥시", "남양주시", "하남시", "용인시", "세종특별자치시", "포천시");
		Collections.shuffle(addr);
		return addr.get(0);

	}

}
