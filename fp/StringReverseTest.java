class StringReverseTest {
  public static void main(String[] args) {
    String input = "hello";
    String outputIter = reverseIter(input);
    System.out.println(outputIter);
    System.out.println(reverseRecur(input, new StringBuilder()).toString());
  }

  public static String reverseIter(String str) {
    StringBuilder sbd = new StringBuilder();
    for (int i = str.length(); i >= 1; i--) {
      sbd.append(str.charAt(i - 1));
    }
    return sbd.toString();
  }

  public static StringBuilder reverseRecur(String str, StringBuilder sbd) {
    sbd.append(str.charAt(str.length() - 1));
    if (str.length() != 1) {
      reverseRecur(str.substring(0, str.length() - 1), sbd);
    }
    return sbd;
  }
}
