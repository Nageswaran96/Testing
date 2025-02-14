package functions;

public class Ratings {
	double cerRecentYr; //2024
	 double cerRecentMinusOneYr;//2023
	 double cerRecentMinusTwoYr;//2022
	 double cerRecentMinusThreeYr;//2021
	 double cerRecentMinusFourYr;//2020
	 double percMoveToBoostReturn;
	 double netCrDb;
	 double stockPrice; // Reference Price
	 double maxReturn; 
	 double pfitm;	 
	 String sentimentAdjustment;
	 
	public static void boosterRatings(double cerRecentYr, double cerRecentMinusOneYr, double cerRecentMinusTwoYr, double cerRecentMinusThreeYr, double cerRecentMinusFourYr, double percMoveToBoostReturn, double netCrDb, double stockPrice, double maxReturn, 
			double pfitm, String sentimentAdjustment) {
		
		double berRecentYr;//2024
		double berRecentMinusOneYr;//2023
		double berRecentMinusTwoYr;//2022
		double berRecentMinusThreeYr;//2021	
		double berRecentMinusFourYr;//2020
		double pfitmRecency;
		double tr;
		double recency;
		@SuppressWarnings("unused")
		double ratings;
		
		//Calculate BER for recent year
		if (cerRecentYr <= percMoveToBoostReturn) {
			
			berRecentYr = Max( (netCrDb / stockPrice), 0.01);
			
		} else if (cerRecentYr <= 0.5 * (maxReturn + percMoveToBoostReturn - netCrDb / stockPrice)) {
			
			berRecentYr = cerRecentYr - percMoveToBoostReturn + netCrDb / stockPrice;
			
		} else {
			berRecentYr = maxReturn - cerRecentYr;
		}
		
		
		//Calculate BER for recent -1 year
		if (cerRecentMinusOneYr <= percMoveToBoostReturn) {
			
			berRecentMinusOneYr = Max( (netCrDb / stockPrice), 0.01);
			
		} else if (cerRecentMinusOneYr <= 0.5 * (maxReturn + percMoveToBoostReturn - netCrDb / stockPrice)) {
			
			berRecentMinusOneYr = cerRecentMinusOneYr - percMoveToBoostReturn + netCrDb / stockPrice;
			
		} else {
			berRecentMinusOneYr = maxReturn - cerRecentMinusOneYr;
		}
		
				
		//Calculate BER for recent -2 year
		if (cerRecentMinusTwoYr <= percMoveToBoostReturn) {
					
			berRecentMinusTwoYr = Max( (netCrDb / stockPrice), 0.01);
					
		} else if (cerRecentMinusTwoYr <= 0.5 * (maxReturn + percMoveToBoostReturn - netCrDb / stockPrice)) {
					
			berRecentMinusTwoYr = cerRecentMinusTwoYr - percMoveToBoostReturn + netCrDb / stockPrice;
					
		} else {
			berRecentMinusTwoYr = maxReturn - cerRecentMinusTwoYr;
		}
		
			
		//Calculate BER for recent -3 year
		if (cerRecentMinusThreeYr <= percMoveToBoostReturn) {
							
			berRecentMinusThreeYr = Max( (netCrDb / stockPrice), 0.01);
							
		} else if (cerRecentMinusThreeYr <= 0.5 * (maxReturn + percMoveToBoostReturn - netCrDb / stockPrice)) {
							
			berRecentMinusThreeYr = cerRecentMinusThreeYr - percMoveToBoostReturn + netCrDb / stockPrice;
							
		} else {
			berRecentMinusThreeYr = maxReturn - cerRecentMinusThreeYr;
		}
		
		
		//Calculate BER for recent -4 year
		if (cerRecentMinusFourYr <= percMoveToBoostReturn) {
									
			berRecentMinusFourYr = Max( (netCrDb / stockPrice), 0.01);
									
		} else if (cerRecentMinusFourYr <= 0.5 * (maxReturn + percMoveToBoostReturn - netCrDb / stockPrice)) {
									
			berRecentMinusFourYr = cerRecentMinusFourYr - percMoveToBoostReturn + netCrDb / stockPrice;
									
		} else {
			berRecentMinusFourYr = maxReturn - cerRecentMinusFourYr;
		}
		
		recency = ((berRecentYr * 5) + (berRecentMinusOneYr * 4) + (berRecentMinusTwoYr * 3) + (berRecentMinusThreeYr * 2) + (berRecentMinusFourYr * 1)) / 15;
		
		pfitmRecency = recency / pfitm;
		
		if (sentimentAdjustment == "Bearish" || sentimentAdjustment == "Neutral") {
			tr = pfitmRecency * 1.25;
		} else if (sentimentAdjustment == "Mildly Bullish") {
			tr = pfitmRecency * 1;
		} else {
			tr = pfitmRecency * 0.75;
		}
		
		
		if (tr > 0.17) {
			 ratings = 5;
			 
		} else if (tr > 0.13) {
			ratings = 4.5;
			
		} else if (tr > 0.075) {
			ratings = 4;
			
		} else if (tr > 0.05) {
			ratings = 3.5;
			
		} else if ( tr > 0.03) {
			ratings = 3;
			
		} else if ( tr > 0) {
			ratings = 2;
			
		} else if ( tr < 0){
			ratings = 1;
			
		} else {
			ratings = 0;
		}
		
	}

	public static double Max(double value1, double value2) {
		double maxValue = 0;
		if (value1 > value2) {
			 maxValue = value1;
		} else if (value1 < value2) {
			maxValue = value2;
		}
		return maxValue;
			
	}
}

