import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Arrays Question 3: Multiply Arbitrary Precision Integer
 * 
 * @author nishakk
 *
 */
public class MultiplyArbitraryPrecisionInt {
	public static void main(String[] args) {
		int[] a1 = {1, 2, 3};
		int[] a2 = {1, 2};
		System.out.println(multiply(a1, a2));
	}
	
	private static List<Integer> multiply(int[] a1, int[] a2) {
		List<List<Integer>> lists = new ArrayList<>();
		for (int i = 0; i < a1.length; i++) {
			List<Integer> l = new ArrayList<>();
			for (int j = 0; j < a2.length; j++) {
				l.add(a1[i] * a2[j]);
			}
			lists.add(l);
		}
		Collections.reverse(lists);
		int maxLen = 0;
		for (int i = 0; i < lists.size(); i++) {
			for (int j = 0; j < i; j++) {
				lists.get(i).add(0);
			}
			maxLen = maxLen < lists.get(i).size() ? lists.get(i).size() : maxLen;
		}
		
		List<Integer> ans = new ArrayList<>();
		int carry = 0;
		for (int i = 0; i < maxLen; i++) {
			int sum = 0;
			for (int j = 0; j < lists.size(); j++) {
				if (lists.get(j).size() > 0) {
					int size = lists.get(j).size();
					sum += lists.get(j).get(size - 1);
					lists.get(j).remove(size - 1);
				}
			}
			sum += carry;
			ans.add(sum % 10);
			carry = sum / 10;
		}
		Collections.reverse(ans);
		return ans;
	}
}
