package com.trace;

/**
 * Created by liuwei on 2015-06-27.
 */
public class ParserUtil {

	public static final String DEF_STRING_VAL = "";
	public static final Integer DEF_INTEGER_VAL = 0;
	public static final Double DEF_DOUBLE_VAL = 0.0;
	public static final Boolean DEF_BOOLEAN_VAL = false;

	public static String optString(Object oriVal) {
		return optString(oriVal, DEF_STRING_VAL);
	}

	public static String optString(Object oriVal, String defVal) {
		try {

			if (oriVal == null) {
				return defVal;
			}

			if (oriVal instanceof String) {
				return (String) oriVal;
			}

			if (oriVal instanceof byte[]) {
				return bytes2String((byte[]) oriVal, defVal);
			}

			return oriVal.toString();

		} catch (Exception e) {
			return defVal;
		}
	}

	public static Integer optInteger(Object oriVal) {
		return optInteger(oriVal, DEF_INTEGER_VAL);
	}

	public static Integer optInteger(Object oriVal, Integer defVal) {
		try {

			if (oriVal == null) {
				return defVal;
			}

			if (oriVal instanceof Integer) {
				return (Integer) oriVal;
			}

			if (oriVal instanceof Number) {
				return ((Number) oriVal).intValue();
			}

			if (oriVal instanceof Boolean) {
				return ((Boolean) oriVal) ? 1 : 0;
			}

			String tmpStr = "";
			if (oriVal instanceof byte[]) {
				tmpStr = bytes2String((byte[]) oriVal, "");
			} else if (oriVal instanceof String) {
				tmpStr = (String) oriVal;
			}

			if (!isEmpty(tmpStr)) {
				Integer result;
				try {
					result = Integer.valueOf(tmpStr);
				} catch (NumberFormatException e) {
					result = defVal;
				}

				return result;
			}

			return defVal;

		} catch (Exception e) {
			return defVal;
		}
	}

	public static Boolean optBoolean(Object oriVal) {
		return optBoolean(oriVal, DEF_BOOLEAN_VAL);
	}

	public static Boolean optBoolean(Object oriVal, Boolean defVal) {
		try {

			if (oriVal == null) {
				return defVal;
			}

			if (oriVal instanceof Boolean) {
				return (Boolean) oriVal;
			}

			if (oriVal instanceof Integer) {
				return (Integer) oriVal == 1;
			}

			String tmpStr = "";
			if (oriVal instanceof byte[]) {
				tmpStr = bytes2String((byte[]) oriVal, "");
			} else if (oriVal instanceof String) {
				tmpStr = (String) oriVal;
			}

			if (!isEmpty(tmpStr)) {
				return tmpStr.equals("1") || tmpStr.equalsIgnoreCase("true");
			}

			return defVal;

		} catch (Exception e) {
			return defVal;
		}
	}

	/**
	 * 针对于 ForumConfigAction 所做的特殊处理 <br />
	 * 对于 true false 的判断优先采用 0 进行判断，对 0 以外的值认为是 true <br />
	 * 如果日后能够确认此处的 boolean 值只有可能为 1 或 0，则可使用正常方法，否则需要考虑 1 和 0 以外的值
	 */
	public static Boolean optBooleanByZeroJudgment(Object oriVal, Boolean defVal) {
		try {

			if (oriVal == null) {
				return defVal;
			}

			if (oriVal instanceof Boolean) {
				return (Boolean) oriVal;
			}

			if (oriVal instanceof Integer) {
				return (Integer) oriVal != 0;
			}

			String tmpStr = "";
			if (oriVal instanceof byte[]) {
				tmpStr = bytes2String((byte[]) oriVal, "");
			} else if (oriVal instanceof String) {
				tmpStr = (String) oriVal;
			}

			if (!isEmpty(tmpStr)) {
				return !tmpStr.equals("0") && !tmpStr.equalsIgnoreCase("false");
			}

			return defVal;

		} catch (Exception e) {
			return defVal;
		}
	}
	
	public static String bytes2String(byte[] bytes, String defVal) {

		if (bytes == null) {
			return defVal;
		}

		String result = null;

		try {
			result = new String(bytes, "UTF-8");

		} catch (Exception e) {
			result = new String(bytes);

		}

		return result;
	}

	

	public static boolean isEmpty(String str) {
		if ((str == null) || (str.length() == 0)) {
			return true;
		} else {
			return false;
		}
	}
}

