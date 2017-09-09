import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JudgmentNews2 {
	static String[] goodWords = { "재건축", "상승", "매매", "청약", "공급", "경쟁", "호가", "최고", "신도시", "재개발", "재건축_아파트", "상승세", "강화",
			"가능성", "증가", "신규", "저금리", "관심", "강남권_재건축", "추진", "최대", "인기", "매수" };
	static String[] badWords = { "혐의", "수사", "사건", "조사", "범죄", "의혹", "구속", "성폭행", "규제", "범행", "고소", "성매매", "피해자", "대책",
			"피해", "사기", "혐오", "제한", "처벌", "살해", "압수", "불법", "위반", "재판", "과열", "뇌물", "입건", "단속", "부채", "폭행", "체포", "선고",
			"적발", "징역", "영장", "횡령" };
	static int goodCnt = 0;
	static int badCnt = 0;
	static int totalCnt = 0;

	public static void judgment(String wordCount) {
		String[] splitedWordCount = wordCount.split(",");

		totalCnt += Integer.parseInt(splitedWordCount[1]);
		
		// 긍정 사전 탐색
		for (int j = 0; j < goodWords.length; j++) {
			if (splitedWordCount[0].equals(goodWords[j])) {
				goodCnt += Integer.parseInt(splitedWordCount[1]);
				break;
			}
		}
		// 부정 사전 탐색
		for (int j = 0; j < badWords.length; j++) {
			if (splitedWordCount[0].equals(badWords[j])) {
				badCnt += Integer.parseInt(splitedWordCount[1]);
				break;
			}
		}
	}

	public static void main(String[] args) {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("D:/국토교통 해커톤/JudgmentNews/JudgmentNews/topic_2.csv"));
			String data = null;
			while ((data = in.readLine()) != null) {
				judgment(data);
			}
			System.out.println("강남 비부동산 관련 키워드 분석");
			System.out.println("긍정 : " + goodCnt);
			System.out.println("부정 : " + badCnt);
			System.out.println("전체 : " + totalCnt);
			System.out.println("부정/전체 : " + (float)goodCnt/(float)totalCnt);
			System.out.println("긍정/전체 : " + (float)badCnt/(float)totalCnt);
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
					in = null;
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
