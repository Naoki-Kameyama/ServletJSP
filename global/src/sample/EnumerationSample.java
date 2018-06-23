/**
 * EnumerationとVectorの例
 */

package sample;

import global.productmgr.Product;

import java.util.Enumeration;
import java.util.Vector;

public class EnumerationSample {

	public static void main(String[] args) {

		// EnumerationとVectorを宣言する。
		Enumeration<Product> enumeration;
		Vector<Product> vector = new Vector<Product>();

		// 要素を作成する。
		Product product1 = new Product();
		Product product2 = new Product();
		Product product3 = new Product();

		product1.setName("SAMPLE1");
		product2.setName("SAMPLE2");
		product3.setName("SAMPLE3");

		// Vectorに追加する。
		vector.add(product1);
		vector.add(product2);
		vector.add(product3);

		// Enumerationを得る。
		enumeration = vector.elements();

		// 要素が存在している間ループする
		while (enumeration.hasMoreElements()) {

			// 要素をひとつずつ取り出す。
			Product product = enumeration.nextElement();
			System.out.println(product.getName());
		}
	}
}

