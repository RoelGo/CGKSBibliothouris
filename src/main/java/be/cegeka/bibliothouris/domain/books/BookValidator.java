package be.cegeka.bibliothouris.domain.books;

/**
 * Created by christom on 30/01/2017.
 */
public class BookValidator {

    public boolean isValid(String isbn) {
        int sumOdd = 0;
        int sumEven = 0;
        if (isbn.length() == 13) {
            for (int i = 0; i < isbn.length(); i++) {
                if (i % 2 == 0) {
                    sumOdd += (int) isbn.charAt(i) - 48;
                }
                if (i % 2 != 0) {
                    sumEven += (int) isbn.charAt(i) - 48;
                }
            }
            sumEven *= 3;
            double sumTotal = sumEven + sumOdd;
            double sumRound = Math.ceil(sumTotal / 10) * 10;
            return ((int) isbn.charAt(isbn.length()-1)-48 == (sumRound-sumTotal));
        }
        return false;
    }
}

