import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JudgmentNews1 {
	static String[] goodWords = { "재건축", "상승", "매매", "청약", "공급", "경쟁", "호가", "최고", "신도시", "재개발", "재건축_아파트", "상승세", "강화",
			"가능성", "증가", "신규", "저금리", "관심", "강남권_재건축", "추진", "최대", "인기", "매수" };
	static String[] badWords = { "규제", "하락", "조합", "과열", "제한", "전매", "조정", "조사", "제외", "부채", "전매제한" };
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
			in = new BufferedReader(new FileReader("D:/국토교통 해커톤/JudgmentNews/JudgmentNews/topic_1.csv"));
			String data = null;
			while ((data = in.readLine()) != null) {
				judgment(data);
			}
			System.out.println("강남 부동산 관련 키워드 분석");
			System.out.println("긍정 : " + goodCnt);
			System.out.println("부정 : " + badCnt);
			System.out.println("전체 : " + totalCnt);
			System.out.println("부정/전체 : " + (float) goodCnt / (float) totalCnt);
			System.out.println("긍정/전체 : " + (float) badCnt / (float) totalCnt);
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
