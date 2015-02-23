/**
 * AEM Sightly Workshop Components Controller package.
 */
package cr.prodigious.aem.sightlyworkshop.components.controller;

import io.sightly.java.api.Use;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jcr.Node;
import javax.script.Bindings;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cr.prodigious.aem.sightlyworkshop.components.model.Link;

/**
 * Class to use as a Tabs Controller by implementing Use.
 * 
 * @author Rodolfo Oviedo
 */
@SuppressWarnings("restriction")
public class TabsController implements Use {

	/**
	 * Class constants.
	 */
	private static final Logger LOG = LoggerFactory
			.getLogger(TabsController.class);
	private static final String BINDING_RESOURCE = "resource";
	private static final String PROP_TITLE = "title";
	private static final String NODE_TABS_CONTENT = "tabs-content";
	private static final String REG_EXP_SPECIAL_CHARS = "[^a-zA-Z0-9]+";
	private static final String SLASH = "/";

	/**
	 * Class attributes.
	 */
	private Resource tabsResource;
	private List<Link> tabs;

	/**
	 * Init method of the Use interface.
	 */
	public void init(Bindings bindings) {
		tabsResource = (Resource) bindings.get(BINDING_RESOURCE);
	}

	/**
	 * Method to get the titles of the tabs from the given configuration.
	 * 
	 * @param tabsResource
	 *            Resource object of the tabs component
	 * 
	 * @return List with the tabs links
	 */
	public List<Link> getTabs() {
		// Check if the tabs are already generated
		if (tabs == null) {
			Resource tabsContentResource;
			tabs = new ArrayList<Link>();
	
			// Get the tabs content node
			tabsContentResource = tabsResource.getChild(
					NODE_TABS_CONTENT);
			
			// Check if the tabs content resource is valid
			if (tabsContentResource != null) {
				// Get the children resources
				Iterator<Resource> tabsChildrenIterator = tabsResource.getChild(
						NODE_TABS_CONTENT).listChildren();
				Node actualTab;
		
				try {
					// Create each tab item (link) object
					while (tabsChildrenIterator.hasNext()) {
						actualTab = tabsChildrenIterator.next().adaptTo(Node.class);
		
						tabs.add(getTabLinkFromNode(actualTab));
					}
				} catch (Exception e) {
					LOG.error(e.getMessage());
				}
			}
		}

		return tabs;
	}

	/**
	 * Method to convert the tab item node into a Link object.
	 * 
	 * @param actualTab Node of the actual tab
	 * 
	 * @return Link object
	 */
	private Link getTabLinkFromNode(Node actualTab) {
		Link tabLink = null;
		String tabTitle = null;

		try {
			if (actualTab.hasProperty(PROP_TITLE)) {
				tabLink = new Link();
				tabTitle = actualTab.getProperty(PROP_TITLE).getString();
				
				// Set the title of the tab
				tabLink.setTitle(tabTitle);

				// Set the link of the tab
				tabLink.setLink(tabTitle.toLowerCase().replaceAll(
						REG_EXP_SPECIAL_CHARS, StringUtils.EMPTY));
				
				// Set the name of the tab node
				tabLink.setName(NODE_TABS_CONTENT + SLASH + actualTab.getName());
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}

		return tabLink;
	}

}
