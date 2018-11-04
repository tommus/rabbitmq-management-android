package co.windly.rabbitmqmanagement.utility.log;

import timber.log.Timber;

@SuppressWarnings("unused")
public class WiLogger {

  //region Constructor

  private WiLogger() {
    /* No-op. */
  }

  //endregion

  //region Initialization

  public static void init(boolean enable) {
    if (enable) {
      // TODO: Deifferentiate tree for dev and debug flavors.
      Timber.plant(new Timber.DebugTree());
    }
  }

  //endregion

  //region Verbose

  public static void v(String message, Object... objects) {
    Timber.v(message, objects);
  }

  public static void v(Throwable throwable, String message, Object... objects) {
    Timber.v(throwable, message, objects);
  }

  //endregion

  //region Debug

  public static void d(String message, Object... objects) {
    Timber.d(message, objects);
  }

  public static void d(Throwable throwable, String message, Object... objects) {
    Timber.d(throwable, message, objects);
  }

  //endregion

  //region Info

  public static void i(String message, Object... objects) {
    Timber.i(message, objects);
  }

  public static void i(Throwable throwable, String message, Object... objects) {
    Timber.i(throwable, message, objects);
  }

  //endregion

  //region Warning

  public static void w(String message, Object... objects) {
    Timber.w(message, objects);
  }

  public static void w(Throwable throwable, String message, Object... objects) {
    Timber.w(throwable, message, objects);
  }

  //endregion

  //region Error

  public static void e(String message, Object... objects) {
    Timber.e(message, objects);
  }

  public static void e(Throwable throwable, String message, Object... objects) {
    Timber.e(throwable, message, objects);
  }

  //endregion

  //region What a Terrible Failure

  public static void wtf(String message, Object... objects) {
    Timber.wtf(message, objects);
  }

  public static void wtf(Throwable throwable, String message, Object... objects) {
    Timber.wtf(throwable, message, objects);
  }

  //endregion
}
