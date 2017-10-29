package com.mycompany.function;

//import java.io.DataOutput;

//import org.roaringbitmap.IntIterator;

//import com.google.common.collect.ImmutableBiMap;
//import org.roaringbitmap.RoaringBitmap;
import com.metamx.collections.bitmap.BitmapFactory;
import com.metamx.collections.bitmap.ImmutableBitmap;
import com.metamx.collections.bitmap.MutableBitmap;
import com.metamx.collections.bitmap.RoaringBitmapFactory;
import com.metamx.collections.bitmap.ConciseBitmapFactory;
//import org.roaringbitmap.buffer.*;

public class RoaringBitmapFunc {
	private static void testBitMap(BitmapFactory factory) {
		MutableBitmap mutableBitmap = factory.makeEmptyMutableBitmap();
		mutableBitmap.add(1);
		mutableBitmap.add(2);
		mutableBitmap.add(3);
		mutableBitmap.add(1000);
		
		for (int i = 0; i < 200000; i++) {
			mutableBitmap.add(i*3+1);
		}
		
		MutableBitmap mutableBitmap2 = factory.makeEmptyMutableBitmap();
		mutableBitmap2.add(9000);
		mutableBitmap2.add(9001);
		mutableBitmap2.add(9002);
		
		mutableBitmap.or(mutableBitmap2);
		
		ImmutableBitmap immutableBitmap = factory.makeImmutableBitmap(mutableBitmap);
		
		byte[] bytes = immutableBitmap.toBytes();
		
		System.out.println("test " + factory);
		System.out.println(immutableBitmap.size());
		System.out.println(bytes.length);
		
	}
	
	public static void main(String[] args) {
		
		RoaringBitmapFactory roaringBitmapFactory = new RoaringBitmapFactory();
		ConciseBitmapFactory conciseBitmapFactory = new ConciseBitmapFactory();
		testBitMap(roaringBitmapFactory);
		testBitMap(conciseBitmapFactory);
		
			
		// MutableBitmap rr = RoaringBitmap.bitmapOf(1,2,3,1000);
		// RoaringBitmap rr2 = new RoaringBitmap();
		// rr2.add(4000L,4255L);
		//
		// RoaringBitmap rror = RoaringBitmap.or(rr, rr2);// new bitmap
		// rr.or(rr2); //in-place computation
		// boolean equals = rror.equals(rr);// true
		// if(!equals) throw new RuntimeException("bug");
		// // number of values stored?
		// long cardinality = rr.getLongCardinality();
		// System.out.println(cardinality);
		// // a "forEach" is faster than this loop, but a loop is possible:
		// for(int i : rr) {
		// System.out.println(i);
		// }
		//// DataOutput out = new Da
		//// rr.serialize(out);
		// RoaringBitmapFactory
		//
		// ImmutableRoaringBitmap immutableRoaringBitmap =
	}
}
