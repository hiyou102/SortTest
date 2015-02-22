import java.util.List;

public class ListTest {

	public static void main(String[] args) {

		int listSize = 0;
		boolean repeat = true;
		if (args.length > 0) {
			try {
				listSize = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				System.err.println("Argument" + args[0]
						+ " must be an integer.");
				System.exit(1);
			}
		}
		if (args.length > 1) {
			repeat = Boolean.parseBoolean(args[1]);

		}

		List<ListItem> unsortedList;

		ListGenerator listGen = new ListGenerator();

		unsortedList = listGen.generate(listSize, repeat);
		System.out.println("list generated");

		InsertSort s = new InsertSort();
		QuickSort qs = new QuickSort();
		MergeSort m = new MergeSort();

		printSortTime(m, unsortedList);
		printSortTime(qs, unsortedList);
		printSortTime(s, unsortedList);

	}

	public static long sortTime(SortInterface x, List<ListItem> list) {

		long startTime = System.nanoTime();
		x.sort(list);
		long endTime = System.nanoTime();

		long duration = (endTime - startTime);
		duration = duration / 1000000;
		return duration;
	}

	public static void printSortTime(SortInterface x, List<ListItem> list) {

		System.out.println(x.GetName() + " time:");
		System.out.println(sortTime(x, list) + " ms");
	}

	public static boolean verifySort(List<ListItem> list) {
		for (int i = 0; i < list.size() - 1; i++) {

			if (list.get(i).getX() > list.get(i + 1).getX()) {
				return false;
			}
		}
		return true;
	}

	public static void printList(List<ListItem> list) {

		for (ListItem i : list) {
			System.out.println(i.getWord());
		}
		System.out.println("");

	}

}
