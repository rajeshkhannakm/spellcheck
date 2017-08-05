public class spellcheck {
    int spellchecker(String string1, String string2) {
        int[][] array = new int[string1.length() + 1][string2.length() + 1];
        for (int i = 1; i <= string1.length(); i++)
            array[i][0] = i;
        for (int i = 1; i <= string2.length(); i++)
            array[0][i] = i;
        for (int i = 1; i <= string1.length(); i++) {
            for (int j = 1; j <= string2.length(); j++) {
                if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
                    array[i][j] = array[i - 1][j - 1];
                } else {
                    int temp = Math.min(array[i - 1][j], array[i][j - 1]);
                    array[i][j] = Math.min(temp, array[i - 1][j - 1]) + 1;
                }
            }
        }
        return array[string1.length()][string2.length()];
    }
}
