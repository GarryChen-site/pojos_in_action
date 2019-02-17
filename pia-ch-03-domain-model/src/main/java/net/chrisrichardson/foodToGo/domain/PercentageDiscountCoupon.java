/*
 * Copyright (c) 2005 Chris Richardson
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 
package net.chrisrichardson.foodToGo.domain;


public class PercentageDiscountCoupon
	extends AbstractCouponImpl {

	private double discountPercentage;
	private double minimum;

    public PercentageDiscountCoupon() {
        super();
    }

    public PercentageDiscountCoupon(
		String code,
		double discountPercentage,
		double minimum) {
		super(code);
		this.discountPercentage = discountPercentage;
		this.minimum = minimum;
	}

    protected double getDiscountPercentage() {
		return discountPercentage;
	}

	protected double getMinimum() {
		return minimum;
	}

    public double getDeliveryChargeDiscount(PendingOrder order) {
        return 0;
    }

    public double getSubtotalDiscount(PendingOrder order) {
        double subtotal = order.getSubtotal();
        if (subtotal < minimum)
          return 0;
        else
          return computeDiscount(subtotal); 
    }

    private double computeDiscount(double subtotal) {
        return subtotal * discountPercentage / 100.0;
    }

}
