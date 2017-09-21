package gov.nist.hla.ii;

import java.util.Queue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.emf.ecore.EObject;

import littleints.Int1;
import littleints.LittleintsFactory;

public class SendInjection extends InterObjInjectionImpl {

	private static final Logger log = LogManager.getLogger(SendInjection.class);

	InjectionFederate federate;

	public SendInjection(InjectionFederate federate) {
		super();
		this.federate = federate;
	}

	@Override
	public Queue<EObject> getPreSynchInteractions() {
		// TODO Auto-generated method stub
		return publications;
	}

	@Override
	public Queue<EObject> getPublications(Double logicalTime) {
		log.trace("getInteractions==>");

			Int1 int1 = LittleintsFactory.eINSTANCE.createInt1();
			int1.setBoolVal(true);
			int1.setIntVal(123);
			int1.setStrVal("ABC");
			addInteraction(int1);
		return publications;
	}
}
