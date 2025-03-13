public class Utils {
    static int checkPassword(String password) {
        int nChars = 0;
        int nNumb = 0;

        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
                nNumb += 1;
            }
            if (password.charAt(i) >= 'A' && password.charAt(i) <= 'z') {
                nChars += 1;
            }
        }

        int passwordComplexity = password.length() + nNumb*3 + nChars*2;


        if (password.length() < 6 ) {
            throw new IllegalArgumentException();
        }
        else if (passwordComplexity < 10) {
            throw new SecurityException();
        }

        return passwordComplexity;

    }
}


class Util {
    public static <T extends RuntimeException> void processData(DataElement el) throws RuntimeException {
        boolean ch;
        try {
            ch = el.check();
            if(ch)
                System.out.println("OK");
            if(!ch)
                System.out.println("ERROR");
        } catch(RuntimeException T) {
            System.out.println(T.getClass().getSimpleName().toString());
            throw new RuntimeException(T.getClass().getSimpleName());
        }
    }
}
