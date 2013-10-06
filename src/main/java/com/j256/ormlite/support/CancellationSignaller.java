package com.j256.ormlite.support;

/**
 * Provides means for signalling a running operation to be cancelled from
 * another thread.
 */
public class CancellationSignaller {

	private volatile Cancellable cancellable;

	/**
	 * Signals for the {@link Cancellable} operation attached to this signal to
	 * be cancelled.
	 * <p>
	 * Cancellation may not be supported by all operation types or database
	 * types.
	 */
	public void signal() {
		if (cancellable != null) {
			cancellable.cancel();
		}
	}

	/**
	 * Attach a {@link Cancellable} operation to this signaller to be notified
	 * of cancellation when signalled via {@link #signal()}.
	 * 
	 * @param cancellable
	 *            a {@link Cancellable}.
	 */
	public void attach(final Cancellable cancellable) {
		this.cancellable = cancellable;
	}

	/**
	 * Cancellable operation interested in receiving cancellation signals.
	 */
	public static interface Cancellable {

		/**
		 * Cancel the cancellable operation.
		 */
		void cancel();

	}

}
