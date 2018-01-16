public class Cell {
    private static int cellNumberCount = 0;

    int cellNumber = 0;

    public Cell(){
        cellNumberCount++;
        cellNumber = cellNumberCount;
    }

    public int getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(int cellNumber) {
       this.cellNumber = cellNumber;
    }
}
