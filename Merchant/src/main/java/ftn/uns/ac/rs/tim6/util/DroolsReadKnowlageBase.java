package ftn.uns.ac.rs.tim6.util;

import java.io.File;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;

public class DroolsReadKnowlageBase {
	
	private ClassLoader classLoader; 
	private File file; 
	private KnowledgeBuilder kbuilder; 
	private StatefulKnowledgeSession ksession;
	
	public DroolsReadKnowlageBase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StatefulKnowledgeSession getSession() throws Exception {
		
		classLoader = getClass().getClassLoader();
		file = new File(classLoader.getResource("droolsPravila.drl").toURI());
		kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newFileResource(file),ResourceType.DRL); 
		
	    KnowledgeBuilderErrors errors = kbuilder.getErrors(); 
	    
	    if (errors.size() > 0) {  
	         for (KnowledgeBuilderError error : errors) {  
	              System.err.println(error);  
	         }  
	         throw new IllegalArgumentException("Could not parse knowledge.");  
	    }  
	    
	    KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();  
	    kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
	    ksession = kbase.newStatefulKnowledgeSession();
	    
	    return ksession;
	}

}
