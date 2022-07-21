
enum Color {
  BLUE("\u001B[34m"),
  CYAN("\u001B[36m");

  Color(String code) {
    this.code = code;
  }

  private final String code;

  @Override
  public String toString() {
    return code;
  }
}