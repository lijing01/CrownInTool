package com.trace;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JSONUtil {

	// region -------- Default Values Define --------

	public static final String JSONUTIL_DEFAULT_STRING_VAL = "";
	public static final Integer JSONUTIL_DEFAULT_INTEGER_VAL = 0;
	public static final Boolean JSONUTIL_DEFAULT_BOOLEAN_VAL = false;
	public static final JSONObject JSONUTIL_DEFAULT_JSONOBJECT_VAL = null;
	public static final JSONArray JSONUTIL_DEFAULT_JSONARRAY_VAL = null;

	// endregion

	private JSONObject jsonObject = null;

	public JSONUtil(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}

	// region -------- Object Value --------

	/**
	 * Returns the value mapped by name, or {@code null} if no such mapping
	 * exists.
	 * 
	 * @param key
	 * @return
	 */
	public Object opt(String key) {
		return jsonObject.opt(key);
	}

	public boolean has(String key) {
		return jsonObject.has(key);
	}

	// endregion

	// region -------- Get String Value --------

	/**
	 * Returns the value mapped by name, or {@code JSONUTIL_DEFAULT_STRING_VAL}
	 * if no such mapping exists.
	 * 
	 * @param key
	 * @return
	 */
	public String optString(String key) {
		return optString(key, JSONUTIL_DEFAULT_STRING_VAL);
	}

	/**
	 * Returns the value mapped by name, or {@code defaultValue} if no such
	 * mapping exists.
	 * 
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public String optString(String key, String defaultValue) {

		try {
			if (jsonObject == null) {
				return defaultValue;
			}
			Object value = jsonObject.opt(key);
			return ParserUtil.optString(value, defaultValue);

		} catch (Exception e) {
			//
		}

		return defaultValue;
	}

	// endregion

	// region -------- Get Integer Value --------

	/**
	 * Returns the value mapped by name, or {@code JSONUTIL_DEFAULT_INTEGER_VAL}
	 * if no such mapping exists.
	 * 
	 * @param key
	 * @return
	 */
	public Integer optInteger(String key) {
		return optInteger(key, JSONUTIL_DEFAULT_INTEGER_VAL);
	}

	/**
	 * Returns the value mapped by name, or {@code defaultValue} if no such
	 * mapping exists.
	 * 
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public Integer optInteger(String key, Integer defaultValue) {

		try {
			if (jsonObject == null) {
				return defaultValue;
			}

			Object value = jsonObject.opt(key);
			return ParserUtil.optInteger(value, defaultValue);

		} catch (Exception e) {
			//
		}

		return defaultValue;
	}

	// endregion

	// region -------- Get Boolean Value --------

	/**
	 * Returns the value mapped by name, or {@code JSONUTIL_DEFAULT_BOOLEAN_VAL}
	 * if no such mapping exists.
	 * 
	 * @param key
	 * @return
	 */
	public Boolean optBoolean(String key) {
		return optBoolean(key, JSONUTIL_DEFAULT_BOOLEAN_VAL);
	}

	/**
	 * Returns the value mapped by name, or {@code defaultValue} if no such
	 * mapping exists.
	 * 
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public Boolean optBoolean(String key, Boolean defaultValue) {

		try {
			if (jsonObject == null) {
				return defaultValue;
			}

			Object value = jsonObject.opt(key);
			return ParserUtil.optBoolean(value, defaultValue);

		} catch (Exception e) {
			//
		}

		return defaultValue;
	}

	// endregion

	// region -------- Get JSONObject Value --------

	public JSONObject optJSONObject(String key) {
		return optJSONObject(key, JSONUTIL_DEFAULT_JSONOBJECT_VAL);
	}

	public JSONObject optJSONObject(String key, JSONObject defaultValue) {
		try {

			if (jsonObject == null) {
				return defaultValue;
			}

			Object value = jsonObject.opt(key);
			if (value == null) {
				return defaultValue;
			}

			if (value instanceof JSONObject) {
				return (JSONObject) value;
			}

		} catch (Exception e) {
			//
		}

		return defaultValue;
	}

	// endregion

	// region -------- Get JSONArray Value --------

	public JSONArray optJSONArray(String key) {
		return optJSONArray(key, JSONUTIL_DEFAULT_JSONARRAY_VAL);
	}

	public JSONArray optJSONArray(String key, JSONArray defaultValue) {
		try {

			if (jsonObject == null) {
				return defaultValue;
			}

			Object value = jsonObject.opt(key);
			if (value == null) {
				return defaultValue;
			}

			if (value instanceof JSONArray) {
				return (JSONArray) value;
			}

		} catch (Exception e) {
			//
		}

		return defaultValue;
	}

	// endregion

}
