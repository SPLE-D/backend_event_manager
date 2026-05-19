module Event.eventcreation.typeeventcreation {
	requires Event.eventcreation.core;
	exports Event.eventcreation.typeeventcreation.model;
	exports Event.eventcreation.typeeventcreation.resource;
	exports Event.eventcreation.typeeventcreation.service;

	requires id.ac.ui.cs.prices.winvmj.core;
	requires id.ac.ui.cs.prices.winvmj.hibernate;
	requires id.ac.ui.cs.prices.winvmj.auth;
	requires java.logging;
	// https://stackoverflow.com/questions/46488346/error32-13-error-cannot-access-referenceable-class-file-for-javax-naming-re/50568217
	requires java.naming;
	requires java.net.http;

	opens Event.eventcreation.typeeventcreation.model to org.hibernate.orm.core, gson, id.ac.ui.cs.prices.winvmj.hibernate;
}
