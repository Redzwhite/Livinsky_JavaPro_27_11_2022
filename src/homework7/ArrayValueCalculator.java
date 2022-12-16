package homework7;


public class ArrayValueCalculator {


    public static void main(String[] args) {
        String[][] matrix = new String[][]{
                {"1", "2", "3", "2"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };

        try {
            System.out.println("Sum of items is " + doCalc(matrix));
        } catch (ArraySizeException | ArrayDataException ex) {
            ex.printStackTrace();
        }
    }
    private static int doCalc(String[][] arrays) throws ArrayDataException, ArraySizeException {
        if (arrays.length != 4) {
            throw new ArraySizeException("Array length should be 4 but array size is " + arrays.length);
        }
        System.out.println("Array length is 4");
        int counter = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length != 4) {
                throw new ArraySizeException("Each element of array should have length 4, " +
                        "but element with index " + i + " but we get length " + arrays[i].length);
            } else {
                for (int j = 0; j < arrays[i].length; j++) {
                    try {
                        counter += Integer.parseInt(arrays[i][j]);
                    } catch (NumberFormatException ex) {
                        throw new ArrayDataException("In element with index " + i + " item with index " + j + " cannot transform to integer");
                    }
                }
            }
        }
        return counter;
    }
}
