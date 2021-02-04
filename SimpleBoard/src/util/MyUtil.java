package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MyUtil {
	public static HttpSession resetSession(HttpServletRequest req) {
		HttpSession ret = req.getSession();
		ret.invalidate();
		ret = req.getSession();
		return ret;
	}
}
