
package junittest.sample;

class ProductDiscount{
 double price, ratio;

 ProductDiscount ( double price, double ratio ) throws Exception {

   this.price= price;
   this.ratio= ratio;

		if( ratio < 0 || ratio > 100 ){
			throw new Exception( "例外です" );
		}
}

	public double getDiscountedPrice() {

		return  price * ( ( 100 -  ratio ) / 100 );
	}
}