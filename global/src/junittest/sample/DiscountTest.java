
package junittest.sample;

import junit.framework.TestCase;

/**
 * Discount用テストクラス
 */
public class DiscountTest extends TestCase{

 public DiscountTest(String name){
   super(name);
 }

	/**
	 * 販売価格の計算
	 */
	public void testDiscount1() throws Exception{

		//定価 1000, 割引率 30%
		ProductDiscount d1 = new ProductDiscount( 1000, 300 );

		//販売価格700でなくてはならない
		assertEquals( 700.0, d1.getDiscountedPrice(), 0 );
	}

	/**
	 * 割引率にマイナスを指定し例外を発生させる
	 */
	public void testDiscount2(){
		try{
			//割引率に-10を指定
			ProductDiscount d1 = new ProductDiscount( 1000, -10 );

			//例外が発生しなければ異常、強制的に異常終了
			fail( "割引率にマイナスを指定しても例外が発生しない" );

		}catch( Exception e ){
			//例外の発生は正常である
			System.out.println( "正しい処理" );
		}
	}
}
