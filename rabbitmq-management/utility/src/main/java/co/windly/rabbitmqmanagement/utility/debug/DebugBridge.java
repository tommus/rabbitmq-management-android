package co.windly.rabbitmqmanagement.utility.debug;

import android.content.Context;
import com.facebook.stetho.Stetho;

public class DebugBridge {

	//region Constructor

	private DebugBridge() {
		/* No-op. */
	}

	//endregion

	//region Initialization

	public static void init(boolean enable, Context context) {
		if (enable) {
			Stetho.initializeWithDefaults(context);
		}
	}

	//endregion
}
