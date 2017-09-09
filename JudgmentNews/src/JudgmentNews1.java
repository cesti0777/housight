import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JudgmentNews1 {
	static String[] goodWords = { "�����", "���", "�Ÿ�", "û��", "����", "����", "ȣ��", "�ְ�", "�ŵ���", "�簳��", "�����_����Ʈ", "��¼�", "��ȭ",
			"���ɼ�", "����", "�ű�", "���ݸ�", "����", "������_�����", "����", "�ִ�", "�α�", "�ż�" };
	static String[] badWords = { "����", "�϶�", "����", "����", "����", "����", "����", "����", "����", "��ä", "��������" };
	static int goodCnt = 0;
	static int badCnt = 0;
	static int totalCnt = 0;

	public static void judgment(String wordCount) {
		String[] splitedWordCount = wordCount.split(",");
		totalCnt += Integer.parseInt(splitedWordCount[1]);

		// ���� ���� Ž��
		for (int j = 0; j < goodWords.length; j++) {
			if (splitedWordCount[0].equals(goodWords[j])) {
				goodCnt += Integer.parseInt(splitedWordCount[1]);
				break;
			}
		}
		// ���� ���� Ž��
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
			in = new BufferedReader(new FileReader("D:/���䱳�� ��Ŀ��/JudgmentNews/JudgmentNews/topic_1.csv"));
			String data = null;
			while ((data = in.readLine()) != null) {
				judgment(data);
			}
			System.out.println("���� �ε��� ���� Ű���� �м�");
			System.out.println("���� : " + goodCnt);
			System.out.println("���� : " + badCnt);
			System.out.println("��ü : " + totalCnt);
			System.out.println("����/��ü : " + (float) goodCnt / (float) totalCnt);
			System.out.println("����/��ü : " + (float) badCnt / (float) totalCnt);
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
