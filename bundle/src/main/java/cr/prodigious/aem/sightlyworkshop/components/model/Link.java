/**
 * AEM Sightly Workshop Components Model package.
 */
package cr.prodigious.aem.sightlyworkshop.components.model;

/**
 * Entity class for the Link.
 * 
 * @author Rodolfo Oviedo
 */
public class Link {

	/**
	 * Class attributes.
	 */
	private String link;
	private String title;
	private String name;
	
	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}
	
	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}	
	
}
