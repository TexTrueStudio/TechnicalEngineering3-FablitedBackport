package ten3.lib.tile.option;

public class FaceOption {

	public static final int NONE = -1;
	public static final int OFF = 0;
	public static final int IN = 1;
	public static final int OUT = 2;
	public static final int BE_IN = 3;
	public static final int BE_OUT = 4;
	public static final int BOTH = 5;

	public static int size() {
		return 6;
	}

	public static String toStr(int v) {

		return switch (v) {
			case OFF -> "off";
			case IN -> "in";
			case OUT -> "out";
			case BE_IN -> "be_in";
			case BE_OUT -> "be_out";
			case BOTH -> "both";
			default -> "none";
		};

	}

	public static boolean isPassive(int v) {

		return v == OFF || v == BOTH || v == BE_IN || v == BE_OUT;

	}

	public static boolean isIn(int v) {

		return v != IN && v != BE_IN;

	}

	public static boolean isOut(int v) {

		return v != OUT && v != BE_OUT;

	}

}
