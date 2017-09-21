package gov.nist.hla.ii;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.emf.ecore.EObject;

public class SendReception extends InterObjReceptionImpl {

	private static final Logger log = LogManager.getLogger(SendReception.class);
	
	// We disposition interactions sent elsewhere in the federation.  Here we simply log.
	@Override
	public EObject receiveInteraction(Double timeStep, String interactionName, Map<String, String> parameters) {
		log.info(String.format("recd: time=%f interaction=%s", timeStep, interactionName));
		return null;
	}

	// Same thing for objects.
	@Override
	public void receiveObject(Double timeStep, String objectClassName, String objectName,
			Map<String, String> attributes) {
		log.info(String.format("recd: time=%f object=%s", timeStep, objectClassName));
	}
}
