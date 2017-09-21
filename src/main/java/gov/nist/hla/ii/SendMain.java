package gov.nist.hla.ii;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SendMain {

	private static final Logger log = LogManager.getLogger(SendMain.class);

	public static void main(String[] args) {
		if (args.length != 1) {
			log.error("command line argument for properties file not specified");
			args = new String[1];
			args[0] = "config.properties";
		}

		try {
			InjectionFederate app = new InjectionFederate();
			app.loadConfiguration(args[0]);
			
			// Set the injection and reception here.
			SendInjection inj = new SendInjection(app);
			app.setInterObjectInjection(inj);
			SendReception recp = new SendReception();
			app.setInterObjectReception(recp);
			SendHook hook = new SendHook();
			app.setTimeStepHook(hook);
			app.init();
			app.run();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

}
