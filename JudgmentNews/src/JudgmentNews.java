import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JudgmentNews {
	static String[] goodWords = { "�����", "���", "�Ÿ�", "û��", "����", "����", "ȣ��", "�ְ�", "�ŵ���", "�簳��", "�����_����Ʈ",
			"��¼�", "��ȭ","���ɼ�", "����", "�ű�", "���ݸ�", "����", "������_�����", "����", "�ִ�", "�α�", "�ż�" };
	static String[] badWords = { "����", "�϶�", "����", "����", "����", "����", "����", "����", "����", "��ä", "��������" };
	static int totalCnt = 0;
	public static int judgment(String wordCount) {
		String[] splitedWordCount = wordCount.split(",");
		int good = 0;
		int bad = 0;
		int result = 0;
		
		totalCnt++;

		for (int i = 0; i < splitedWordCount.length; i += 2) {// �ܾ� ���� interval
			// ���� ���� Ž��
			for (int j = 0; j < goodWords.length; j++) {
				if (splitedWordCount[i].equals(goodWords[j])) {
					good += Float.parseFloat(splitedWordCount[i + 1]);
					break;
				}
			}
			// ���� ���� Ž��
			for (int j = 0; j < badWords.length; j++) {
				if (splitedWordCount[i].equals(badWords[j])) {
					bad += Float.parseFloat(splitedWordCount[i + 1]);
					break;
				}
			}
		}

		// ����or����or�߸� �Ǻ�
		result = good - bad;
		System.out.println(good + " - " + bad + " = " + result);

		if (result > 0) {// ����
			result = 1;
		} else if (result < 0) {// ����
			result = -1;
		} else {// �߸�
			result = 0;
		}
		System.out.println("��� : " + result);
		return result;
	}

	public static void main(String[] args) {
		int result = 0;
		int goodCnt = 0;
		int badCnt = 0;
		int neutralCnt = 0;
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("D:/���䱳�� ��Ŀ��/JudgmentNews/JudgmentNews/result.csv"));
			String data = null;
			while ((data = in.readLine()) != null) {
				// System.out.println(data);
				result = judgment(data);
				if (result == 1) {
					System.out.println("����");
					goodCnt++;
				} else if (result == -1) {
					System.out.println("����");
					badCnt++;
				} else {
					System.out.println("�߸�");
					neutralCnt++;
				}
			}
			System.out.println();
			System.out.println("���� : " + goodCnt);
			System.out.println("���� : " + badCnt);
			System.out.println("�߸� : " + neutralCnt);
			System.out.println("�� : " + totalCnt);
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