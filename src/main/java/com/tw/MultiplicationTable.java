package com.tw;

public class MultiplicationTable {
    public String create(int start, int end) {
        if (isValid(start, end)) {
            return generateTable(start, end);
        }
        return null;
    }

    public boolean isValid(int start, int end) {
        return isInRange(start) && isInRange(end) && isStartNotBiggerThanEnd(start, end);
    }

    public boolean isInRange(int number) {
        return  number >=1 && number <= 1000;
    }

    public boolean isStartNotBiggerThanEnd(int start, int end) {
        return start <= end;
    }

    public String generateTable(int start, int end) {
        StringBuilder tableResult = new StringBuilder();
        for (int row = start; row <= end; row++ ) {
            String resultPlaceholder = row == end ? "%s" : "%s%n";
            tableResult.append(String.format(resultPlaceholder, generateLine(start, row)));
        }
        return tableResult.toString();
    }

    public String generateLine(int start, int row) {
        String lineResult = "";
        for(int multiplier = start; multiplier<=row; multiplier++) {
            lineResult = lineResult + (generateSingleExpression(multiplier, row) + "  ");
        }
        return lineResult.trim();
    }

    public String generateSingleExpression(int multiplicand, int multiplier) {
        return String.format("%d*%d=%d", multiplicand, multiplier,  multiplicand*multiplier);
    }
}
