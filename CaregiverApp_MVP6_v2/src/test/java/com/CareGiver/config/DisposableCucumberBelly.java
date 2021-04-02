package com.CareGiver.config;

import com.CareGiver.domains.Provider;

/**
 * A test helper class which simulates a class that holds system resources which
 * need disposing at the end of the test.
 *
 * In a real app, this could be a database connector or similar.
 */
public class DisposableCucumberBelly {

	/*
	 * private Provider provider; private boolean isDisposed = false;
	 * 
	 * public void setProvider(Provider provider) { assert !isDisposed;
	 * this.provider = provider; }
	 * 
	 * public Provider getProvider() { assert !isDisposed; return provider; }
	 * 
	 *//**
		 * "dispose()" is useful in addition to @After, as it is guaranteed to run after
		 * all @After hooks, which is useful if this class is needed by the After hooks
		 * themselves.
		 *//*
			 * @Override public void dispose() { isDisposed = true; }
			 * 
			 * public boolean isDisposed() { return isDisposed; }
			 */
}
