public class ComplexNumber {
  long real;
  long imaginary;

  ComplexNumber(long r, long i) {
    real = r;
    imaginary = i;
  }

  public static ComplexNumber multiply(ComplexNumber a, ComplexNumber b) {
    long v1 = a.real * b.real;
    long v2 = a.real * b.imaginary;
    long v3 = a.imaginary * b.real;
    long v4 = a.imaginary * b.imaginary;

    Long imaginaryPart = v2 + v3;
    long productImaginary = (a.imaginary == 0 || b.imaginary == 0) ? 0 : (-1) * v4;

    Long realPart = v1 + productImaginary;
    return new ComplexNumber(realPart, imaginaryPart);
  }

  public String toString() {
    String result = "";
    result += real;
    if (imaginary > 0) {
      result += "+";
    }
    result += imaginary + "i";
    return result;
  }

  public static void main(String[] args) {
    ComplexNumber c1 = new ComplexNumber(1, 1);
    ComplexNumber c2 = new ComplexNumber(1, 1);

    String x = "1+-2i";

    System.out.println(multiply(c1, c2));
  }
}
