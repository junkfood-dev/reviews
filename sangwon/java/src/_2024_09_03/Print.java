package _2024_09_03;

class Print {
    // class member : delimiter, A, B
    public String delimiter = "";
    public Print(String delimiter) {
        this.delimiter = delimiter;
    }
    public void A() {
        System.out.println(this.delimiter);
        System.out.println("A");
    }

    public void B() {
        System.out.println(this.delimiter);
        System.out.println("B");
    }
}