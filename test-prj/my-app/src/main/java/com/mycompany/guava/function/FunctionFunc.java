package com.mycompany.guava.function;

import com.google.common.base.Function;

public class FunctionFunc {
	public static void main(String[] args) {
		Function<Double[], Double> sum = new Function<Double[], Double>() {
		    public Double apply(Double[] input) {
		        Double result = 0.0;
		        for (Double element : input) {
		            result += element;
		        }
		        return result;
		    }
		};
		double ret = sum.apply(new Double[]{3.0, 4.0, 5.1});//12.1
		System.out.println(ret);
	}
}
