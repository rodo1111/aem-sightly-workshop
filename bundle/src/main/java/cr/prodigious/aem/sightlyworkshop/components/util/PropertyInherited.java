/**
 * AEM Sightly Workshop Components Controller package.
 */
package cr.prodigious.aem.sightlyworkshop.components.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.adobe.cq.sightly.WCMUse;
import com.day.cq.wcm.api.Page;

import com.day.cq.commons.inherit.HierarchyNodeInheritanceValueMap;
import com.day.cq.commons.inherit.InheritanceValueMap;

/**
 * Util class to be used to get inherited properties
 * 
 */
public class PropertyInherited extends WCMUse {
	
	private String propertyName;
	
	@Override
	public void activate() throws Exception {
		propertyName = get("property", String.class);
	}
	
	public String getProperty() {
		// Getting inherited property 'propertyName' for the current resource);
		InheritanceValueMap iProperties = new HierarchyNodeInheritanceValueMap(getResource());
		return iProperties.getInherited(propertyName,String.class);
	}
	
	public String[] getListProperty() {
		// Getting inherited properties 'propertyName' for the current resource);
		InheritanceValueMap iProperties = new HierarchyNodeInheritanceValueMap(getResource());
		return iProperties.getInherited(propertyName,String[].class);
	}

}
