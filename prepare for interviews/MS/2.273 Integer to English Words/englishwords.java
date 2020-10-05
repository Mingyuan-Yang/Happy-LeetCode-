public class englishwords {
    private String[] belowTen = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private String[] belowTwenty = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
            "Seventeen", "Eighteen", "Nineteen"};
    private String[] belowHundred = new String[]{" ", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return helper(num);
    }
    private String helper(int num) {
        String s = "";
        if (num < 10) {
           s = belowTen[num % 10];
        } else if (num < 20) {
            s = belowTwenty[num % 10];
        } else if (num < 100) {
            s = belowHundred[num / 10] + " " + helper(num % 10);
        } else if (num < 1000) {
            s = helper(num / 100) + " Hundred " + helper(num % 100);
        } else if (num < 1000000) {
            s = helper(num / 1000) + " Thousand " + helper(num % 1000);
        } else if (num < 1000000000){
            s = helper(num / 1000000) + " Million " + helper(num % 1000000);
        } else{
            s = helper(num / 1000000000) + " Billion " + helper(num % 1000000000);
        }
        return s.trim();
    }
}
