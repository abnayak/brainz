class StringToInt {
	public static int myAtoi(String str) {
        boolean negative  = false;

        if ( str.charAt(0) == '-') {
        	negative = true;
        	str = str.substring(1,str.length());
        }

		int result = 0;
		int pow = str.length()-1;

		for (int i = 0 ; i < str.length() ; i++) {
			int tenpower  = (str.charAt(i) - '0') * (int)Math.pow(10, pow-i);
			result += tenpower;
		}

		if (negative) {
			result *= -1;
		}

        return result;
    }

	public static void main(String[] args) {
		System.out.println(myAtoi("1"));
	}
}