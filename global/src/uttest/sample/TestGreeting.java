package uttest.sample;

class TestGreeting {
	public static void main(String[] args) throws Exception {
		String actual = "";

		Greeting greeting = new Greeting();

		// Test1
		System.out.print("Test1: japaneseを指定したときの検証: ");
		actual = greeting.hello("japanese");
		if (actual.equals("konnichiwa"))
			System.out.println("合格");
		else
			System.out.println("失敗");

		// Test2
		System.out.print("Test2: englishを指定したときの検証: ");
		actual = greeting.hello("english");
		if (actual.equals("hello"))
			System.out.println("合格");
		else
			System.out.println("失敗");

		// Test3
		System.out.print("Test3: germanを指定したときの検証: ");
		actual = greeting.hello("german");
		if (actual.equals("hallo"))
			System.out.println("合格");
		else
			System.out.println("失敗");

		// Test4
		System.out.print("Test4: italianを指定したときの検証: ");
		actual = greeting.hello("italian");
		if (actual.equals("ciao"))
			System.out.println("合格");
		else
			System.out.println("失敗");

		// Test5
		System.out.print("Test5: spanishを指定したときの検証: ");
		actual = greeting.hello("spanish");
		if (actual.equals("hola"))
			System.out.println("合格");
		else
			System.out.println("失敗");

		// Test6
		System.out.print("Test6: koreanを指定したときの検証: ");
		actual = greeting.hello("korean");
		if (actual.equals("annyunghaseyo"))
			System.out.println("合格");
		else
			System.out.println("失敗");

		// Test7
		System.out.print("Test7: 存在しない言語を指定したときの例外発生の検証: ");
		try {
			actual = greeting.hello("non");
			System.out.println("失敗");
		} catch (Exception e) {
			System.out.println("合格");
		}
	}
}
